/***********************************************************************
 * Module:  CustomObjectBrowser.java
 * Author:  maril
 * Purpose: Defines the Class CustomObjectBrowser
 ***********************************************************************/

package view.decoratorPanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;

import localization.Localization;
import model.ApplicationModel;
import view.ContextMenu;
import view.contextMenu.ObjectBrowserContextMenu;
import view.listeners.ObjectBrowserMouseListener;
import view.objectBrowser.SearchPanel;
import view.objectBrowser.TreePanel;

public class ObjectBrowserPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton showObjectBrowserButton;
	private SearchPanel searchPanel;
	private TreePanel treePanel;
	private ContextMenu contextMenu;

	private Localization localization = null;
	private boolean isObjectBrowserVisible = true;

	public ObjectBrowserPane() {
		localization = Localization.getInstance();

		setPreferredSize(new Dimension(250, 0));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

		JLabel titleLabel = new JLabel(localization.getString("objectBrowser.label"));
		localization.registerComponent("objectBrowser.label", titleLabel);
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		add(Box.createVerticalStrut(10));
		add(titleLabel);
		add(Box.createVerticalStrut(10));

		treePanel = new TreePanel(new ApplicationModel());
		
		searchPanel = new SearchPanel(treePanel);
		searchPanel.setPreferredSize(new Dimension(250, 40));
		
		add(searchPanel);
		add(Box.createVerticalStrut(10));
		add(treePanel);

		showObjectBrowserButton = new JButton(localization.getString("objectBrowser.show"));
		localization.registerComponent("objectBrowser.show", showObjectBrowserButton);
		showObjectBrowserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		showObjectBrowserButton.setVisible(false);
		showObjectBrowserButton.addActionListener(e -> showComponent());
		add(showObjectBrowserButton);

		contextMenu = new ObjectBrowserContextMenu(this, showObjectBrowserButton);

		addMouseListener(new ObjectBrowserMouseListener((ObjectBrowserContextMenu) contextMenu, this));

	}

	public void showComponent() {
		for (Component component : getComponents()) {
			component.setVisible(true); // Show all components inside ObjectBrowser
		}
		showObjectBrowserButton.setVisible(false); // Hide the button when showing the ObjectBrowser
		isObjectBrowserVisible = true;
		revalidate();
		repaint();
	}

	public void hideComponent() {
		for (Component component : getComponents()) {
			if (component != showObjectBrowserButton) {
				component.setVisible(false); // Hide everything except the button
			}
		}
		showObjectBrowserButton.setVisible(true); // Show the button to bring back the ObjectBrowser
		isObjectBrowserVisible = false;
		revalidate();
		repaint();
	}

	public boolean isObjectBrowserVisible() {
		return isObjectBrowserVisible;
	}

	public JPanel getContentPane() {
		// TODO: implement
		return null;
	}

	public JButton getButtonClose() {
		// TODO: implement
		return null;
	}


	public void refreshTree(ApplicationModel applicationModel) {
		if (this.treePanel != null) {
			this.remove(this.treePanel);
			// Clean up the old TreePanel's listeners
			JTree oldTree = this.treePanel.getObjectTree();
			for (MouseListener listener : oldTree.getMouseListeners()) {
				oldTree.removeMouseListener(listener);
			}
		}
		TreePanel newTreePanel = new TreePanel(applicationModel);
		this.add(newTreePanel);
		this.revalidate();
		this.repaint();
		this.treePanel = newTreePanel;

	}

}