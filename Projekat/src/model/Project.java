/***********************************************************************
 * Module:  Project.java
 * Author:  goran
 * Purpose: Defines the Class Project
 ***********************************************************************/

package model;

import java.util.List;
import java.util.Vector;

public class Project {
	private String projectName;
	private String projectAbsolutePath;
	private boolean isActive;
	private List<Diagram> diagrams;
	
	
	public Project() {

	}


	public Project(String projectName, String projectAbsolutePath) {
		setDiagrams(new Vector<Diagram>());
		setProjectName(projectName);
		setProjectAbsolutePath(projectAbsolutePath);
		setActive(true);
	}
	

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Diagram> getDiagrams() {
		return diagrams;
	}

	public void setDiagrams(List<Diagram> diagrams) {
		this.diagrams = diagrams;
	}
	

	public String getProjectAbsolutePath() {
		return projectAbsolutePath;
	}

	public void setProjectAbsolutePath(String projectAbsolutePath) {
		this.projectAbsolutePath = projectAbsolutePath;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void addDiagram(Diagram diagram) {
		diagrams.add(diagram);
	}

	public void deleteDiagram() {
	    // TODO: implement
	}

	public void closeDiagram() {
		// TODO: implement
	}

	public void createDiagram() {
		// TODO: implement
	}

	public void openDiagram() {
		// TODO: implement
	}

	public void renameDiagram() {
		// TODO: implement
	}

	public void saveDiagram() {
		// TODO: implement
	}

	public void removeDiagram(Diagram diagram) {
		diagrams.remove(diagram);
	}

	public void setCommand() {
		// TODO: implement
	}

	public void executeCommand() {
		// TODO: implement
	}
	
	public Diagram getActiveDiagram() {
		Diagram activeDiagram = null;
		
		for (Diagram diagram : this.getDiagrams()) {
			
			//return diagram;/*
			if(diagram.isActive() == true)
			{
				activeDiagram = diagram;
				System.out.println("Vracen aktivan dijagram");
			}
			
		}
		
	//	System.out.println("Vracen aktivan dijagram");
		return activeDiagram;
	}
	
	public void initDiagrams() {
        if (diagrams != null) {
            for (Diagram prohjectDiagram : diagrams) {
            	prohjectDiagram.setState(new SelectionState());
                for (Diagram diagram : diagrams) {
					for (Element element : diagram.getElements()) {
						element.initializeJunctionPoints();
					}
				}
            	prohjectDiagram.setCommandHistory(new CommandHistory());
            	prohjectDiagram.getCommandHistory().pushUndoCommand(prohjectDiagram);

            }
        }
    }
	
	@Override
	public String toString() {
		
		return this.projectName;
	}
}