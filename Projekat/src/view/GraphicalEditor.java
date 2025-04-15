/***********************************************************************
 * Module:  GraphicalEditor.java
 * Author:  goran
 * Purpose: Defines the Class GraphicalEditor
 ***********************************************************************/

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import model.ApplicationModel;
import model.Diagram;
import model.SelectionState;
import observer.Subject;
import view.diagramCanvas.CustomTabbedPane;
import view.diagramCanvas.DiagramCanvas;
import view.diagramCanvas.DiagramTabPane;
import view.listeners.SelectionListener;
import view.listeners.TabChangeListener;

public class GraphicalEditor extends Editor {
	private static final long serialVersionUID = 1L;
	private static CustomTabbedPane tabbedPane;

	public GraphicalEditor() {
		setPreferredSize(new Dimension(400, 200));
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setCanvas();
		setTabbedPane(this.applicationModel, this);
		add(tabbedPane);
	}

	@Override
	public void update(Subject subject) {
		super.update(subject);
	    int focusId = tabbedPane.getSelectedIndex();
	    ApplicationModel applicationModel = (ApplicationModel) subject;
	    tabbedPane.removeAll(); // Clear previous tabs
	    tabbedPane.setApplicationModel(applicationModel);
	    canvases.clear();

	    for (Diagram diagram : applicationModel.getOpenedDiagrams()) {
	        Canvas canvas = new DiagramCanvas(diagram, applicationModel);
	        canvas.setFocused(true);
	        canvases.add(canvas);
	    	if(diagram.getState() instanceof SelectionState)
	    	{
	    		canvas.addMouseListener(new SelectionListener(this));
	    	}
	    	
	        tabbedPane.addDiagramTabPane(new DiagramTabPane((DiagramCanvas) canvas), diagram.getDiagramName());
	        tabbedPane.repaint();
	    }

	    if (focusId >= 0) {
	        tabbedPane.setSelectedIndex(focusId); 
	    }
	    else
	    {
	    	tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
	    }

	    setTabbedPane(applicationModel, this); 
	}



	public static CustomTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public static void setTabbedPane(ApplicationModel applicationModel, Editor editor) {
		if (tabbedPane == null) {
			tabbedPane = new CustomTabbedPane(applicationModel);
			for (ChangeListener listener : tabbedPane.getChangeListeners()) {
				tabbedPane.removeChangeListener(listener);
			}
			tabbedPane.addChangeListener(new TabChangeListener(editor));
		}
	}

	@Override
	public List<Canvas> getCanvas() {
		return super.getCanvas();
	}

	public void setCanvas() {
		super.setCanvas();
	}
}
