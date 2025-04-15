package model.command;

import model.ApplicationModel;
import model.ModelCommand;

public class SaveDiagram extends ModelCommand{

	public SaveDiagram(ApplicationModel applicationModel) {
		super(applicationModel);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute() {
		if(getApplicationModel().getActiveProject() != null)
			this.getApplicationModel().getCurrentState().save(getApplicationModel(), getApplicationModel().getActiveProject().getActiveDiagram());
		else
			this.getApplicationModel().getCurrentState().save(getApplicationModel(), getApplicationModel().getActiveDiagram());
		
	}

}
