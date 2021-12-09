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
	
	/**
	 * the enrolled number
	 */
	private int enrolledNum = 0;

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
			return false;
			
		}
		return false;
		
		
		
	}

	// getter and setter methods
	
	/**
	 * get the course id
	 * @return course id
	 */
	public String getId() {
		return id;
	}

	/**
	 * set the course id
	 * @param id course id from file or input
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * get the course name
	 * @return course name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the course name
	 * @param name course name from file or input
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the course lecturer
	 * @return course lecturer
	 */
	public String getLecturer() {
		return lecturer;
	}

	/**
	 * set the course lecturer
	 * @param lecturer the course lecturer from file or input
	 */
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}


	/**
	 * get the course days
	 * @return course days
	 */
	public String getDays() {
		return days;
	}

	/**
	 * set the course days
	 * @param days the course days from file or input
	 */
	public void setDays(String days) {
		this.days = days;
	}

	/**
	 * get the startTime of the course
	 * @return the course's startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * set the startTime of the course
	 * @param startTime the course's startTime from file or input
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * get the endTime of the course
	 * @return the course's endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	
	/**
	 * set the endTime of the course
	 * @param endTime the course's endTime from file or input
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * get the capacity of the course
	 * @return course's capacity
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * set the capacity of the course
	 * @param capacity course's capacity from file or input
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	
	/**
	 * get the enrolled number of the course
	 * @return course's enrolledNum
	 */
	public int getEnrolledNum() {
		return enrolledNum;
	}

	/**
	 * set the enrolled number of the course
	 * @param enrolledNum course's enrolledNum increased when student get enrolledNum
	 */
	public void addEnrolledNum() {
		this.enrolledNum ++;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
