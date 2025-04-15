package helper;

import java.io.FileReader;

import com.google.gson.Gson;

public class GsonParser {
	 private static final Gson gson = new Gson();

	    // Generička metoda za parsiranje JSON-a u bilo koji tip klase
	    public static <T> T parseJson(String filePath, Class<T> classOfT) {
	        try (FileReader reader = new FileReader(filePath)) {
	            return gson.fromJson(reader, classOfT);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
