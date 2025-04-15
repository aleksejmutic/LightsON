/***********************************************************************
 * Module:  CommandHistory.java
 * Author:  goran
 * Purpose: Defines the Class CommandHistory
 ***********************************************************************/

package model;

import java.util.*;

public class CommandHistory {
	protected static List<Element> elementStack = null;
	protected List<Diagram> redoStack = new Vector<>();
	protected List<Diagram> undoStack = new Vector<>();

	public CommandHistory() {
		setRedoStack(redoStack);
		setUndoStack(undoStack);
		setElementStack();
	}

	public void pushUndoCommand(Diagram diagram) {
		Diagram undoDiagram = new Diagram();
		undoDiagram.setActive(diagram.isActive());
		undoDiagram.setCommandHistory(diagram.getCommandHistory());
		
		for (Element element : diagram.getElements()) {
			undoDiagram.addElement(element);
		}
		
		undoDiagram.setDiagramApsolutePath(diagram.getDiagramApsolutePath());
		undoDiagram.setDiagramName(diagram.getDiagramName());
		undoDiagram.setState(diagram.getState());
		this.undoStack.add(undoDiagram);
	}

	public void pushRedoCommand(Diagram diagram) {
		Diagram redoDiagram = new Diagram();
		redoDiagram.setActive(diagram.isActive());
		redoDiagram.setCommandHistory(diagram.getCommandHistory());
		
		for (Element element : diagram.getElements()) {
			redoDiagram.addElement(element);
		}
		
		redoDiagram.setDiagramApsolutePath(diagram.getDiagramApsolutePath());
		redoDiagram.setDiagramName(diagram.getDiagramName());
		redoDiagram.setState(diagram.getState());
		this.redoStack.add(redoDiagram);
	}

	public Diagram popUndoCommand() {
		Diagram diagram = this.undoStack.getLast();
		pushRedoCommand(diagram);
		this.undoStack.removeLast();
		if(!this.undoStack.isEmpty())
			diagram = this.undoStack.getLast();
		return diagram;
	}

	public Diagram popRedoCommand() {
		Diagram diagram = this.redoStack.getLast();
		pushUndoCommand(diagram);
		this.redoStack.removeLast();
		return diagram;
	}

	public  List<Diagram> getRedoStack() {
		return redoStack;
	}

	public  void setRedoStack(List<Diagram> redoStack) {
		if (redoStack == null) {
			redoStack = new Vector<Diagram>();
		}
	}

	public List<Diagram> getUndoStack() {
		return undoStack;
	}

	public  void setUndoStack(List<Diagram> undoStack) {
		if (undoStack == null) {
			undoStack = new Vector<Diagram>();
		}
	}

	public static List<Element> getElementStack() {
		return elementStack;
	}

	public static void setElementStack() {
		if(elementStack == null){
			CommandHistory.elementStack = new Vector<Element>(); 
		}
	}
	
	

}