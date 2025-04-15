/***********************************************************************
 * Module:  Wire.java
 * Author:  maril
 * Purpose: Defines the Class Wire
 ***********************************************************************/

package model;

import java.awt.Graphics;
import java.awt.Point;

public class Wire extends Conductor {

	@SuppressWarnings("exports")
	public Wire(Point point, Point endPoint, int width, int height, boolean isSelected) {
	 super(point, endPoint, 0, 0);
		this.elementType = "Wire";
		this.elementName = "Wire";
	}
	
	public Wire() {
		this.elementType = "Wire";
	}
	
	@SuppressWarnings("exports")
	@Override
	public void drawElement(Graphics g) {
		super.drawElement(g);
		JunctionPoint middlejunctionPoint = null;
		if(getJunctionPoints().get(0).getPoint().getX() < getJunctionPoints().get(1).getPoint().getX() && getJunctionPoints().get(0).getPoint().getY() < getJunctionPoints().get(1).getPoint().getY()) {
			 middlejunctionPoint = new JunctionPoint((int) getJunctionPoints().get(1).getX(), (int) getJunctionPoints().get(0).getPoint().getY());
		}else if(getJunctionPoints().get(0).getPoint().getX() > getJunctionPoints().get(1).getPoint().getX() && getJunctionPoints().get(0).getPoint().getY() > getJunctionPoints().get(1).getPoint().getY()){
			 middlejunctionPoint = new JunctionPoint((int) getJunctionPoints().get(0).getX(), (int) getJunctionPoints().get(1).getPoint().getY());
		}
		else if(getJunctionPoints().get(0).getPoint().getX() < getJunctionPoints().get(1).getPoint().getX() && getJunctionPoints().get(0).getPoint().getY()> getJunctionPoints().get(1).getPoint().getY()) {
			 middlejunctionPoint = new JunctionPoint((int) getJunctionPoints().get(1).getX(), (int) getJunctionPoints().get(0).getPoint().getY());
		}else if(getJunctionPoints().get(0).getPoint().getX() > getJunctionPoints().get(1).getPoint().getX() && getJunctionPoints().get(0).getPoint().getY() < getJunctionPoints().get(1).getPoint().getY()){
			 middlejunctionPoint = new JunctionPoint((int) getJunctionPoints().get(0).getX(), (int) getJunctionPoints().get(1).getPoint().getY());
		}
		else {
			middlejunctionPoint = new JunctionPoint((int) getJunctionPoints().get(1).getX(), (int) getJunctionPoints().get(1).getPoint().getY());
		}
		
		
		this.point.x = (int)getJunctionPoints().get(0).getPoint().getX()+5;
		this.point.y = (int) getJunctionPoints().get(0).getPoint().getY()+5;
		this.endPoint.x = (int) middlejunctionPoint.getPoint().getX()+5;
		this.endPoint.y = (int) middlejunctionPoint.getPoint().getY()+10;
		
		g.drawLine((int) point.getX(), (int) point.getY(), (int) endPoint.getX(), (int) endPoint.getY());
	}

	@Override
	protected void initializeJunctionPoints() {
		// TODO Auto-generated method stub
		
	}
}