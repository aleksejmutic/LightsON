/***********************************************************************
 * Module:  Copy.java
 * Author:  goran
 * Purpose: Defines the Class Copy
 ***********************************************************************/

package model;

import java.awt.Point;

public class Copy extends AbstractUndoableCommad {

	public Copy(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	public void execute() {
		Diagram diagram = this.applicationModel.getActiveDiagram();

		if (diagram != null) {
			CommandHistory.getElementStack().clear();

			for (Element diagramElement : diagram.getElements()) {

				if (diagramElement.isSelected == true) {
					Element element = new JunctionBox(new Point(10,10), new Point(10,10), 100, 50);
					System.out.println(diagramElement.toString() + " is copied!!!\n");
					CommandHistory.getElementStack().add(element);
				}
			}
		}
		applicationModel.notifyObervers();
	}
}