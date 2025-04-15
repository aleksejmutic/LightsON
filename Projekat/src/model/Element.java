/***********************************************************************
 * Module:  Element.java
 * Author:  maril
 * Purpose: Defines the Class Element
 ***********************************************************************/

package model;

import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import java.util.Vector;

public abstract class Element {
	protected String elementName;
	protected List<JunctionPoint> junctionPoints;
	protected Point point;
	protected Point endPoint;
	protected int width;
	protected int height;
	protected transient boolean isSelected = false;
	protected String elementType;

	public Element() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("exports")
	public Element(Point point, Point endPoint, int width, int height) {
		this.point = point;
		this.endPoint = endPoint;
		this.width = width;
		this.height = height;
		this.junctionPoints = new Vector<JunctionPoint>();
	}

	@SuppressWarnings("exports")
	public Point getPoint() {
		return point;
	}

	/** @param newPoint */
	@SuppressWarnings("exports")
	public void setPoint(Point newPoint) {
		point = newPoint;
	}

	@SuppressWarnings("exports")
	public Point getEndPoint() {
		return endPoint;
	}

	/** @param newEndPoint */
	@SuppressWarnings("exports")
	public void setEndPoint(Point newEndPoint) {
		endPoint = newEndPoint;
	}

	public int getWidth() {
		return width;
	}

	/** @param newWidth */
	public void setWidth(int newWidth) {
		width = newWidth;
	}

	public int getHeight() {
		return height;
	}

	/** @param newHeight */
	public void setHeight(int newHeight) {
		height = newHeight;
	}

	public boolean getIsSelected() {
		return isSelected;
	}

	/** @param newIsSelected */
	public void setIsSelected(boolean newIsSelected) {
		isSelected = newIsSelected;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.elementName;
	}
	

	public List<JunctionPoint> getJunctionPoints() {
		return junctionPoints;
	}

	public void setJunctionPoints(List<JunctionPoint> junstionPoints) {
			this.junctionPoints = junstionPoints;
	}

	@SuppressWarnings("exports")
	public abstract void drawElement(Graphics g);
	protected abstract void initializeJunctionPoints();
}
