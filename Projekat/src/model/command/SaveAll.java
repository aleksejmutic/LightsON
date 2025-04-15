package model.command;

import model.ApplicationModel;
import model.ModelCommand;

public class SaveAll extends ModelCommand {

	public SaveAll(ApplicationModel applicationModel) {
		super(applicationModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		this.getApplicationModel().getCurrentState().saveAll(getApplicationModel());
	}

}
