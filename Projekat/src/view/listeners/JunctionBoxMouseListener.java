package view.listeners;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.CompositeWire;
import model.Diagram;
import model.Element;
import model.JunctionBox;
import view.Editor;
import view.diagramCanvas.DiagramCanvas;

public class JunctionBoxMouseListener extends MouseAdapter {
    private DiagramCanvas canvas;
    private boolean isDrawing = false;
    private Editor editor;
    
    public JunctionBoxMouseListener(Editor editor) {
    	this.editor = editor;
    	this.canvas = (DiagramCanvas) editor.getFocusedCanvas();
    	setDrawing(true);
		if (!isDrawing) {
			((DiagramCanvas) canvas).resetCursor();
		} else {
			((DiagramCanvas)canvas).setDrawingCursor();
		}
    }

    public void setDrawing(boolean drawing) {
        this.isDrawing = drawing;
    }

    public boolean isDrawing() {
        return isDrawing;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
       
            Point clickPoint = e.getPoint();
            System.out.println("JunctionBox clicked");

            if (isDrawing) {
                drawNewJunctionBox(clickPoint);
            }
        }
    }

    private void drawNewJunctionBox(Point clickPoint) {
        int boxWidth = 100;
        int boxHeight = 50;

        if (isOverlappingExistingJunctionBox(clickPoint.x, clickPoint.y, boxWidth, boxHeight)) {
            Toolkit.getDefaultToolkit().beep();
        } else {
            JunctionBox junctionBox = new JunctionBox(clickPoint, clickPoint, boxWidth, boxHeight);
            Diagram diagram = canvas.getDiagram();
            diagram.addElement(junctionBox);
            diagram.getCommandHistory().pushUndoCommand(diagram);
            canvas.repaint();
        }
    }

 
    @SuppressWarnings("unused")
	private JunctionBox getClickedJunctionBox(Point point) {
        for (Element element : canvas.getDiagram().getElements()) { // Iterate through Elements
            if (!(element instanceof CompositeWire)) { // For every element besides the CompositeWire
                JunctionBox box = (JunctionBox) element; // Cast to JunctionBox
                Rectangle bounds = new Rectangle(box.getX(), box.getY(), box.getWidth(), box.getHeight());
                if (bounds.contains(point)) { // If the clicked point is inside the box
                    return box;
                }
            }
        }
        return null;
    }


    private boolean isOverlappingExistingJunctionBox(int x, int y, int width, int height) {
        Rectangle newBoxBounds = new Rectangle(x, y, width, height);
        for (Element element : canvas.getDiagram().getElements()) { // Go through all Elements
            if (!(element instanceof CompositeWire)) { // For every element besides the CompositeWire
                Rectangle existingBoxBounds = new Rectangle((int)element.getPoint().getX(),(int) element.getPoint().getY(), element.getWidth(), element.getHeight());
                if (newBoxBounds.intersects(existingBoxBounds)) { // Check for overlapping
                    return true;
                }
            }
        }
        return false;
    }

	public Editor getEditor() {
		return editor;
	}

	public void setEditor(Editor editor) {
		this.editor = editor;
	}

}