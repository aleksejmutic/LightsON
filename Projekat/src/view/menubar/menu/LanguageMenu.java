package view.menubar.menu;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import localization.Localization;
import view.listeners.LanguageActionListener;


/** 
 * Klasa za definisanje Language menija. 
 * 
 * @see Menu
 * @author Grupa 1
 * @version 1.0
 */
public class LanguageMenu extends Menu{

	private static final long serialVersionUID = 1L;
	private MenuItem serbianLatinLanguageMenuItem = null;
	private MenuItem serbianCyrilicLanguageMenuItem = null;
	private MenuItem englishLanguageMenuItem = null;
	private Localization localization = null;
	private LanguageActionListener langActionListener = new LanguageActionListener();
	
	public LanguageMenu(){
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		localization = Localization.getInstance();
		
		setText(localization.getString("menu.lang"));
		localization.registerComponent("menu.lang", this);
		
		serbianLatinLanguageMenuItem = new MenuItem(localization.getString("menu.lang.serbianLatin"));
		Image serbianLatinIcon = toolkit.getImage("icons/serbia.png");
		serbianLatinIcon = serbianLatinIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		serbianLatinLanguageMenuItem.setIcon(new ImageIcon(serbianLatinIcon));
		serbianLatinLanguageMenuItem.setActionCommand("serbian");
		serbianLatinLanguageMenuItem.addActionListener(langActionListener);
		localization.registerComponent("menu.lang.serbianLatin", serbianLatinLanguageMenuItem);
		add(serbianLatinLanguageMenuItem);
		
		serbianCyrilicLanguageMenuItem = new MenuItem(localization.getString("menu.lang.serbianCyrilic"));
		Image serbianCyrilicIcon = toolkit.getImage("icons/serbia.png");
		serbianCyrilicIcon = serbianCyrilicIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		serbianCyrilicLanguageMenuItem.setIcon(new ImageIcon(serbianCyrilicIcon));
		serbianCyrilicLanguageMenuItem.setActionCommand("serbiancyrilic");
		serbianCyrilicLanguageMenuItem.addActionListener(langActionListener);
		localization.registerComponent("menu.lang.serbianCyrilic", serbianCyrilicLanguageMenuItem);
		add(serbianCyrilicLanguageMenuItem);
		
		englishLanguageMenuItem = new MenuItem(localization.getString("menu.lang.english"));
		Image englishIcon = toolkit.getImage("icons/united-kingdom.png");
		englishIcon = englishIcon.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
		englishLanguageMenuItem.setIcon(new ImageIcon(englishIcon));
		englishLanguageMenuItem.setActionCommand("english");
		englishLanguageMenuItem.addActionListener(langActionListener);
		localization.registerComponent("menu.lang.english", englishLanguageMenuItem);
		add(englishLanguageMenuItem);
		
	}

	@Override
	public void idleState() {
		serbianLatinLanguageMenuItem.setEnabled(true);
		serbianCyrilicLanguageMenuItem.setEnabled(true);
		englishLanguageMenuItem.setEnabled(true);
		
	}

	@Override
	public void activeState() {
		serbianLatinLanguageMenuItem.setEnabled(true);
		serbianCyrilicLanguageMenuItem.setEnabled(true);
		englishLanguageMenuItem.setEnabled(true);
		
	}

	@Override
	public void editState() {
		serbianLatinLanguageMenuItem.setEnabled(true);
		serbianCyrilicLanguageMenuItem.setEnabled(true);
		englishLanguageMenuItem.setEnabled(true);
		
	}

	@Override
	public void selectionState() {
		serbianLatinLanguageMenuItem.setEnabled(true);
		serbianCyrilicLanguageMenuItem.setEnabled(true);
		englishLanguageMenuItem.setEnabled(true);
		
	}

	@Override
	public void addingState() {
		serbianLatinLanguageMenuItem.setEnabled(true);
		serbianCyrilicLanguageMenuItem.setEnabled(true);
		englishLanguageMenuItem.setEnabled(true);
		
	}
	
	

}
