package view.listeners;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import model.CompositeWire;
import model.Diagram;
import model.Element;
import model.JunctionPoint;
import model.Wire;
import view.Editor;
import view.diagramCanvas.DiagramCanvas;

public class CompositeWireMouseListener extends MouseAdapter implements MouseMotionListener {
	private DiagramCanvas canvas;
	private Editor editor;
	private boolean isDrawingMode = false;
	private boolean isDrawingWire = false;
	private CompositeWire currentWire = null;
	private static JunctionPoint firstJunction = null;

	public CompositeWireMouseListener(Editor editor) {
		this.editor = editor;
		this.canvas = (DiagramCanvas) editor.getFocusedCanvas();
		setDrawingMode(true);
	}

	public void setDrawingMode(boolean drawingMode) {
		this.isDrawingMode = drawingMode;
		if (!isDrawingMode) {
			resetState();
			this.canvas.resetCursor();
		} else {
			((DiagramCanvas)canvas).setDrawingCursor();
		}
	}

	public boolean isDrawingMode() {
		return isDrawingMode;
	}

	public boolean isDrawingWire() {
		return isDrawingWire;
	}

	public CompositeWire getCurrentWire() {
		return currentWire;
	}

	private void resetState() {
		isDrawingWire = false;
		currentWire = null;
		firstJunction = null;
		canvas.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!isDrawingMode || e.getButton() != MouseEvent.BUTTON1) {
			return;
		}else if (e.getButton() == MouseEvent.BUTTON3)
		{
			resetState();
		}
		
		Point clickPoint = e.getPoint();
		JunctionPoint clickedJunctionPoint = getClickedJunctionPoint(clickPoint);

		if (!isDrawingWire) {
			if (clickedJunctionPoint != null) {
				isDrawingWire = true;
				firstJunction = clickedJunctionPoint;
			}
		} else {
			Element clickedJunctionBox = clickedJunctionPoint != null ? clickedJunctionPoint.getParentBox() : null;

			if (clickedJunctionBox != null && clickedJunctionPoint == null) {
				resetState();
			} else if (clickedJunctionPoint != null) {
				Element endingJunctionBox = clickedJunctionPoint.getParentBox();
				if (endingJunctionBox != firstJunction.getParentBox()) {
					Wire wire = new Wire(firstJunction.getPoint(), new Point((int) clickedJunctionPoint.getPoint().getX(), (int) firstJunction.getPoint().getY()), 0, 0, false);
					Wire wire2 = new Wire(new Point((int) clickedJunctionPoint.getPoint().getX(), (int) firstJunction.getPoint().getY()), clickedJunctionPoint.getPoint(), 0, 0, false);
				
					wire.getJunctionPoints().add(firstJunction);
					wire.getJunctionPoints().add(clickedJunctionPoint);
					
					wire2.getJunctionPoints().add(clickedJunctionPoint);
					wire2.getJunctionPoints().add(firstJunction);
					
					CompositeWire compositeWire =  new CompositeWire();
					compositeWire.addWire(wire);
					compositeWire.addWire(wire2);
					
					Diagram diagram = this.canvas.getDiagram();
					
					diagram.getElements().add(compositeWire);
					diagram.getCommandHistory().pushUndoCommand(diagram);
					this.canvas.repaint();
					resetState();
				} else {
					Toolkit.getDefaultToolkit().beep();
				}
			} 
			canvas.repaint();
		}
	}

	

	// Samo vraca junctionPoint koji se nalazi na JunctionBox-u, popraviti!!!
	private JunctionPoint getClickedJunctionPoint(Point point) {
	    for (Element element : this.canvas.getDiagram().getElements()) { // Go through all Elements
	        if (!(element instanceof CompositeWire)) { // Check if the Element is a JunctionBox
	            Element element1 =  element; // Cast to JunctionBox
	            for (JunctionPoint junctionPoint : element1.getJunctionPoints()) { 
	                if (junctionPoint.contains(point)) { // If the point is inside the JunctionPoint
	                    return junctionPoint; // Return the JunctionPoint immediately
	                }
	            }
	        }
	    }
	    return null; // If nothing is found, return null
	}

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}
	
	


}
