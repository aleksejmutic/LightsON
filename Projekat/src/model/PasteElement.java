/***********************************************************************
 * Module:  PasteElement.java
 * Author:  goran
 * Purpose: Defines the Class PasteElement
 ***********************************************************************/

package model;

import java.util.List;

public class PasteElement extends AbstractUndoableCommad {

	public PasteElement(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	@Override
	public void execute() {

		Diagram diagram = this.applicationModel.getActiveDiagram();
		

		if (diagram != null) {
			List<Element> elementStack = CommandHistory.getElementStack();
			for (Element element : elementStack) {
				diagram.getElements().add(element);
				System.out.println(element.toString() + " is pasted!!!\n");
			}
		}
		applicationModel.notifyObervers();
	}
}