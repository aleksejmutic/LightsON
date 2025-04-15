package view.listeners;

import view.contextMenu.ObjectBrowserContextMenu;
import view.decoratorPanels.ObjectBrowserPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ObjectBrowserMouseListener extends MouseAdapter {
    private ObjectBrowserContextMenu contextMenu;
    private ObjectBrowserPane objectBrowser;

    public ObjectBrowserMouseListener(ObjectBrowserContextMenu contextMenu, ObjectBrowserPane objectBrowser) {
        this.contextMenu = contextMenu;
        this.objectBrowser = objectBrowser;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Check if ObjectBrowser is visible, only then trigger context menu
        if (objectBrowser.isObjectBrowserVisible() && e.isPopupTrigger()) {
            showMenu(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Check if ObjectBrowser is visible, only then trigger context menu
        if (objectBrowser.isObjectBrowserVisible() && e.isPopupTrigger()) {
            showMenu(e);
        }
    }

    private void showMenu(MouseEvent e) {
        // Only show context menu if ObjectBrowser is visible
        if (objectBrowser.isObjectBrowserVisible()) {
            contextMenu.getContextMenu().show(e.getComponent(), e.getX(), e.getY());
        }
    }
}
