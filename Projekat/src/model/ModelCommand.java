package model;

public abstract class ModelCommand implements ExecutableCommand {
	ApplicationModel applicationModel;
	
	public ModelCommand(ApplicationModel applicationModel) {
		super();
		setApplicationModel(applicationModel);
	}
	
	public ApplicationModel getApplicationModel() {
		return applicationModel;
	}



	public void setApplicationModel(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}



	@Override
	public abstract void execute();

}
