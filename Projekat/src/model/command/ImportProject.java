package model.command;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.ApplicationModel;
import model.ModelCommand;

public class ImportProject extends ModelCommand{

	public ImportProject(ApplicationModel applicationModel) {
		super(applicationModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Import Project");

        // Set the approve button text
        fileChooser.setApproveButtonText("Import");
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("LightsOn Project Files", "lghProj");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showDialog(null, "Import");

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            System.out.println("File Path: " + filePath);

            this.getApplicationModel().getCurrentState().importProject(getApplicationModel(), filePath);
        } else {
            System.out.println("Import command canceled");
        }
		
	}

	
}
