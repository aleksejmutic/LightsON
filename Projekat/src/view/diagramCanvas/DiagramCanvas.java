package view.diagramCanvas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


import model.*;
import view.Canvas;
import view.contextMenu.*;
import view.listeners.CompositeWireMouseListener;

public class DiagramCanvas extends Canvas {
	private static final long serialVersionUID = 1L;
	private Diagram diagram;
	private SelectDecorator selectionDecorator = null;
	private ArrayList<SelectDecorator> selectionDecorators; // Specifically handle SelectionDecorators
	private CompositeWireMouseListener wireMouseListener;
	private ElementContextMenu contextMenu;
	private DiagramCanvasContextMenu diagramContextMenu;
	private ApplicationModel applicationModel;

	// Zoom state and scale levels
	private float currentZoom = 1.0f;
	private final float[] zoomLevels = { 0.25f, 0.33f, 0.50f, 0.60f, 0.75f, 1.0f, 1.25f, 1.50f, 1.75f, 2.0f, 4.0f };

	private boolean gridVisible = true; // Track if the grid is visible

	public DiagramCanvas(Diagram diagram, ApplicationModel applicationModel) {
		this.diagram = diagram;
		this.applicationModel = applicationModel;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(800, 500)); // Initial preferred size
		setBackground(Color.WHITE);

		selectionDecorators = new ArrayList<>(); // Initialize selectionDecorators list
		setFocusable(true);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					showContextMenu(e);
				}
			}
		});
		toggleSelection();
	}

	public void addElement(Element element) {
		diagram.addElement(element);
		repaint();
	}

	public void addDecorator(SelectDecorator decorator) {
		selectionDecorators.add(decorator); // Add the decorator to the list
		repaint();
	}

	public void removeDecorator(SelectDecorator decorator) {
		selectionDecorators.remove(decorator); // Remove the decorator from the list
		repaint();
	}

	public void setWireMouseListener(CompositeWireMouseListener listener) {
		this.wireMouseListener = listener;
	}

	public void setDrawingCursor() {
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	}

	public void resetCursor() {
		setCursor(Cursor.getDefaultCursor());
	}

	// Zoom methods
	public void zoomIn() {
		int index = findCurrentZoomIndex();
		if (index < zoomLevels.length - 1) {
			currentZoom = zoomLevels[index + 1];
			updatePreferredSize();
			repaint();
		}
	}

	public void zoomOut() {
		int index = findCurrentZoomIndex();
		if (index > 0) {
			currentZoom = zoomLevels[index - 1];
			updatePreferredSize();
			repaint();
		}
	}

	// Find the current zoom level index
	private int findCurrentZoomIndex() {
		for (int i = 0; i < zoomLevels.length; i++) {
			if (currentZoom == zoomLevels[i]) {
				return i;
			}
		}
		return 5; // Default to 100% (index 5)
	}

	// Update the preferred size based on current zoom level
	private void updatePreferredSize() {
		int width = (int) (800 * currentZoom); // Base width (800) scaled by zoom factor
		int height = (int) (500 * currentZoom); // Base height (500) scaled by zoom factor
		setPreferredSize(new Dimension(width, height));
		revalidate(); // Notify parent container about the size change
	}

	public void toggleGrid() {
		gridVisible = !gridVisible; // Toggle the grid visibility
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.scale(currentZoom, currentZoom); // Scale the graphics based on currentZoom

		if (gridVisible) {
			drawGrid(g2d);
		}

		for (Element element : diagram.getElements()) {
			element.drawElement(g);
		}

		// Draw wires
		if (wireMouseListener != null && wireMouseListener.isDrawingWire()) {
			CompositeWire currentWire = wireMouseListener.getCurrentWire();
			if (currentWire != null) {
				currentWire.drawElement(g2d);
			}
		}

		// Draw SelectionDecorators
		for (SelectDecorator decorator : selectionDecorators) {
			decorator.draw(g);
		}
	}

	// Method to draw the grid
	private void drawGrid(Graphics2D g2d) {
		int gridSize = 20;
		int dotSize = 3; // Increase the dot size here
		g2d.setColor(Color.GRAY);
		for (int x = 0; x < getWidth(); x += gridSize) {
			for (int y = 0; y < getHeight(); y += gridSize) {
				g2d.fillRect(x - dotSize / 2, y - dotSize / 2, dotSize, dotSize);
			}
		}
	}

	public void showContextMenu(MouseEvent e) {
		for (Element element : diagram.getElements()) {
			if (!(element instanceof CompositeWire) && !(element instanceof Wire)) {
				Rectangle bounds = new Rectangle((int) element.getPoint().getX(), (int) element.getPoint().getY(),
						element.getWidth(), element.getHeight());
				if (bounds.contains(e.getPoint())) {
					contextMenu = new ElementContextMenu(element, applicationModel);
					contextMenu.getContextMenu().show(e.getComponent(), e.getX(), e.getY());
					return;
				}
			}
		}

		diagramContextMenu = new DiagramCanvasContextMenu(this);
		diagramContextMenu.getContextMenu().show(e.getComponent(), e.getX(), e.getY());
	}

	public Diagram getDiagram() {
		return diagram;
	}

	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	public ArrayList<SelectDecorator> getSelectionDecorators() {
		return selectionDecorators;
	}

	public void setSelectionDecorators(ArrayList<SelectDecorator> selectionDecorators) {
		this.selectionDecorators = selectionDecorators;
	}

	public void toggleSelection() {
		for (Element element : this.getDiagram().getElements()) {
			if (element.getIsSelected()) {
				selectionDecorator = new SelectDecorator(element.getPoint(), element.getEndPoint(), element.getWidth(),
						element.getHeight(), element);
				this.addDecorator(selectionDecorator);

				this.repaint();
			}
			else
			{
				for (SelectDecorator decorator : this.getSelectionDecorators()) {
					if (decorator.getElement() == element) {
						selectionDecorator = decorator;
						break;
					}
				}
				this.removeDecorator(selectionDecorator);
				selectionDecorator = null;
			}
		}
	}
}
