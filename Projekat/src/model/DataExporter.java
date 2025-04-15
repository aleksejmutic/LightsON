/***********************************************************************
 * Module:  DataExporter.java
 * Author:  maril
 * Purpose: Defines the Class DataExporter
 ***********************************************************************/

package model;

public class DataExporter {
	private DataExporterStrategy exporterStrategy;

	public void setExporterStrategy(DataExporterStrategy exporterStrategy) {
		this.exporterStrategy = exporterStrategy;
	}

	public DataExporterStrategy getExporterStrategy() {
		return exporterStrategy;
	}

}