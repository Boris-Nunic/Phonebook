package ba.bildit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ba.bildit.DTO.User;

public class UserDAOImplementation implements UserDAOInterface {

	Connection connention = ConnectionManager.getInstance().getConnection();

	@Override
	public User getUser(String username) throws SQLException {
		User user = null;
		String query = "SELECT * FROM user WHERE username = ?";
		ResultSet rs = null;
		try (PreparedStatement statment = connention.prepareStatement(query);) {
			statment.setString(1, username);
			rs = statment.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("first_name"), rs.getString("surname"),
						rs.getString("email"), rs.getDate("dob"), rs.getString("phone_number"), rs.getString("adress"),
						rs.getString("username"), rs.getString("password"), rs.getBoolean("is_online"));
			}
		}
		return user;
	}

	@Override
	public void addUser(User user) throws SQLException {
		String query = "INSERT INTO user(user_id, username, password, is_online,"
				+ "first_name, surname, email, dob, phone_number, adress) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement statment = connention.prepareStatement(query);) {
			statment.setInt(1, user.getID());
			statment.setString(2, user.getUsername());
			statment.setString(3, user.getPassword());
			statment.setBoolean(4, user.isOnline());
			statment.setString(5, user.getName());
			statment.setString(6, user.getSurname());
			statment.setString(7, user.getEmail());
			statment.setDate(8, user.getDob());
			statment.setString(9, user.getPhoneNumber());
			statment.setString(10, user.getAdress());

			statment.executeUpdate();
		}
	}

	@Override
	public void removeUser(User user) throws SQLException {
		String query = "DELETE FROM user WHERE user_id = ?";
		try (PreparedStatement statment = connention.prepareStatement(query);) {
			statment.setInt(1, user.getID());
			statment.executeUpdate();
		}

	}

	@Override
	public void editUser(User user) throws SQLException {
		String query = "UPDATE user SET username = ?, password = ?, is_online = ?, "
				+ "first_name = ?, surname = ?, email = ?, dob = ?, phone_number = ?, adress = ? WHERE user_id = ?";

		try (PreparedStatement statment = connention.prepareStatement(query);) {
			
			statment.setString(1, user.getUsername());
			statment.setString(2, user.getPassword());
			statment.setBoolean(3, user.isOnline());
			statment.setString(4, user.getName());
			statment.setString(5, user.getSurname());
			statment.setString(6, user.getEmail());
			statment.setDate(7, user.getDob());
			statment.setString(8, user.getPhoneNumber());
			statment.setString(9, user.getAdress());
			statment.setInt(10, user.getID());

			statment.executeUpdate();
			System.out.println("succsess");
		}
	}

	@Override
	public ArrayList<String> getUsernames() throws SQLException {
		String query = "SELECT username FROM user";
		ResultSet rs = null;
		ArrayList<String> usernames = new ArrayList<>();
		try(Statement statment = connention.createStatement();) {
			rs = statment.executeQuery(query);
			while(rs.next()) {
				usernames.add(rs.getString("username"));
			}
		}
		return usernames;
	}

	@Override
	public ArrayList<String> getEmails() throws SQLException {
		String query = "SELECT email FROM user";
		ResultSet rs = null;
		ArrayList<String> emails = new ArrayList<>();
		try(Statement statment = connention.createStatement();) {
			rs = statment.executeQuery(query);
			while(rs.next()) {
				emails.add(rs.getString("email"));
			}
		}
		return emails;
	}

}
