package ba.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ba.bildit.DTO.Contact;

public class ContactDAOImplementation implements ContactDAOInterface {

	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public ArrayList<Contact> getContacts(int userID) throws SQLException {
		ArrayList<Contact> contacts = new ArrayList<>();
		String query = "SELECT * FROM contact WHERE user_id = ?";
		ResultSet rs = null;
		Contact contact = null;
		try (PreparedStatement statment = connection.prepareStatement(query);) {
			statment.setInt(1, userID);
			rs = statment.executeQuery();
			while (rs.next()) {
				contact = new Contact(rs.getInt("contact_id"), rs.getString("first_name"), rs.getString("surname"),
						rs.getString("email"), rs.getDate("dob"), rs.getString("phone_number"),
						rs.getString("adress"));
				contacts.add(contact);
			}

		}
		return contacts;
	}

	@Override
	public ArrayList<Contact> getContactsByFirstName(String firstName, int userID) throws SQLException {
		ArrayList<Contact> contacts = new ArrayList<>();
		String query = "SELECT * FROM contact WHERE first_name = ? AND user_id = ?";
		ResultSet rs = null;
		Contact contact = null;
		try (PreparedStatement statment = connection.prepareStatement(query);) {
			statment.setString(1, firstName);
			statment.setInt(2, userID);
			rs = statment.executeQuery();
			while (rs.next()) {
				contact = new Contact(rs.getInt("contact_id"), rs.getString("first_name"), rs.getString("surname"),
						rs.getString("email"), rs.getDate("dob"), rs.getString("phone_number"),
						rs.getString("adress"));
				contacts.add(contact);
			}
		}
		return contacts;
	}

	@Override
	public ArrayList<Contact> getContactsBySurname(String surname, int userID) throws SQLException{
		ArrayList<Contact> contacts = new ArrayList<>();
		String query = "SELECT * FROM contact WHERE surname = ? AND user_id = ?";
		ResultSet rs = null;
		Contact contact = null;
		try (PreparedStatement statment = connection.prepareStatement(query);) {
			statment.setString(1, surname);
			statment.setInt(2, userID);
			rs = statment.executeQuery();
			while (rs.next()) {
				contact = new Contact(rs.getInt("contact_id"), rs.getString("first_name"), rs.getString("surname"),
						rs.getString("email"), rs.getDate("dob"), rs.getString("phone_number"),
						rs.getString("adress"));
				contacts.add(contact);
			}
		}
		return contacts;
	}
	
	@Override
	public Contact getContact(int contactID, int userID) throws SQLException {
		Contact contact = null;
		ResultSet rs = null;
		String query = "SELECT * FROM contact WHERE contact_id = ? AND user_id = ?";
		try (PreparedStatement statiment = connection.prepareStatement(query);) {
			statiment.setInt(1, contactID);
			statiment.setInt(2, userID);
			rs = statiment.executeQuery();
			if (rs.next()) {
				contact = new Contact(rs.getInt("contact_id"), rs.getString("first_name"), rs.getString("surname"),
						rs.getString("email"), rs.getDate("dob"), rs.getString("phone_number"),
						rs.getString("adress"));
			}
		}
		return contact;
	}

	@Override
	public void addConntact(Contact contact, int userID) throws SQLException {
		String query = "INSERT INTO contact(contact_id, first_name, surname, email, dob, phone_number, adress, user_id) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statment = connection.prepareStatement(query);) {
			statment.setInt(1, contact.getID());
			statment.setString(2, contact.getName());
			statment.setString(3, contact.getSurname());
			statment.setString(4, contact.getEmail());
			statment.setDate(5, contact.getDob());
			statment.setString(6, contact.getPhoneNumber());
			statment.setString(7, contact.getAdress());
			statment.setInt(8, userID);
			statment.executeUpdate();
		}
	}

	@Override
	public void editContact(Contact contact, int contactID, int userID) throws SQLException {
		String query = "UPDATE contact SET first_name = ?, surname = ?,"
				+ " email = ?, dob = ?, phone_number = ?, adress = ? WHERE contact_id = ? AND user_id = ?";
		try(PreparedStatement statment = connection.prepareStatement(query);) {
			statment.setString(1, contact.getName());
			statment.setString(2, contact.getSurname());
			statment.setString(3, contact.getEmail());
			statment.setDate(4, contact.getDob());
			statment.setString(5, contact.getPhoneNumber());
			statment.setString(6, contact.getAdress());
			statment.setInt(7, contactID);
			statment.setInt(8, userID);
			statment.executeUpdate();
		}

	}

	@Override
	public void removeContact(int contactID, int userID) throws SQLException {
		String query = "DELETE FROM contact WHERE contact_id = ? AND user_id = ?";
		try(PreparedStatement statment = connection.prepareStatement(query);){
			statment.setInt(1, contactID);
			statment.setInt(2, userID);
			statment.executeUpdate();
		}

	}
	
	@Override
	public ArrayList<Integer> getIDs(int userID) throws SQLException {
		String query = "SELECT contact_id FROM contact WHERE user_id = ?";
		ArrayList<Integer> ids = new ArrayList<>();
		ResultSet rs = null;
		try(PreparedStatement statment = connection.prepareStatement(query);) {
			statment.setInt(1, userID);
			rs = statment.executeQuery();
			while(rs.next()) {
				ids.add(rs.getInt("contact_id"));
			}
		}
		return ids;
	}

}
