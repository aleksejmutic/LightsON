/***********************************************************************
 * Module:  Decorator.java
 * Author:  maril
 * Purpose: Defines the Class Decorator
 ***********************************************************************/

package model;

import java.awt.Graphics;
import java.awt.Point;

public class Decorator extends Element {
	@SuppressWarnings("exports")
	public Decorator(Point point, Point endPoint, int width, int height) {
		super(point, endPoint, width, height);
	}

	public Decorator() {
		super();
		this.elementType = "Decorator";
	}

	public java.util.Collection<Element> elementDecorator;

	@SuppressWarnings("exports")
	@Override
	public void drawElement(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initializeJunctionPoints() {
		// TODO Auto-generated method stub
		
	}

}