/***********************************************************************
 * Module:  Conductor.java
 * Author:  maril
 * Purpose: Defines the Class Conductor
 ***********************************************************************/

package model;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Conductor extends Element {

	@SuppressWarnings("exports")
	public Conductor(Point point, Point endPoint, int width, int height) {
        super(point, endPoint, width, height);
        
    }

    public Conductor() {
        super();
        this.elementType = "Conductor";
    }
    
    @SuppressWarnings("exports")
	@Override
    public void drawElement(Graphics g) {
        
    }
}