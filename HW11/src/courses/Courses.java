package courses;

import files.FileInfoReader;

/**
 * Represents courses in the system
 * @author Xinyang Shen
 */
public class Courses {
	
	// instance variables
	
	/**
	 * line from the file for a given course
	 */
	String courseLine;
	
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
	
	
	/**
	 * lecture days of the course
	 */
	String lectureDays;
	
	
	// constructor
	
	/**
	 * set the course with its ID
	 * @param ID to set
	 */
	public Courses(String ID){
		// sets the id
		this.id = ID;
		
		// get the line of the course from the file
		// "CIT590; Programming Languages and Techniques; Brandon L Krakowsky; MW; 16:30; 18:00; 110"
		this.courseLine = FileInfoReader.getCourseInfo(ID);
		
		// split the string
		//["CIT590", "Programming Languages and Techniques", "Brandon L Krakowsky", "MW", "16:30", "18:00", "110"]
		String[] courseInfo = courseLine.split("; ");
		
		// [1] as the name of the course
		this.name = courseInfo[1];
		
		// [2] as the lecturer of the course
		this.lecturer = courseInfo[2];
		
		// [3] as the lecture days of the course
		this.lectureDays = courseInfo[3];
		
		// [4] as the start time of the lecture
		this.startTime = courseInfo[4];
		
		// [5] as the end time of the lecture
		this.endTime = courseInfo[5];
		
		// [6] as the capacity of the course
		this.capacity = courseInfo[6];
		
	}
	
	
	// getter method
	
	/**
	 * get the name of the course
	 * @return
	 */
	public String getName() {
		return name;
	}



}
