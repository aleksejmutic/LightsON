/***********************************************************************
 * Module:  ProjectCommand.java
 * Author:  goran
 * Purpose: Defines the Class ProjectCommand
 ***********************************************************************/

package model;

public abstract class ProjectCommand implements ExecutableCommand {
   protected Project project;
   
   
   public ProjectCommand(Project project) {
	super();
	setProject(project);
}


public Project getProject() {
	return project;
}


public void setProject(Project project) {
	this.project = project;
}

public void execute() {
      
   }

}