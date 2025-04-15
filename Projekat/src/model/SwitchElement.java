/***********************************************************************
 * Module:  JunctionBox.java
 * Author:  maril
 * Purpose: Defines the Class JunctionBox
 ***********************************************************************/

package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class SwitchElement extends Element {
	private transient Color color = Color.WHITE;
	private static final int OFFSET = 5; // Distance from the edge for connector points
	private transient BufferedImage image; // Image to display inside the JunctionBox
	// Image path within the src folder
	private static String imagePath = "icons/power-switch1.png"; // Adjust to your image's path

	// Unique ID generation
	private static int id = 0;

	/**
	 * Constructs a JunctionBox. Note: The passed width and height are swapped to
	 * force portrait orientation.
	 *
	 * @param x         The x-coordinate of the top-left corner.
	 * @param y         The y-coordinate of the top-left corner.
	 * @param width     The width (this becomes the effective height).
	 * @param height    The height (this becomes the effective width).
	 * @param imagePath The resource path for the image (can be null).
	 */
	@SuppressWarnings({ "exports", "static-access" })
	public SwitchElement(Point point, Point endPoint, int width, int height) {
		// Swap width and height for portrait orientation:
		// effectiveWidth = height and effectiveHeight = width.
		// Call super() as the very first statement.
		super(point, endPoint, width, height);

		// Now assign the ID and update the name.
		id++;
		this.elementName = this.toString() + this.id;
		// Initialize connector points.
		this.setJunctionPoints(new Vector<JunctionPoint>());
		this.elementType = "Switch";
		initializeJunctionPoints();

		// Attempt to load the image.
		loadImage();
	}
	
	public SwitchElement() {
		this.elementType = "Switch";
		loadImage();
	}

	/**
	 * Loads the image from the specified path.
	 *
	 * @param imagePath The path to the image resource.
	 */
	private void loadImage() {
		if (imagePath != null) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream(imagePath));
				if (image == null) {
					System.err.println("Image not found in resources: " + imagePath);
				}
			} catch (IOException e) {
				e.printStackTrace();
				image = null;
			}
		} else {
			image = null;
		}
	}

	/**
	 * Initializes the four JunctionPoints around the box.
	 */
	protected void initializeJunctionPoints() {

		for (int i = 0; i < 2; i++) {
			this.getJunctionPoints().add(new JunctionPoint(0, 0));
		}

		for (int i = 0; i < 2; i++) {
			int jpX = 0, jpY = 0;
			switch (i) {
			case 0: // Top
				jpX = point.x + width / 2;
				jpY = point.y;
				break;
			case 1: // Bottom
				jpX = point.x + width / 2;
				jpY = point.y + height;
				break;
			}
			this.getJunctionPoints().set(i, new JunctionPoint(jpX, jpY));
			this.getJunctionPoints().get(i).setParentBox(this);
		}
	}
	
	/**
	 * Recalculates the junction points of this JunctionBox based on its current location.
	 * Ensures that the points are positioned at the ends of the connector lines.
	 */
	public void recalculateJunctionPoints() {
	    for (int i = 0; i < 2; i++) {
	        int jpX = 0, jpY = 0;
	        switch (i) {
	            case 0: // Top
	                jpX = point.x + width / 2 - OFFSET; // Horizontally centered on the top edge
	                jpY = point.y - OFFSET - 10;             // Aligned with the top edge of the box
	                break;
	            case 1: // Bottom
	                jpX = point.x + width / 2 - OFFSET;  // Horizontally centered on the bottom edge
	                jpY = point.y + height - OFFSET + 10;     // Aligned with the bottom edge of the box
	                break;
	        }
	       // Update the JunctionPoint's position
	        this.getJunctionPoints().get(i).setPoint(new Point(jpX, jpY));
	    }
	}


	/**
	 * Checks if a given point is within the bounds of the JunctionBox.
	 *
	 * @param p the point to test.
	 * @return true if the point is inside the box; false otherwise.
	 */
	@SuppressWarnings("exports")
	public boolean contains(Point p) {
		Rectangle bounds = new Rectangle(point.x, point.y, width, height);
		return bounds.contains(p);
	}

	public List<JunctionPoint> getJunctionPoints() {
		return super.getJunctionPoints();
	}

	/**
	 * Draws the JunctionBox including its border, image (if available), connector
	 * lines, and the JunctionPoints.
	 *
	 * @param g the Graphics context.
	 */
	@SuppressWarnings("exports")
	public void draw(Graphics g) {
		// Draw the box border.
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setStroke(new BasicStroke(2));
		
		g2.setColor(Color.BLACK);
		g2.drawRect(point.x, point.y, width, height);

		// Draw the image if available; otherwise, fill with the default color.
		if (image != null) {
			int imgWidth = image.getWidth();
			int imgHeight = image.getHeight();
			double imgAspect = (double) imgWidth / imgHeight;
			double boxAspect = (double) width / height;

			int drawWidth, drawHeight;
			if (imgAspect > boxAspect) {
				drawWidth = width - 2;
				drawHeight = (int) (drawWidth / imgAspect);
			} else {
				drawHeight = height - 2;
				drawWidth = (int) (drawHeight * imgAspect);
			}

			int drawX = point.x + (width - drawWidth) / 2 + 1;
			int drawY = point.y + (height - drawHeight) / 2 + 1;
			g2.drawImage(image, drawX, drawY, drawWidth, drawHeight, null);
			recalculateJunctionPoints();
		} else {
			g2.setColor(color);
			g2.fillRect(point.x + 1, point.y + 1, width - 1, height - 1);
		}
 
		// Draw connector lines to each JunctionPoint.
		g2.setColor(Color.BLACK);
		g2.drawLine(point.x + width / 2, point.y, (int) this.getJunctionPoints().get(0).getX(),
				(int) this.getJunctionPoints().get(0).getY());
		g2.drawLine(point.x + width / 2, point.y + height, (int) this.getJunctionPoints().get(1).getX(),
				(int) this.getJunctionPoints().get(1).getY());

		// Draw each JunctionPoint.
		for (JunctionPoint jp : this.getJunctionPoints()) {
			jp.draw(g);
		}
	}

	// Add the getBounds method to return a Rectangle representing the bounding box
	// of the JunctionBox
	@SuppressWarnings("exports")
	public Rectangle getBounds() {
		return new Rectangle(point.x, point.y, width, height);
	}

	// Optional convenience getter methods.
	public int getX() {
		return point.x;
	}

	public int getY() {
		return point.y;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return super.elementName;
	}

	public void setName(String name) {
		this.elementName = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Switch";
	}

	@SuppressWarnings("exports")
	@Override
	public void drawElement(Graphics g) {
		draw(g);
	}

}