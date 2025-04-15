package view.diagramCanvas;


import javax.swing.JPanel;

import view.Canvas;

public class DocumentationTabPane extends JPanel {

	private static final long serialVersionUID = 1L;

	public DocumentationTabPane(Canvas canvas) {
		canvas = new DocumentationCanvas();
		add(canvas);
    }
}