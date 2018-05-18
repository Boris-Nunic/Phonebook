package ba.bildit.BO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import ba.bildit.DAO.ContactDAOImplementation;
import ba.bildit.DTO.Contact;

public class ContactInfo {

	private Contact contact = new Contact();
	private ContactDAOImplementation contactDAO = new ContactDAOImplementation();

	public ContactInfo() {

	}

	// Sets contact's name to specified value
	public void changeFirstName(String firstName) {
		contact.setName(firstName);
	}

	// Sets contact's surname to specified value
	public void changeSurname(String surname) {
		contact.setSurname(surname);
	}

	// Sets contact's email to specified value
	public void changeEmail(String email) {
		contact.setEmail(email);
	}

	// Sets contact's phone number to specified value
	public void changePhoneNumber(String phoneNumber) {
		contact.setPhoneNumber(phoneNumber);
	}

	// Sets contact's date of birth to specified value
	public void changeDateOfBirth(Date dob) {
		contact.setDob(dob);
	}

	// Sets contact's address to specified value
	public void changeAddress(String adress) {
		contact.setAdress(adress);
	}

	public void saveContact(int userID) throws SQLException {
		contactDAO.addConntact(contact, userID);
	}

	public void editContact(int contactID, int userID) throws SQLException {
		if (Check.existingContactID(contactID, userID)) {
		contactDAO.editContact(contact, contactID, userID);
		}
		else {
			System.out.println("There is no match");
		}
	}

	public void deleteContact(int contactID, int userID) throws SQLException {
		if (Check.existingContactID(contactID, userID)) {
			contactDAO.removeContact(contactID, userID);
		}
		else {
			System.out.println("There is no match");
		}
	}

	public void searchByFirstName(String firstName, int userID) throws SQLException {
		ArrayList<Contact> list = contactDAO.getContactsByFirstName(firstName, userID);
		for (Contact e : list) {
			System.out.println(e.toString());
		}
	}

	public void searchBySurname(String surname, int userID) throws SQLException {
		ArrayList<Contact> list = contactDAO.getContactsBySurname(surname, userID);
		for (Contact e : list) {
			System.out.println(e.toString());
		}
	}

	public void displayAllContacts(int userID) throws SQLException {
		ArrayList<Contact> list = contactDAO.getContacts(userID);
		for (Contact e : list) {
			System.out.println(e.toString());
		}
	}

}
