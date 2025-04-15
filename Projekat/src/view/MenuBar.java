/***********************************************************************
 * Module:  MenuBar.java
 * Author:  goran
 * Purpose: Defines the Class MenuBar
 ***********************************************************************/

package view;


import javax.swing.JMenuBar;

import model.ApplicationModel;
import observer.Subject;
import view.menubar.menu.DocumentationMenu;
import view.menubar.menu.EditMenu;
import view.menubar.menu.FileMenu;
import view.menubar.menu.HelpMenu;
import view.menubar.menu.LicenceMenu;
import view.menubar.menu.AccountMenu;
import view.menubar.menu.ViewMenu;
import view.menubar.menu.WindowDecoratorsMenu;
import view.menubar.menu.WindowMenu;


/** 
 * Klasa za definisanje izgleda i funkcionalnosti MenuBar-a. 
 * 
 * @see JMenuBar
 * @see ViewComponent
 * @author Grupa 1
 * @version 1.0
 */
public class MenuBar extends JMenuBar implements ViewComponent{


	private static final long serialVersionUID = 1L;
	
	protected FileMenu fileMenu;
	protected EditMenu editMenu;
	protected ViewMenu viewMenu;
	protected WindowMenu windowMenu;
	protected AccountMenu profileMenu;
	protected LicenceMenu licenceMenu;
	protected HelpMenu helpMenu;
	protected DocumentationMenu documentationMenu;
	protected WindowDecoratorsMenu windowDecoratorsMenu;
	protected ApplicationModel applicationModel;
	
	public MenuBar(ObjectBrowser objectBrowser, ToolBox toolbox, OutputTerminal outputTerminal) {
		
		fileMenu = new FileMenu(applicationModel);
		this.add(fileMenu);
		
		editMenu = new EditMenu(applicationModel);
		this.add(editMenu);
		
		viewMenu = new ViewMenu();
		this.add(viewMenu);
		
		windowMenu = new WindowMenu();
		this.add(windowMenu);
		
		windowDecoratorsMenu = new WindowDecoratorsMenu(objectBrowser, toolbox, outputTerminal);
		this.add(windowDecoratorsMenu);
		
	
		licenceMenu = new LicenceMenu();
		this.add(licenceMenu);
		
		profileMenu = new AccountMenu();
		this.add(profileMenu);
		
		helpMenu = new HelpMenu();
		this.add(helpMenu);
		
	}
	
	

	public ApplicationModel getApplicationModel() {
		return applicationModel;
	}



	public void setApplicationModel(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}



	@Override
	public void update(Subject subject) {
		setApplicationModel((ApplicationModel) subject);
		this.applicationModel = (ApplicationModel) subject;
		System.out.println("\nMenuBar je updateovan!!\n");
	}



	public WindowDecoratorsMenu getWindowDecoratorsMenu() {
		return windowDecoratorsMenu;
	}



	public void setWindowDecoratorsMenu(WindowDecoratorsMenu windowDecoratorsMenu) {
		this.windowDecoratorsMenu = windowDecoratorsMenu;
	}
	
	
	public void idleState() {
		fileMenu.idleState();
		editMenu.idleState();
		viewMenu.idleState();
		windowMenu.idleState();
		profileMenu.idleState();
		licenceMenu.idleState();
		helpMenu.idleState();
		//documentationMenu.idleState();
		windowDecoratorsMenu.idleState();
		
	}

	public void activeState() {
		fileMenu.activeState();
		editMenu.activeState();
		viewMenu.activeState();
		windowMenu.activeState();
		profileMenu.activeState();
		licenceMenu.activeState();
		helpMenu.activeState();
		//documentationMenu.activeState();
		windowDecoratorsMenu.activeState();
		
	}

	public void editState() {
		fileMenu.editState();
		editMenu.editState();
		viewMenu.editState();
		windowMenu.editState();
		profileMenu.editState();
		licenceMenu.editState();
		helpMenu.editState();
		//documentationMenu.editState();
		windowDecoratorsMenu.editState();
		
	}

	public void selectionState() {
		fileMenu.selectionState();
		editMenu.selectionState();
		viewMenu.selectionState();
		windowMenu.selectionState();
		profileMenu.selectionState();
		licenceMenu.selectionState();
		helpMenu.selectionState();
		//documentationMenu.selectionState();
		windowDecoratorsMenu.selectionState();
		
	}

	public void addingState() {
		fileMenu.addingState();
		editMenu.addingState();
		viewMenu.addingState();
		windowMenu.addingState();
		profileMenu.addingState();
		licenceMenu.addingState();
		helpMenu.addingState();
		//documentationMenu.addingState();
		windowDecoratorsMenu.addingState();
		
	}
	
	
}