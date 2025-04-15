package view.toolbar;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import localization.Localization;
import model.ApplicationModel;
import model.command.CreateDiagram;
import model.command.CreateProject;
import model.command.SaveAll;
import model.command.SaveDiagram;
import view.listeners.PrintActionListener;
import view.listeners.ProjectCommandListener;

/** 
 * Klasa koja definiše ToolBar za skup opcija datoteke.  
 * @see JToolBar
 * @author Grupa 1
 * @version 1.0
 */
public class FileToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	JButton newDiagramButton;
	JButton newProjectButton;
	JButton saveButton;
	JButton saveAllButton;
	JButton printButton;
	private Localization localization = null;

	public FileToolBar(ApplicationModel applicationModel) {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		localization = Localization.getInstance();

		newDiagramButton = new JButton();
		Image newDiagramIcon = toolkit.getImage("icons/new_Diagram.png");
		newDiagramIcon = newDiagramIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		newDiagramButton.setIcon(new ImageIcon(newDiagramIcon));
		newDiagramButton.setToolTipText(localization.getString("menu.file.newDiagram"));
		localization.registerComponent("menu.file.newDiagram", newDiagramButton);
		newDiagramButton.setActionCommand("createDiagram");;
		newDiagramButton.addActionListener(new ProjectCommandListener(new CreateDiagram(applicationModel), newDiagramButton));

		newProjectButton = new JButton();
		Image newProjectIcon = toolkit.getImage("icons/idea.png");
		newProjectIcon = newProjectIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		newProjectButton.setIcon(new ImageIcon(newProjectIcon));
		newProjectButton.setToolTipText(localization.getString("menu.file.newProject"));
		localization.registerComponent("menu.file.newProject", newProjectButton);
		newProjectButton.setActionCommand("createProject");
		newProjectButton.addActionListener(new ProjectCommandListener(new CreateProject(applicationModel), newProjectButton));

		saveButton = new JButton();
		Image saveIcon = toolkit.getImage("icons/Save.png");
		saveIcon = saveIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		saveButton.setIcon(new ImageIcon(saveIcon));
		saveButton.setToolTipText(localization.getString("menu.file.save"));
		localization.registerComponent("menu.file.save", saveButton);
		saveButton.setActionCommand("saveDiagram");
		saveButton.addActionListener(new ProjectCommandListener(new SaveDiagram(applicationModel), saveButton));
		
		saveAllButton = new JButton();
		Image saveAllIcon = toolkit.getImage("icons/SaveAs.png");
		saveAllIcon = saveAllIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		saveAllButton.setIcon(new ImageIcon(saveAllIcon));
		saveAllButton.setToolTipText(localization.getString("menu.file.saveAll"));
		localization.registerComponent("menu.file.saveAll", saveAllButton);
		saveAllButton.setActionCommand("saveAll");
		saveAllButton.addActionListener(new ProjectCommandListener(new SaveAll(applicationModel), saveAllButton));
		
		printButton = new JButton();
		Image printIcon = toolkit.getImage("icons/Print.png");
		printIcon = printIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		printButton.setIcon(new ImageIcon(printIcon));
		printButton.setEnabled(true); 
		printButton.setToolTipText(localization.getString("menu.file.print"));
		localization.registerComponent("menu.file.print", printButton);
		printButton.addActionListener(new PrintActionListener("Hello, this is a test print!"));
		
		add(newDiagramButton);
		add(newProjectButton);
		add(saveButton);
		add(saveAllButton);
		add(printButton);
	}
	
	
	public void idleState() {
		newDiagramButton.setEnabled(true);
		newProjectButton.setEnabled(true);
		saveButton.setEnabled(false);
		saveAllButton.setEnabled(false);
		printButton.setEnabled(false);
	}

	public void activeState() {
		newDiagramButton.setEnabled(true);
		newProjectButton.setEnabled(true);
		saveButton.setEnabled(false);
		saveAllButton.setEnabled(false);
		printButton.setEnabled(false);
	}

	public void editState() {
		newDiagramButton.setEnabled(true);
		newProjectButton.setEnabled(true);
		saveButton.setEnabled(true);
		saveAllButton.setEnabled(true);
		printButton.setEnabled(true);
	}

	public void selectionState() {
		newDiagramButton.setEnabled(true);
		newProjectButton.setEnabled(true);
		saveButton.setEnabled(true);
		saveAllButton.setEnabled(true);
		printButton.setEnabled(true);
	}

	public void addingState() {
		newDiagramButton.setEnabled(true);
		newProjectButton.setEnabled(true);
		saveButton.setEnabled(true);
		saveAllButton.setEnabled(true);
		printButton.setEnabled(true);
	}
}
