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

import roles.Professor;
import roles.Student;

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
	
	/**
	 * the arrayList of students who get enrolled in the class
	 */
	public ArrayList<Student> addStudent = new ArrayList<Student>();
	
	/**
	 * lists of conflict courses
	 * should be cleared every time when trying to add a new course
	 */
	private ArrayList<Course> conflictCourses = new ArrayList<Course>();
	


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

	

	
	public static boolean compareName(String addName, ArrayList<Course> COURSELIST) {
		
		if (COURSELIST.contains(addName)){
			return false;
			
		}
		return false;
		
		
		
	}

	// getter and setter methods
	
	
	/**
	 * @return the list of conflict courses
	 */
	public ArrayList<Course> getConflictCourses() {
		return conflictCourses;
	}


	/**
	 * sets the list of conflict courses
	 * @param conflictCourses
	 */
	public void setConflictCourses(ArrayList<Course> conflictCourses) {
		this.conflictCourses = conflictCourses;
	}

	
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

	
	
	
	// other method
	
	/**
	 * set the enrolled number of the course
	 * @param enrolledNum course's enrolledNum increased when student get enrolledNum
	 */
	public void addEnrolledNum() {
		this.enrolledNum ++;
	}

	
	/**
	 * compare the course time
	 * @param addCourse means the course user wants to add
	 * @param enrolledCourses means the user's enrolled course
	 * @return if there is no time conflict, returns true; else returns false;
	 */
	public boolean noTimeConflict(Student student, Course addCourse, ArrayList<Course> enrolledCourses) {
	
			
		// get all the course in the same day
		ArrayList<Course> sameDayCourse = new ArrayList<Course>();
			

		// iterate over the enrolledCourses list, gets the lecture day for each course and compare with the add Course
		for(int i = 0; i < student.getEnrolledCourses().size(); i++) {
			
			// there are situations where some lecture only have 1 day, where others have several days
			// split the string into characters
			
			// for example, split MW into M W
			String [] enrolledCourseDays = student.getEnrolledCourses().get(i).getDays().split("");
			
			// also split the days for the course needed to add
			// for example: M
			String [] addCourseDays = addCourse.getDays().split("");
			
			// iterate over these 2 list and compare if they have the same day
			for(int a = 0; a < enrolledCourseDays.length; a++){
				
				for(int b = 0; b < addCourseDays.length; b++) {
					
					// if they have the same day
					if(enrolledCourseDays[a].equals(addCourseDays[b])) {
						
						// if on the same day, then add to the list
						sameDayCourse.add(student.getEnrolledCourses().get(i));
						break;
						
					}
				}			
			}	
		}
			
	
		// then compare the start time and end time for those course in the same day
			
		//create a dateFormatTranslator
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
			
		try {
				
			//change the start_time string to the date
			Date x = sdf.parse(addCourse.startTime);
				
			//change the end_time string to the date
			Date y = sdf.parse(addCourse.endTime);
				
			for(int i = 0;i < sameDayCourse.size(); i ++){
				
				Course course = sameDayCourse.get(i);
		            
		        //change the start_time string to the date
		        Date a = sdf.parse(course.startTime);
		            
				//change the end_time string to the date
				Date b= sdf.parse(course.endTime);
					
				//change the date to millisecond and compare
					
				// this condition means time conflicts
				if(!(x.getTime()-b.getTime() >= 0 || a.getTime()-y.getTime() >= 0)) {
					// add this course in the conflictCourses list
					this.conflictCourses.add(course);
				}		
			}
							
			} catch (ParseException e) {
				
				e.printStackTrace();
				return false;
				
			}
		if(conflictCourses.size() > 0) {
			
			// if there are courses in the conflict courses list
			return false;
			
		} 
		else {
			// if the conflict courses list is empty
			return true;
		}
			
		
		}
		
        
		/**
		 * get the arrayList of enrolled students
		 * @return a list of enrolled students
		 */
		public ArrayList<Student> getAddStudent() {
			return addStudent;
		}

		
		/**
		 * updates the arrayList
		 * @param addStudent the list of enrolled students
		 */
		public void setAddStudent(ArrayList<Student> addStudent) {
			this.addStudent = addStudent;
		}

		
			//if (!this.addStudent.contains(student)) {
			//	this.addStudent.add(student);}
		

		/**
		 * print the course with given format
		 */

		public String toString() {
			return this.getId()  + "|" + this.getName() + ", " + this.getStartTime() + "-" + this.getEndTime() + " on " + this.getDays() + ", " + "with course capacity: " + this.getCapacity() + ", students: " + this.getEnrolledNum() + ", lecturer: Professior " + this.getLecturer(); 
			
		}


		/**
		 * compare the time between new course and professor given courses
		 * @param newCourse means the course user wants to add
		 * @param courseList means the professor's given course
		 * @return if there is no time conflict, returns true; else returns false;
		 */
		

		public boolean noTimeConflict(Professor p, Course newCourse, ArrayList<Course> courseList) {
			// get all the course in the same day
			ArrayList<Course> sameDayCourse = new ArrayList<Course>();
				

			// iterate over the courseList, gets the lecture day for each course and compare with the new Course
			for(int i = 0; i < p.getCourseList().size(); i++) {
					
				if(p.getCourseList().get(i).getDays().equals(newCourse.getDays())){
						
					// if on the same day, then add to the list
					sameDayCourse.add(p.getCourseList().get(i));
					
				}	
			}
				
		
			// then compare the start time and end time for those course in the same day
				
			//create a dateFormatTranslator
			SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");
				
			try {
					
				//change the start_time string to the date
				Date x = sdf.parse(newCourse.startTime);
					
				//change the end_time string to the date
				Date y = sdf.parse(newCourse.endTime);
					
				for(int i = 0;i < sameDayCourse.size(); i ++){
					
					Course course = sameDayCourse.get(i);
			            
			        //change the start_time string to the date
			        Date a = sdf.parse(course.startTime);
			            
					//change the end_time string to the date
					Date b= sdf.parse(course.endTime);
						
					//change the date to millisecond and compare
					// this condition means time conflicts
					if(!(x.getTime()-b.getTime() >= 0 || a.getTime()-y.getTime() >= 0)) {
						this.conflictCourses.add(course);
						return false;	
					}		
				}
								
				} catch (ParseException e) {
					
					e.printStackTrace();
					return false;
					
				}
			
			// if can pass the for-loop meaning that no time conflict
			return true;
				
		}

		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
