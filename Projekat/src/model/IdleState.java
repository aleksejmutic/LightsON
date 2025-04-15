/***********************************************************************
 * Module:  IdleState.java
 * Author:  goran
 * Purpose: Defines the Class IdleState
 ***********************************************************************/

package model;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IdleState extends ApplicationState {
	
	public IdleState() {
		System.out.println("State is now Idle!!!");
	}
	
   public void createProject(ApplicationModel applicationModel, String projectPath, String name) {
	   super.createProject(applicationModel, projectPath, name);
	   applicationModel.setCurrentState(new ActiveState());
   }
   
   public void openProject(ApplicationModel applicationModel, Project project) {
	   super.openProject(applicationModel, project);
	   applicationModel.setCurrentState(new ActiveState());
   }
   
   @Override
public void createDiagram(ApplicationModel applicationModel, String diagramPath, String name) {
	    File newDiagram = new File(diagramPath);

	    try {

	        Path projectFilePath = Paths.get(newDiagram.getAbsolutePath() + ".lghDiag");
	        Files.createFile(projectFilePath);

	        Diagram diagram = new Diagram(name, newDiagram.getAbsolutePath());
	        applicationModel.getDiagrams().add(diagram);
	        applicationModel.getExporterStrategy().exportDiagram(diagram, projectFilePath.toString());

	        applicationModel.setCurrentState(new ActiveState());
	        applicationModel.notifyObervers();
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
}
   
   @Override
public void importProject(ApplicationModel applicationModel, String projectPath) {
	super.importProject(applicationModel, projectPath);
	applicationModel.setCurrentState(new ActiveState());
}
   

}