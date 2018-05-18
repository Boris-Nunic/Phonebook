package ba.bildit.DTO;

import java.sql.Date;

public class Contact {

	// Data fields
	private int id;
	private String name;
	private String surname;
	private String email;
	private Date dob;
	private String phoneNumber;
	private String address;

	// Constructors
	public Contact() {

	}

	public Contact(int id, String name, String surname, String email, Date dob, String phoneNumber, String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	// Getters
	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public Date getDob() {
		return dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAdress() {
		return address;
	}

	// Setters
	public void setID(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAdress(String adress) {
		this.address = adress;
	}

	@Override
	public String toString() {
		return "ID: " + getID() + "\nFirst Name: " + getName() + "\nSurname: " + getSurname() + "\nPhoone Number: "
				+ getPhoneNumber() + "\nEmail: " + getEmail()  + "\nDob: "
				+ getDob()  + "\nAdress: " + getAdress() + "\n"; 
	}
}
