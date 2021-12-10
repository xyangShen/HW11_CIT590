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
	
	/**
	 * 
	 */
	private ArrayList<Course> enrolledCourses = new ArrayList<Course>();
	
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

	/**
	 * set the student's userName
	 * @param userName of student
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * get the student's password
	 * @return the password of student
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set the student's password
	 * @param password of student
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * get the student's courseMap
	 * @return courseMap of student
	 */
	public Map<String, String> getCourseMap() {
		return courseMap;
	}
	
	
	// other method
	
	
	/**
	 * add the enrolled courses from the hashmap into arraylist 
	 * convert string to course
	 */
	private void addEnrolledCourse() {
		
		//iterate over all the keys in the courseMap
		for (Map.Entry<String, String> set: courseMap.entrySet()) {
			
			// key value as the course ID
			String cID = set.getKey();
			
			// iterate over the course arraylist, finding the courseID which matches
			for(int i = 0; i < Course.COURSELIST.size(); i++) {
				if (Course.COURSELIST.get(i).getId().equals(cID)) {
					
					// create the course instance
					Course course = Course.COURSELIST.get(i);
					
					// add the course into the enrolledcourse list
					this.enrolledCourses.add(course);
					}
				}
			}
		}

	
	
	/**
	 * add a course in the student's course list
	 * 
	 * @param courseID
	 */
	public void addCourse(String courseID) {
		
		// initiate enrolled courses arraylist
		this.addEnrolledCourse();
		
		// to check if the course is in the course list
		
		
		
		// iterate over the enrolled course arraylist
		for (int i = 1; i < this.enrolledCourses.size(); i++) {
			
			// if the course already exist in the enrolledCourse ArrayList
			if(this.enrolledCourses.get(i).getId().equals(courseID)) {
				System.out.println("The course you selected ");
			}
			
		}
		
		
		
		
		
	}

	/**
	 * set the student's courseMap 
	 * @param courseMap of student
	 */
	public void setCourseMap(Map<String, String> courseMap) {
		this.courseMap = courseMap;
	}
	
	
   

}



