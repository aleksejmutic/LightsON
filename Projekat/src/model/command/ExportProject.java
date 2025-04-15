package model.command;

import java.io.File;

import javax.swing.JFileChooser;

import model.ApplicationModel;
import model.ModelCommand;

public class ExportProject extends ModelCommand{

	public ExportProject(ApplicationModel applicationModel) {
		super(applicationModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
	       JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setDialogTitle("Export Project");

	        // Set the approve button text
	        fileChooser.setApproveButtonText("Export");
	        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	        
	        int userSelection = fileChooser.showDialog(null, "Export");

	        if (userSelection == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            String filePath = selectedFile.getAbsolutePath();

	            System.out.println("File Path: " + filePath);

	            this.getApplicationModel().getCurrentState().exportProjects(getApplicationModel(), getApplicationModel().getActiveProject(), filePath);
	        } else {
	            System.out.println("Export command canceled");
	        }
		
	}

}
