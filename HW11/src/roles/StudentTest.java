package roles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import courses.Course;
import files.FileInfoReader;



class StudentTest {


	Student student;
	
	 @BeforeEach
	    void setUp() throws Exception {
		
		 FileInfoReader.setAdminInfo();
		 FileInfoReader.setCourseInfo();
		 FileInfoReader.setStudentInfo();
		 FileInfoReader.setProfessorInfo();
	      
	    }
	 
	 

	@Test
	void testAddEnrolledCourse() {
		
		
		Map<String, String> courseList = new HashMap<String, String>();
		
		courseList.put("CIS545", "A+");
		
		courseList.put("CBE554", "A+");
		
		Student newStudent = new Student("003", "student03", "teststudent03", "012345", courseList);
		
		// can not put course which are not in the list into the enrolled list (eg."CBE554")
		// can add course like "CIS545" which is on the course list
		newStudent.addEnrolledCourse();
		assertEquals(1, newStudent.getEnrolledCourses().size());	
		
		
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
	}
	 
	

	@Test
	void testAddCourse() {
		
		
		student = Student.STUDENTS.get(0);


		student.addEnrolledCourse();
		
		
		// add a course which had been selected before, should not get enrolled
		student.addCourse("CIS191");
		assertEquals(2, student.getEnrolledCourses().size());
		
		//add a course that dose not exist, should not get enrolled
		student.addCourse("CBE554");
		assertEquals(2, student.getEnrolledCourses().size());

		// add a course and successful
		student.addCourse("CIT592");
		assertEquals(3, student.getEnrolledCourses().size());
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
		
	}

	@Test
	void testDropCourse() {
		
		
		student = Student.STUDENTS.get(1);

		student.addEnrolledCourse();
		
		
		// drop a course which had not been selected before, should not get dropped
		student.dropCourse("CIS191");
		assertEquals(2, student.getEnrolledCourses().size());
		
		
		// drop a course that dose not exist, should not get dropped
		student.dropCourse("CBE554");
		assertEquals(2, student.getEnrolledCourses().size());
		
		
		// drop a course and successful
		student.dropCourse("CIT592");
		assertEquals(1, student.getEnrolledCourses().size());
		
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
		
	}
	
	

	@Test
	void testIsIDOccupied() {
		
	
		// 001 is occupied
		assertTrue(Student.isIDOccupied("001"));
		
		
		// 12345 is not occupied
		assertFalse(Student.isIDOccupied("12345"));
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
	}

	@Test
	void testIsUserNameOccupied() {
		
		// testStudent01 is occupied
		assertTrue(Student.isUserNameOccupied("testStudent01"));
		
		// xinyangs is not occupied
		assertFalse(Student.isUserNameOccupied("xinyangs"));
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
	}

}
