package view.listeners;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;


/** 
 * Klasa za realizaciju ActionListener-a pri korišćenju Help menija. 
 * 
 * @see ActionListener
 * @author Grupa 1
 * @version 1.0
 */
public class HtmlActionListener implements ActionListener {

    private String helpFileName;

    public HtmlActionListener(String helpFileName) {
        this.helpFileName = helpFileName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        File htmlFile = new File("lib/" + helpFileName);

        if (htmlFile.exists()) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().browse(htmlFile.toURI());
                } else {
                    JOptionPane.showMessageDialog(null, "Desktop class is not supported on your system.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Failed to open the HTML file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "The HTML file could not be found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
