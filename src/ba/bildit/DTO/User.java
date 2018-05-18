package ba.bildit.DTO;

import java.sql.Date;

public class User extends Contact {

	// Data fields
	private String username;
	private String password;
	private boolean isOnline;

	// Constructors
	public User() {

	}

	public User(int id, String name, String surname, String email, Date dob, String phoneNumber, String adress, String username,
			String password, boolean isOnline) {
		super(id, name, surname, email, dob, phoneNumber, adress);
		this.username = username;
		this.password = password;
		this.isOnline = isOnline;
	}

	// Getters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isOnline() {
		return isOnline;
	}

	// Setters
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login() {
		isOnline = true;
	}

	public void logout() {
		isOnline = false;
	}

}
