package view.menubar.menu;


import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import localization.Localization;
import view.dialog.FontDialog;


/** 
 * Klasa za definisanje Window menija. 
 * 
 * @see Menu
 * @author Grupa 1
 * @version 1.0
 */
public class WindowMenu extends Menu{

	private static final long serialVersionUID = 1L;
	
	private MenuItem fontMenuItem = null;
	private LanguageMenu languageMenu = null;
	private Localization localization= null;
	private JCheckBoxMenuItem menuItemObjectBrowser = null;
	private JCheckBoxMenuItem menuItemToolbox = null;
	
	public WindowMenu() {
		
		localization = Localization.getInstance();
		
		setText(localization.getString("menu.window"));
		localization.registerComponent("menu.window", this);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		
	   JFrame frame = new JFrame("Osnovni prozor");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(400, 300);
		
		fontMenuItem = new MenuItem(localization.getString("menu.window.font"));
		Image fontIcon = toolkit.getImage("icons/font.png").getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		fontMenuItem.setIcon(new ImageIcon(fontIcon));
		localization.registerComponent("menu.window.font", fontMenuItem);
		fontMenuItem.addActionListener(e -> new FontDialog(frame));
		add(fontMenuItem);
		

		languageMenu = new LanguageMenu();
		Image languageIcon = toolkit.getImage("icons/speech.png").getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		languageMenu.setIcon(new ImageIcon(languageIcon));
		add(languageMenu);
		
		
	}

	@Override
	public void idleState() {
		fontMenuItem.setEnabled(false);
		languageMenu.setEnabled(true);;
		
	}

	@Override
	public void activeState() {
		fontMenuItem.setEnabled(false);
		languageMenu.setEnabled(true);
		
	}

	@Override
	public void editState() {
		fontMenuItem.setEnabled(true);
		languageMenu.setEnabled(true);
		
	}

	@Override
	public void selectionState() {
		fontMenuItem.setEnabled(true);
		languageMenu.setEnabled(true);
		
	}

	@Override
	public void addingState() {
		fontMenuItem.setEnabled(true);
		languageMenu.setEnabled(true);
		
	}

	public JCheckBoxMenuItem getMenuItemObjectBrowser() {
		return menuItemObjectBrowser;
	}

	public void setMenuItemObjectBrowser(JCheckBoxMenuItem menuItemObjectBrowser) {
		this.menuItemObjectBrowser = menuItemObjectBrowser;
	}

	public JCheckBoxMenuItem getMenuItemToolbox() {
		return menuItemToolbox;
	}

	public void setMenuItemToolbox(JCheckBoxMenuItem menuItemToolbox) {
		this.menuItemToolbox = menuItemToolbox;
	}

}
