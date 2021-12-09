package roles;

import java.util.ArrayList;

import files.FileInfoReader;

/**
 * Represents an admin
 * @author Xinyang Shen
 */
public class Admin{
	
	//instance variable
	/**
	 * use an ArrayList to contain all the admins in the system
	 */
	public static ArrayList<Admin> ADMINS = new ArrayList<Admin>();
	
	/**
	 * the id of Admin
	 */
	private String id;
	
	/**
	 * the name of Admin
	 */
	private String name;
	
	/**
	 * the userName of Admin
	 */
	private String userName;
	
	/**
	 * the password of Admin
	 */
	private String password;
	
	
	// static variable
	
	static String FILENAME = "adminInfo";

	// constructor
	/**
	 * create an admin with its given features
	 * @param id
	 * @param name
	 * @param userName
	 * @param password
	 */
	
	public Admin(String id, String name, String userName, String password) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		
	}

}
