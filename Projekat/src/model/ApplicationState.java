/***********************************************************************
 * Module:  ApplicationState.java
 * Author:  goran
 * Purpose: Defines the Interface ApplicationState
 ***********************************************************************/

package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

public abstract class ApplicationState {
	public void createProject(ApplicationModel applicationModel, String projectPath, String name) {
		File newProject = new File(projectPath + FileSystems.getDefault().getSeparator());

		try {
			Files.createDirectories(newProject.toPath());

			Path projectFilePath = Paths.get(newProject.getAbsolutePath(), name + ".lghProj");
			Files.createFile(projectFilePath);

			Project project = new Project(name, newProject.getAbsolutePath());
			project.setActive(true);
			applicationModel.getProjects().add(project);
			applicationModel.getExporterStrategy().exportProject(project, projectFilePath.toString());

			applicationModel.notifyObervers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openProject(ApplicationModel applicationModel, Project project) {
		for (Project modelProject : applicationModel.getProjects()) {
			if (modelProject == project) {
				modelProject.setActive(true);
			}
		}
	}

	public void closeProject(ApplicationModel applicationModel, Project project) {
		for (Project modelProject : applicationModel.getProjects()) {
			if (modelProject == project) {
				modelProject.setActive(false);
			}
		}
		applicationModel.notifyObervers();
	}

	public void removeProject(ApplicationModel applicationModel, Project project) {
		List<Project> newProjectList = new Vector<Project>();

		for (Project newListProject : applicationModel.getProjects()) {
			newProjectList.add(newListProject);
		}

		if (newProjectList.size() != 0) {
			for (Project modelProject : applicationModel.getProjects()) {
				if (modelProject == project) {
					newProjectList.remove(modelProject);
				}
			}
			applicationModel.setProjects(newProjectList);
		} else {
			System.out.println("There is no project loaded");
		}
	}

	public void deleteProject(ApplicationModel applicationModel, Project loadedProject) {
		applicationModel.getProjects().remove(loadedProject);
		try {
			Files.deleteIfExists(Paths.get(loadedProject.getProjectAbsolutePath()
					+ FileSystems.getDefault().getSeparator() + loadedProject.getProjectName() + ".lghProj"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationModel.notifyObervers();
	}

	public void createDiagram(ApplicationModel applicationModel, String diagramPath, String name) {
		Project activeProject = applicationModel.getActiveProject();

		for (Diagram diagram : activeProject.getDiagrams()) {
			diagram.setActive(false);
		}

		File newDiagram = new File(diagramPath);

		try {

			Path diagramFilePath = Paths.get(newDiagram.getAbsolutePath() + ".lghDiag");
			Files.createFile(diagramFilePath);

			Diagram diagram = new Diagram(name, newDiagram.getAbsolutePath());
			activeProject.addDiagram(diagram);
			applicationModel.getExporterStrategy().exportDiagram(diagram, diagramFilePath.toString());
			applicationModel.getExporterStrategy()
					.exportProject(activeProject, Paths
							.get(activeProject.getProjectAbsolutePath(), activeProject.getProjectName() + ".lghProj")
							.toString());

			applicationModel.notifyObervers();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeDiagram(ApplicationModel applicationModel, Diagram loadedDiagram) {
		for (Diagram diagram : applicationModel.getDiagrams()) {
			if (diagram == loadedDiagram) {
				diagram.setActive(false);
			}
		}
		applicationModel.notifyObervers();
	}

	public void openDiagram(ApplicationModel applicationModel, Diagram loadedDiagram) {
		for (Diagram diagram : applicationModel.getDiagrams()) {
			if (diagram == loadedDiagram) {
				diagram.setState(new SelectionState());
			}
		}

		applicationModel.notifyObervers();
	}

	public void removeDiagram(ApplicationModel applicationModel, Diagram loadedDiagram) {

		for (Diagram diagram : applicationModel.getDiagrams()) {
			if (diagram == loadedDiagram) {
				applicationModel.getDiagrams().remove(loadedDiagram);
			}
		}
	}

	public void deleteDiagram(ApplicationModel applicationModel, Diagram loadedDiagram) {
		applicationModel.getDiagrams().remove(loadedDiagram);
		try {
			Files.deleteIfExists(Paths.get(loadedDiagram.getDiagramApsolutePath()
					+ FileSystems.getDefault().getSeparator() + loadedDiagram.getDiagramName() + ".lghDiag"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		applicationModel.notifyObervers();
	}

	public void save(ApplicationModel applicationModel, Diagram diagram) {

		System.out
				.println(Paths.get(diagram.getDiagramApsolutePath(), diagram.getDiagramName() + ".lghDiag").toString());
		applicationModel.getExporterStrategy().exportDiagram(diagram,
				Paths.get(diagram.getDiagramApsolutePath() + ".lghDiag").toString());
		if (applicationModel.getActiveProject() != null) {
			applicationModel.getExporterStrategy()
					.exportProject(
							applicationModel.getActiveProject(), Paths
									.get(applicationModel.getActiveProject().getProjectAbsolutePath(),
											applicationModel.getActiveProject().getProjectName() + ".lghProj")
									.toString());
			System.out.println(Paths.get(applicationModel.getActiveProject().getProjectAbsolutePath(),
					applicationModel.getActiveProject().getProjectName() + ".lghProj").toString());
		}

		applicationModel.notifyObervers();
	}

	public void saveAll(ApplicationModel applicationModel) {

		for (Diagram diagram : applicationModel.getDiagrams()) {
			save(applicationModel, diagram);
		}

		if (!applicationModel.getProjects().isEmpty()) {
			for (Project activeProject : applicationModel.getProjects()) {
				for (Diagram diagram : activeProject.getDiagrams()) {
					save(applicationModel, diagram);
				}
			}
		}
		applicationModel.notifyObervers();
	}

	public void saveAs(ApplicationModel applicationModel, Diagram diagram, String newDiagramPath, String newName) {

		try {

			Path diagramFilePath = Paths.get(newDiagramPath + ".lghDiag");
			Files.createFile(diagramFilePath);
			diagram.setDiagramApsolutePath(newDiagramPath);
			applicationModel.getExporterStrategy().exportDiagram(diagram, diagramFilePath.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void importProject(ApplicationModel applicationModel, String projectPath) {
		Project loadedProject = applicationModel.getImporterStrategy().importProject(projectPath);
		applicationModel.getProjects().add(loadedProject);

		for (Project project : applicationModel.getProjects()) {
			if (project != loadedProject) {
				project.setActive(false);
			}
		}

		for (Project project : applicationModel.getProjects()) {
			if (project == loadedProject) {
				project.setActive(true);
			}
		}
		applicationModel.notifyObervers();
	}

	public void exportProjects(ApplicationModel applicationModel, Project project, String newProjectPath) {
		createProject(applicationModel, Paths.get(newProjectPath, project.getProjectName()).toString(),
				project.getProjectName());
		project.setProjectAbsolutePath(Paths.get(newProjectPath, project.getProjectName()).toString());
		for (Diagram diagram : project.getDiagrams()) {
			createDiagram(applicationModel,
					Paths.get(project.getProjectAbsolutePath(), diagram.getDiagramName()).toString(),
					diagram.getDiagramName());
		}
	}

}