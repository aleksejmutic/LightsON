package view.contextMenu;

import javax.swing.*;

import localization.Localization;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ContextMenu;

public class ToolBarContextMenu extends ContextMenu {
    private JMenuItem hideToolbarItem;
    private JToolBar toolBar;
    private JButton showToolbarButton;
    private JFrame parentFrame;
    Localization localization = null;

    public ToolBarContextMenu(JFrame parentFrame, JToolBar toolBar, JButton showToolbarButton) {
        super(); // Call parent constructor to initialize the context menu
        
        localization = Localization.getInstance();

        this.parentFrame = parentFrame;
        this.toolBar = toolBar;
        this.showToolbarButton = showToolbarButton;
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // Initialize the "Hide Toolbar" menu item
        hideToolbarItem = new JMenuItem(localization.getString("toolBar.hideToolBar"));
        localization.registerComponent("toolBar.hideToolBar", hideToolbarItem);

        Image hideToolbarIcon = toolkit.getImage("icons/hide.png");
        hideToolbarIcon = hideToolbarIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
        hideToolbarItem.setIcon(new ImageIcon(hideToolbarIcon));
        
        hideToolbarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toolBar.setVisible(false); // Hide the toolbar
                showToolbarButton.setVisible(true); // Show the "Show Toolbar" button
                parentFrame.revalidate();
                parentFrame.repaint();
            }
        });

        // Add the menu item to the context menu
        contextMenu.add(hideToolbarItem);
    }

	public JToolBar getToolBar() {
		return toolBar;
	}

	public void setToolBar(JToolBar toolBar) {
		this.toolBar = toolBar;
	}

	public JButton getShowToolbarButton() {
		return showToolbarButton;
	}

	public void setShowToolbarButton(JButton showToolbarButton) {
		this.showToolbarButton = showToolbarButton;
	}

	public JFrame getParentFrame() {
		return parentFrame;
	}

	public void setParentFrame(JFrame parentFrame) {
		this.parentFrame = parentFrame;
	}
    
    
    
}
