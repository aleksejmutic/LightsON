package helper;

import javax.crypto.SecretKey;
import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LicenseHelper {

    private static final String LICENSE_FILE = "../../license.txt"; // Lokacija fajla sa licencom
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final String CONFIG_FILE = "config.txt"; // Fajl sa modom rada
    private static final String USERS_CSV = "korisnici.csv"; // CSV fajl sa korisnicima

    // Proverava da li je licenca istekla
    public static boolean isLicenseValid() {
        try {
            // Učitavanje datuma iz fajla
            String content = new String(Files.readAllBytes(Paths.get("license.txt")));
            System.out.println(content);
            SecretKey secretKey = AESHelper.loadSecretKey("secret.key");
            String datum = AESHelper.decrypt(content, secretKey);
            LocalDate licenseDate = LocalDate.parse(datum, FORMATTER);
            
            LocalDate today = LocalDate.now();

            // Provera da li je licenca istekla
            return today.isBefore(licenseDate) || today.isEqual(licenseDate);
        } catch (Exception e) {
            return false; // Ako se ne može pročitati, smatra se da licenca nije validna
        }
    }
    
    public static boolean isSpecialMode() {
        try {
            if (!Files.exists(Paths.get(CONFIG_FILE))) {
                return askUserForMode(); // Prvi put pokrećemo aplikaciju
            }
            String mode = new String(Files.readAllBytes(Paths.get(CONFIG_FILE))).trim();
            return mode.equals("special");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Pita korisnika koji mod želi i upisuje u config.txt
    private static boolean askUserForMode() {
        int choice = JOptionPane.showOptionDialog(null,
                "Izaberite režim rada:",
                "Prvo pokretanje",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"License mod", "Guest mod"},
                "Guest mod");

        boolean specialMode = (choice == JOptionPane.YES_OPTION);

        try {
            Files.writeString(Paths.get(CONFIG_FILE), specialMode ? "special" : "normal");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return specialMode;
    }

    // Unos nove licence
    public static void enterNewLicense() throws Exception {
        String email = JOptionPane.showInputDialog(null,
                "Unesite e-mail:",
                "Verifikacija licence",
                JOptionPane.QUESTION_MESSAGE);

        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            JOptionPane.showMessageDialog(null, "Neispravan e-mail. Pokušajte ponovo.", "Greška", JOptionPane.ERROR_MESSAGE);
            enterNewLicense();
            return;
        }

        String password = JOptionPane.showInputDialog(null,
                "Unesite lozinku:",
                "Verifikacija licence",
                JOptionPane.QUESTION_MESSAGE);

        if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lozinka ne sme biti prazna!", "Greška", JOptionPane.ERROR_MESSAGE);
            enterNewLicense();
            return;
        }

        if (isValidUserFromCSV(email, password)) {
            try {
                LocalDate newLicenseDate = LocalDate.now().plusYears(1); // Dodaje godinu

                Path licensePath = Paths.get(LICENSE_FILE);
                // Brisanje fajla ako postoji
                Files.deleteIfExists(licensePath);
                
                SecretKey secretKey = AESHelper.generateKey();
                AESHelper.saveSecretKey(secretKey, "secret.key");
                
                String encryptLicense = AESHelper.encrypt(newLicenseDate.toString(), secretKey);
                
                System.out.println("Enkriptovana lozinka: " + encryptLicense);
                
                // Kreiranje novog fajla
                Files.createFile(licensePath);
                
                FileWriter writer = new FileWriter("license.txt");
                writer.write(encryptLicense);
                writer.close();

                // Upisivanje u novi fajl
                Files.writeString(licensePath, newLicenseDate.format(FORMATTER));

                JOptionPane.showMessageDialog(null, "Licenca uspešno ažurirana do: " + newLicenseDate + "\nRestartujte aplikaciju.",
                        "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0); // Restart aplikacije
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Greška pri pisanju u fajl: " + e.getMessage(),
                        "Greška", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Neispravan e-mail ili lozinka!", "Greška", JOptionPane.ERROR_MESSAGE);
            enterNewLicense();
        }
    }

    // Provera ispravnosti korisničkog email-a i lozinke iz CSV fajla
    private static boolean isValidUserFromCSV(String email, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_CSV))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                String storedEmail = userData[0].trim();
                String storedPassword = userData[1].trim();
                if (email.equals(storedEmail) && password.equals(storedPassword)) {
                	
                	FileWriter writer = new FileWriter("user.txt");
                    writer.write(storedEmail);
                    writer.close();
                	
                    return true;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Greška pri čitanju fajla korisnika.", "Greška", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
