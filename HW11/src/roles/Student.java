package roles;

import java.util.ArrayList;
import java.util.Map;

import courses.Course;
import files.FileInfoReader;

/**
 * Represents a student
 * @author Xinyang Shen
 */
public class Student {
	
	// instance variables
	
	/**
	 * use an ArrayList to contain all the students in the system
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

	// getter and setter
	/**
	 * get the student id
	 * @return student id
	 */
	public String getId() {
		return id;
	}

	/**
	 * set the student id
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * get the student name
	 * @return student's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the student name
	 * @param name of student
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the student's userName
	 * @return userName of student
	 */
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Map<String, String> getCourseMap() {
		return courseMap;
	}


	public void setCourseMap(Map<String, String> courseMap) {
		this.courseMap = courseMap;
	}
	
	
    
	
	
	
	
	
	
	
	
	
	
	

}
