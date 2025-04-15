package view.toolbar;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import localization.Localization;


/** 
 * Klasa koja definiše ToolBar za skup opcija licence.  
 * @see JToolBar
 * @author Grupa 1
 * @version 1.0
 */
public class LicenceToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	JButton activateLicenceButton;
	JButton deactivateLicenceButton;
	JButton renewLicenceButton;
	private Localization localization = null;

	public LicenceToolBar() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		localization = Localization.getInstance();

		activateLicenceButton = new JButton();
		Image activateLicenceIcon = toolkit.getImage("icons/licence-icon.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		activateLicenceButton.setIcon(new ImageIcon(activateLicenceIcon));
		activateLicenceButton.setToolTipText(localization.getString("menu.licence.activateLicence"));
		localization.registerComponent("menu.licence.activateLicence", activateLicenceButton);
		add(activateLicenceButton);

		deactivateLicenceButton = new JButton();
		Image deactivateLicenceIcon = toolkit.getImage("icons/deactivate.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		deactivateLicenceButton.setIcon(new ImageIcon(deactivateLicenceIcon));
		deactivateLicenceButton.setToolTipText(localization.getString("menu.licence.deactivateLicence"));
		localization.registerComponent("menu.licence.deactivateLicence", deactivateLicenceButton);
		add(deactivateLicenceButton);

		renewLicenceButton = new JButton();
		Image renewLicenceIcon = toolkit.getImage("icons/renewable.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		renewLicenceButton.setIcon(new ImageIcon(renewLicenceIcon));
		renewLicenceButton.setToolTipText(localization.getString("menu.licence.renewLicence"));
		localization.registerComponent("menu.licence.renewLicence", renewLicenceButton);
		add(renewLicenceButton);
	}
	
	
	public void idleState() {
		activateLicenceButton.setEnabled(true);
		deactivateLicenceButton.setEnabled(true);
		renewLicenceButton.setEnabled(true);

	}

	public void activeState() {
		activateLicenceButton.setEnabled(true);
		deactivateLicenceButton.setEnabled(true);
		renewLicenceButton.setEnabled(true);
	}

	public void editState() {
		activateLicenceButton.setEnabled(true);
		deactivateLicenceButton.setEnabled(true);
		renewLicenceButton.setEnabled(true);
	}

	public void selectionState() {
		activateLicenceButton.setEnabled(true);
		deactivateLicenceButton.setEnabled(true);
		renewLicenceButton.setEnabled(true);
	}

	public void addingState() {
		activateLicenceButton.setEnabled(true);
		deactivateLicenceButton.setEnabled(true);
		renewLicenceButton.setEnabled(true);
	}
}
