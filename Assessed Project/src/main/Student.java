package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * This class is the interface that is at the top 
 * of the hierarchy and contains the base methods 
 * to be used throughout the program.
 */

import java.util.Map;

public interface Student {
	
	public static void noOfStudents() {
	}

	public static void registerStudent(String name, String dateOfBirth, Map<String, Module> modulesent) {
	}

	public void ammendStudent(int uniqueID, String name, String dateOfBirth);
	
	public static void terminateStudent(StudentID uniqueID) {
	}
	
	public StudentID getStudentID();

	public SmartCard getSmartCard();

	public String getSupervisor();
	
}
