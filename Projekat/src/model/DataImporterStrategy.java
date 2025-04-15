/***********************************************************************
 * Module:  DataImporterStrategy.java
 * Author:  maril
 * Purpose: Defines the Interface DataImporterStrategy
 ***********************************************************************/

package model;


public interface DataImporterStrategy {
   /** @param url */
   Project importProject(String url);
   Diagram importDiagram(String url);

}