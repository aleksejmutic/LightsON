/***********************************************************************
 * Module:  JsonDataExporter.java
 * Author:  maril
 * Purpose: Defines the Class JsonDataExporter
 ***********************************************************************/

package model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDataExporter implements DataExporterStrategy {

	private Gson gson;

	public JsonDataExporter() {
		setGson(new Gson());
	}

	@SuppressWarnings("exports")
	public Gson getGson() {
		return gson;
	}

	@SuppressWarnings("exports")
	public void setGson(Gson gson) {
		this.gson = gson;
	}

	public void exportProject(Project project, String url) {
		// Create a GSON instance
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            // Convert the project object to JSON
            String json = gson.toJson(project);

            // Create the path object
            Path path = Paths.get(url);

            // Print the absolute path to check
            System.out.println("Absolute path: " + path.toAbsolutePath());

            // Write JSON to file with the .lghProj extension
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                writer.write(json);
            }

            System.out.println("Project exported to JSON successfully with .lghProj extension.");

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void exportDiagram(Diagram diagram, String url) {
		// Create a GSON instance
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            // Convert the project object to JSON
            String json = gson.toJson(diagram);

            // Create the path object
            Path path = Paths.get(url);

            // Print the absolute path to check
            System.out.println("Absolute path: " + path.toAbsolutePath());

            // Write JSON to file with the .lghProj extension
            try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                writer.write(json);
            }
            System.out.println("Project exported to JSON successfully with .lghDiag extension.");

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}