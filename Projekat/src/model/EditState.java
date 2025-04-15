/***********************************************************************
 * Module:  EditState.java
 * Author:  goran
 * Purpose: Defines the Class EditState
 ***********************************************************************/

package model;

public class EditState extends ApplicationState {

	public EditState() {
		System.out.println("State is now Edit!!!");
	}
	public void closeDiagram(ApplicationModel applicationModel, Diagram diagram) {
		super.closeDiagram(applicationModel, diagram);
		applicationModel.setCurrentState(new ActiveState());
	}
}