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

import observer.Subject;
import view.decoratorPanels.OutputTerminalPane;

public class OutputTerminal  extends JTabbedPane implements DraggableContent, ViewComponent{
	private static final long serialVersionUID = 1L;
	private OutputTerminalPane outputTerminalPane;
	private JButton closeButton;
	
	
	public OutputTerminal() {
		super();
		outputTerminalPane = new OutputTerminalPane();
		addClosableTab("Output Terminal", outputTerminalPane);
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

        //Zatvara se na dugme X na tabu
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
		addMouseListener(arg0);
		addMouseMotionListener(arg0);
	}


	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub
		
	}

	public OutputTerminalPane getOutputTerminalPane() {
		return outputTerminalPane;
	}

	public void setOutputTerminalPane(OutputTerminalPane outputTerminalPane) {
		this.outputTerminalPane = outputTerminalPane;
	}
	
	
}
