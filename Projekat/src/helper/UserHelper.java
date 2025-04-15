package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserHelper {

    private static final String FILE_PATH = "user.txt"; // Putanja do fajla
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; // Regex za email

    /**
     * Proverava da li fajl "user.txt" sadrži email adresu.
     * @return true ako sadrži email, inače false.
     */
    public static boolean containsEmail() {
        File file = new File(FILE_PATH);

        // Ako fajl ne postoji, vraća false bez daljeg pokušaja čitanja
        if (!file.exists() || !file.isFile()) {
            System.out.println("Fajl " + FILE_PATH + " ne postoji.");
            return false;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) { // Čitamo liniju po liniju
                if (line.trim().matches(EMAIL_REGEX)) {
                    return true; // Ako se nađe email, vraća true
                }
            }
        } catch (IOException e) {
            System.err.println("Greška pri čitanju " + FILE_PATH + ": " + e.getMessage());
        }
        return false; // Ako nema emaila, vraća false
    }
}
