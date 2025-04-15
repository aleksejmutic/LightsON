package helper;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class AESHelper {

	  private static final String ALGORITHM = "AES";

	    // Generiše nasumični ključ (možeš ga sačuvati za kasnije)
	    public static SecretKey generateKey() throws Exception {
	        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
	        keyGenerator.init(128);
	        return keyGenerator.generateKey();
	    }
	    
	    public static void saveSecretKey(SecretKey secretKey, String filePath) throws IOException {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
	            oos.writeObject(secretKey);
	        }
	    }

	    public static SecretKey loadSecretKey(String filePath) throws IOException, ClassNotFoundException {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
	            return (SecretKey) ois.readObject();
	        }
	    }

	    // Enkripcija teksta
	    public static String encrypt(String data, SecretKey secretKey) throws Exception {
	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
	        return Base64.getEncoder().encodeToString(encryptedBytes);
	    }

	    // Dekripcija teksta
	    public static String decrypt(String encryptedData, SecretKey secretKey) throws Exception {
	        Cipher cipher = Cipher.getInstance(ALGORITHM);
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
	        return new String(decryptedBytes);
	    }

	    // Kreiranje ključa iz niza bajtova
	    public static SecretKey getKeyFromBytes(byte[] keyBytes) {
	        return new SecretKeySpec(keyBytes, ALGORITHM);
	    }
}
