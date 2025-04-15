/***********************************************************************
 * Module:  ApplicationView.java
 * Author:  maril
 * Purpose: Defines the Class ApplicationView
 ***********************************************************************/

package view;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import localization.Localization;
import model.ApplicationModel;

public class ApplicationView {
   //Application window
   private WindowFrame windowFrame;
   private ApplicationModel appModel;
   
   
   public WindowFrame getWindow() {
      // TODO: implement
      return this.windowFrame;
   }
   
   public void setWindow(Window windowFrame) {
      // TODO: implement
	   this.windowFrame = windowFrame;
   }
   
   public ApplicationModel getApplicationModel() {
		return appModel;
   }

public ApplicationView(ApplicationModel appModel) {
	
	Localization localization = Localization.getInstance();
	localization.setLocal("sr", "RS");
	//Podesavanje look and feel-a
	try {
		com.jtattoo.plaf.fast.FastLookAndFeel.setTheme("Large-Font", "", "LightsOn");
		UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	this.appModel = appModel;
	this.windowFrame = new Window(appModel);
	System.out.println("Model je: "+appModel.getActiveDiagram());
}
   
  
}