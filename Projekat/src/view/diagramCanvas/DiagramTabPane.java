package view.diagramCanvas;

import javax.swing.JPanel;

import model.Diagram;
import view.Canvas;

public class DiagramTabPane extends JPanel {
	private static final long serialVersionUID = 1L;
	private DiagramScrollPane diagramScrollPane;
    private Diagram diagram;
    private Canvas canvas;

    public DiagramTabPane(DiagramCanvas canvas) {
        diagramScrollPane = new DiagramScrollPane(canvas);
        this.diagram = canvas.getDiagram();
        setCanvas(canvas);
        add(diagramScrollPane);
    }

    // Setter for DiagramScrollPane
    public void setDiagramPane(DiagramScrollPane diagramPane) {
        this.diagramScrollPane = diagramPane;
    }

    // Getter for accessing the DiagramScrollPane if needed
    public DiagramScrollPane getDiagramScrollPane() {
        return diagramScrollPane;
    }

	public Diagram getDiagram() {
		return diagram;
	}

	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	
    
}
