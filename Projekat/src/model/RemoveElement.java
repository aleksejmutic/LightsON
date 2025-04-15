/***********************************************************************
 * Module:  RemoveElemetn.java
 * Author:  goran
 * Purpose: Defines the Class RemoveElemetn
 ***********************************************************************/

package model;

import java.util.Vector;

public class RemoveElement extends AbstractUndoableCommad {
	private Element element = null;
	
	public RemoveElement(ApplicationModel applicationModel, Element element) {
		super(applicationModel);
		this.element = element;
	}
	@Override
	public void execute() {
	    Diagram activeDiagram = this.applicationModel.getActiveProject().getActiveDiagram();
	    
	    synchronized (activeDiagram) {
	        activeDiagram.getElements().remove(element);
	    }

	    Diagram newDiagram = new Diagram();
	    newDiagram.setDiagramName(activeDiagram.getDiagramName());
	    newDiagram.setDiagramApsolutePath(activeDiagram.getDiagramApsolutePath());
	    newDiagram.setState(activeDiagram.getState());
	    newDiagram.setActive(activeDiagram.isActive());
	    newDiagram.setCommandHistory(activeDiagram.getCommandHistory());
	    
	    newDiagram.setElements(new Vector<>(activeDiagram.getElements()));

	    newDiagram.getCommandHistory().pushUndoCommand(newDiagram);
	    this.applicationModel.updateActiveDiagram(newDiagram);
	    this.applicationModel.notifyObervers(); 
	}

}