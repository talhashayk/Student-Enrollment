package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

/*
 * Being on of the more specific student classed. This class refers to 
 * postgraduate students that are doing research rather than being taught
 * and thus has methods and fields such as @param supervisor in order to
 * accomodate for the students needs.
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PostgradResearch extends AbstractStudent {

	private static Map<StudentID, Student> researchMap = new HashMap<StudentID, Student>();
	private String supervisor;
	private DateOfBirth dateOfBirth;
	private Name name;


	public PostgradResearch(SmartCard smartcard, String supervisor) {
		super(smartcard);
		this.supervisor = supervisor;
		researchMap.put(smartcard.getStuID(), this);
	}

	public static Student registerStudent(String name, String dateOfBirth, String supervisor) {
		Name studentName = Name.valueOf(name);
		DateOfBirth studentDOB = DateOfBirth.valueOf(dateOfBirth);
		SmartCardNumber scn = new SmartCardNumber(studentName);
		SmartCard sc = new SmartCard(studentDOB, scn);
		researchMap.put(sc.getStuID(), new PostgradResearch(sc, supervisor));
		return researchMap.get(sc.getStuID());
	}

	public static void terminateStudent(StudentID uniqueID) {
		researchMap.remove(uniqueID);
	}

	public static void ammendStudent(StudentID uniqueID, String name, String dateOfBirth, String supervisor) {
		PostgradResearch student = (PostgradResearch) researchMap.get(uniqueID);
		student.name = Name.valueOf(name);
		student.dateOfBirth = DateOfBirth.valueOf(dateOfBirth);
		student.supervisor = supervisor;
		researchMap.replace(student.getStudentID(), student);
	}
	
	public static int getResearchMapSize() {
		return researchMap.size();
	}

	public static Collection<Student> getResearchMap() {
		return researchMap.values();
	}
	
	public String getSupervisor() {
		return supervisor;
	}

	public StudentID getStudentID() {
		return getSmartCard().getStuID();
	}

	public String toString() {
		return new String(super.toString() + "\n" + "Student Level:\tPostgraduate - Research\nYear of Entry:\t"
				+ super.dateOfEntry() + "\nSupervisor:\t" + supervisor + super.getNewStudentLine() + "\n");
	}

	@Override
	public void ammendStudent(int uniqueID, String name, String dateOfBirth) {
		// TODO Auto-generated method stub
		
	}

}
