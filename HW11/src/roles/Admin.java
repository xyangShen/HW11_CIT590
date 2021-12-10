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
	
	//getter and setter
	/**
	 * get the Admin id
	 * @return id of Admin
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * set the Admin id
	 * @param id of Admin
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * get the Admin name
	 * @return name of Admin
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the Admin name
	 * @param name of Admin
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the Admin userName
	 * @return userName of Admin
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * set the Admin userName
	 * @param userName of Admin
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * get the Admin password
	 * @return password of Admin
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * set the Admin password
	 * @param password of Admin
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	
	

}
