package courses;


/**
 * Represents courses in the system
 * @author Xinyang Shen
 */
public class Courses {
	
	// instance variables
	
	/**
	 * course ID
	 */
	String id;
	
	/**
	 * course name
	 */
	String name;
	
	/**
	 * lecturer of the course
	 */
	String lecturer;
	
	/**
	 * Start time
	 */
	String startTime;
	
	/**
	 * end time
	 */
	String endTime;
	
	/**
	 * capacity
	 */
	String capacity;
	
	// constructor
	/**
	 * set the course with its ID
	 * @param ID to set
	 */
	public Courses(String ID){
		this.id = ID;
		
	}
	

}
