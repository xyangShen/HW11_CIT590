package roles;

/**
 * abstract class for user who can access this system
 * three subclass: student, professor and admin
 * @author Xinyang Shen
 */
public abstract class User {
	
	// instance variables
	
	/**
	 * ID number for a user
	 */
	String id;
	
	/**
	 * real name for a user
	 */
	String name;
	
	/**
	 * user name 
	 */
	String userName;
	
	
	// constructor
	public User(String userName) {
		this.userName = userName;
	}

	// getters

	/**
	 * @return id of the user
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return name of the user
	 */
	public String getName() {
		return name;
	}


	// abstract methods
	/**
	 * view the courses with the given ID
	 */
	public abstract void viewCourses();
	
	/**
	 * add the courses to each user information
	 */
	public abstract void addCourses();
	
	/**
	 * drop the courses to each user information
	 */
	public abstract void dropCourses();
	
	
	
	
	
	

}
