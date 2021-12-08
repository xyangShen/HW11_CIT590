package roles;

import java.util.ArrayList;
import java.util.Map;

import courses.Courses;
import files.FileInfoReader;

/**
 * Represents a student
 * @author Xinyang Shen
 */
public class Student extends User {
	
	// instance variables
	
	/**
	 * list of the courses
	 */
	Map<String, String> courses;
	
	
	// static variables
	
	/**
	 * name of the student file
	 */
	static String FILENAME = "studentInfo.txt";
	
	
	// constructors
	
	public Student(String userName) {
		// call the constructor from the super class
		super(userName);
		
		// call the methods from fileInfoReader to get the detailed information about this student
		this.name = FileInfoReader.getName(Student.FILENAME, userName);
		this.id = FileInfoReader.getID(this.FILENAME, userName);
		this.courses = FileInfoReader.getCourses(userName);
		
	}

	
	
	

}
