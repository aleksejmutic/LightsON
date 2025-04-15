package view.listeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ApplicationModel;
import view.printer.PrintHandler;

/** 
 * Klasa za realizaciju ActionListener-a pri korišćenju print opcije. 
 * 
 * @see ActionListener
 * @author Grupa 1
 * @version 1.0
 */
public class PrintActionListener implements ActionListener {
    private String textToPrint;

    public PrintActionListener(String textToPrint) {
        this.textToPrint = textToPrint;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("Toolbar print button clicked"); // Debug log
        new PrintHandler(textToPrint);
 
    }
    
    public void generateDocumentation() {
    	@SuppressWarnings("unused")
		ApplicationModel model = new ApplicationModel();
	}
}