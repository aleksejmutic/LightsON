package view;
import javax.swing.*;

import com.javadocking.dockable.DraggableContent;
import com.javadocking.drag.DragListener;

import view.decoratorPanels.ObjectBrowserPane;

import java.awt.*;

public class CustomObjectBrowser extends JTabbedPane implements DraggableContent{
	private static final long serialVersionUID = 1L;
	private ObjectBrowserPane objectBrowserPane;
	private JButton closeButton;
	
    public CustomObjectBrowser() {
        super();
        objectBrowserPane = new ObjectBrowserPane();
        addClosableTab("ObjectBrowser", objectBrowserPane);
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

	public ObjectBrowserPane getObjectBrowserPane() {
		return objectBrowserPane;
	}

	public void setObjectBrowserPane(ObjectBrowserPane objectBrowserPane) {
		this.objectBrowserPane = objectBrowserPane;
	}
	
	@Override
	public void addDragListener(DragListener arg0) {
		addMouseListener(arg0);
		addMouseMotionListener(arg0);
	}

	public JButton getCloseButton() {
		return closeButton;
	}

	public void setCloseButton(JButton closeButton) {
		this.closeButton = closeButton;
	}
    
	
	
    
}
