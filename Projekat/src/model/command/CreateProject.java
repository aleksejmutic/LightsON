package model.command;

import java.io.File;

import javax.swing.JFileChooser;

import model.ApplicationModel;
import model.ModelCommand;

public class CreateProject extends ModelCommand {

	public CreateProject(ApplicationModel applicationModel) {
		super(applicationModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Create New Project");
   
        // Set the approve button text
        fileChooser.setApproveButtonText("Create");
        
        int userSelection = fileChooser.showDialog(null, "Create");
        
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File project = fileChooser.getSelectedFile();
			String filePath = project.getAbsolutePath();
			String fileName = project.getName();

			// Output the file name and path
			System.out.println("File Name: " + fileName);
			System.out.println("File Path: " + filePath);
			
			this.getApplicationModel().getCurrentState().createProject(getApplicationModel(), filePath, fileName);
		}
	}
}
