/***********************************************************************
 * Module:  JsonDataImporter.java
 * Author:  maril
 * Purpose: Defines the Class JsonDataImporter
 ***********************************************************************/

package model;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.gsonHelpers.ElementDeserializer;

public class JsonDataImporter implements DataImporterStrategy {

	Gson gson;

	public JsonDataImporter() {
		setGson(new GsonBuilder().registerTypeAdapter(Element.class, new ElementDeserializer()).setPrettyPrinting().create());
	}

	@SuppressWarnings("exports")
	public Gson getGson() {
		return gson;
	}

	@SuppressWarnings("exports")
	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public Project importProject(String projectPath) {
		    try {
		        String jsonString = new String(Files.readAllBytes(Paths.get(projectPath)));
		        Project project = getGson().fromJson(jsonString, Project.class);
		        project.initDiagrams();
		        return project;
		    } catch (Exception e) {
		        throw new RuntimeException("Error parsing project file: " + e.getMessage(), e);
		    }
		}
	

	public Diagram importDiagram(String diagramPath) {
		Diagram diagram = null;
		try {
			String jsonString = new String(Files.readAllBytes(Paths.get(diagramPath)));
			diagram = getGson().fromJson(jsonString, Diagram.class);
			diagram.init();
			
			for (Element element : diagram.getElements()) {
				if(element instanceof JunctionBox)
				{
					element.initializeJunctionPoints();
				}
			}
			
		} catch (Exception e) {
			new Exception(e.getMessage());
		}
		return diagram;
	}

}