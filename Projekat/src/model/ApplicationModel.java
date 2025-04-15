package model;

import java.util.Vector;

import observer.Observer;

public class ApplicationModel implements observer.Subject {
	private ApplicationState currentState;
	private DataExporter dataExporter;
	private DataImporter dataImporter;

	private java.util.Collection<Project> projects;
	private java.util.Collection<Diagram> diagrams;
	private java.util.Collection<Diagram> openedDiagrams;
	private ApplicationSettings settings;
	private ApplicationSettingsStrategy settingsStartegy;
	private DataImporterStrategy importerStrategy;
	private DataExporterStrategy exporterStrategy;
	private java.util.Collection<ApplicationState> applicationState;
	private java.util.Collection<Observer> obervers;

	public ApplicationModel() {
		setCurrentState(new IdleState());
		setImporterStrategy(new JsonDataImporter());
		setExporterStrategy(new JsonDataExporter());
		setSettingsStartegy(new JsonSettings());
		setDataImporter(new DataImporter());
		setDataExporter(new DataExporter());
		setSettings(new ApplicationSettings());
		setProjects(new Vector<Project>());
		setDiagrams(new Vector<Diagram>());
		setOpenedDiagrams();
		setObervers(new Vector<Observer>());

		this.dataExporter.setExporterStrategy(exporterStrategy);
		this.dataImporter.setImporterStrategy(importerStrategy);
		this.settings.setApplicationSettingsStrategy(settingsStartegy);
	}

	public ApplicationState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(ApplicationState currentState) {
		this.currentState = currentState;
	}

	public void setImporterStrategy(DataImporterStrategy importerStrategy) {
		this.importerStrategy = importerStrategy;
	}

	public void setExporterStrategy(DataExporterStrategy exporterStrategy) {
		this.exporterStrategy = exporterStrategy;
	}

	public java.util.Collection<Project> getProjects() {
		return projects;
	}

	public void setProjects(java.util.Collection<Project> projects) {
		this.projects = projects;
	}

	public java.util.Collection<Diagram> getDiagrams() {
		return diagrams;
	}

	public void setDiagrams(java.util.Collection<Diagram> diagrams) {
		this.diagrams = diagrams;
	}

	public ApplicationSettings getSettings() {
		return settings;
	}

	public void setSettings(ApplicationSettings settings) {
		this.settings = settings;
	}

	public ApplicationSettingsStrategy getSettingsStartegy() {
		return settingsStartegy;
	}

	public void setSettingsStartegy(ApplicationSettingsStrategy settingsStartegy) {
		this.settingsStartegy = settingsStartegy;
	}

	public DataImporterStrategy getImporterStrategy() {
		return importerStrategy;
	}

	public DataExporterStrategy getExporterStrategy() {
		return exporterStrategy;
	}

	public java.util.Collection<ApplicationState> getApplicationState() {
		return applicationState;
	}
	

	public DataExporter getDataExporter() {
		return dataExporter;
	}

	public void setDataExporter(DataExporter dataExporter) {
		this.dataExporter = dataExporter;
	}

	public DataImporter getDataImporter() {
		return dataImporter;
	}

	public void setDataImporter(DataImporter dataImporter) {
		this.dataImporter = dataImporter;
	}

	public void setApplicationState(java.util.Collection<ApplicationState> applicationState) {
		this.applicationState = applicationState;
	}

	/** @param state */
	public void changeState(ApplicationState state) {
		this.currentState = state;
	}
	

	@SuppressWarnings("exports")
	public java.util.Collection<Observer> getObervers() {
		return obervers;
	}

	public void setObervers(@SuppressWarnings("exports") java.util.Collection<Observer> obervers) {
		this.obervers = obervers;
	}

	@Override
	public void addObserver(@SuppressWarnings("exports") Observer observer) {
		this.obervers.add(observer);
		
	}

	@Override
	public void removeObserver(@SuppressWarnings("exports") Observer observer) {
		this.obervers.remove(observer);
	}

	@Override
	public void notifyObervers() {
		for (Observer observer : obervers) {
			observer.update(this);
		}
		
	}
	
	public Project getActiveProject() {
		Project activeProject = null;
		for (Project project : this.getProjects()) {
			if(project.isActive() == true)
			{
				activeProject = project;
			}
		}
		
		return activeProject;
	}
	
	public Diagram getActiveDiagram() {
		Diagram activeDiagram = null;
		if (this.getActiveProject() != null
				&& this.getActiveProject().getActiveDiagram() != null) {
			activeDiagram = this.getActiveProject().getActiveDiagram();
		} else {
			for (Diagram diagram : this.getDiagrams()) {
				if(diagram.isActive() == true)
					activeDiagram = diagram;
			}
		}
		
		return activeDiagram;
	}

	public java.util.Collection<Diagram> getOpenedDiagrams() {
		return openedDiagrams;
	}

	public void setOpenedDiagrams() {
		this.openedDiagrams = new Vector<Diagram>();
	}
	
	
	public void updateActiveDiagram(Diagram diagram) {
		if(getActiveProject() != null)
		{
			for (Diagram activeDiagram : getActiveProject().getDiagrams()) {
				if(activeDiagram.isActive() == true)
				{
					activeDiagram.setCommandHistory(diagram.getCommandHistory());
					activeDiagram.setDiagramName(diagram.getDiagramName());
					activeDiagram.setElements(diagram.getElements());
				}
			}
		}
		else
		{
			for (Diagram activeDiagram : getDiagrams()) {
				if(activeDiagram.isActive() == true)
				{
					activeDiagram.setCommandHistory(diagram.getCommandHistory());
					activeDiagram.setDiagramName(diagram.getDiagramName());
					activeDiagram.setElements(diagram.getElements());
				}
			}
		}
	}
	
	
	

}