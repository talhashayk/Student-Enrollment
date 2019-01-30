package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * This class is used in order to create an undergraduate 
 * student object thus has methods and fields that correspond
 * to its needs such as @passGrade which must be 40% in this 
 * case to pass.
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Undergraduate extends AbstractStudent {

	private static Map<StudentID, Student> undergradMap = new HashMap<StudentID, Student>();
	private static Map<String, Module> modules = new HashMap<String, Module>();
	private int passGrade;
	private int credits;
	private int creditsTaken;
	private DateOfBirth dateOfBirth;
	private Name name;

	public Undergraduate(SmartCard smartcard, Map<String, Module> modules) {
		super(smartcard);
		this.passGrade = 40;
		this.credits = 120;
		this.creditsTaken = getCreditsTaken();
		this.modules = modules;
		undergradMap.put(smartcard.getStuID(), this);
	}

	public static Student registerStudent(String name, String dateOfBirth, Map<String, Module> modules) {
		Name studentName = Name.valueOf(name);
		DateOfBirth studentDOB = DateOfBirth.valueOf(dateOfBirth);
		SmartCardNumber scn = new SmartCardNumber(studentName);
		SmartCard sc = new SmartCard(studentDOB, scn);
		undergradMap.put(sc.getStuID(), new Undergraduate(sc, modules));
		return undergradMap.get(sc.getStuID());
	}

	public static void terminateStudent(StudentID studentID) {
		undergradMap.remove(studentID);
	}

	public static void ammendStudent(StudentID uniqueID, String name, String dateOfBirth, Map<String, Module> modules) {
		Undergraduate student = (Undergraduate) undergradMap.get(uniqueID);
		student.name = Name.valueOf(name);
		student.dateOfBirth = DateOfBirth.valueOf(dateOfBirth);
		student.modules = modules;
		undergradMap.replace(student.getStudentID(), student);
	}
	
	public static Map<String, Module> getModulesList(Student student) {
		return modules;
	}

	public static int getUndergradMapSize() {
		return undergradMap.size();
	}

	public static Collection<Student> getUndergradMap() {
		return undergradMap.values();
	}

	public int getCreditsTaken() {
		for (Module m : modules.values()) {
			int i = m.getModuleCredits();
			creditsTaken += i;
		}
		return creditsTaken;
	}

	public String toString() {
		return new String(super.toString() + "\n" + "Student Level:\tUndergraduate\nYear of Entry:\t\t"
				+ super.dateOfEntry() + "\nPass Percentage:\t" + passGrade + "%\nCredits Required:\t" + credits
				+ "\nCredits Taken:\t\t" + creditsTaken + "\n\nModules:\n" + modules.values()
				+ super.getNewStudentLine() + "\n");
	}

	public StudentID getStudentID() {
		return getSmartCard().getStuID();
	}
	
	@Override
	public String getSupervisor() {
		return null;
	}

	@Override
	public void ammendStudent(int uniqueID, String name, String dateOfBirth) {
	}

}
