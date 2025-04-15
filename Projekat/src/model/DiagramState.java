/***********************************************************************
 * Module:  DiagramState.java
 * Author:  maril
 * Purpose: Defines the Interface DiagramState
 ***********************************************************************/

package model;

public abstract class DiagramState {
	protected Diagram diagram;

	public void setDiagram(Diagram diagram) {
	    this.diagram = diagram;
	}
	
	
	public abstract void EnterState();
    public abstract void HandleInput();
    public abstract void ExitState();
}