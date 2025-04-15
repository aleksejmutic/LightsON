/***********************************************************************
 * Module:  AbstracDiagramCommad.java
 * Author:  goran
 * Purpose: Defines the Class AbstracDiagramCommad
 ***********************************************************************/

package model;


public  class AbstractUndoableCommad implements UndoableCommands {
   protected ApplicationModel applicationModel;
   
   public AbstractUndoableCommad(ApplicationModel applicationModel) {
	this.applicationModel = applicationModel;
}
   
   
   public void execute() {
   }
   
   public void undo(){
		Diagram diagram = this.applicationModel.getActiveProject().getActiveDiagram();
		Diagram undoDiagram = diagram.getCommandHistory().popUndoCommand();
		this.applicationModel.updateActiveDiagram(undoDiagram);
		this.applicationModel.notifyObervers();
   }
   
   public void redo(){
		Diagram diagram = this.applicationModel.getActiveProject().getActiveDiagram();
		Diagram redoDiagram = diagram.getCommandHistory().popRedoCommand();
		this.applicationModel.updateActiveDiagram(redoDiagram);
		this.applicationModel.notifyObervers();
   }

}