package roles;

import java.util.ArrayList;

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
	public static ArrayList<Professor> PROFESSIORS = new ArrayList<Professor>();
	
	
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
	
	
	// static variable
	
	/**
	 * name of the professor file
	 */
	static String FILENAME = "profInfo.txt";
	
	
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
	
	
	
}
