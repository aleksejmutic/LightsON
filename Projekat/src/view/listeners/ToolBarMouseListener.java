package view.listeners;



import view.contextMenu.ToolBarContextMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolBarMouseListener extends MouseAdapter {
    private ToolBarContextMenu contextMenu;

    public ToolBarMouseListener(ToolBarContextMenu contextMenu) {
        this.contextMenu = contextMenu;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) {
            showMenu(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            showMenu(e);
        }
    }

    private void showMenu(MouseEvent e) {
    	 contextMenu.getContextMenu().show(e.getComponent(), e.getX(), e.getY());
    }
}

