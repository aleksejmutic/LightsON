package model;

public class User {

	private int id;
	private String email;
	private String licenseKey;
	private String password;
	
	
	 public User(int id, String email, String password, String licenseKey) {
	        this.id = id;
	        this.email = email;
	        this.password = password;
	        this.licenseKey = licenseKey;
	    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLicenseKey() {
		return licenseKey;
	}
	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
