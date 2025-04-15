/***********************************************************************
 * Module:  AddingState.java
 * Author:  maril
 * Purpose: Defines the Class AddingState
 ***********************************************************************/

package model;



public class AddingState extends DiagramState {

	@Override
	public void EnterState() {
		// TODO Auto-generated method stub
		System.out.println("Entering Adding State");
		
	}

	@Override
	public void HandleInput() {
		// TODO Auto-generated method stub
		System.out.println("Handling Adding State");
	}

	@Override
	public void ExitState() {
		// TODO Auto-generated method stub
		System.out.println("Exiting Adding State");
	}
}