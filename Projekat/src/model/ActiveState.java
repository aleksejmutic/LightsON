/***********************************************************************
 * Module:  ActiveState.java
 * Author:  goran
 * Purpose: Defines the Class ActiveState
 ***********************************************************************/

package model;


public class ActiveState extends ApplicationState {
	
	public ActiveState() {
		System.out.println("State is now Active!!!");
		}
   
   public void closeProject(ApplicationModel applicationModel, Project project) {
	   super.closeProject(applicationModel, project);
	      applicationModel.setCurrentState(new IdleState());
   }

   
   public void openDiagram(ApplicationModel applicationModel, Diagram diagram) {
	   super.openDiagram(applicationModel, diagram);
      applicationModel.setCurrentState(new EditState());
   }

   @Override
public String toString() {
	// TODO Auto-generated method stub
	return "Active state";
	}
}