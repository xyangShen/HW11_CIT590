package roles;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import courses.Course;
import files.FileInfoReader;

class AdminTest {

	Admin admin;
	
	@BeforeEach
	void setUp() throws Exception {
		FileInfoReader.setAdminInfo();
		 FileInfoReader.setCourseInfo();
		 FileInfoReader.setStudentInfo();
		 FileInfoReader.setProfessorInfo();
	}

	@Test
	void testAddProfessor() {
		
		
		
		
		
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
	}
	
	
	void testDelProfessor() {
			
			
			
			
			
			
			Student.STUDENTS.clear();
			Professor.PROFESSORS.clear();
			Admin.ADMINS.clear();
			Course.COURSELIST.clear();
		}
	
	
	
	
	
	
	

}
