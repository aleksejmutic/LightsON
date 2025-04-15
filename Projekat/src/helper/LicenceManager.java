package helper;

import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class LicenceManager {

	 private static final String SECRET_KEY = "MySecretKey123";

	    // Generisanje licence
	    public static String generateLicenseKey(String email, String password) {
	        try {
	            String data = email + password + SECRET_KEY;
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] hash = md.digest(data.getBytes());
	            return Base64.getEncoder().encodeToString(hash).substring(0, 16);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	    // Upisivanje licence u JSON fajl
	    public static void updateLicenseKeyInJson( String email, String password) {
	        try {
	            // Učitavanje JSON objekta
	            Gson gson = new Gson();
	            String jsonFilePath = "appsettings.json";
	            JsonObject jsonObject = gson.fromJson(new java.io.FileReader(jsonFilePath), JsonObject.class);

	            // Generisanje nove licence
	            String newLicenseKey = generateLicenseKey(email, password);

	            // Ažuriranje licence u JSON objektu
	            JsonObject userObject = jsonObject.getAsJsonObject("User");
	            userObject.addProperty("licenseKey", newLicenseKey);

	            // Čuvanje ažuriranog JSON objekta u fajl
	            FileWriter writer = new FileWriter(jsonFilePath);
	            gson.toJson(jsonObject, writer);
	            writer.close();

	            System.out.println("License key updated: " + newLicenseKey);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        // Putanja do JSON fajla
	         // Zameni sa stvarnom putanjom

	        // Unos emaila i lozinke
	        String email = "ikanoviczeljko095@gmail.com";
	        String password = "zeljko22";

	        // Ažuriranje licence u JSON fajlu
	        updateLicenseKeyInJson( email, password);
	    }
	}


