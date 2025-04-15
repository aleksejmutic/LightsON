package view.menubar.menu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;

import localization.Localization;
import view.ObjectBrowser;
import view.OutputTerminal;
import view.ToolBox;

public class WindowDecoratorsMenu extends Menu {
	private static final long serialVersionUID = 1L;
	private JCheckBoxMenuItem objectBrowserMenuItem = null;
	private JCheckBoxMenuItem toolboxMenuItem = null;
	private JCheckBoxMenuItem terminalMenuItem = null;
	private int objectBrowserClick = 0;
	private int toolBoxClick = 0;
	private int terminalClick = 0;
	Localization localization = null;

	public WindowDecoratorsMenu(ObjectBrowser objectBrowser, ToolBox toolBox, OutputTerminal outputTerminal) {
		super();
		
		localization = Localization.getInstance();
		
		setText(localization.getString("elementiProzora"));
		localization.registerComponent("elementiProzora", this);

		objectBrowserMenuItem = new JCheckBoxMenuItem(localization.getString("menu.windowDecorators.objectBrowser"));
		objectBrowserMenuItem.setFont(new Font("Arial", Font.PLAIN, 16));
		objectBrowserMenuItem.setSelected(true);
		objectBrowserMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				objectBrowserClick++;
				System.out.println("ObjectBrowser clicks: " + objectBrowserClick);
				// Example: you can check if even or odd
				if (objectBrowserClick % 2 == 0) {
					System.out.println("ObjectBrowser should be hidden");
					objectBrowser.showComponent();
				} else {
					System.out.println("ObjectBrowser should be shown");
					objectBrowser.hideComponent();
				}
			}
		});
		localization.registerComponent("menu.windowDecorators.objectBrowser", objectBrowserMenuItem);
		add(objectBrowserMenuItem);

		toolboxMenuItem = new JCheckBoxMenuItem(localization.getString("menu.windowDecorators.toolBox"));
		toolboxMenuItem.setFont(new Font("Arial", Font.PLAIN, 16));
		toolboxMenuItem.setSelected(true);
		toolboxMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toolBoxClick++;
				System.out.println("Toolbox clicks: " + objectBrowserClick);
				// Example: you can check if even or odd
				if (toolBoxClick % 2 == 0) {
					System.out.println("ToolBox should be hidden");
					toolBox.hideComponent();
				} else {
					System.out.println("ToolBox should be shown");
					toolBox.showComponent();
				}
			}
		});
		localization.registerComponent("menu.windowDecorators.toolBox", toolboxMenuItem);
		add(toolboxMenuItem);

		terminalMenuItem = new JCheckBoxMenuItem(localization.getString("menu.windowDecorators.terminal"));
		terminalMenuItem.setFont(new Font("Arial", Font.PLAIN, 16));
		terminalMenuItem.setSelected(true);
		terminalMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				terminalClick++;
				System.out.println("Terminal clicks: " + objectBrowserClick);
				// Example: you can check if even or odd
				if (terminalClick % 2 == 0) {
					System.out.println("Terminal should be hidden");
				} else {
					System.out.println("Terminal should be shown");
				}
			}
		});
		localization.registerComponent("menu.windowDecorators.terminal", terminalMenuItem);
		add(terminalMenuItem);
	}

	@Override
	public void idleState() {
		objectBrowserMenuItem.setEnabled(true);
		toolboxMenuItem.setEnabled(true);
		terminalMenuItem.setEnabled(true);
		
	}

	@Override
	public void activeState() {
		objectBrowserMenuItem.setEnabled(true);
		toolboxMenuItem.setEnabled(true);
		terminalMenuItem.setEnabled(true);
		
	}

	@Override
	public void editState() {
		objectBrowserMenuItem.setEnabled(true);
		toolboxMenuItem.setEnabled(true);
		terminalMenuItem.setEnabled(true);
		
	}

	@Override
	public void selectionState() {
		objectBrowserMenuItem.setEnabled(true);
		toolboxMenuItem.setEnabled(true);
		terminalMenuItem.setEnabled(true);
		
	}

	@Override
	public void addingState() {
		objectBrowserMenuItem.setEnabled(true);
		toolboxMenuItem.setEnabled(true);
		terminalMenuItem.setEnabled(true);
		
	}

	
	
}
