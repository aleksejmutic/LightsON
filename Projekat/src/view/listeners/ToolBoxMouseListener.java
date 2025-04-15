package view.listeners;

import view.contextMenu.ToolBoxContextMenu;
import view.decoratorPanels.CustomToolBoxPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolBoxMouseListener extends MouseAdapter {
    private ToolBoxContextMenu contextMenu;
    private CustomToolBoxPane toolBox;

    public ToolBoxMouseListener(ToolBoxContextMenu contextMenu, CustomToolBoxPane customToolBox) {
        this.contextMenu = contextMenu;
        this.toolBox = customToolBox;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (toolBox.isToolBoxVisible() && e.isPopupTrigger()) {
            showMenu(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (toolBox.isToolBoxVisible() && e.isPopupTrigger()) {
            showMenu(e);
        }
    }

    private void showMenu(MouseEvent e) {
        contextMenu.getContextMenu().show(e.getComponent(), e.getX(), e.getY());
    }
}
