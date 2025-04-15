/***********************************************************************
 * Module:  DataImporter.java
 * Author:  maril
 * Purpose: Defines the Class DataImporter
 ***********************************************************************/

package model;

public class DataImporter {
	private DataImporterStrategy importerStrategy;

	public void setImporterStrategy(DataImporterStrategy importerStrategy) {
		this.importerStrategy = importerStrategy;
	}

	public DataImporterStrategy getImporterStrategy() {
		return importerStrategy;
	}

}