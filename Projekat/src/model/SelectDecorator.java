/***********************************************************************
 * Module:  SelectDecorator.java
 * Author:  maril
 * Purpose: Defines the Class SelectDecorator
 ***********************************************************************/

package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class SelectDecorator extends Decorator {

	private Element element;

	@SuppressWarnings("exports")
	public SelectDecorator(Point point, Point endPoint, int width, int height, Element element) {
		super(point, endPoint, width, height);
		this.element = element;
	}

	public SelectDecorator() {
		super(new Point(0, 0), new Point(0, 0), 0, 0);
	}

	@SuppressWarnings("exports")
	public void draw(Graphics g) {
		if (g != null) {
			Graphics2D g2d = (Graphics2D) g; // Cast to Graphics2D for more control over drawing

			if (!(element instanceof Wire) && !(element instanceof CompositeWire) && !(element instanceof Conductor)) {
				g2d.setColor(Color.BLACK);

				// Set the stroke to create a dashed line
				float[] dashPattern = { 10f, 5f }; // 10 pixels on, 5 pixels off
				BasicStroke dashedStroke = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10f,
						dashPattern, 0f);
				g2d.setStroke(dashedStroke);

				// Get the point for the top-left corner and the width/height of the decorated
				// object
				Point point = element.getPoint();
				int offset = 10; // Adjust this value to control the amount of space around the decorated object

				// Draw the rectangle with space added around it
				g2d.drawRect((int) point.getX() - 2 - offset, // Apply horizontal offset
						(int) point.getY() - 2 - offset, // Apply vertical offset
						getWidth() + 4 + 2 * offset, // Increase width by twice the offset
						getHeight() + 4 + 2 * offset // Increase height by twice the offset
				);
			}
			else
			{
				for (Wire wire : ((CompositeWire)element).getWires()) {
					g2d.setColor(Color.RED);
					wire.drawElement(g2d);
				}
			}
		}
	}
    @SuppressWarnings("exports")
	public void updatePosition(Point newStartPoint, Point newEndPoint) {
        this.point = newStartPoint;
        this.endPoint = newEndPoint;

        // Optional: Recalculate width and height if needed
        this.width = Math.abs(newEndPoint.x - newStartPoint.x);
        this.height = Math.abs(newEndPoint.y - newStartPoint.y);
    }

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	@SuppressWarnings("exports")
	@Override
	public void drawElement(Graphics g) {
		draw(g);
	}
}