package view.contextMenu;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;

import localization.Localization;

public class ToolBoxContextMenu {
    private JPopupMenu contextMenu;
    private JMenuItem hideToolBoxItem;
    Localization localization = null;

    public ToolBoxContextMenu() {
    	
    	localization = Localization.getInstance();
    	
    	Toolkit toolkit = Toolkit.getDefaultToolkit();
    	
        contextMenu = new JPopupMenu();

        // Create the "Hide ToolBox" menu item
        hideToolBoxItem = new JMenuItem(localization.getString("toolBox.hideToolBox"));
        localization.registerComponent("toolBox.hideToolBox", hideToolBoxItem);
        Image hideToolBoxImage = toolkit.getImage("icons/hide.png");
        hideToolBoxImage = hideToolBoxImage.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
        hideToolBoxItem.setIcon(new ImageIcon(hideToolBoxImage));

        // Add the menu item to the context menu
        contextMenu.add(hideToolBoxItem);
    }

    // Method to add action listener for hiding the ToolBox
    public void addHideToolBoxListener(ActionListener actionListener) {
        hideToolBoxItem.addActionListener(actionListener);
    }

    // Get the context menu
    public JPopupMenu getContextMenu() {
        return contextMenu;
    }
}
