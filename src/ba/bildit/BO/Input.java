package ba.bildit.BO;

import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

	private static Scanner input = new Scanner(System.in);

	public static String getPassword() {
		String password = input.nextLine();
		while (!Check.validPassword(password)) {
			System.out.println("Password is not valid. Please try again");
			password = input.nextLine();
		}
		return password;
	}

	public static String getEmail() {
		String email = input.nextLine();
		while (!Check.validEmail(email)) {
			System.out.println("Entered email is not valid. Please try again");
			email = input.nextLine();
		}
		return email;
	}

	public static String getUsername() {
		String username = input.nextLine();
		while (!Check.validUsername(username)) {
			System.out.println("Entered username is not valid. Please try again");
			username = input.nextLine();
		}
		return username;
	}

	public static Date getDob() {
		boolean valid = false;
		LocalDate ld = null;
		while (!valid) {
			try {
				System.out.println("Enter year: ");
				int year = getInteger();
				System.out.println("Enter month: ");
				int month = getInteger();
				System.out.println("Enter day of month: ");
				int dayOfMonth = getInteger();
				ld = LocalDate.of(year, month, dayOfMonth);
				valid = true;
			} catch (Exception e) {
				System.out.println("Invalid date please try again");
			}
		}
		return Date.valueOf(ld);
	}

	public static int getInteger() {
		while (true) {
			try {
				int number = input.nextInt();
				input.nextLine();
				return number;
			} catch (InputMismatchException e) {
				System.out.println("You must enter integer number");
				input.nextLine();
			}
		}
	}

	public static String getString() {
		return input.nextLine();
	}

}
