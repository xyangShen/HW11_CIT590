package roles;

import files.FileInfoReader;

/**
 * Represents an admin
 * @author Xinyang Shen
 */
public class Admin extends User {
	
	// static variable
	
	static String FILENAME = "adminInfo";

	// constructor
	
	/**
	 * 
	 * @param userName
	 */
	public Admin(String userName) {
		
		super(userName);
		
		// call methods from the FileInfoReader to set up values
		this.id = FileInfoReader.getID(Admin.FILENAME, userName);
		this.name = FileInfoReader.getName(Admin.FILENAME, userName);
		
	}

}
