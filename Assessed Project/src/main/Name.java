package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * The Name class is used to pass in names that if necessary are
 * split in to separate parts via the @valueOf method and then 
 * formatted into the Name object via the constructor.
 */

public class Name {

	private String forename;
	private String surname;
	private String fInitials;
	private String sInitials;

	public Name(String forename, String surname) {
		this.forename = forename.toUpperCase();
		this.surname = surname.toUpperCase();
		this.fInitials = forename.substring(0, 1).toUpperCase();
		this.sInitials = surname.substring(0, 1).toUpperCase();
	}

	public String getForename() {
		return forename;
	}

	public String getSurname() {
		return surname;
	}

	public String getForenameInitial() {
		return fInitials;
	}

	public String getSurnameInitial() {
		return sInitials;
	}

	public String toString() {
		return new String(forename + " " + surname);
	}

	public static Name valueOf(String name) {
		final String[] subnames = name.split(" ");
		return new Name(subnames[0], subnames[1]);
	}

}
