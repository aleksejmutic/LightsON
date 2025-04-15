package view.menubar.menu;

import java.awt.Font;

import javax.swing.JMenu;


/** 
 * Klasa za definisanje osnovnog izgleda Menija. 
 * Nasljedjuju je svi Meniji.
 * 
 * @see JMenu
 * @author Grupa 1
 * @version 1.0
 */
public abstract class Menu extends JMenu{


	private static final long serialVersionUID = 1L;

	
	public Menu() {
		setFont(new Font("Arial", Font.PLAIN, 16));
		setFocusable(false);
	}
	
	public abstract void idleState();
	public abstract void activeState();
	public abstract void editState();
	
	public abstract void selectionState();
	public abstract void addingState();
	
	

}
