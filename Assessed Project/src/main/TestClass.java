package main;
/**
 * @author Talha Sheikh
 * @version 1.0
 * @since 08-05-2018
 * Student Number: 170322690
 */

import java.util.HashMap;
import java.util.Map;

public class TestClass {

	public static void main(String[] args) {
		testName();
		testDateOfBirth();
		testSmartCardNumber();
		testSmartCard();
		testStudents();
		testNoOfStudents();
		testRegisterStudents();
		testTerminateStudents();
		testAmmendStudents();
	}

	public static void testName() {
		Name name = new Name("Mohammed", "Sheikh");
		Name name2 = new Name("Zahid", "Sheikh");

		System.out.println(name + "\n" + name2);
	}

	public static void testDateOfBirth() {
		DateOfBirth date = new DateOfBirth(1, 5, 1999);
		DateOfBirth date2 = new DateOfBirth(20, 8, 1966);

		System.out.println(date + "\n" + date2);
	}

	public static void testSmartCardNumber() {
		Name name = new Name("Mohammed", "Sheikh");
		Name name2 = new Name("Zahid", "Sheikh");

		SmartCardNumber scn = new SmartCardNumber(name);
		SmartCardNumber scn2 = new SmartCardNumber(name2);
		SmartCardNumber scn3 = new SmartCardNumber(name);

		System.out.println(scn + "\n" + scn2 + "\n" + scn3);
	}

	public static void testSmartCard() {
		Name name = new Name("Mohammed", "Sheikh");
		Name name2 = new Name("Zahid", "Sheikh");

		SmartCardNumber scn = new SmartCardNumber(name);
		SmartCardNumber scn2 = new SmartCardNumber(name2);
		SmartCardNumber scn3 = new SmartCardNumber(name);

		DateOfBirth date = new DateOfBirth(1, 5, 1999);
		DateOfBirth date2 = new DateOfBirth(20, 8, 1966);

		SmartCard sc = new SmartCard(date, scn);
		SmartCard sc2 = new SmartCard(date2, scn2);
		SmartCard sc3 = new SmartCard(date, scn3);

		System.out.println(sc + "\n" + sc2 + "\n" + sc3);
	}

	public static void testStudents() {
		Name name = new Name("Mohammed", "Sheikh");
		Name name2 = new Name("Zahid", "Sheikh");

		SmartCardNumber scn = new SmartCardNumber(name);
		SmartCardNumber scn2 = new SmartCardNumber(name2);
		SmartCardNumber scn3 = new SmartCardNumber(name);

		DateOfBirth date = new DateOfBirth(1, 5, 1999);
		DateOfBirth date2 = new DateOfBirth(20, 8, 1966);

		SmartCard sc = new SmartCard(date, scn);
		SmartCard sc2 = new SmartCard(date2, scn2);
		SmartCard sc3 = new SmartCard(date, scn3);

		Module m = new Module().getInstance("CSC1021", "Programming 1", 20);
		Module m1 = new Module().getInstance("CSC1021", "Programming 2", 20);
		Module m2 = new Module().getInstance("CSC1021", "Programming 3", 20);
		Module m3 = new Module().getInstance("CSC1021", "Programming 4", 20);
		Module m4 = new Module().getInstance("CSC1021", "Programming 5", 20);
		Module m5 = new Module().getInstance("CSC1021", "Programming 6", 20);

		Student student = new Undergraduate(sc, Module.getMODULES());
		Student student2 = new PostgradTaught(sc2, Module.getMODULES());
		Student student3 = new PostgradResearch(sc3, "Melissa");
		Student student4 = new PostgradResearch(sc3, "mel");

		System.out.println(student);
		System.out.println(student2);
		System.out.println(student3);

		System.out.println(student.getStudentID());
		System.out.println(student2.getStudentID());
		System.out.println(student3.getStudentID());

		System.out.println(student3.getSupervisor());
		System.out.println(student4.getSupervisor());

	}

