/***********************************************************************
 * Module:  ComponentDecorator.java
 * Author:  goran
 * Purpose: Defines the Class ComponentDecorator
 ***********************************************************************/

package view;
import com.javadocking.dock.LineDock;

import model.ApplicationModel;
import observer.Subject;

public abstract class ComponentDecorator extends Editor {
	private static final long serialVersionUID = 1L;
	protected Editor editor;

	public ComponentDecorator(Editor editor) {
		this.editor = editor;
	}

	public void showComponent() {
	
	}

	public void hideComponent() {

	}

	@Override
	public ApplicationModel getApplicationModel() {
		// TODO Auto-generated method stub
		return super.getApplicationModel();
	}
	
	@Override
	public void update(Subject subject) {
		super.update(subject);		
	}
	
	@Override
	public LineDock getContentPane() {
		// TODO Auto-generated method stub
		return editor.getContentPane();
	}

}