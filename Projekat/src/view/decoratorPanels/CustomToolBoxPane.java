package view.decoratorPanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import localization.Localization;
import model.ApplicationModel;
import view.Editor;
import view.contextMenu.ToolBoxContextMenu;
import view.listeners.CustomToolboxListener;
import view.listeners.ToolBoxMouseListener;

public class CustomToolBoxPane extends JPanel {
    private static final long serialVersionUID = 1L;
    private JButton btnSelect;
    private JButton btnWire;
    private JButton btnJunctionBox;
    private JButton btnFuse;
    private JButton btnSocket;
    private JButton btnConsumer;
    private JButton btnSwitchElement;
    private JPanel toolPanel;
    private Localization localization = null;
    private ToolBoxContextMenu contextMenu;
    private JButton showToolBoxButton;
    private boolean isToolBoxVisible;
    
    private Editor graphicalEditor;
    private ApplicationModel applicationModel;

    public CustomToolBoxPane(Editor graphicalEditor, ApplicationModel applicationModel){
        localization = Localization.getInstance();
        
        this.applicationModel = applicationModel;
        this.graphicalEditor = graphicalEditor;
        // Initialize the ToolBox UI
        initializeToolBoxUI();
        // Set initial visibility state
        isToolBoxVisible = true;
        // ContextMenu setup
        addMouseListener(new ToolBoxMouseListener(contextMenu, this));
    }

