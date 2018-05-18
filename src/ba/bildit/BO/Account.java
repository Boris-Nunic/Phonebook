package ba.bildit.BO;

import java.sql.Date;
import java.sql.SQLException;
import ba.bildit.DAO.UserDAOImplementation;
import ba.bildit.DTO.User;

public class Account {

	private User user;
	private UserDAOImplementation userDAO = new UserDAOImplementation();

	public Account() {
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
	
	public void register(String email, String username, String password) throws SQLException{
		if (Check.registeredEmail(email)) {
			System.out.println("This email is already registered");
			return;
		}
		if (Check.registeredUsername(username)) {
			System.out.println("This username is already taken");
			return;
		}
		user = new User();
		this.user.setEmail(email);
		this.user.setUsername(username);
		this.user.setPassword(password);
		userDAO.addUser(user);
	}

	public void login(String username, String password) throws SQLException {

		if (Check.registeredUsername(username)) {
			setUser(userDAO.getUser(username));
			if (!user.isOnline()) {
				if (password.equals(user.getPassword())) {
					user.login();
				}
			}
		}
		else {
			System.out.println("Incorrect username or password");
		}

	}

	public void logout() {
		if (user.isOnline()) {
			user.logout();
			user = null;
		}
	}

	public void changeUsername(String newUsername) {
		if (user.isOnline()) {
			user.setUsername(newUsername);
		}
	}

	public void changePassword(String newPassword) {
		if (user.isOnline()) {
			user.setPassword(newPassword);
		}
	}
	
	public void changeEmail(String newEmail) {
		if (user.isOnline()) {
			user.setEmail(newEmail);
		}
	}
	
	public void changeFirstName(String firstName) {
		if(user.isOnline()) {
			user.setName(firstName);
		}
	}
	
	public void changeSurname(String surname) {
		if (user.isOnline()) {
			user.setSurname(surname);
		}
	}
	
	public void changeDateOfBirth(Date dob) {
		if(user.isOnline()) {
			user.setDob(dob);
		}
	}
	
	public void changeAdress(String adress) {
		if (user.isOnline()) {
			user.setAdress(adress);
		}
	}
	
	public void changePhoneNumber(String phoneNumber) {
		if (user.isOnline()) {
			user.setPhoneNumber(phoneNumber);
		}
	}
	
	public int getUserID() {
		if (user.isOnline()) {
			return user.getID();
		}
		return -1;
	}
	
	public void saveChanges(String password) throws SQLException {
		if (user.isOnline() && password.equals(user.getPassword())) {
			userDAO.editUser(user);
		}
	}
}
