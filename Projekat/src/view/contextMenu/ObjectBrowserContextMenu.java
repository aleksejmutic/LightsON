package view.contextMenu;

import view.ContextMenu;
import view.decoratorPanels.ObjectBrowserPane;

import javax.swing.*;

import localization.Localization;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ObjectBrowserContextMenu extends ContextMenu {
    private JMenuItem hideObjectTreeItem;
    private ObjectBrowserPane objectBrowser = null;
    private JButton showObjectTreeButton = null;
    Localization localization = null;

    public ObjectBrowserContextMenu(ObjectBrowserPane objectBrowser, JButton showObjectTreeButton) {
        this.objectBrowser = objectBrowser;
        this.showObjectTreeButton = showObjectTreeButton;
        
        localization = Localization.getInstance();
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Create the "Hide Object Tree" menu item
        hideObjectTreeItem = new JMenuItem(localization.getString("objectBrowser.hide"));
        localization.registerComponent("objectBrowser.hide", hideObjectTreeItem);
        
        Image hideObjectMenuIcon = toolkit.getImage("icons/hide.png");
        hideObjectMenuIcon = hideObjectMenuIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		hideObjectTreeItem.setIcon(new ImageIcon(hideObjectMenuIcon));

        // Action listener for hiding the tree
        hideObjectTreeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                objectBrowser.hideComponent(); // Hide all components inside ObjectBrowser
                showObjectTreeButton.setVisible(true); // Show the "Show Object Tree" button
            }
        });

        // Add the menu item to the context menu
        contextMenu.add(hideObjectTreeItem);
        
        // Disable right-click when ObjectBrowser is hidden
        objectBrowser.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!objectBrowser.isVisible()) {
                    // If the ObjectBrowser is hidden, do not show context menu
                    return;
                }
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!objectBrowser.isVisible()) {
                    // If the ObjectBrowser is hidden, do not show context menu
                    return;
                }
                if (e.isPopupTrigger()) {
                    showMenu(e);
                }
            }
        });
    }

    private void showMenu(MouseEvent e) {
        contextMenu.show(e.getComponent(), e.getX(), e.getY());
    }

	public ObjectBrowserPane getObjectBrowser() {
		return objectBrowser;
	}

	public void setObjectBrowser(ObjectBrowserPane objectBrowser) {
		this.objectBrowser = objectBrowser;
	}

	public JButton getShowObjectTreeButton() {
		return showObjectTreeButton;
	}

	public void setShowObjectTreeButton(JButton showObjectTreeButton) {
		this.showObjectTreeButton = showObjectTreeButton;
	}
    
    
}
