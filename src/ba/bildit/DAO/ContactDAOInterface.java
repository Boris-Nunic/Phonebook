package ba.bildit.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import ba.bildit.DTO.Contact;

public interface ContactDAOInterface {

	public ArrayList<Contact> getContacts(int userID) throws SQLException;
	
	public ArrayList<Contact> getContactsByFirstName(String firstName, int userID) throws SQLException;
	
	public ArrayList<Contact> getContactsBySurname(String surname, int userID) throws SQLException;
	
	public Contact getContact(int contactID, int userID) throws SQLException;
	
	public void addConntact(Contact contact, int userID) throws SQLException;
	
	public void editContact(Contact contact, int contacID, int userID) throws SQLException;
	
	public void removeContact(int contactID, int userID) throws SQLException; 
	
	public ArrayList<Integer> getIDs(int userID) throws SQLException;
}
