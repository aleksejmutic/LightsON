package main;

import model.ApplicationModel;
import view.ApplicationView;

import javax.swing.*;

import helper.LicenseHelper;

public class MainClass {
    public static void main(String[] args) throws Exception {
        // Proveri da li je aplikacija u specijalnom režimu
       if (LicenseHelper.isSpecialMode()) {
            // Ako je specijalni mod, proverava se licenca
            if (!LicenseHelper.isLicenseValid()) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Vaša licenca je istekla! Da li želite da unesete novu?",
                        "Licenca istekla",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    LicenseHelper.enterNewLicense();
                } else {
                    System.exit(0); // Izlazak ako nema licence
                }
            } else {
                JOptionPane.showMessageDialog(null, "Licenca validna. Pokreće se license mod.", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pokreće se guest mod.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        // Ako je sve u redu, pokreće se aplikacija
        ApplicationModel model = new ApplicationModel();
        @SuppressWarnings("unused")
		ApplicationView view = new ApplicationView(model);
    }
}
