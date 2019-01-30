package test;

import main.Student;
import main.AbstractStudent;
import main.Undergraduate;
import main.PostgradTaught;
import main.PostgradResearch;
import main.DateOfBirth;
import main.Module;
import main.Name;
import main.SmartCard;
import main.SmartCardNumber;
import main.StudentID;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestCase {

	@Test
	public void testName() {
		Name name = new Name("Mohammed", "Sheikh");
		assertEquals("MOHAMMED", name.getForename());
		assertEquals("SHEIKH", name.getSurname());
		assertEquals("M", name.getForenameInitial());
		assertEquals("S", name.getSurnameInitial());
	}

	@Test
	public void testDateOfBirth() {
		DateOfBirth date = new DateOfBirth(1, 5, 1999);
		assertEquals("01:05:1999", date.toString());
		assertEquals(1, date.getDayDOB());
		assertEquals(5, date.getMonthDOB());
		assertEquals(1999, date.getYearDOB());
	}

	@Test
	public void testSmartCardNumber() {
		Name name = new Name("Mohammed", "Sheikh");
		Name name2 = new Name("Zahid", "Sheikh");

		SmartCardNumber scn = new SmartCardNumber(name);
		SmartCardNumber scn2 = new SmartCardNumber(name2);

		assertEquals("MS-2018-10", scn.toString());
		assertEquals("ZS-2018-11", scn2.toString());
	}

	@Test
	public void testSmartCard() {
		Name name = new Name("Mohammed", "Sheikh");
		SmartCardNumber scn = new SmartCardNumber(name);
		DateOfBirth date = new DateOfBirth(1, 5, 1999);
		SmartCard sc = new SmartCard(date, scn);

		assertEquals(sc.dateOfIssue(), 2018);
		assertEquals(sc.getCardNumber(), "MS-2018-10");
		assertEquals(sc.getdOB().toString(), "01:05:1999");
		assertEquals(sc.getName().toString(), "Mohammed Sheikh");
	}

	@Test
	public void testStudents() {
		Name name = new Name("Mohammed", "Sheikh");
		SmartCardNumber scn = new SmartCardNumber(name);
		DateOfBirth date = new DateOfBirth(1, 5, 1999);
		SmartCard sc = new SmartCard(date, scn);

		Module m = new Module().getInstance("CSC1021", "Programming 1", 20);
		Module m1 = new Module().getInstance("CSC1021", "Programming 2", 20);
		Module m2 = new Module().getInstance("CSC1021", "Programming 3", 20);
		Module m3 = new Module().getInstance("CSC1021", "Programming 4", 20);
		Module m4 = new Module().getInstance("CSC1021", "Programming 5", 20);
		Module m5 = new Module().getInstance("CSC1021", "Programming 6", 20);

		Student student = new PostgradResearch(sc, "Melissa");

		assertEquals("Melissa", student.getSupervisor());
	}

	@Test
	public void testNoOfStudents() {
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

		assertEquals(1, Undergraduate.getUndergradMapSize());
		assertEquals(1, PostgradTaught.getTaughtMapSize());
		assertEquals(2, PostgradResearch.getResearchMapSize());
	}

}
