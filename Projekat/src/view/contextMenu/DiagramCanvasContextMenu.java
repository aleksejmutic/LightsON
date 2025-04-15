package view.contextMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import view.ContextMenu;
import view.diagramCanvas.DiagramCanvas;

public class DiagramCanvasContextMenu extends ContextMenu {
	private DiagramCanvas diagramCanvas;

	public DiagramCanvasContextMenu(DiagramCanvas canvas) {
		this.setDiagramCanvas(canvas);

		// Grid option
		JMenuItem toggleGridMenuItem = new JMenuItem("Toggle Grid");
		toggleGridMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.toggleGrid(); // Toggle grid visibility
			}
		});
		this.contextMenu.add(toggleGridMenuItem);

		// Zoom In option
		JMenuItem zoomInMenuItem = new JMenuItem("Zoom In");
		zoomInMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.zoomIn(); // Zoom in action
			}
		});
		this.contextMenu.add(zoomInMenuItem);

		// Zoom Out option
		JMenuItem zoomOutMenuItem = new JMenuItem("Zoom Out");
		zoomOutMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.zoomOut(); // Zoom out action
			}
		});
		this.contextMenu.add(zoomOutMenuItem);
	}

	public DiagramCanvas getDiagramCanvas() {
		return diagramCanvas;
	}

	public void setDiagramCanvas(DiagramCanvas diagramCanvas) {
		this.diagramCanvas = diagramCanvas;
	}
}
