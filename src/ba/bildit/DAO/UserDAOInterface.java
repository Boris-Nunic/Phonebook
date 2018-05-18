package ba.bildit.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import ba.bildit.DTO.User;

public interface UserDAOInterface {
	
	public User getUser(String username) throws SQLException;
	
	public void addUser(User user) throws SQLException;
	
	public void removeUser(User user) throws SQLException;
	
	public void editUser(User user) throws SQLException;
	
	public ArrayList<String> getUsernames() throws SQLException;
	
	public ArrayList<String> getEmails() throws SQLException;
	
}
