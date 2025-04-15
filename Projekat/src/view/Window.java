/***********************************************************************
 * Module:  Window.java
 * Author:  maril
 * Purpose: Defines the Class Window
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.HeadlessException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import localization.Localization;
import model.ApplicationModel;
import observer.Observer;
import view.contextMenu.ToolBarContextMenu;
import view.listeners.ToolBarMouseListener;

/**
 * Klasa za definisanje glavnog prozora sa svim komponentama prikaza.
 * 
 * @see WindowFrame
 * @author Grupa 1
 * @version 1.0
 */
public class Window extends WindowFrame {
	private static final long serialVersionUID = 1L;

	private ViewComponent menuBar;
	private ViewComponent toolBar;
	private JButton showToolbarButton;
	private ViewComponent graphicalEditor;
	private ViewComponent objectBrowser;
	private ViewComponent toolBox;
	private ViewComponent statusBar = null;
	private ViewComponent outputTerminal= null;
	Localization localization = null;

	public Window(ApplicationModel applicationModel) throws HeadlessException {
		super();
		
		SwingUtilities.invokeLater(() -> {
			
			localization = Localization.getInstance();
			
			graphicalEditor = new GraphicalEditor();
			this.viewComponents.add(graphicalEditor);

			objectBrowser = new ObjectBrowser((Editor) graphicalEditor);
			this.viewComponents.add(objectBrowser);
			
			toolBox = new ToolBox((Editor) graphicalEditor, applicationModel);
			this.viewComponents.add(toolBox);
			
			outputTerminal = new OutputTerminal();
			
			menuBar = new MenuBar((ObjectBrowser)objectBrowser, (ToolBox) toolBox, (OutputTerminal)outputTerminal);
			setJMenuBar((JMenuBar) menuBar);
			this.viewComponents.add(menuBar);
		

			toolBar = new ToolBar(applicationModel);
			add((Component) toolBar, BorderLayout.NORTH);
			this.viewComponents.add(toolBar);

			showToolbarButton = new JButton(localization.getString("toolBar.showToolBar"));
			localization.registerComponent("toolBar.showToolBar", showToolbarButton);
			showToolbarButton.setVisible(false);
			showToolbarButton.addActionListener(e -> {
				((ToolBar) toolBar).setVisible(true); // Show the toolbar
				showToolbarButton.setVisible(false); // Hide the button
				revalidate();
				repaint();
			});

			((MenuBar) menuBar).add(Box.createHorizontalGlue()); // Push button to the right
			((MenuBar) menuBar).add(showToolbarButton);

			// Create context menu and add the mouse listener to the ToolBar
			ToolBarContextMenu contextMenu = new ToolBarContextMenu(this, ((ToolBar)toolBar), showToolbarButton);
			((ToolBar) toolBar).addMouseListener(new ToolBarMouseListener(contextMenu));

			
			statusBar = new StatusBar();
			this.viewComponents.add(statusBar);
			
           

         // Wrap GraphicalEditor in a panel (editorPanel)
            JPanel editorPanel = new JPanel(new BorderLayout());
            editorPanel.add((GraphicalEditor)graphicalEditor, BorderLayout.CENTER);
            
            // Bottom Panel (StatusBar + OutputTerminal)
            JPanel bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.add((StatusBar)statusBar, BorderLayout.NORTH);
            bottomPanel.add((OutputTerminal)outputTerminal, BorderLayout.SOUTH);

            // Add bottomPanel below the GraphicalEditor
            editorPanel.add(bottomPanel, BorderLayout.SOUTH);

            // Add components to the main layout
            add(((ObjectBrowser) objectBrowser).getCustomObjectBrowser(), BorderLayout.WEST);
            add((ToolBox) toolBox, BorderLayout.EAST);
            add(editorPanel, BorderLayout.CENTER);

			revalidate();
			repaint();

			// prozor je vidljiv
			setVisible(true);
			
			for (Observer observer : this.viewComponents) {
				applicationModel.addObserver(observer);
			}

			super.setViewComponents(this.viewComponents);
		});
		
		
	}

	public OutputTerminal getOutputTerminal() {
		return (OutputTerminal) outputTerminal;
	}

	public void setOutputTerminal(OutputTerminal outputTerminal) {
		this.outputTerminal = outputTerminal;
	}
	
	
}