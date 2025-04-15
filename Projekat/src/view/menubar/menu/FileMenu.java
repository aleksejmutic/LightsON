package view.menubar.menu;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


import localization.Localization;
import model.ApplicationModel;
import model.command.CreateDiagram;
import model.command.CreateProject;
import model.command.ExportProject;
import model.command.ImportProject;
import model.command.SaveAll;
import model.command.SaveAs;
import model.command.SaveDiagram;
import view.listeners.ProjectCommandListener;
import view.listeners.PrintActionListener;

/** 
 * Klasa za definisanje File menija. 
 * 
 * @see Menu
 * @author Grupa 1
 * @version 1.0
 */
public class FileMenu extends Menu {

	private static final long serialVersionUID = 1L;
	 
	private MenuItem newDiagramMenuItem;
	private MenuItem newProjectMenuItem;
	private MenuItem saveMenuItem;
	private MenuItem saveAllMenuItem;
	private MenuItem saveAsMenuItem;
	private MenuItem printMenuItem;
	private MenuItem importMenuItem;
	private MenuItem exportMenuItem;
	private MenuItem exitMenuItem;
	private Localization localization=null;

	
	public FileMenu(ApplicationModel applicationModel) {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		localization = Localization.getInstance();
		
		setText(localization.getString("menu.file"));
		localization.registerComponent("menu.file", this);
		setMnemonic(KeyEvent.VK_F);
		
		newDiagramMenuItem = new MenuItem(localization.getString("menu.file.newDiagram"));
		Image newDiagramIcon = toolkit.getImage("icons/new_Diagram.png");
		newDiagramIcon = newDiagramIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		newDiagramMenuItem.setIcon(new ImageIcon(newDiagramIcon));
		newDiagramMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK));
		newDiagramMenuItem.setMnemonic(KeyEvent.VK_D);
		localization.registerComponent("menu.file.newDiagram", newDiagramMenuItem);
		newDiagramMenuItem.setActionCommand("createDiagram");
		newDiagramMenuItem.addActionListener(new ProjectCommandListener(new CreateDiagram(applicationModel), newDiagramMenuItem));
		add(newDiagramMenuItem);
		
		
		newProjectMenuItem = new MenuItem(localization.getString("menu.file.newProject"));
		Image newProjectIcon = toolkit.getImage("icons/new_Project.png");
		newProjectIcon = newProjectIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		newProjectMenuItem.setIcon(new ImageIcon(newProjectIcon));
		newProjectMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
		newProjectMenuItem.setMnemonic(KeyEvent.VK_P);
		localization.registerComponent("menu.file.newProject", newProjectMenuItem);
		newProjectMenuItem.setActionCommand("createProject");
		newProjectMenuItem.addActionListener(new ProjectCommandListener(new CreateProject(applicationModel), newProjectMenuItem));
		add(newProjectMenuItem);
		
		addSeparator();
		
		saveMenuItem = new MenuItem(localization.getString("menu.file.save"));
		Image saveIcon = toolkit.getImage("icons/Save.png");
		saveIcon = saveIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		saveMenuItem.setIcon(new ImageIcon(saveIcon));
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		saveMenuItem.setMnemonic(KeyEvent.VK_S);
		localization.registerComponent("menu.file.save", saveMenuItem);
		saveMenuItem.setActionCommand("saveDiagram");
		saveMenuItem.addActionListener(new ProjectCommandListener(new SaveDiagram(applicationModel), saveMenuItem));
		add(saveMenuItem);
		
		saveAllMenuItem = new MenuItem(localization.getString("menu.file.saveAll"));
		Image saveAllIcon = toolkit.getImage("icons/SaveAs.png");
		saveAllIcon = saveAllIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		saveAllMenuItem.setIcon(new ImageIcon(saveAllIcon));
		localization.registerComponent("menu.file.saveAll", saveAllMenuItem);
		saveAllMenuItem.setActionCommand("saveAll");
		saveAllMenuItem.addActionListener(new ProjectCommandListener(new SaveAll(applicationModel), saveAllMenuItem));
		add(saveAllMenuItem);
		
		saveAsMenuItem = new MenuItem(localization.getString("menu.file.saveAs"));
		Image saveAsIcon = toolkit.getImage("icons/SaveAs.png");
		saveAsIcon = saveAsIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		saveAsMenuItem.setIcon(new ImageIcon(saveAsIcon));
		localization.registerComponent("menu.file.saveAs", saveAsMenuItem);
		saveAsMenuItem.setActionCommand("saveAs");
		saveAsMenuItem.addActionListener(new ProjectCommandListener(new SaveAs(applicationModel), saveAsMenuItem));
		add(saveAsMenuItem);
		
		addSeparator();
		
		printMenuItem = new MenuItem(localization.getString("menu.file.print"));
		Image printIcon = toolkit.getImage("icons/Print.png");
		printIcon = printIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		printMenuItem.setIcon(new ImageIcon(printIcon));
		localization.registerComponent("menu.file.print", printMenuItem);
		add(printMenuItem);
		printMenuItem.addActionListener(new PrintActionListener("Hello, this is a test print!"));
		
		addSeparator();
		
		importMenuItem = new MenuItem(localization.getString("menu.file.import"));
		Image importIcon = toolkit.getImage("icons/Import.png");
		importIcon = importIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		importMenuItem.setIcon(new ImageIcon(importIcon));
		localization.registerComponent("menu.file.import", importMenuItem);
		importMenuItem.setActionCommand("importProject");
		importMenuItem.addActionListener(new ProjectCommandListener(new ImportProject(applicationModel), importMenuItem));
		add(importMenuItem);
		
		exportMenuItem = new MenuItem(localization.getString("menu.file.export"));
		Image exportIcon = toolkit.getImage("icons/Export.png");
		exportIcon = exportIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		exportMenuItem.setIcon(new ImageIcon(exportIcon));
		localization.registerComponent("menu.file.export", exportMenuItem);
		exportMenuItem.setActionCommand("exportProject");
		exportMenuItem.addActionListener(new ProjectCommandListener(new ExportProject(applicationModel), exportMenuItem));
		add(exportMenuItem);
		
		addSeparator();
		
		exitMenuItem = new MenuItem(localization.getString("menu.file.exit"));
		Image exitIcon = toolkit.getImage("icons/Exit.png");
		exitIcon = exitIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		exitMenuItem.setIcon(new ImageIcon(exitIcon));
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
		exitMenuItem.setMnemonic(KeyEvent.VK_E);
		localization.registerComponent("menu.file.exit", exitMenuItem);
		exitMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object[] choices = {localization.getString("menu.window.optPane.yes"), localization.getString("menu.window.optPane.no")};
				Object defaultChoice = choices[1];
			
				int response = new JOptionPane().showOptionDialog(
						getParent().getParent(), 
						localization.getString("menu.window.optPane.exitMessage"),
						localization.getString("menu.window.optPane.exit"),
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,
						choices,
						defaultChoice
						);
				
				if(response == JOptionPane.YES_OPTION)
				{
					System.exit(0);	
				}
				else;
			}
		});
		add(exitMenuItem);
	}


	@Override
	public void idleState() {
		newDiagramMenuItem.setEnabled(true);
		newProjectMenuItem.setEnabled(true);
		saveMenuItem.setEnabled(false);
		saveAllMenuItem.setEnabled(false);
		saveAsMenuItem.setEnabled(false);
		printMenuItem.setEnabled(false);
		importMenuItem.setEnabled(true);
		exportMenuItem.setEnabled(false);
		exitMenuItem.setEnabled(true);
		
	}


	@Override
	public void activeState() {
		newDiagramMenuItem.setEnabled(true);
		newProjectMenuItem.setEnabled(true);
		saveMenuItem.setEnabled(false);
		saveAllMenuItem.setEnabled(false);
		saveAsMenuItem.setEnabled(false);
		printMenuItem.setEnabled(false);
		importMenuItem.setEnabled(true);
		exportMenuItem.setEnabled(false);
		exitMenuItem.setEnabled(true);
		
	}


	@Override
	public void editState() {
		newDiagramMenuItem.setEnabled(true);
		newProjectMenuItem.setEnabled(true);
		saveMenuItem.setEnabled(true);
		saveAllMenuItem.setEnabled(true);
		saveAsMenuItem.setEnabled(true);
		printMenuItem.setEnabled(true);
		importMenuItem.setEnabled(true);
		exportMenuItem.setEnabled(true);
		exitMenuItem.setEnabled(true);
		
	}


	@Override
	public void selectionState() {
		newDiagramMenuItem.setEnabled(true);
		newProjectMenuItem.setEnabled(true);
		saveMenuItem.setEnabled(true);
		saveAllMenuItem.setEnabled(true);
		saveAsMenuItem.setEnabled(true);
		printMenuItem.setEnabled(true);
		importMenuItem.setEnabled(true);
		exportMenuItem.setEnabled(true);
		exitMenuItem.setEnabled(true);
		
	}


	@Override
	public void addingState() {
		newDiagramMenuItem.setEnabled(true);
		newProjectMenuItem.setEnabled(true);
		saveMenuItem.setEnabled(true);
		saveAllMenuItem.setEnabled(true);
		saveAsMenuItem.setEnabled(true);
		printMenuItem.setEnabled(true);
		importMenuItem.setEnabled(true);
		exportMenuItem.setEnabled(true);
		exitMenuItem.setEnabled(true);
		
	}
	
	
}
