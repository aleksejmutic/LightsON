package view.printer;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


import java.awt.print.Printable;
import java.awt.print.PageFormat;
import java.awt.Graphics;

/** 
 * Klasa koja definiše mehanizam printanja tekstualnog sadržaja. 
 * 
 * @author Grupa 1
 * @version 1.0
 */
public class PrintHandler {

    private String textToPrint;

    public PrintHandler(String text) {
        this.textToPrint = text;
        printText(); 
    }

    public void printText() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
                if (pageIndex == 0) {
                    graphics.drawString(textToPrint, 100, 100);  
                    return Printable.PAGE_EXISTS;  
                } else {
                    return Printable.NO_SUCH_PAGE;  
                }
            }
        });

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                showErrorDialog("Printer error: " + e.getMessage());
            }
        } else {
            showErrorDialog("No printer selected or available.");
        }
    }

    private void showErrorDialog(String errorMessage) {
        JDialog dialog = new JDialog();
        JOptionPane.showMessageDialog(dialog, errorMessage, "Print Error", JOptionPane.ERROR_MESSAGE);
    }
    
}