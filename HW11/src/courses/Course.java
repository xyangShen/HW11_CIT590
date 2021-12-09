package courses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Represents courses in the system
 * @author Xinyang Shen
 */
public class Course {
	
	// instance variables
	
	/**
	 * use an ArrayList to contain all the courses in the system
	 */
	public static ArrayList<Course> COURSELIST = new ArrayList<Course>();
	
	
	/**
	 * course ID
	 */
	private String id;
	
	/**
	 * course name
	 */
	private String name;
	
	/**
	 * lecturer of the course
	 */
	private String lecturer;
	
	/**
	 * course days
	 */
	private String days;
	
	/**
	 * Start time
	 */
	private String startTime;
	
	/**
	 * end time
	 */
	private String endTime;
	
	/**
	 * capacity
	 */
	private String capacity;	

	// constructor
	/**
	 * set the course with its information
	 * @param id
	 * @param name
	 * @param lecturer
	 * @param days
	 * @param startTime
	 * @param endTime
	 * @param capacity
	 */
	
	public Course(String id, String name, String lecturer, String days, String startTime, String endTime, String capacity){
		this.id = id;	
		this.name = name;
		this.lecturer = lecturer;
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
		this.capacity = capacity;     
	}

	
	// methods
	/**
	 * compare the course time
	 * @param addCourse means the course user wants to add
	 * @param enrolledCourses means the user's enrolled course
	 * @return if there is no time conflict, returns true; else returns false;
	 */
	public static boolean compareTime(Course addCourse, ArrayList<Course> enrolledCourses) {
		//create a dateFormatTranslator
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
		
		try {
			//change the start_time string to the date
			Date x = sdf.parse(addCourse.startTime);
			//change the end_time string to the date
			Date y = sdf.parse(addCourse.endTime);
			
			for(int i = 0;i < enrolledCourses.size(); i ++){
	            Course course = enrolledCourses.get(i);
	            //change the start_time string to the date
	            Date a = sdf.parse(course.startTime);
				//change the end_time string to the date
				Date b= sdf.parse(course.endTime);
				
				//change the date to millisecond and compare
				// this condition means time conflicts
				if(!(x.getTime()-b.getTime() >= 0 || a.getTime()-y.getTime() >= 0))
					return false;
				else
					continue;   
	            
	            
	        }
			// if can pass the for-loop meaning that no time conflict
			return true;
						
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return false;
		
	
	}	
	
	
	public static boolean compareName(String addName, ArrayList<Course> COURSELIST) {
		
		if (COURSELIST.contains(addName)){
			return null;
			
		}
		
		
		
	}

}
