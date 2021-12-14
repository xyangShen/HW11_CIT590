package roles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import courses.Course;
import files.FileInfoReader;

class StudentTest {
	
	Student student1;
	
	Student student2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		Map<String, String> studentCourse1 = new HashMap<String, String>();
		Map<String, String> studentCourse2 = new HashMap<String, String>();
		
		
		studentCourse1.put("CIT590", "A+");
		studentCourse2.put("CIS545", "A+");
		
		student1 = new Student("003", "StudentName3", "testStudent03", "password590", studentCourse1);
		
		student2 = new Student("003", "StudentName3", "testStudent03", "password590", studentCourse2);
		
		
	}
	

	@Test
	void testAddCourse() {
		
		FileInfoReader.setAdminInfo();
		FileInfoReader.setCourseInfo();
		FileInfoReader.setStudentInfo();

		student1.addEnrolledCourse();
		
		
		// add a course which had been selected before, should not get enrolled
		student1.addCourse("CIS590");
		assertEquals(1, student1.getEnrolledCourses().size());
		System.out.println(student1.getEnrolledCourses().size());
		
		//add a course that dose not exist, should not get enrolled
		student1.addCourse("CBE554");
		assertEquals(1, student1.getEnrolledCourses().size());
		System.out.println(student1.getEnrolledCourses().size());
		
		// add a course and successful
		student1.addCourse("CIT592");
		assertEquals(2, student1.getEnrolledCourses().size());
		System.out.println(student1.getEnrolledCourses().size());
		
		
	}

	@Test
	void testDropCourse() {
		
		FileInfoReader.setAdminInfo();
		FileInfoReader.setCourseInfo();
		FileInfoReader.setStudentInfo();
		
		student2.addEnrolledCourse();
		
		// drop a course which had not been selected before, should not get dropped
		student2.dropCourse("CIT592");
		assertEquals(1, student2.getEnrolledCourses().size());
		System.out.println(student2.getEnrolledCourses().size());
		
		// drop a course that dose not exist, should not get dropped
		student2.dropCourse("CBE554");
		assertEquals(1, student2.getEnrolledCourses().size());
		System.out.println(student2.getEnrolledCourses().size());
		
		// drop a course and successful
		student2.dropCourse("CIS545");
		assertEquals(0, student2.getEnrolledCourses().size());
		System.out.println(student2.getEnrolledCourses().size());
		
	}

	@Test
	void testIsIDOccupied() {
		fail("Not yet implemented");
	}

	@Test
	void testIsUserNameOccupied() {
		fail("Not yet implemented");
	}

}
