/***********************************************************************
 * Module:  Editor.java
 * Author:  goran
 * Purpose: Defines the Class Editor
 ***********************************************************************/

package view;

import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import com.javadocking.dock.LineDock;

import model.ApplicationModel;
import model.Diagram;
import observer.Subject;

public abstract class Editor extends JPanel implements ViewComponent {
	private static final long serialVersionUID = 1L;
	private java.util.Collection<Diagram> diagrams;
	protected List<Canvas> canvases;
	private LineDock contentPane;
	
	protected ApplicationModel applicationModel;
	
	public java.util.Collection<Diagram> getDiagrams() {
		return diagrams;
	}
	
	public Editor() {
		setCanvas();
		contentPane = new LineDock();
	}

	public void setDiagrams(java.util.Collection<Diagram> diagrams) {
		this.diagrams = diagrams;
	}

	public ApplicationModel getApplicationModel() {
		return applicationModel;
	}

	public List<Canvas> getCanvas()
	{
		return this.canvases;
	}
	
	public Canvas getFocusedCanvas()
	{
		Canvas focusedCanvas = null;
		for (Canvas canvas : canvases) {
			if(canvas.isFocused)
			{
				focusedCanvas = canvas;
			}
		}
		return focusedCanvas;
	}
	
	
	
	protected void setCanvas()
	{
		if(this.canvases == null)
			this.canvases = new Vector<Canvas>();
	}
	
	@Override
	public void update(Subject subject) {
		this.applicationModel = (ApplicationModel) subject;
		this.repaint();
		this.updateUI();
		
		for (Canvas canvas : canvases) {
			canvas.repaint();
		}
		
	}
	
	
	public LineDock getContentPane() {
		return contentPane;
	}
}