package view.toolbar;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import localization.Localization;
import view.listeners.HtmlActionListener;


/** 
 * Klasa koja definiše ToolBar za skup opcija korisničke pomoći.  
 * @see JToolBar
 * @author Grupa 1
 * @version 1.0
 */
public class HelpToolBar extends JToolBar {

    private static final long serialVersionUID = 1L;

    JButton onlineHelpButton;
    JButton FAQButton;
    JButton aboutLightsOnButton;
    private Localization localization = null;

    public HelpToolBar() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        localization = Localization.getInstance();

        // Online Help Button
        onlineHelpButton = new JButton();
        Image onlineHelpIcon = toolkit.getImage("icons/online_help.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        onlineHelpButton.setIcon(new ImageIcon(onlineHelpIcon));
        onlineHelpButton.setToolTipText(localization.getString("menu.help.onlineHelp"));
        localization.registerComponent("menu.help.onlineHelp", onlineHelpButton);
        add(onlineHelpButton);
        onlineHelpButton.addActionListener(new HtmlActionListener("OnlineHelp.html"));

        // FAQ Button
        FAQButton = new JButton();
        Image FAQIcon = toolkit.getImage("icons/information.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        FAQButton.setIcon(new ImageIcon(FAQIcon));
        FAQButton.setToolTipText(localization.getString("menu.help.FAQ"));
        localization.registerComponent("menu.help.FAQ", FAQButton);
        add(FAQButton);
        FAQButton.addActionListener(new HtmlActionListener("FAQ.html"));

        // About Lights On Button
        aboutLightsOnButton = new JButton();
        Image aboutLightsOnIcon = toolkit.getImage("icons/LightsOnLogo.png").getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        aboutLightsOnButton.setIcon(new ImageIcon(aboutLightsOnIcon));
        aboutLightsOnButton.setToolTipText(localization.getString("menu.help.about"));
        localization.registerComponent("menu.help.about", aboutLightsOnButton);
        add(aboutLightsOnButton);
        aboutLightsOnButton.addActionListener(new HtmlActionListener("AboutLightsOn.html"));
    }
    
    
    public void idleState() {
    	onlineHelpButton.setEnabled(true);
    	FAQButton.setEnabled(true);
    	aboutLightsOnButton.setEnabled(true);

	}

	public void activeState() {
		onlineHelpButton.setEnabled(true);
    	FAQButton.setEnabled(true);
    	aboutLightsOnButton.setEnabled(true);
	}

	public void editState() {
		onlineHelpButton.setEnabled(true);
    	FAQButton.setEnabled(true);
    	aboutLightsOnButton.setEnabled(true);
	}

	public void selectionState() {
		onlineHelpButton.setEnabled(true);
    	FAQButton.setEnabled(true);
    	aboutLightsOnButton.setEnabled(true);
	}

	public void addingState() {
		onlineHelpButton.setEnabled(true);
    	FAQButton.setEnabled(true);
    	aboutLightsOnButton.setEnabled(true);
	}
}
