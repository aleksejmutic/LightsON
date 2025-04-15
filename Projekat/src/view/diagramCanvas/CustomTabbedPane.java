package view.diagramCanvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.ApplicationModel;
import model.Diagram;

public class CustomTabbedPane extends JTabbedPane {
	private static final long serialVersionUID = 1L;
	private ApplicationModel applicationModel;
	private List<Diagram> diagramList;
    public CustomTabbedPane(ApplicationModel applicationModel) {
    	this.applicationModel = applicationModel;
    	this.diagramList = new Vector<Diagram>();
    }

    public JPanel createTabPanel(String nameLabel) {
        JPanel tabPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        tabPanel.setOpaque(false);

        JLabel label = new JLabel(nameLabel);
        JButton closeButton = new JButton("X");
        closeButton.setPreferredSize(new Dimension(15, 15));
        closeButton.setToolTipText("Close Tab");
        closeButton.setBackground(Color.BLACK);
        closeButton.setForeground(Color.WHITE);
        closeButton.setBorder(BorderFactory.createEmptyBorder());

        closeButton.addActionListener(e -> {
            int index = indexOfTabComponent(tabPanel);
            if (index != -1) {
                removeTabAt(index);
                this.applicationModel.getOpenedDiagrams().remove(this.diagramList.get(index));
                this.applicationModel.notifyObervers();
            }
        });

        tabPanel.add(label);
        tabPanel.add(closeButton);

        return tabPanel;
    }

    public void addDiagramTabPane(DiagramTabPane tabPane, String name) {
        this.addTab(name, tabPane);
        int index = indexOfComponent(tabPane);
        if (index != -1) {
            this.setTabComponentAt(index, createTabPanel(name));
            this.diagramList.add(index, tabPane.getDiagram());
        }
    }
    public void addDocumentationTabPane(DocumentationTabPane tabPane, String name) {
        this.addTab(name, tabPane);
        int index = indexOfComponent(tabPane);
        if (index != -1) {
            this.setTabComponentAt(index, createTabPanel(name));
        }
    }

	public ApplicationModel getApplicationModel() {
		return applicationModel;
	}

	public void setApplicationModel(ApplicationModel applicationModel) {
		this.applicationModel = applicationModel;
	}

	public List<Diagram> getDiagramList() {
		return this.diagramList;
	}
    
    

}
