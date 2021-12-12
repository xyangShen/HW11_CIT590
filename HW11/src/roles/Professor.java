package roles;

import java.util.ArrayList;

import courses.Course;
import files.FileInfoReader;

/**
 * Represents a professor
 * @author Xinyang Shen
 */
public class Professor {
	
	//instance variables
	
	/**
	 * use an ArrayList to contain all the professors in the system
	 */
	public static ArrayList<Professor> PROFESSORS = new ArrayList<Professor>();
	
	
	/**
	 * professor's name
	 */
	private String name;
	
	/**
	 * professor's id
	 */
	private String id;
	
	/**
	 * professor's userName
	 */
	private String userName;
	
	/**
	 * professor's password
	 */
	private String password;
	

	
	// constructor
	
	/**
	 * create a professor with his/her given features
	 * @param name
	 * @param id
	 * @param userName
	 * @param password
	 */
	
	public Professor(String name, String id, String userName, String password) {
	this.name = name;
	this.id = id;
	this.userName = userName;
	this.password = password;
	}
	
    
	
	
	
	//methods
	// return the list of given courses names
	public ArrayList<String> getTeachingCourses(){
		return null;
		
	}
	
	// return the list of student names from one given course
	public ArrayList<String> getStudentInvolved(){
		return null;
		
	}




	/**
	 * get the professor name
	 * @return professor name
	 */
	public String getName() {
		return name;
	}



	/**
	 * set the professor name
	 * @param name of professor
	 */

	public void setName(String name) {
		this.name = name;
	}



	/**
	 * get the professor id
	 * @return id of professor
	 */

	public String getId() {
		return id;
	}



	/**
	 * set the professor id
	 * @param id of professor
	 */

	public void setId(String id) {
		this.id = id;
	}



	/**
	 * get the professor userName
	 * @return userName of professor
	 */

	public String getUserName() {
		return userName;
	}



	/**
	 * set the professor userName
	 * @param userName of professor
	 */

	public void setUserName(String userName) {
		this.userName = userName;
	}


	/**
	 * get the professor password
	 * @return password of professor
	 */

	public String getPassword() {
		return password;
	}


	/**
	 * set the professor password
	 * @param password of professor
	 */

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public ArrayList<Course> getCourseList() {
	
	//create an arrayList of given courses
	ArrayList<Course> courseList = new ArrayList<Course>();
	
	for (int j = 0; j < Course.COURSELIST.size(); j++) {
		  // get each professor
		  String prof = Course.COURSELIST.get(j).getLecturer();
		  // if professor name is in the courseList, get the course
		  if (this.getName().equals(prof)) {
			  Course givenCourse = Course.COURSELIST.get(j);
			  courseList.add(givenCourse);
		  }
	
	}
	return courseList;	  
		  }	
	
	
	/**
	 * to check if a professor id is already in the list
	 * @param proID to check
	 * @return true if the id is occupied, otherwise false
	 */
	public static boolean isIDOccupied(String proID) {
		
		// sets the initial value to be false
		boolean isIDOccupied = false;
		
		// iterate over the professor list
		for (int i = 0; i < Professor.PROFESSORS.size(); i++) {
			
			if(Professor.PROFESSORS.get(i).getId().equals(proID)) {
				
				// if the id is occupied
				isIDOccupied = true;
				break;
			}
		}

		return isIDOccupied;
		
	}
	
	/**
	 * to check if a professor user name is already in the list
	 * @param proUN to check
	 * @return true if the username is occupied, otherwise false
	 */
	public static boolean isUserNameOccupied(String proUN) {
		
		// sets the initial value to be false
		boolean isUserNameOccupied = false;
		
		// iterate over the professor list
				for (int i = 0; i < Professor.PROFESSORS.size(); i++) {
					
					if(Professor.PROFESSORS.get(i).getUserName().equals(proUN)) {
						
						// if the id is occupied
						isUserNameOccupied = true;
						break;
					}
				}

				return isUserNameOccupied;	
	}
	

	
	
}
