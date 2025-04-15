package view.menubar.menu;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


import localization.Localization;
import view.listeners.HtmlActionListener;

public class HelpMenu extends Menu {

    private static final long serialVersionUID = 1L;

    private MenuItem onlineHelpMenuItem = null;
    private MenuItem FAQMenuItem = null;
    private MenuItem aboutLightsOnMenuItem = null;
    private Localization localization = null;

    public HelpMenu() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        localization = Localization.getInstance();

        setText(localization.getString("menu.help"));
        localization.registerComponent("menu.help", this);
        setMnemonic(KeyEvent.VK_V);

        // Online Help Menu Item
        onlineHelpMenuItem = new MenuItem(localization.getString("menu.help.onlineHelp"));
        Image onlineHelpIcon = toolkit.getImage("icons/online_help.png").getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        onlineHelpMenuItem.setIcon(new ImageIcon(onlineHelpIcon));
        localization.registerComponent("menu.help.onlineHelp", onlineHelpMenuItem);
        add(onlineHelpMenuItem);
        onlineHelpMenuItem.addActionListener(new HtmlActionListener("OnlineHelp.html"));

        // FAQ Menu Item
        FAQMenuItem = new MenuItem(localization.getString("menu.help.FAQ"));
        Image FAQIcon = toolkit.getImage("icons/information.png").getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        FAQMenuItem.setIcon(new ImageIcon(FAQIcon));
        localization.registerComponent("menu.help.FAQ", FAQMenuItem);
        add(FAQMenuItem);
        FAQMenuItem.addActionListener(new HtmlActionListener("FAQ.html"));

        // About Lights On Menu Item
        aboutLightsOnMenuItem = new MenuItem(localization.getString("menu.help.about"));
        Image aboutLightsOnIcon = toolkit.getImage("icons/LightsOnLogo.png").getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        aboutLightsOnMenuItem.setIcon(new ImageIcon(aboutLightsOnIcon));
        localization.registerComponent("menu.help.about", aboutLightsOnMenuItem);
        add(aboutLightsOnMenuItem);
        aboutLightsOnMenuItem.addActionListener(new HtmlActionListener("AboutLightsOn.html"));
    }

	@Override
	public void idleState() {
		onlineHelpMenuItem.setEnabled(true);
		FAQMenuItem.setEnabled(true);
		aboutLightsOnMenuItem.setEnabled(true);
	}

	@Override
	public void activeState() {
		onlineHelpMenuItem.setEnabled(true);
		FAQMenuItem.setEnabled(true);
		aboutLightsOnMenuItem.setEnabled(true);
		
	}

	@Override
	public void editState() {
		onlineHelpMenuItem.setEnabled(true);
		FAQMenuItem.setEnabled(true);
		aboutLightsOnMenuItem.setEnabled(true);
		
	}

	@Override
	public void selectionState() {
		onlineHelpMenuItem.setEnabled(true);
		FAQMenuItem.setEnabled(true);
		aboutLightsOnMenuItem.setEnabled(true);
		
	}

	@Override
	public void addingState() {
		onlineHelpMenuItem.setEnabled(true);
		FAQMenuItem.setEnabled(true);
		aboutLightsOnMenuItem.setEnabled(true);
		
	}
    
    
}
