package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * This class is utilised in order to create a smartcard 
 * that contains all of the details of the student such as
 * @stuID, @name, @dOB, @cardNumber and @issueDate.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SmartCard {

	private StudentID stuID;
	private String name;
	private DateOfBirth dOB;
	private SmartCardNumber cardNumber;

	private String issueDate;
	private DateFormat df = new SimpleDateFormat("dd:MMM:yyyy");

	public SmartCard(DateOfBirth dOB, SmartCardNumber cardNumber) {
		this.stuID = new StudentID().getInstance();
		this.name = cardNumber.getName();
		this.dOB = dOB;
		this.cardNumber = cardNumber;
		this.issueDate = new String("Issued:\t\t" + dateOfIssue());
	}

	public String dateOfIssue() {
		Date today = new Date();
		return df.format(today);
	}

	public StudentID getStuID() {
		return stuID;
	}
	
	public String getName() {
		return name;
	}

	public DateOfBirth getdOB() {
		return dOB;
	}

	public SmartCardNumber getCardNumber() {
		return cardNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public String toString() {
		return new String("SmartCard:\n" + stuID + "\nName:\t\t" + name + "\nDate of Birth:\t" + dOB + "\nCard Number:\t"
				+ cardNumber + "\n" + issueDate + "\n");
	}

}
