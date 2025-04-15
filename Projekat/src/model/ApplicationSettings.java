/***********************************************************************
 * Module:  ApplicationSettings.java
 * Author:  goran
 * Purpose: Defines the Class ApplicationSettings
 ***********************************************************************/

package model;

public class ApplicationSettings {
	private ApplicationSettingsStrategy settingsStrategy;

	public void setApplicationSettingsStrategy(ApplicationSettingsStrategy applicationSettings) {
		this.settingsStrategy = applicationSettings;
	}

	public ApplicationSettingsStrategy getApplicationSettingsStrategy() {
		return settingsStrategy;
	}

}