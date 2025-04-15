package view.contextMenu;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import localization.Localization;

import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ContextMenu;
import view.decoratorPanels.OutputTerminalPane;

public class TerminalContextMenu extends ContextMenu {
    private JMenuItem hideTerminalItem;
    Localization localization = null;

    public TerminalContextMenu(OutputTerminalPane outputTerminal) {
        super();        
        localization = Localization.getInstance();
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        hideTerminalItem = new JMenuItem(localization.getString("terminal.hide"));
        localization.registerComponent("terminal.hide", hideTerminalItem);
        Image hideObjectMenuIcon = toolkit.getImage("icons/hide.png");
        hideObjectMenuIcon = hideObjectMenuIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
        hideTerminalItem.setIcon(new ImageIcon(hideObjectMenuIcon));

        hideTerminalItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTerminal.hideTerminal();
            }
        });

        contextMenu.add(hideTerminalItem); // Use `contextMenu` from ContextMenu
    }
    
 // Method to show the context menu at the specified location
    public void showMenu(Component invoker, int x, int y) {
        contextMenu.show(invoker, x, y);
    }
}