	public static void testNoOfStudents() {
		Name name = new Name("Mohammed", "Sheikh");
		Name name2 = new Name("Zahid", "Sheikh");

		SmartCardNumber scn = new SmartCardNumber(name);
		SmartCardNumber scn2 = new SmartCardNumber(name2);
		SmartCardNumber scn3 = new SmartCardNumber(name);

		DateOfBirth date = new DateOfBirth(1, 5, 1999);
		DateOfBirth date2 = new DateOfBirth(20, 8, 1966);

		SmartCard sc = new SmartCard(date, scn);
		SmartCard sc2 = new SmartCard(date2, scn2);
		SmartCard sc3 = new SmartCard(date, scn3);

		Module m = new Module().getInstance("CSC1021", "Programming 1", 20);
		Module m1 = new Module().getInstance("CSC1021", "Programming 2", 20);
		Module m2 = new Module().getInstance("CSC1021", "Programming 3", 20);
		Module m3 = new Module().getInstance("CSC1021", "Programming 4", 20);
		Module m4 = new Module().getInstance("CSC1021", "Programming 5", 20);
		Module m5 = new Module().getInstance("CSC1021", "Programming 6", 20);

		Student student = new Undergraduate(sc, Module.getMODULES());
		Student student2 = new PostgradTaught(sc2, Module.getMODULES());
		Student student3 = new PostgradResearch(sc3, "Melissa");
		Student student4 = new PostgradResearch(sc3, "mel");

		AbstractStudent.noOfStudents();

		System.out.println(Undergraduate.getUndergradMapSize());
		System.out.println(PostgradTaught.getTaughtMapSize());
		System.out.println(PostgradResearch.getResearchMapSize());

	}

	public static void testRegisterStudents() {
		Map<String, Module> modules = new HashMap<String, Module>();
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 1", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 2", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 3", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 4", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 5", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 6", 20));

		System.out.println(Undergraduate.registerStudent("Talha Sheikh", "01:05:1999", modules));
		System.out.println(PostgradTaught.registerStudent("Moeez Shahid", "02:06:1998", modules));
		System.out.println(PostgradResearch.registerStudent("Shawak Sharma", "07:06:1999", "Bruno"));

	}

	public static void testAmmendStudents() {
		Map<String, Module> modules = new HashMap<String, Module>();
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 1", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 2", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 3", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 4", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 5", 20));
		modules.put("CSC1021Programming 1", new Module("CSC1021", "Programming 6", 20));

		System.out.println(Undergraduate.registerStudent("Talha Sheikh", "01:05:1999", modules));
		System.out.println(PostgradTaught.registerStudent("Moeez Shahid", "02:06:1998", modules));
		Student stu = PostgradResearch.registerStudent("Shawak Sharma", "07:06:1999", "Bruno");
		System.out.println(stu);
		Undergraduate.ammendStudent(stu.getStudentID(), "Haris Khan", "10:07:1998", modules);
		System.out.println(stu);

	}

	public static void testTerminateStudents() {
		Name name = new Name("Mohammed", "Sheikh");
		Name name2 = new Name("Zahid", "Sheikh");

		SmartCardNumber scn = new SmartCardNumber(name);
		SmartCardNumber scn2 = new SmartCardNumber(name2);
		SmartCardNumber scn3 = new SmartCardNumber(name);

		DateOfBirth date = new DateOfBirth(1, 5, 1999);
		DateOfBirth date2 = new DateOfBirth(20, 8, 1966);

		SmartCard sc = new SmartCard(date, scn);
		SmartCard sc2 = new SmartCard(date2, scn2);
		SmartCard sc3 = new SmartCard(date, scn3);

		Module m = new Module().getInstance("CSC1021", "Programming 1", 20);
		Module m1 = new Module().getInstance("CSC1021", "Programming 2", 20);
		Module m2 = new Module().getInstance("CSC1021", "Programming 3", 20);
		Module m3 = new Module().getInstance("CSC1021", "Programming 4", 20);
		Module m4 = new Module().getInstance("CSC1021", "Programming 5", 20);
		Module m5 = new Module().getInstance("CSC1021", "Programming 6", 20);

		Student student = new Undergraduate(sc, Module.getMODULES());
		Student student2 = new PostgradTaught(sc2, Module.getMODULES());
		Student student3 = new PostgradResearch(sc3, "Melissa");
		Student student4 = new PostgradResearch(sc3, "mel");

		System.out.println(student);
		System.out.println(student2);
		System.out.println(student3);
		System.out.println(student4);

		Undergraduate.terminateStudent(student.getStudentID());

		System.out.println(student);

	}

}
