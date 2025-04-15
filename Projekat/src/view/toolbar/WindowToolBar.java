package view.toolbar;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

import localization.Localization;
import view.dialog.FontDialog;


/** 
 * Klasa koja definiše ToolBar za skup opcija prozora.  
 * @see JToolBar
 * @author Grupa 1
 * @version 1.0
 */
public class WindowToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	JButton fontButton;
	JButton languageButton;
	private Localization localization = null;

	public WindowToolBar() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		localization = Localization.getInstance();
		
		JFrame frame = new JFrame("Osnovni prozor");

		fontButton = new JButton();
		Image fontIcon = toolkit.getImage("icons/font.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		fontButton.setIcon(new ImageIcon(fontIcon));
		fontButton.setToolTipText(localization.getString("menu.window.font"));
		fontButton.addActionListener(e -> {
			// Create the FontDialog when the button is clicked
			new FontDialog(frame);
		});
		localization.registerComponent("menu.window.font", fontButton);
		
		add(fontButton);
	
	}
	
	
	public void idleState() {
		fontButton.setEnabled(false);

	}

	public void activeState() {
		fontButton.setEnabled(false);

	}


	public void editState() {
		fontButton.setEnabled(false);


	}

	public void selectionState() {
		fontButton.setEnabled(false);


	}

	public void addingState() {
		fontButton.setEnabled(false);

	}
}
