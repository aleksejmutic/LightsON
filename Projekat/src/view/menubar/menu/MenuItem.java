package view.menubar.menu;

import java.awt.Font;

import javax.swing.JMenuItem;

/** 
 * Klasa za definisanje izgleda svih Menu Item-a. 
 * 
 * @see JMenuItem
 * @author Grupa 1
 * @version 1.0
 */
public class MenuItem extends JMenuItem{

	private static final long serialVersionUID = 1L;
	
	public MenuItem(String text)
	{
		super(text);
		setFont(new Font("Arial", Font.PLAIN, 16));
	}

}
