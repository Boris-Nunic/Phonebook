package ba.bildit.BO;

import java.sql.SQLException;
import java.util.ArrayList;

import ba.bildit.DAO.ContactDAOImplementation;
import ba.bildit.DAO.UserDAOImplementation;
import ba.bildit.DTO.User;

public class Check {

	private static UserDAOImplementation userDao = new UserDAOImplementation();
	private static ContactDAOImplementation contactDAO = new ContactDAOImplementation();
	
	// Return true if entered email is valid
	public static boolean validEmail(String email) {
		final String PATTERN = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
		return email.matches(PATTERN);
	}
	
	/*
	 * Return true if entered password is valid
	 * A digit must occur at least once
	 * A lower case character must occur at least once
	 * An upper case character must occur at least once
	 * A special character must occur at least once
	 * No whitespace allowed in entire string
	 * String must contain at least 8 characters
	 */
	public static boolean validPassword(String password) {
		final String PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		return password.matches(PATTERN);
	}
	
	/* Return true if username is valid
	 * Can only contain lower and upper case letters, digits, undersores and dashes
	 * Must have at least 5 chars
	 */
	public static boolean validUsername(String username) {
		final String PATTERN = "[a-zA-Z0-9_-]{5,}";
		return username.matches(PATTERN);
	}
	
	// Return true if enter email is already registered
	public static boolean registeredEmail(String email) throws SQLException{
		ArrayList<String> emails = new UserDAOImplementation().getEmails();
		return emails.contains(email);
	}
	
	// Return true if username is already registered
	public static boolean registeredUsername(String username) throws SQLException{
		return userDao.getUsernames().contains(username);
	}
	
	//Return true if entered password is correct
	public static boolean correctPassword(User user, String password) {
		return password.equals(user.getPassword());
	}
	
	// Return true if entered contact ID exists in DB
	public static boolean existingContactID(int contactID, int userID) throws SQLException{
		ArrayList<Integer> list = contactDAO.getIDs(userID);
		return list.contains(contactID);
	}
}
