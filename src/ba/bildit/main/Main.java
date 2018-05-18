package ba.bildit.main;

import java.sql.Date;
import java.sql.SQLException;

import ba.bildit.BO.Account;
import ba.bildit.BO.ContactInfo;
import ba.bildit.BO.Input;

public class Main {

	public static void main(String[] args) throws SQLException {

		String email;
		String username;
		String password;
		String placeholder;
		Account acc = new Account();
		ContactInfo conInfo = new ContactInfo();
		Date dob;
		int select = 0;
		int id;
		boolean play = true;

		while (play) {
			System.out.println("1 - Login\n2 - Register\n3 - Close program");
			select = Input.getInteger();
			switch (select) {
			case 1:
				System.out.println("Enter username:");
				username = Input.getUsername();
				System.out.println("Enter password");
				password = Input.getPassword();
				acc.login(username, password);
				while (acc.getUser() != null && acc.getUser().isOnline()) {
					System.out.println("1 - Contact Options\n2 - Account Settings\n3 - Logout");
					select = Input.getInteger();
					switch (select) {
					case 1:
						do {
							System.out.println("1 - Search Contacts\n2 - Contact Info\n3 - Remove Contact\n4 - Back");
							select = Input.getInteger();
							switch (select) {
							case 1:
								do {
									System.out.println(
											"1 - Display all contacts\n2 - Search by first name\n3 - Search by surname\n4 - Back");
									select = Input.getInteger();
									switch (select) {
									case 1:
										conInfo.displayAllContacts(acc.getUserID());
										break;
									case 2:
										System.out.println("Enter contacts first name:");
										placeholder = Input.getString();
										conInfo.searchByFirstName(placeholder, acc.getUserID());
										break;
									case 3:
										System.out.println("Enter contact surname:");
										placeholder = Input.getString();
										conInfo.searchBySurname(placeholder, acc.getUserID());
										break;
									}
								} while (select != 4);
								break;
							case 2:
								do {
									System.out.println(
											"1 - Change first name\n2 - Change surname\n3 - Change Phone Number\n4 - Change Email"
													+ "\n5 - Change Adress\n6 - Change Date of Birth\n7 - Save\n8 - Back");
									select = Input.getInteger();
									switch (select) {
									case 1:
										System.out.println("Enter first name:");
										placeholder = Input.getString();
										conInfo.changeFirstName(placeholder);
										break;
									case 2:
										System.out.println("Enter surname:");
										placeholder = Input.getString();
										conInfo.changeSurname(placeholder);
										break;
									case 3:
										System.out.println("Enter phone number:");
										placeholder = Input.getString();
										conInfo.changePhoneNumber(placeholder);
										break;
									case 4:
										System.out.println("Enter email:");
										email = Input.getEmail();
										conInfo.changeEmail(email);
										break;
									case 5:
										System.out.println("Enter adress:");
										placeholder = Input.getString();
										conInfo.changeAddress(placeholder);
										break;
									case 6:
										System.out.println("Enter date of birth");
										dob = Input.getDob();
										conInfo.changeDateOfBirth(dob);
										break;
									case 7:
										System.out.println(
												"1 - Save as new contact\n2 - Edit existing contact\n3 - Back");
										select = Input.getInteger();
										switch (select) {
										case 1: conInfo.saveContact(acc.getUserID());
											break;
										case 2: 
											System.out.println("Enter ID of the contact you wish to edit:");
											id = Input.getInteger();
											conInfo.editContact(id, acc.getUserID());
											break;
										case 3:
											break;
										}
										break;
									}
								} while (select != 8);
								break;
							case 3:
								System.out.println("Enter ID of the contact you wish to delete:");
								id = Input.getInteger();
								conInfo.deleteContact(id, acc.getUserID());
								break;
							}
						} while (select != 4);
						break;

					case 2:
						do {
							System.out.println(
									"1 - Change Uasername\n2 - Change Password\n3 - Change Email\n4 - Change User Info\n5 - Save Changes\n6 - Back");
							select = Input.getInteger();
							switch (select) {
							case 1:
								System.out.println("Enter new username:");
								username = Input.getUsername();
								acc.changeUsername(username);
								break;
							case 2:
								System.out.println("Enter new password:");
								password = Input.getPassword();
								acc.changePassword(password);
								break;
							case 3:
								System.out.println("Enter new email:");
								email = Input.getEmail();
								acc.changeEmail(email);
								break;
							case 4:
								do {
									System.out.println(
											"1 - Change First Name\n2 - Change Surname\n3 - Change Adress\n4 - Change Dato of Birth\n5 - Change Phone Number\n6 - Save Changes\n7 - Back");
									select = Input.getInteger();
									switch (select) {
									case 1:
										System.out.println("Enter your First Name:");
										placeholder = Input.getString();
										acc.changeFirstName(placeholder);
										break;
									case 2:
										System.out.println("Enter your surname:");
										placeholder = Input.getString();
										acc.changeSurname(placeholder);
										break;
									case 3:
										System.out.println("Enter your Adress:");
										placeholder = Input.getString();
										acc.changeAdress(placeholder);
										break;
									case 4:
										System.out.println("Enter your Date of Birth:");
										dob = Input.getDob();
										acc.changeDateOfBirth(dob);
										break;
									case 5:
										System.out.println("Enter your phone number:");
										placeholder = Input.getString();
										acc.changePhoneNumber(placeholder);
										break;
									case 6:
										System.out.println("Enter your password to confirm changers:");
										password = Input.getPassword();
										acc.saveChanges(password);
										break;
									}
								} while (select != 6 && select != 7);
								break;
							case 5:
								System.out.println("Enter your password to confirm changes");
								password = Input.getPassword();
								acc.saveChanges(password);
								break;
							}
						} while (select != 5 && select != 6);
						break;
					case 3:
						acc.logout();
						break;
					}
				}
				break;
			case 2:
				System.out.println("Enter email:");
				email = Input.getEmail();
				System.out.println("Enter username:");
				username = Input.getUsername();
				System.out.println("Enter password:");
				password = Input.getPassword();
				acc.register(email, username, password);
				break;
			case 3:
				play = false;
			}

		}
	}

}
