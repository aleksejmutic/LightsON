/***********************************************************************
 * Module:  RenameElement.java
 * Author:  goran
 * Purpose: Defines the Class RenameElement
 ***********************************************************************/

package model;


public class RenameElement extends AbstractUndoableCommad {
	private Element element;
	public RenameElement(ApplicationModel applicationModel,  Element element) {
		super(applicationModel);
		this.element = element;
		// TODO Auto-generated constructor stub
	}
	

	public Element getElement() {
		return element;
	}


	public void setElement(Element element) {
		this.element = element;
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}
}