package view.contextMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.ApplicationModel;
import model.Element;
import model.JunctionBox;
import model.command.GroupElements;
import model.command.UngroupElements;
import view.ContextMenu;

public class ElementContextMenu extends ContextMenu {
    private JMenuItem editMenuItem;
    private JMenuItem cutMenuItem;
    private JMenuItem copyMenuItem;
    private JMenuItem renameMenuItem;
    private JMenuItem showExampleMenuItem;
    private JMenuItem groupMenuItem;
    private JMenuItem ungroupMenuItem;

    public ElementContextMenu(Element junctionBox, ApplicationModel applicationModel) {
        // Edit
        editMenuItem = new JMenuItem("Edit");
        editMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Edit JunctionBox: " + ((JunctionBox)junctionBox).getName());
            }
        });

        // Cut
        cutMenuItem = new JMenuItem("Cut");
        cutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Cut JunctionBox: " + ((JunctionBox)junctionBox).getName());
            }
        });

        // Copy
        copyMenuItem = new JMenuItem("Copy");
        copyMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Copy JunctionBox: " + ((JunctionBox)junctionBox).getName());
            }
        });

        // Rename
        renameMenuItem = new JMenuItem("Rename");
        renameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName = JOptionPane.showInputDialog("Enter new name:");
                if (newName != null && !newName.isEmpty()) {
                	((JunctionBox)junctionBox).setName(newName);
                    JOptionPane.showMessageDialog(null, "Renamed JunctionBox to: " + newName);
                }
            }
        });

        // Show Example
        showExampleMenuItem = new JMenuItem("Show Example");
        showExampleMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Showing example for: " + ((JunctionBox)junctionBox).getName());
            }
        });
        
        groupMenuItem = new JMenuItem("Group Elements");
        groupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GroupElements groupCommand  = new GroupElements(applicationModel);
                groupCommand.execute();
            }
        });
        
        ungroupMenuItem = new JMenuItem("Ungroup Elements");
        ungroupMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UngroupElements ungroupCommand  = new UngroupElements(applicationModel);
                ungroupCommand.execute();
            }
        });

        // Add items to the context menu
        this.contextMenu.add(groupMenuItem);
        this.contextMenu.add(ungroupMenuItem);
        this.contextMenu.addSeparator();
        this.contextMenu.add(editMenuItem);
        this.contextMenu.add(cutMenuItem);
        this.contextMenu.add(copyMenuItem);
        this.contextMenu.addSeparator();
        this.contextMenu.add(renameMenuItem);
        this.contextMenu.add(showExampleMenuItem);
    }
}
