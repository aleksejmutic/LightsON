/***********************************************************************
 * Module:  DataExporterStrategy.java
 * Author:  maril
 * Purpose: Defines the Interface DataExporterStrategy
 ***********************************************************************/

package model;

public interface DataExporterStrategy {
   void exportProject(Project project, String url);
   void exportDiagram(Diagram diagram, String url);

}