    private void initializeToolBoxUI() {
        toolPanel = new JPanel();
        toolPanel.setLayout(new GridLayout(0, 3, 5, 5));
        toolPanel.setPreferredSize(new Dimension(240, 250));
        ActionListener buttonActionListener = (ActionListener) new CustomToolboxListener(applicationModel, graphicalEditor);
        
        contextMenu = new ToolBoxContextMenu();
        contextMenu.addHideToolBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideComponent(); // Hide the ToolBox when "Hide ToolBox" is selected
            }
        });

        // Set layout and size for the ToolBox
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, 0)); // Set width, height adjusts dynamically
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Add name label for the ToolBox
        JLabel titleLabel = new JLabel(localization.getString("toolBox"));
        localization.registerComponent("toolBox", titleLabel);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 17));
        add(Box.createVerticalStrut(10));
        add(titleLabel);
        add(Box.createVerticalStrut(30));

        // Button to show ToolBox again when it's hidden
        showToolBoxButton = new JButton(localization.getString("toolBox.showToolBox"));
        localization.registerComponent("toolBox.showToolBox", showToolBoxButton);
        showToolBoxButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showToolBoxButton.setVisible(false);
        showToolBoxButton.addActionListener(e -> showComponent());
        add(showToolBoxButton);

        Dimension buttonSize = new Dimension(60, 60);

        // Initialize buttons
        btnSelect = createToolBoxButton("toolBox.select", "icons/cursor.png", buttonSize);
        btnSelect.setActionCommand("select");
        btnSelect.addActionListener(buttonActionListener);
        
        btnWire = createToolBoxButton("toolBox.wire", "icons/cable.png", buttonSize);
        btnWire.setActionCommand("wire");
        btnWire.addActionListener(buttonActionListener);
       
        btnJunctionBox = createToolBoxButton("toolBox.junctionBox", "icons/box.png", buttonSize);
        btnJunctionBox.setActionCommand("junctionBox");
        btnJunctionBox.addActionListener(buttonActionListener);
        
        btnFuse = createToolBoxButton("toolBox.fuse", "icons/fuse.png", buttonSize);
        btnFuse.setActionCommand("fuse");
        btnFuse.addActionListener(buttonActionListener);
        
        btnSocket = createToolBoxButton("toolBox.socket", "icons/wall-socket.png", buttonSize);
        btnSocket.setActionCommand("socket");
        btnSocket.addActionListener(buttonActionListener);
        
        btnConsumer = createToolBoxButton("toolBox.consumer", "icons/light-bulb.png", buttonSize);
        btnConsumer.setActionCommand("consumer");
        btnConsumer.addActionListener(buttonActionListener);
        
        btnSwitchElement = createToolBoxButton("toolBox.switchElement", "icons/power-switch.png", buttonSize);
        btnSwitchElement.setActionCommand("switch");
        btnSwitchElement.addActionListener(buttonActionListener);

        // Add buttons to the tool panel
        toolPanel.add(btnSelect);
        toolPanel.add(btnWire);
        toolPanel.add(btnJunctionBox);
        toolPanel.add(btnFuse);
        toolPanel.add(btnSocket);
        toolPanel.add(btnConsumer);
        toolPanel.add(btnSwitchElement);

        JPanel toolPanelHolder = new JPanel();
        toolPanelHolder.setLayout(new FlowLayout());
        toolPanelHolder.add(toolPanel);
        this.add(toolPanelHolder);
    }

    private JButton createToolBoxButton(String tooltipKey, String iconPath, Dimension size) {
        JButton button = new JButton("");
        button.setToolTipText(localization.getString(tooltipKey));
        localization.registerComponent(tooltipKey, button);
        ImageIcon icon = new ImageIcon(iconPath);
        Image img = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setMaximumSize(size);
        button.setMinimumSize(size);
        button.setPreferredSize(size);
        return button;
    }

    public void showComponent() {
        for (Component comp : getComponents()) {
            comp.setVisible(true);
        }
        showToolBoxButton.setVisible(false);
        isToolBoxVisible = true;
        revalidate();
        repaint();
    }

    public void hideComponent() {
        for (Component comp : getComponents()) {
            if (comp != showToolBoxButton) {
                comp.setVisible(false);
            }
        }
        showToolBoxButton.setVisible(true);
        isToolBoxVisible = false;
        revalidate();
        repaint();
    }

    public boolean isToolBoxVisible() {
        return isToolBoxVisible;
    }

    public void showToolBoxButtons() {
        this.setVisible(true);
        revalidate();
        repaint();
    }

	public Editor getGraphicalEditor() {
		return graphicalEditor;
	}

	public void setGraphicalEditor(Editor graphicalEditor) {
		this.graphicalEditor = graphicalEditor;
	}

	public ApplicationModel getApplicationModel() {
		return applicationModel;
	}

	public void setApplicationModel(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}
	
	
	public void idleState() {
		btnSelect.setEnabled(false);
		btnWire.setEnabled(false);
		btnJunctionBox.setEnabled(false);
		btnFuse.setEnabled(false);
		btnSocket.setEnabled(false);
		btnConsumer.setEnabled(false);
		btnSwitchElement.setEnabled(false);
	}

	public void activeState() {
		btnSelect.setEnabled(false);
		btnWire.setEnabled(false);
		btnJunctionBox.setEnabled(false);
		btnFuse.setEnabled(false);
		btnSocket.setEnabled(false);
		btnConsumer.setEnabled(false);
		btnSwitchElement.setEnabled(false);
	}


	public void editState() {
		btnSelect.setEnabled(true);
		btnWire.setEnabled(true);
		btnJunctionBox.setEnabled(true);
		btnFuse.setEnabled(true);
		btnSocket.setEnabled(true);
		btnConsumer.setEnabled(true);
		btnSwitchElement.setEnabled(true);

	}

	public void selectionState() {
		btnSelect.setEnabled(true);
		btnWire.setEnabled(true);
		btnJunctionBox.setEnabled(true);
		btnFuse.setEnabled(true);
		btnSocket.setEnabled(true);
		btnConsumer.setEnabled(true);
		btnSwitchElement.setEnabled(true);

	}

	public void addingState() {
		btnSelect.setEnabled(true);
		btnWire.setEnabled(true);
		btnJunctionBox.setEnabled(true);
		btnFuse.setEnabled(true);
		btnSocket.setEnabled(true);
		btnConsumer.setEnabled(true);
		btnSwitchElement.setEnabled(true);
	}
    
    
}