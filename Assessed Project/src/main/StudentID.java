package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * This class is used in order to generate a 
 * random number that will be the students ID 
 * and will be unique thus, allowing it to be 
 * the key to each student.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StudentID {

	private char prefixID;
	private String numberID;
	private static final Map<String, StudentID> STUDENTIDLIST = new HashMap<String, StudentID>();
	private static final Random random = new Random();

	public StudentID() {

	}

	public StudentID(char prefixID, String numberID) {
		this.prefixID = prefixID;
		this.numberID = numberID;
	}

	public static char createRandomPrefix() {
		char randomPrefix = (char) ('a' + random.nextInt(26));
		return randomPrefix;
	}

	public static String createRandomNumber() {
		String randomNumber = ("" + (random.nextInt(8000) + 1000));
		return randomNumber;
	}

	public static StudentID getInstance() {
		char prefixID = createRandomPrefix();
		String numberID = createRandomNumber();
		final String Identification = prefixID + numberID;
		if (!STUDENTIDLIST.containsKey(Identification)) {
			STUDENTIDLIST.put(Identification, new StudentID(prefixID, numberID));
		} else {
			getInstance();
		}
		return STUDENTIDLIST.get(Identification);

	}

	public char getPrefixID() {
		return prefixID;
	}

	public String getNumberID() {
		return numberID;
	}

	public String toString() {
		return new String("Student ID:\t" + prefixID + numberID);
	}

}
