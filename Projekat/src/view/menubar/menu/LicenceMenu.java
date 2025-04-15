package view.menubar.menu;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import localization.Localization;
import view.dialog.LicenceDialog;


/** 
 * Klasa za definisanje Licence menija. 
 * 
 * @see Menu
 * @author Grupa 1
 * @version 1.0
 */
public class LicenceMenu extends Menu{

	private static final long serialVersionUID = 1L;
	
	private MenuItem activateLicenceMenuItem = null;
	private MenuItem deactivateLicenceMenuItem = null;
	private MenuItem renewLicenceMenuItem = null;
	private Localization localization = null;
	
	public LicenceMenu() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		localization = Localization.getInstance();
		
		JFrame frame = new JFrame();
		
		setText(localization.getString("menu.licence"));
		localization.registerComponent("menu.licence", this);
		setMnemonic(KeyEvent.VK_V);
		
		activateLicenceMenuItem = new MenuItem(localization.getString("menu.licence.activateLicence"));
		Image activateLicenceIcon = toolkit.getImage("icons/licence-icon.png");
		activateLicenceIcon = activateLicenceIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		activateLicenceMenuItem.setIcon(new ImageIcon(activateLicenceIcon));
		localization.registerComponent("menu.licence.activateLicence", activateLicenceMenuItem);
		activateLicenceMenuItem.addActionListener(e -> new LicenceDialog(frame));
		add(activateLicenceMenuItem);
		
		deactivateLicenceMenuItem = new MenuItem(localization.getString("menu.licence.deactivateLicence"));
		Image deactivateLicenceIcon = toolkit.getImage("icons/deactivate.png");
		deactivateLicenceIcon = deactivateLicenceIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		deactivateLicenceMenuItem.setIcon(new ImageIcon(deactivateLicenceIcon));
		localization.registerComponent("menu.licence.deactivateLicence", deactivateLicenceMenuItem);
		add(deactivateLicenceMenuItem);
		
		renewLicenceMenuItem = new MenuItem(localization.getString("menu.licence.renewLicence"));
		Image renewLicenceIcon = toolkit.getImage("icons/renewable.png");
		renewLicenceIcon = renewLicenceIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		renewLicenceMenuItem.setIcon(new ImageIcon(renewLicenceIcon));
		localization.registerComponent("menu.licence.renewLicence", renewLicenceMenuItem);
		add(renewLicenceMenuItem);
		
	}

	@Override
	public void idleState() {

		
	}

	@Override
	public void activeState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectionState() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addingState() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
