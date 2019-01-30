package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * A class that extends the main interface and allows the more specific classes
 * to branch off of it. It holds basic methods and a toString method that returns
 * the smartcard for use in printing the values. @yearOfEntry is used to state 
 * students year of entry to the institution. @df is used to format this date.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractStudent implements Student {
	
	private String newStudentLine;
	private String yearOfEntry;
	private DateFormat df = new SimpleDateFormat("yyyy");
	private SmartCard smartCard;

	public AbstractStudent(SmartCard smartcard) {
		this.smartCard = smartcard;
		this.yearOfEntry = dateOfEntry();
	}

	public String dateOfEntry() {
		Date today = new Date();
		return df.format(today);
	}
	
	public static void noOfStudents() {
		int totalStudents = Undergraduate.getUndergradMapSize() + PostgradTaught.getTaughtMapSize() + PostgradResearch.getResearchMapSize();
		System.out.println("\n   Total Students:\t\t\t" + totalStudents);
		System.out.println(" - Undergraduate Students:\t\t" + Undergraduate.getUndergradMapSize());
		System.out.println(" - Postgraduate-Taught Students:\t" + PostgradTaught.getTaughtMapSize());
		System.out.println(" - Postgraduate-Research Students:\t" + PostgradResearch.getResearchMapSize());
	}

	public static StudentID getStudentID(Student student) {
		StudentID stu = student.getSmartCard().getStuID();
		return stu;
	}
	
	
	public String getNewStudentLine() {
		newStudentLine = "\n________________________________________";
		return newStudentLine;
	}
	
	public SmartCard getSmartCard() {
		return smartCard;
	}

	public String toString() {
		return new String("" + smartCard);
	}

}
