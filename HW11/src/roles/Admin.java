package roles;

import java.util.ArrayList;
import courses.Course;

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
	
	
	// other method
	/**
	 * add the new professor into the system
	 * @param professor to add
	 */
	public static void addProfessor(Professor professor) {
		
		System.out.println("Sucessfully add the professor: " + professor.getId() + professor.getName());
		
		Professor.PROFESSORS.add(professor);
		
	}
	
	
	/**
	 * delete the given professor with given id
	 * @param proID to delete
	 */
	public static void delProfessor(String proID) {
		
		// iterate over the professor list 
		for(int i = 0; i < Professor.PROFESSORS.size(); i++) {
			
			// find the professor by id
			if(Professor.PROFESSORS.get(i).getId().equals(proID)){
				
				System.out.println("Sucessfully remove the professor: " + Professor.PROFESSORS.get(i).getId() + Professor.PROFESSORS.get(i).getName());
				
				// remove this professor
				Professor.PROFESSORS.remove(i);
			}
		}
		
	}
	
	/**
	 * take the given student and add to the list
	 * @param student to add
	 */
	public static void addStudent(Student student) {
		
		System.out.println("You have successfully add the student:" + student.getId() + student.getName());
		Student.STUDENTS.add(student);
		
	}
	
	
	/**
	 * delete the student in the system
	 * check if the student is in the list
	 * @param studentID to delete
	 * @return
	 */
	public static void delStudent(String studentID) {
		// iterate over the student list 
		for(int i = 0; i < Student.STUDENTS.size(); i++) {
				
			// find the student by id
				if(Student.STUDENTS.get(i).getId().equals(studentID)) {
					
					System.out.println("Sucessfully remove the student: " + Student.STUDENTS.get(i).getId() + Student.STUDENTS.get(i).getName());
					
					// remove this student
					Student.STUDENTS.remove(i);
				}
			}
		
	}
	

	/**
	 * check whether the input profID is in the profInfo
	 * @param lecturerId
	 * @return boolean if the input exists, return true
	 */
	public boolean checkProfessorId(String lecturerId){
		// get the lecture name with the lecturerId
		for (int i = 0; i < Professor.PROFESSORS.size(); i++) {
			// get the i professor
			Professor p = Professor.PROFESSORS.get(i);
			if (p.getId().equals(lecturerId)) {
				return true;
			}else {
				continue;
			}
				}return false;
		
		
		
		
		
	}
	
	/**
	 * delete the course in the system
	 * check if the course is in the list
	 * @param courseID to delete
	 * @return
	 */
	public static void delCourse(String courseID) {
		// iterate over the course list 
		for(int i = 0; i < Course.COURSELIST.size(); i++) {
				
			// find the course by id
				if(Course.COURSELIST.get(i).getId().equals(courseID)) {
					
					System.out.println("Sucessfully remove the course: " + Course.COURSELIST.get(i).getId() + Course.COURSELIST.get(i).getName());
					
					// remove this course
					Course.COURSELIST.remove(i);
				}
			}
		
	}
	
	
	
	
	
	
	
	
	

}
