package view.toolbar;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import localization.Localization;


/** 
 * Klasa koja definiše ToolBar za skup opcija pogleda.  
 * @see JToolBar
 * @author Grupa 1
 * @version 1.0
 */
public class ViewToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	JButton zoomInButton;
	JButton zoomOutButton;
	JButton delimiterButton;
	JButton scaleButton;
	private Localization localization = null;

	public ViewToolBar() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		localization = Localization.getInstance();

		zoomInButton = new JButton();
		Image zoomInIcon = toolkit.getImage("icons/ZoomIn.png");
		zoomInIcon = zoomInIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		zoomInButton.setIcon(new ImageIcon(zoomInIcon));
		zoomInButton.setToolTipText(localization.getString("menu.view.zoomIn"));
		localization.registerComponent("menu.view.zoomIn", zoomInButton);

		zoomOutButton = new JButton();
		Image zoomOutIcon = toolkit.getImage("icons/ZoomOut.png");
		zoomOutIcon = zoomOutIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		zoomOutButton.setIcon(new ImageIcon(zoomOutIcon));
		zoomOutButton.setToolTipText(localization.getString("menu.view.zoomOut"));
		localization.registerComponent("menu.view.zoomOut", zoomOutButton);

		delimiterButton = new JButton();
		Image delimiterIcon = toolkit.getImage("icons/gridIcon.png");
		delimiterIcon = delimiterIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		delimiterButton.setIcon(new ImageIcon(delimiterIcon));
		delimiterButton.setToolTipText(localization.getString("menu.view.gridLines"));
		localization.registerComponent("menu.view.gridLines", delimiterButton);

		scaleButton = new JButton();
		Image scaleIcon = toolkit.getImage("icons/percent.png");
		scaleIcon = scaleIcon.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		scaleButton.setIcon(new ImageIcon(scaleIcon));
		scaleButton.setToolTipText(localization.getString("menu.view.scale"));
		localization.registerComponent("menu.view.scale", scaleButton);

		add(zoomInButton);
		add(zoomOutButton);
		add(delimiterButton);
		add(scaleButton);
	}
	
	public void idleState() {
		zoomInButton.setEnabled(false);
		zoomOutButton.setEnabled(false);
		delimiterButton.setEnabled(false);
		scaleButton.setEnabled(false);

	}

	public void activeState() {
		zoomInButton.setEnabled(false);
		zoomOutButton.setEnabled(false);
		delimiterButton.setEnabled(false);
		scaleButton.setEnabled(false);
	}

	public void editState() {
		zoomInButton.setEnabled(true);
		zoomOutButton.setEnabled(true);
		delimiterButton.setEnabled(true);
		scaleButton.setEnabled(true);
	}

	public void selectionState() {
		zoomInButton.setEnabled(true);
		zoomOutButton.setEnabled(true);
		delimiterButton.setEnabled(true);
		scaleButton.setEnabled(true);
	}

	public void addingState() {
		zoomInButton.setEnabled(true);
		zoomOutButton.setEnabled(true);
		delimiterButton.setEnabled(true);
		scaleButton.setEnabled(true);
	}
}
