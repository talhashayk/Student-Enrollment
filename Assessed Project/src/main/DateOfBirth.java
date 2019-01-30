package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * The DateOfBirth class is used in order to determine the date of birth
 * of the student and format it into separate pieces as well as a single
 * formatted date type that will allow consistency throughout the program.
 * The main formatting is done with @df.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateOfBirth {

	private int yearDOB;
	private int monthDOB;
	private int dayDOB;

	private Calendar cal = new GregorianCalendar();
	private DateFormat df = new SimpleDateFormat("dd:MMM:yyyy");

	public DateOfBirth(int dayDOB, int monthDOB, int yearDOB) {

		this.dayDOB = dayDOB;
		this.monthDOB = monthDOB;
		this.yearDOB = yearDOB;

		cal.set(Calendar.DAY_OF_MONTH, dayDOB);
		cal.set(Calendar.MONTH, (monthDOB - 1));
		cal.set(Calendar.YEAR, yearDOB);
	}

	public String toString() {
		return df.format(cal.getTime());
	}

	public int getYearDOB() {
		return yearDOB;
	}

	public int getMonthDOB() {
		return monthDOB;
	}

	public int getDayDOB() {
		return dayDOB;
	}

	public static DateOfBirth valueOf(String date) {
		final String[] subdates = date.split(":");
		int day = Integer.parseInt(subdates[0]);
		int month = Integer.parseInt(subdates[1]);
		int year = Integer.parseInt(subdates[2]);
		return new DateOfBirth(day, month, year);
	}

}
