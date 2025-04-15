package view.menubar.menu;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import localization.Localization;

/** 
 * Klasa za definisanje View menija. 
 * 
 * @see Menu
 * @author Grupa 1
 * @version 1.0
 */
public class ViewMenu extends Menu{

	private static final long serialVersionUID = 1L;
	
	private MenuItem zoomInMenuItem = null;
	private MenuItem zoomOutMenuItem = null;
	private MenuItem delimiterMenuItem = null;
	private ScaleMenu scaleMenu = null;
	private Localization localization=null;
	
	public ViewMenu() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		localization = Localization.getInstance();
		
		setText(localization.getString("menu.view"));
		localization.registerComponent("menu.view", this);
		setMnemonic(KeyEvent.VK_V);
		
		zoomInMenuItem = new MenuItem(localization.getString("menu.view.zoomIn"));
		Image zoomInIcon = toolkit.getImage("icons/ZoomIn.png");
		zoomInIcon = zoomInIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		zoomInMenuItem.setIcon(new ImageIcon(zoomInIcon));
		zoomInMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6,0));
		localization.registerComponent("menu.view.zoomIn", zoomInMenuItem);
		add(zoomInMenuItem);
		
		zoomOutMenuItem = new MenuItem(localization.getString("menu.view.zoomOut"));
		Image zoomOutIcon = toolkit.getImage("icons/ZoomOut.png");
		zoomOutIcon = zoomOutIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		zoomOutMenuItem.setIcon(new ImageIcon(zoomOutIcon));
		zoomOutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7,0));
		localization.registerComponent("menu.view.zoomOut", zoomOutMenuItem);
		add(zoomOutMenuItem);
		
		delimiterMenuItem = new MenuItem(localization.getString("menu.view.gridLines"));
 		Image delimiterIcon = toolkit.getImage("icons/gridIcon.png");
 		delimiterIcon = delimiterIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
 		delimiterMenuItem.setIcon(new ImageIcon(delimiterIcon));
 		delimiterMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8,0));
 		localization.registerComponent("menu.view.gridLines", delimiterMenuItem);
 		add(delimiterMenuItem);
		
 		scaleMenu=new ScaleMenu();
 		Image scaleIcon = toolkit.getImage("icons/percent.png");
 		scaleIcon = scaleIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
 		scaleMenu.setIcon(new ImageIcon(scaleIcon));
 		add(scaleMenu);
		
		
	}

	@Override
	public void idleState() {
		zoomInMenuItem.setEnabled(false);
		zoomOutMenuItem.setEnabled(false);
		delimiterMenuItem.setEnabled(false);
		scaleMenu.setEnabled(false);
		
	}

	@Override
	public void activeState() {
		zoomInMenuItem.setEnabled(false);
		zoomOutMenuItem.setEnabled(false);
		delimiterMenuItem.setEnabled(false);
		scaleMenu.setEnabled(false);
		
	}

	@Override
	public void editState() {
		zoomInMenuItem.setEnabled(true);
		zoomOutMenuItem.setEnabled(true);
		delimiterMenuItem.setEnabled(true);
		scaleMenu.setEnabled(true);
		
	}

	@Override
	public void selectionState() {
		zoomInMenuItem.setEnabled(true);
		zoomOutMenuItem.setEnabled(true);
		delimiterMenuItem.setEnabled(true);
		scaleMenu.setEnabled(true);
		
	}

	@Override
	public void addingState() {
		zoomInMenuItem.setEnabled(true);
		zoomOutMenuItem.setEnabled(true);
		delimiterMenuItem.setEnabled(true);
		scaleMenu.setEnabled(true);
		
	}
	
	
	
	
}
