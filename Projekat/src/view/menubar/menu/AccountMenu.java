package view.menubar.menu;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import localization.Localization;
import view.listeners.HtmlActionListener;


/** 
 * Klasa za definisanje User Profile menija. 
 * 
 * @see Menu
 * @author Grupa 1
 * @version 1.0
 */
public class AccountMenu extends Menu{
	
	private static final long serialVersionUID = 1L;
	
	private MenuItem registerUserMenuItem = null;
	private MenuItem logInUserMenuItem = null;
	private MenuItem logOutUserMenuItem = null;
	private MenuItem changePasswordMenuItem = null;
	private Localization localization=null;
	
	public AccountMenu() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		localization = Localization.getInstance();
		
		setText(localization.getString("menu.account"));
		localization.registerComponent("menu.account", this);
		setMnemonic(KeyEvent.VK_L);
		
		registerUserMenuItem = new MenuItem(localization.getString("menu.account.register"));
		Image registeredUserIcon = toolkit.getImage("icons/user.png");
		registeredUserIcon = registeredUserIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		registerUserMenuItem.setIcon(new ImageIcon(registeredUserIcon));
		localization.registerComponent("menu.account.register", registerUserMenuItem);
		registerUserMenuItem.addActionListener(new HtmlActionListener("Registration.html"));
		add(registerUserMenuItem);
		
		logInUserMenuItem = new MenuItem(localization.getString("menu.account.logIn"));
		Image logInUserIcon = toolkit.getImage("icons/Login.png");
		logInUserIcon = logInUserIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		logInUserMenuItem.setIcon(new ImageIcon(logInUserIcon));
		localization.registerComponent("menu.account.logIn", logInUserMenuItem);
		logInUserMenuItem.addActionListener(new HtmlActionListener("LogIn.html"));
		add(logInUserMenuItem);
		
		logOutUserMenuItem = new MenuItem(localization.getString("menu.account.logOut"));
		Image logOutUserIcon = toolkit.getImage("icons/Logout.png");
		logOutUserIcon = logOutUserIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		logOutUserMenuItem.setIcon(new ImageIcon(logOutUserIcon));
		localization.registerComponent("menu.account.logOut", logOutUserMenuItem);
		logOutUserMenuItem.addActionListener(new HtmlActionListener("LogOut.html"));
		add(logOutUserMenuItem);
		
		changePasswordMenuItem = new MenuItem(localization.getString("menu.account.changePassword"));
		Image changePasswordIcon = toolkit.getImage("icons/lock.png");
		changePasswordIcon = changePasswordIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		changePasswordMenuItem.setIcon(new ImageIcon(changePasswordIcon));
		localization.registerComponent("menu.account.changePassword", changePasswordMenuItem);
		changePasswordMenuItem.addActionListener(new HtmlActionListener("ChangePassword.html"));
		add(changePasswordMenuItem);
		
	}

	@Override
	public void idleState() {
		registerUserMenuItem.setEnabled(true);
		logInUserMenuItem.setEnabled(true);
		logOutUserMenuItem.setEnabled(true);
		changePasswordMenuItem.setEnabled(true);
		
	}

	@Override
	public void activeState() {
		registerUserMenuItem.setEnabled(true);
		logInUserMenuItem.setEnabled(true);
		logOutUserMenuItem.setEnabled(true);
		changePasswordMenuItem.setEnabled(true);
		
	}

	@Override
	public void editState() {
		registerUserMenuItem.setEnabled(true);
		logInUserMenuItem.setEnabled(true);
		logOutUserMenuItem.setEnabled(true);
		changePasswordMenuItem.setEnabled(true);
		
	}

	@Override
	public void selectionState() {
		registerUserMenuItem.setEnabled(true);
		logInUserMenuItem.setEnabled(true);
		logOutUserMenuItem.setEnabled(true);
		changePasswordMenuItem.setEnabled(true);
		
	}

	@Override
	public void addingState() {
		registerUserMenuItem.setEnabled(true);
		logInUserMenuItem.setEnabled(true);
		logOutUserMenuItem.setEnabled(true);
		changePasswordMenuItem.setEnabled(true);
		
	}
	
	
	
	
}
