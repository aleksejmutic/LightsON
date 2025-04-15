package view.listeners;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;

import model.CompositeWire;
import model.Conductor;
import model.Element;
import model.SelectDecorator;
import model.Wire;
import view.Editor;
import view.diagramCanvas.DiagramCanvas;

public class SelectionListener extends MouseAdapter implements MouseMotionListener {
	private DiagramCanvas canvas;
	private Element selectedElement = null;
	private SelectDecorator selectionDecorator = null;
	private static Point dragStart = null; // Track the starting drag point
	private static Element draggedElement = null; // Track the element being dragged

	public SelectionListener(Editor editor) {
		this.canvas = (DiagramCanvas) editor.getFocusedCanvas();
		((DiagramCanvas) canvas).resetCursor();

		// Set the initial cursor to "hand"
		canvas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) { // Left mouse button
			Point clickPoint = e.getPoint();
			Element clickedBox = getClickedElement(clickPoint);

			if (clickedBox != null) {
				toggleSelection(clickedBox); // Select or deselect the clicked element
				draggedElement = clickedBox; // Mark the clicked element as draggable
				dragStart = clickPoint; // Save the starting position of the drag

				// Change cursor to "closed hand"
				canvas.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			}
			else
			{
				for (Element element : ((DiagramCanvas)canvas).getDiagram().getElements()) {
					element.setIsSelected(false);
				}
				canvas.toggleSelection();
			}
		} else if (e.getButton() == MouseEvent.BUTTON3) { // Right mouse button
			canvas.showContextMenu(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	    if (draggedElement != null && dragStart != null) {
	        Point dragEnd = e.getPoint();

	        // Calculate the distance dragged
	        int deltaX = dragEnd.x - dragStart.x;
	        int deltaY = dragEnd.y - dragStart.y;

	        // Update the dragged element's position
	        draggedElement.getPoint().translate(deltaX, deltaY); // Update startPoint
	        draggedElement.getEndPoint().translate(deltaX, deltaY); // Update endPoint

	        // Update the decorator position if it exists
	        if (selectionDecorator != null) {
	            selectionDecorator.updatePosition(draggedElement.getPoint(), draggedElement.getEndPoint());
	        }

	        // Update the drag starting point for the next step
	        dragStart = dragEnd;

	        // Repaint the canvas to reflect the changes
	        canvas.repaint();
	    }
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) { // Left mouse button
			draggedElement = null; // Stop dragging
			dragStart = null;

			// Change cursor back to "hand"
			canvas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	}

	private void toggleSelection(Element clickedBox) {
		if (clickedBox.getIsSelected()) {
			// Deselect the element
			for (SelectDecorator decorator : canvas.getSelectionDecorators()) {
				if (decorator.getElement() == clickedBox) {
					selectionDecorator = decorator;
					break;
				}
			}
			canvas.removeDecorator(selectionDecorator);
			selectionDecorator = null;
			clickedBox.setIsSelected(false);
		} else {
			// Select the element
			selectedElement = clickedBox;
			selectionDecorator = new SelectDecorator(clickedBox.getPoint(), clickedBox.getEndPoint(),
					clickedBox.getWidth(), clickedBox.getHeight(), clickedBox);
			clickedBox.setIsSelected(true);
			canvas.addDecorator(selectionDecorator);
		}
		canvas.repaint();
	}

	private Element getClickedElement(Point point) {
		for (Element element : canvas.getDiagram().getElements()) {
			if (element instanceof Wire || element instanceof CompositeWire || element instanceof Conductor) {
				for (Wire wire : ((CompositeWire) element).getWires()) {
					Line2D line = new Line2D.Double(wire.getPoint().getX(), wire.getPoint().getY(),
							wire.getEndPoint().getX(), wire.getEndPoint().getY());

					double distance = line.ptSegDist(point);
					if (distance <= 5) { // Check proximity within 5 pixels
						return element;
					}
				}
			} else {
				Rectangle bounds = new Rectangle((int) element.getPoint().getX(), (int) element.getPoint().getY(),
						element.getWidth(), element.getHeight());
				if (bounds.contains(point)) {
					return element;
				}
			}
		}
		return null;
	}

	public Element getSelectedElement() {
		return selectedElement;
	}

	public void setSelectedElement(Element selectedElement) {
		this.selectedElement = selectedElement;
	}
	
	
}