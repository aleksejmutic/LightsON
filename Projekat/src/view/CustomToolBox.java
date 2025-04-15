package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.javadocking.dockable.DraggableContent;
import com.javadocking.drag.DragListener;

import model.ApplicationModel;
import view.decoratorPanels.CustomToolBoxPane;

public class CustomToolBox extends JTabbedPane implements DraggableContent{
	private static final long serialVersionUID = 1L;
	private CustomToolBoxPane customToolBoxPane;
	private JButton closeButton;

	public CustomToolBox(Editor graphicalEditor, ApplicationModel applicationModel) {
		super();
		customToolBoxPane = new CustomToolBoxPane(graphicalEditor, applicationModel);
		addClosableTab("ToolBox", customToolBoxPane);
	}
	
	// Method to add a new tab with close ("X") button
    public void addClosableTab(String title, Component component) {
        this.addTab(title, component);
        int index = this.indexOfComponent(component);

        // Kreiran tab koji moze da se zatvara
        JPanel tabHeader = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tabHeader.setOpaque(false);

        JLabel titleLabel = new JLabel(title);
        closeButton = new JButton("X");

        closeButton.setMargin(new Insets(0, 4, 0, 4));
        closeButton.setFocusable(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder());
        closeButton.setFont(new Font("Arial", Font.BOLD, 12));

        // Action to close tab on clicking X
        closeButton.addActionListener(e -> {
            int tabIndex = this.indexOfComponent(component);
            if (tabIndex != -1) {
                this.remove(tabIndex);
            }
        });

        tabHeader.add(titleLabel);
        tabHeader.add(closeButton);

        this.setTabComponentAt(index, tabHeader);
    }
	
	@Override
	public void addDragListener(DragListener arg0) {
		// TODO Auto-generated method stub
		
	}

	public CustomToolBoxPane getCustomToolBoxPane() {
		return customToolBoxPane;
	}

	public void setCustomToolBoxPane(CustomToolBoxPane customToolBoxPane) {
		this.customToolBoxPane = customToolBoxPane;
	}
	
	

}
