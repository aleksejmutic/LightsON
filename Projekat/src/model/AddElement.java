/***********************************************************************
  * Module:  AddElement.java
 * Author:  goran
 * Purpose: Defines the Class AddElement
 ***********************************************************************/

package model;

import java.util.Vector;

public class AddElement extends AbstractUndoableCommad {
	private Element element = null;
	
	public AddElement(ApplicationModel applicationModel, Element element) {
		super(applicationModel);
		this.element = element;
	}
	@Override
	public void execute() {
	    Diagram activeDiagram = this.applicationModel.getActiveProject().getActiveDiagram();
	    activeDiagram.getElements().add(element);

	    // Create a new Diagram and copy properties from activeDiagram
	    Diagram diagram = new Diagram();
	    diagram.setDiagramName(activeDiagram.getDiagramName());
	    diagram.setDiagramApsolutePath(activeDiagram.getDiagramApsolutePath());
	    diagram.setState(activeDiagram.getState());
	    diagram.setActive(activeDiagram.isActive());
	    diagram.setCommandHistory(activeDiagram.getCommandHistory());
	    diagram.setElements(new Vector<Element>(activeDiagram.getElements()));

	    diagram.getCommandHistory().pushUndoCommand(diagram);
	    this.applicationModel.notifyObervers();
	}
}