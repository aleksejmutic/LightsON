package view.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import model.ExecutableCommand;
import view.Window;

public class ProjectCommandListener implements ActionListener {
	private ExecutableCommand command;
	private Component component;

	public ProjectCommandListener(ExecutableCommand command, Component component) {
		this.command = command;
		this.component = component;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "createProject": {
			writeInTemrinal("Creating Project");
			command.execute();
			break;
		}
		case "createDiagram": {
			writeInTemrinal("Creating Diagram");
			command.execute();
			break;
		}
		case "importProject": {
			writeInTemrinal("Importing Project");
			command.execute();
			break;
		}
		case "saveDiagram": {
			writeInTemrinal("Saving Diagram");
			command.execute();
			break;
		}
		case "saveAll": {
			writeInTemrinal("Saving All");
			command.execute();
			break;
		}
		case "saveAs": {
			writeInTemrinal("Saving As");
			command.execute();
			break;
		}
		case "exportProject": {
			System.out.println("Exporting Project");
			command.execute();
			break;
		}
		}
	}

	public void writeInTemrinal(String text) {
		Window frame;
		if (this.component instanceof JMenuItem) {
			JPopupMenu popupMenu = (JPopupMenu) SwingUtilities.getAncestorOfClass(JPopupMenu.class, component);
			JMenu menuInvoker = (JMenu) popupMenu.getInvoker();
			frame = (Window) SwingUtilities.getWindowAncestor(menuInvoker);
		}
		else
		{
			frame = (Window) SwingUtilities.getWindowAncestor(component);
		}
		frame.getOutputTerminal().getOutputTerminalPane().appendStyledText(text);
	}
}
