package roles;

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

}
