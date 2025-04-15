/***********************************************************************
 * Module:  Cut.java
 * Author:  goran
 * Purpose: Defines the Class Cut
 ***********************************************************************/

package model;

import java.util.List;
import java.util.Vector;

public class Cut extends AbstractUndoableCommad {

	public Cut(ApplicationModel applicationModel) {
		super(applicationModel);
	}

	public void execute() {

		Diagram diagram  = this.applicationModel.getActiveDiagram();
		

		if (diagram != null) {
			CommandHistory.getElementStack().clear();
			List<Element> elementList = new Vector<Element>();

			for (Element diagramElement : diagram.getElements()) {

				if (diagramElement.isSelected == true) {
					CommandHistory.getElementStack().add(diagramElement);
					elementList.add(diagramElement);
					System.out.println(diagramElement.toString() + "is cut!!!");
				}
			}

			diagram.getElements().removeAll(elementList);

			System.out.println("Uradjeno");
			applicationModel.notifyObervers();
		}
	}

}