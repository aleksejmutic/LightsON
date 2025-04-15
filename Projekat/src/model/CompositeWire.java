/***********************************************************************
 * Module:  CompositeWire.java
 * Author:  goran
 * Purpose: Defines the Class CompositeWire
 ***********************************************************************/

package model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Vector;

public class CompositeWire extends Conductor {
	private List<Wire> wires;
    public CompositeWire() {
    	this.elementType = "CompositeWire";
    	this.elementName = "Composite Wire";
    	setWires();
    }
	public List<Wire> getWires() {
		return wires;
	}
	public void setWires() {
		if(this.wires == null)
			this.wires = new Vector<Wire>();
	}
	
	public void addWire(Wire wire)
	{
		if(this.wires.size() == 0)
		{
			this.wires.add(wire);
		}
		else
		{
			Wire lastWire = this.wires.getLast();
			if(lastWire.endPoint.getX() == wire.point.getX() && lastWire.endPoint.getY() == wire.point.getY())
			{
				this.wires.add(wire);
			}
		}
	}
	
	@Override
	public void drawElement(@SuppressWarnings("exports") Graphics g) {
		super.drawElement(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setStroke(new BasicStroke(2));
		
		for (Wire wire : this.wires) {
			wire.drawElement(g2);
		}
	}
	@Override
	protected void initializeJunctionPoints() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setIsSelected(boolean newIsSelected) {
		super.setIsSelected(newIsSelected);
		for (Wire wire : this.wires) {
			wire.setIsSelected(newIsSelected);
		}
	}

}