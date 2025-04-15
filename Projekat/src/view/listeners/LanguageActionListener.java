package view.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import localization.Localization;


/** 
 * Klasa za realizaciju ActionListener-a pri korišćenju opcije odabira jezika. 
 * 
 * @see ActionListener
 * @author Grupa 1
 * @version 1.0
 */
public class LanguageActionListener implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Localization localization = Localization.getInstance();

		switch (e.getActionCommand()) {
		case "english":
			localization.setLocal("en", "US");
			break;
		case "serbian":
			localization.setLocal("sr", "BA");
			break;
		case "serbiancyrilic":
			localization.setLocal("sr", "RS");
			break;
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				localization.updateAll();
			}
		});
	}
}
