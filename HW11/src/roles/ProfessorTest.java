package roles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import courses.Course;
import files.FileInfoReader;

class ProfessorTest {
	
	Professor professor; 

	@BeforeEach
	void setUp() throws Exception {
		
		FileInfoReader.setAdminInfo();
		 FileInfoReader.setCourseInfo();
		 FileInfoReader.setStudentInfo();
		 FileInfoReader.setProfessorInfo();
	}

	@Test
	void testGetCourseList() {
		Professor pro = Professor.PROFESSORS.get(0);
		
		
		
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
	}
	
	
	
	
	@Test
	void testIsIDOccupied() {
		
		// 001 is occupied
		assertTrue(Professor.isIDOccupied("001"));
	
		// 12345 is not occupied
		assertFalse(Professor.isIDOccupied("12345"));
		

		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
	}
	
	
	@Test
	void testIsUserNameOccupied() {
		
		// testStudent01 is occupied
		assertTrue(Professor.isUserNameOccupied("Greenberg"));
		
		// curry is not occupied
		assertFalse(Professor.isUserNameOccupied("curry"));
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
	}
	
	
	
	
	
	
	
	
	

}
