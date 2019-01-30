package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * This class refers to oostgraduate students that are being taught
 * and therefore has methods and fields that accommodate for its needs
 * such as @credits where unlike the undergraduate class with 120 credits
 * being needed, this class requires 180 credits.
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PostgradTaught extends AbstractStudent {

	private static Map<StudentID, Student> taughtMap = new HashMap<StudentID, Student>();
	private static Map<String, Module> modules = new HashMap<String, Module>();
	private int passGrade;
	private int credits;
	private int creditsTaken;
	private DateOfBirth dateOfBirth;
	private Name name;

	public PostgradTaught(SmartCard smartcard, Map<String, Module> modules) {
		super(smartcard);
		this.passGrade = 50;
		this.credits = 180;
		this.creditsTaken = getCreditsTaken();
		this.modules = modules;
		taughtMap.put(smartcard.getStuID(), this);
	}

	public static Student registerStudent(String name, String dateOfBirth, Map<String, Module> modules) {
		Name studentName = Name.valueOf(name);
		DateOfBirth studentDOB = DateOfBirth.valueOf(dateOfBirth);
		SmartCardNumber scn = new SmartCardNumber(studentName);
		SmartCard sc = new SmartCard(studentDOB, scn);
		taughtMap.put(sc.getStuID(), new PostgradTaught(sc, modules));
		return taughtMap.get(sc.getStuID());
	}

	public static void terminateStudent(StudentID uniqueID) {
		taughtMap.remove(uniqueID);
	}

	public static void ammendStudent(StudentID uniqueID, String name, String dateOfBirth, Map<String, Module> modules) {
		PostgradTaught student = (PostgradTaught) taughtMap.get(uniqueID);
		student.name = Name.valueOf(name);
		student.dateOfBirth = DateOfBirth.valueOf(dateOfBirth);
		student.modules = modules;
		taughtMap.replace(student.getStudentID(), student);
	}

	public int getCreditsTaken() {
		for (Module m : modules.values()) {
			int i = m.getModuleCredits();
			creditsTaken += i;
		}
		return creditsTaken;
	}

	public static Map<String, Module> getModulesList(Student student) {
		return modules;
	}

	public static int getTaughtMapSize() {
		return taughtMap.size();
	}

	public static Collection<Student> getTaughtMap() {
		return taughtMap.values();
	}
	
	public String toString() {
		return new String(super.toString() + "\n" + "Student Level:\tPostgraduate - Taught\nYear of Entry:\t\t"
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
		// TODO Auto-generated method stub

	}

}
