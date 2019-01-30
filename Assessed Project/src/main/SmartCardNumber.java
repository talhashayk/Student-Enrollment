package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * This class uses the Name class in order to create 
 * a unique smartcard number. It contains the respective 
 * students initials, the year it was issued and a unique 
 * number at the end of it.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmartCardNumber {

	private String name;
	private String concatenatedInitials;
	private String yearIssued;
	private static int uniqueNumber = 0;
	private DateFormat df = new SimpleDateFormat("yyyy");

	public SmartCardNumber(Name name) {
		this.name = new String(name.getForename() + " " + name.getSurname());
		this.concatenatedInitials = new String(name.getForenameInitial() + name.getSurnameInitial());
		this.yearIssued = yearOfIssue();
	}

	public String yearOfIssue() {
		Date today = new Date();
		return df.format(today);
	}

	public static int getUniqueNumber() {
		return uniqueNumber;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return new String(concatenatedInitials + "-" + yearIssued + "-" + (uniqueNumber++ + 10));
	}

}
