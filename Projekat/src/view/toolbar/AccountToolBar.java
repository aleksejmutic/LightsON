package view.toolbar;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import localization.Localization;
import view.listeners.HtmlActionListener;

/**
 * Klasa koja definiše ToolBar za skup opcija korisničkog naloga.
 * 
 * @see JToolBar
 * @author Grupa 1
 * @version 1.0
 */
public class AccountToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	JButton registerUserButton;
	JButton logInUserButton;
	JButton logOutUserButton;
	JButton changePasswordButton;
	private Localization localization = null;

	public AccountToolBar() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		localization = Localization.getInstance();

		registerUserButton = new JButton();
		Image registeredUserIcon = toolkit.getImage("icons/user.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		registerUserButton.setIcon(new ImageIcon(registeredUserIcon));
		registerUserButton.setToolTipText(localization.getString("menu.account.register"));
		localization.registerComponent("menu.account.register", registerUserButton);
		registerUserButton.addActionListener(new HtmlActionListener("Registration.html"));
		add(registerUserButton);

		logInUserButton = new JButton();
		Image logInUserIcon = toolkit.getImage("icons/Login.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		logInUserButton.setIcon(new ImageIcon(logInUserIcon));
		logInUserButton.setToolTipText(localization.getString("menu.account.logIn"));
		localization.registerComponent("menu.account.logIn", logInUserButton);
		logInUserButton.addActionListener(new HtmlActionListener("LogIn.html"));
		add(logInUserButton);

		logOutUserButton = new JButton();
		Image logOutUserIcon = toolkit.getImage("icons/Logout.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		logOutUserButton.setIcon(new ImageIcon(logOutUserIcon));
		logOutUserButton.setToolTipText(localization.getString("menu.account.logOut"));
		localization.registerComponent("menu.account.logOut", logOutUserButton);
		logOutUserButton.addActionListener(new HtmlActionListener("LogOut.html"));
		add(logOutUserButton);

		changePasswordButton = new JButton();
		Image changePasswordIcon = toolkit.getImage("icons/lock.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		changePasswordButton.setIcon(new ImageIcon(changePasswordIcon));
		changePasswordButton.setToolTipText(localization.getString("menu.account.changePassword"));
		localization.registerComponent("menu.account.changePassword", changePasswordButton);
		changePasswordButton.addActionListener(new HtmlActionListener("ChangePassword.html"));
		add(changePasswordButton);
	}

	public void idleState() {
		registerUserButton.setEnabled(true);
		logInUserButton.setEnabled(true);
		logOutUserButton.setEnabled(true);
		changePasswordButton.setEnabled(true);
	}

	public void activeState() {
		registerUserButton.setEnabled(true);
		logInUserButton.setEnabled(true);
		logOutUserButton.setEnabled(true);
		changePasswordButton.setEnabled(true);
	}

	public void editState() {
		registerUserButton.setEnabled(true);
		logInUserButton.setEnabled(true);
		logOutUserButton.setEnabled(true);
		changePasswordButton.setEnabled(true);
	}

	public void selectionState() {
		registerUserButton.setEnabled(true);
		logInUserButton.setEnabled(true);
		logOutUserButton.setEnabled(true);
		changePasswordButton.setEnabled(true);
	}

	public void addingState() {
		registerUserButton.setEnabled(true);
		logInUserButton.setEnabled(true);
		logOutUserButton.setEnabled(true);
		changePasswordButton.setEnabled(true);
	}

}
