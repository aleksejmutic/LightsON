package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class Diagram {
	private String diagramName;
	private String diagramApsolutePath;
	private transient DiagramState state;
	private List<Element> elements = new Vector<Element>();
	private transient CommandHistory commandHistory;
	private boolean isActive;
	private boolean isFocused;
	
	public Diagram() {
		
	}
	
	public Diagram(String diagramName, String diagramApsolutePath) {
		setDiagramName(diagramName);
		setDiagramApsolutePath(diagramApsolutePath);
		setState(new SelectionState());
		setElements(new Vector<Element>());
		setCommandHistory(new CommandHistory());
		setActive(true);
		setFocused(false);
		
		getCommandHistory().pushUndoCommand(this);
	}

    public String getDiagramName() {
        return diagramName;
    }

    public void setDiagramName(String diagramName) {
        this.diagramName = diagramName;
    }

    public String getDiagramApsolutePath() {
        return diagramApsolutePath;
    }

    public void setDiagramApsolutePath(String diagramApsolutePath) {
        this.diagramApsolutePath = diagramApsolutePath;
    }

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

    public CommandHistory getCommandHistory() {
        return commandHistory;
    }

    public void setCommandHistory(CommandHistory commandHistory) {
        this.commandHistory = commandHistory;
    }

    public boolean isActive() {
        return isActive;
    }

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

    public DiagramState getState() {
        return state;
    }

    public void addElement(Element element) {
        this.getElements().add(element);
    }

    public void removeElement() {
        // TODO: implement
    }

	/** @param state */
	public void setState(DiagramState state) {
		this.state = state;
	}
	
    public void init() {
        setState(new SelectionState());
        setCommandHistory(new CommandHistory());
        getCommandHistory().pushUndoCommand(this);
    }
    
    
	
	public boolean isFocused() {
		return isFocused;
	}

	public void setFocused(boolean isFocused) {
		this.isFocused = isFocused;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.diagramName;
	}
	
	public String generateDocumentation()
	{
        StringBuilder documentation = new StringBuilder();

        // Create a summary of element types and their counts
        List<Element> elements = this.getElements();
        Map<String, Integer> elementCounts = new HashMap<>();

        for (Element element : elements) {
            String elementType = element.getClass().getSimpleName();
            elementCounts.put(elementType, elementCounts.getOrDefault(elementType, 0) + 1);
        }

        // Add element type and count information
        documentation.append("Element Types and Counts:\n");
        for (Map.Entry<String, Integer> entry : elementCounts.entrySet()) {
            documentation.append("- ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return documentation.toString();
	}
	
}