package roles;

import java.util.ArrayList;
import java.util.Map;

import courses.Course;
import courses.Courses;
import files.FileInfoReader;

/**
 * Represents a student
 * @author Xinyang Shen
 */
public class Student {
	
	// instance variables
	
	/**
<<<<<<< HEAD
	 * use an ArrayList to contain all the students in the system
=======
	 * map of the courses
>>>>>>> refs/remotes/origin/main
	 */
	public static ArrayList<Student> STUDENTS = new ArrayList<Student>();
	
	/**
	 * student ID
	 */
	private String id;
	
	/**
	 * student name
	 */
	private String name;
	
	/**
	 * student userName
	 */
	private String userName;
	
	/**
	 * student password
	 */
	private String password;
		
	/**
	 * the course and its grade
	 */
	private Map<String, String> courseMap;
	
	
	// static variables
	
	/**
	 * name of the student file
	 */
	static String FILENAME = "studentInfo.txt";
	
	
	// constructor
	/**
	 * create a student with his/her given features
	 * @param id
	 * @param name
	 * @param userName
	 * @param password
	 * @param courseMap
	 */
	public Student(String id, String name, String userName, String password, Map<String, String> courseMap) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.courseMap = courseMap;
	}
	
	
		
<<<<<<< HEAD
	
	
	
	
	
	
	
	

	//methods
	public Map<String, String> getCourses() {
		return this.courses;
=======
		// call the methods from fileInfoReader to get the detailed information about this student
		this.name = FileInfoReader.getName(Student.FILENAME, userName);
		this.id = FileInfoReader.getID(Student.FILENAME, userName);
		this.courses = FileInfoReader.getCourses(userName);
		
>>>>>>> refs/remotes/origin/main
	}

	

}
