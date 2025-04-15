package model.command;

import java.io.File;

import javax.swing.JFileChooser;

import model.ActiveState;
import model.ApplicationModel;
import model.IdleState;
import model.ModelCommand;

public class CreateDiagram extends ModelCommand {
	private boolean isProject;
	public CreateDiagram(ApplicationModel applicationModel) {
		super(applicationModel);
		this.isProject = false;
	}

	@Override
	public void execute() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Create New Diagram");

		fileChooser.setApproveButtonText("Create");

		if (this.getApplicationModel().getActiveProject() != null) {
			fileChooser.setCurrentDirectory(
					new File(this.getApplicationModel().getActiveProject().getProjectAbsolutePath()));
		}

		int userSelection = fileChooser.showDialog(null, "Create");

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File diagram = fileChooser.getSelectedFile();
			String filePath = diagram.getAbsolutePath();
			String fileName = diagram.getName();
			
			File directory = fileChooser.getSelectedFile().getParentFile();
	        if (directory.isDirectory()) {
	            File[] files = directory.listFiles();

	            if (files != null) {
	            	this.isProject = false;
	                for (File file : files) {
	                    if (file.isFile()) {
	                        System.out.println("Checking file: " + file.getName());
	                        if (file.getName().contains(".lghProj")) {
		                    	System.out.println("The directory is a project");
		                    	this.isProject = true;
							}
	                    }
	                }
	            }
	        } 
	        
	        if(isProject)
	        {
	        	System.out.println("The directory is a project");
	        	this.getApplicationModel().setCurrentState(new ActiveState());
	        }
	        else
	        {
	        	System.out.println("The directory is not a project");
	        	this.getApplicationModel().setCurrentState(new IdleState());
	        }

			// Output the file name and path
			System.out.println("File Name: " + fileName);
			System.out.println("File Path: " + filePath);
			
			this.getApplicationModel().getCurrentState().createDiagram(getApplicationModel(), filePath, fileName);
		}

	}

}
