package roles;

import java.util.ArrayList;

import files.FileInfoReader;

/**
 * Represents a professor
 * @author Xinyang Shen
 */
public class Professor extends User {
	
	// static variable
	
	/**
	 * name of the professor file
	 */
	static String FILENAME = "prefInfo.txt";
	
	
	// constructor
	
	public Professor(String userName) {
		super(userName);
		
		// call methods from the FileInfoReader class to set up the values
		// reverse the order for the professor class
		this.id = FileInfoReader.getName(Professor.FILENAME, userName);
		this.name= FileInfoReader.getID(Professor.FILENAME, userName);
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
