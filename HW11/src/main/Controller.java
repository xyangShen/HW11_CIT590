package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import courses.Course;
import files.FileInfoReader;
import roles.Admin;
import roles.Professor;
import roles.Student;


/**
 * a student management system
 * control the main logic flow of the entire system
 * @author Xinyang Shen, Jiahao He
 */
public class Controller {
	
	
	
	public static void main(String[] args) {
		
		// load the file into the arrayLists of students/courses/professors/admin
		FileInfoReader.setStudentInfo();
		FileInfoReader.setCourseInfo();
		FileInfoReader.setProfessorInfo();
		FileInfoReader.setAdminInfo();
		
	
		// when the system is on
		while(true) {
			// when enter the system, select to log in as student/professor/admin/quit the system
			System.out.println("----------------------------");
			System.out.println("Students Management System");
			System.out.println("----------------------------");
			System.out.println("1--Login as a student");
			System.out.println("2--Login as a professor");
			System.out.println("3--Login as an admin");
			System.out.println("4--Quit the system");
			System.out.println();
			
			// get user input
			// creates scanner
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter your option, eg.'1'");
			
			// eliminate situations with invalid input
			try {
				
				int userNum = sc.nextInt();
				
				//1--Login as a student
				if (userNum == 1) {
					
					// log in as students or quit
					System.out.println("Please enter your username, or typr 'q' to quit");			
					String studentInput = sc.next();
					
					if (studentInput.equals("q")) {
						// if quit, go back to the previous menu
						continue;
						}
					else {
						// get the user name and password in the file as a map
						Map<String, String> studentLoginInfo = new HashMap<String, String>();
						studentLoginInfo = FileInfoReader.LoginInfo("studentInfo.txt");
							
						// if the input user name exist in the map
							if(studentLoginInfo.containsKey(studentInput)) {							
								// if there's matching username in the file, ask for the password
								System.out.println("Please enter your password, or typr 'q' to quit");
								String pw = sc.next();
								// get the password stores in the file
								String systemPW = studentLoginInfo.get(studentInput);
								// if the input password is right, successfully log into the student account
								if(pw.equals(systemPW)) {
									
									// create student instance 
									Student student = null;
									
									// get the student in the student ArrayList
									for (int i = 0; i < Student.STUDENTS.size(); i++) {
										if (Student.STUDENTS.get(i).getUserName().equals(studentInput)) {
											// create the student instance
											student = Student.STUDENTS.get(i);
											
											// initiate enrolled courses arraylist
											student.addEnrolledCourse(student);
											break;		
										}										
									}
									
									boolean flag = true;
									
									while(flag) {
									
									// prints out information
									System.out.println("----------------------------");
									System.out.println("Welcome, " + student.getName());
									System.out.println("----------------------------");
									System.out.println("1--View all courses");
									System.out.println("2--Add courses to your list");
									System.out.println("3--View enrolled courses");
									System.out.println("4--Drop courses in your list");
									System.out.println("5--View grades");
									System.out.println("6--Return to previous menu");
									System.out.println();
									System.out.println("Please enter your option, eg.'1'");																		
									
									// get the user input
									int inputS = sc.nextInt();
									
									
									// view course information
									if (inputS == 1) {
										
								        // print all the information line by line
										Course.COURSELIST.forEach(System.out::println);
									}
									
									// Add courses to your list
									if (inputS == 2) {
										
										// ask for the student to input courses which needed to be added
										System.out.println("Please select the course ID you want to add to your list, eg. 'CIT590'. "
												+ "\\r\\nOr enter 'q' to return to the previous menu");
										String inputCourse = sc.next();
										
										
										if (studentInput.equals("q")) {
											// if quit, go back to the previous menu
											continue;
											}
								
										else {
											// create an instance
											Course courseToAdd = null;
											// call the add course method in the student class
											student.addCourse(inputCourse);
																						
											for (int c = 0; c < student.getEnrolledCourses().size(); c++) {
												if (inputCourse.equals(student.getEnrolledCourses().get(c))) {
											    // convert the string to course class
											    courseToAdd = student.getEnrolledCourses().get(c);
													}
											}
											// if the student is not in the arrayList
											if (!courseToAdd.addStudent.contains(student)) {
												courseToAdd.addStudent.add(student);
												// update the arrayList
												courseToAdd.setAddStudent(courseToAdd.addStudent);
											}
											continue;
											}
										}
									
									//3--View enrolled courses
									if(inputS == 3) {
										
										// call method from the student class
										student.viewEnrolledCourses();
										continue;
						
									}
									
									// 4--Drop courses in your list
									if(inputS == 4) {
										
										// ask for the student to input courses which needed to be dropped
										System.out.println("Please select the course ID you want to drop, eg. 'CIT590'. "
												+ "\\r\\nOr enter 'q' to return to the previous menu");
										String inputCourse = sc.next();
										
										if (studentInput.equals("q")) {
											// if quit, go back to the previous menu
											continue;
											}
										
										else {
											// call the add course method in the student class
											student.dropCourse(inputCourse);								
											continue;
											}		
									}


									// "5--View grades"
									if(inputS == 5) {
										System.out.println("Here are the courses you already taken, with your grade in letter format");
										student.viewGrade();
										continue;
										
									}
									
									// 6--Return to previous menu
									if(inputS == 6) {
										flag = false;
										continue;
										
									}
								
									}}
								else {
									// if the password in not correct, get back to the previous menu
									System.out.println("Password incorrect.");
									continue;	
								}
							
				
								}
							else {
								// if the student username is not in the file, get back to the previous menu
								System.out.println("User not found.");
								continue;		
							}
						}
				}
						
				
			
			
				//2--Login as a professor
				if (userNum == 2) {
				// log in as professor or quit
				System.out.println("Please enter your username, or typr 'q' to quit");			
				String profInput = sc.next();
				
				if (profInput.equals("q")) {
					// if quit, go back to the previous menu
					continue;
					}
				else {
					// get the user name and password in the file as a map
					Map<String, String> profLoginInfo = new HashMap<String, String>();
					profLoginInfo = FileInfoReader.LoginInfo("profInfo.txt");
						
					// if the input user name exist in the map
						if(profLoginInfo.containsKey(profInput)) {							
							// if there's matching username in the file, ask for the password
							System.out.println("Please enter your password, or typr 'q' to quit");
							String pw = sc.next();
							// get the password stores in the file
							String systemPW = profLoginInfo.get(profInput);
							// if the input password is right, successfully log into the professor account
							if(pw.equals(systemPW)) {
						
								// create professor instance 
								Professor professor = null;
								
								// get the professor in the professor ArrayList
								for (int i = 0; i < Professor.PROFESSORS.size(); i++) {
									if (Professor.PROFESSORS.get(i).getUserName().equals(profInput)) {
										// create the professor instance
										professor = Professor.PROFESSORS.get(i);
										break;
												
									}		
								}
									System.out.println("----------------------------");
									System.out.println("Welcome, " + professor.getName());
									System.out.println("----------------------------");
																	
									System.out.println("1--View given courses");
									System.out.println("2--View student list of the given course");
									System.out.println("3--Return to the previous menu");
									System.out.println();
									System.out.println("Please enter your option, eg.'1'");
									// get the professor input
									int inputP = sc.nextInt();
									
						if (inputP == 1) {
							//create an arrayList of given courses
							ArrayList<Course> courseList = new ArrayList<Course>();
							
							for (int j = 0; j < Course.COURSELIST.size(); j++) {
								  // get each professor
								  String prof = Course.COURSELIST.get(j).getLecturer();
								  // if professor name is in the courseList, get the course
								  if (professor.getName().equals(prof)) {
									  Course givenCourse = Course.COURSELIST.get(j);
									  courseList.add(givenCourse);
								  }
							
								  
								  }	
							// print the couseList
					  		System.out.println("-----------The course list---------------");
					  		for (int n = 0; n < courseList.size(); n++) {
						    System.out.println(courseList.get(n));
								  }
								

							}
						
						if (inputP == 2) {
							//create an arrayList of given courses
							ArrayList<Course> courseList = new ArrayList<Course>();
							
							
							for (int j = 0; j < Course.COURSELIST.size(); j++) {
								  // get each professor
								  String prof = Course.COURSELIST.get(j).getLecturer();
								  // if professor name is in the courseList, get the course
								  if (professor.getName().equals(prof)) {
									  Course givenCourse = Course.COURSELIST.get(j);
									  courseList.add(givenCourse);
								  }								  					
							}
							
							// print the couseList
							  System.out.println("-----------The course list---------------");
							  for (int n = 0; n < courseList.size(); n++) {
								  System.out.println(courseList.get(n));
							  }						
							//ask the professor to enter the input course name
							System.out.println();
							System.out.println("Please enter the course ID, eg. 'CIS519'.");
							System.out.println("Or type 'q' to quit.");
							//get the professor input
							profInput = sc.next();
							
							if (profInput.equals("q")) {
								// if quit, go back to the previous menu
								continue;
								}
							else {
							for (int n = 0; n < courseList.size(); n++) {
								// get the student list of the specific course
								if (profInput.equals(courseList.get(n).getId())){
		                         System.out.println("Students in your course " + profInput + " " + courseList.get(n).getName() + ":");	   
		                         // print the arrayList of Students
		                         for (int m = 0; m < courseList.get(n).getAddStudent().size(); m++) {
		                        	 System.out.println(courseList.get(n).getAddStudent().get(m));
		                         }
		                         
		                         
								}
								}
							}
							}	
								
								
							}
							
						}
							}			
						}
				
								
				//3--Login as an admin
				if(userNum == 3) {
				// log in as admin or quit
				System.out.println("Please enter your username, or typr 'q' to quit");			
				String adminInput = sc.next();
				
				if (adminInput.equals("q")) {
					// if quit, go back to the previous menu
					continue;
					}
				else {
					// get the user name and password in the file as a map
					Map<String, String> adminLoginInfo = new HashMap<String, String>();
					adminLoginInfo = FileInfoReader.LoginInfo("adminInfo.txt");
						
					// if the input user name exist in the map
						if(adminLoginInfo.containsKey(adminInput)) {							
							// if there's matching userName in the file, ask for the password
							System.out.println("Please enter your password, or typr 'q' to quit");
							String pw = sc.next();
							// get the password stores in the file
							String systemPW = adminLoginInfo.get(adminInput);
							// if the input password is right, successfully log into the admin account
							if(pw.equals(systemPW)) {
								
								// create admin instance 
								Admin admin = null;
								
								// get the admin in the admin ArrayList
								for (int i = 0; i < Admin.ADMINS.size(); i++) {
									if (Admin.ADMINS.get(i).getUserName().equals(adminInput)) {
										// create the admin instance
										admin = Admin.ADMINS.get(i);
										break;
												
									}			
																	
									}
								
								System.out.println("----------------------------");
								System.out.println("Welcome, " + admin.getName());
								System.out.println("----------------------------");
																
								System.out.println("1--View all courses");
								System.out.println("2--Add new courses");
								System.out.println("3--Delete courses");
								System.out.println("4--Add new professor");
								System.out.println("5--Delete professor");
								System.out.println("6--Add new student");
								System.out.println("7--Delete student");
								System.out.println("8--Return to the previous menu");
								System.out.println();
								System.out.println("Please enter your option, eg.'1'");	
								// get the admin input
								int inputA = sc.nextInt();	
								
								// View all courses
								if (inputA == 1) {
									
									// print all the information line by line
									Course.COURSELIST.forEach(System.out::println);
									
								}	
								
								// add new courses
								if (inputA == 2) {
								//If an admin wants to add a course that already exists in the system,
									
								//If the lecturer of the course we want to add does not exist in the system
								
							    //the program needs to check if the course has a time conflict with all of the lecturer¡¯s other courses.
								
							    // After adding a new course, we can see the newly added course CIT900 in the system.
									
									
									// create the local variable
									String id;
									String name;
									String startTime;
									String endTime;
									String date;
									String capacity;
									String lecturerId;
									String profName;
																
									String IdInput = sc.next();
									
									//get new course ID
									System.out.println("Please enter the course ID, or type 'q' to end.");
									if (IdInput.equals("q")) {
										// if quit, go back to the previous menu
										continue;
										}
									else {
									// get the course ID
									id = IdInput;																		
									}
									
									String NameInput = sc.next();
									// get new course name
									System.out.println("Please enter the course name, or type 'q' to end.");
									if (NameInput.equals("q")) {
										// if quit, go back to the previous menu
										continue;
										}
									else {
									// get the course name
									name = NameInput;																		
									}
									
													
									String StartInput = sc.next();
									//get new course start time
									System.out.println("Please enter the course start time, or type 'q' to end. eg. '19:00'");
									if (StartInput.equals("q")) {
										// if quit, go back to the previous menu
										continue;
										}
									else {
									// get the course startTime
									startTime = StartInput;																		
									}
									
									
									String EndInput = sc.next();
									//get new course end time
									System.out.println("Please enter the course end time, or type 'q' to end. eg. '20:00'");
									if (EndInput.equals("q")) {
										// if quit, go back to the previous menu
										continue;
										}
									else {
									// get the course endTime
									endTime = EndInput;																		
									}
									
												
									String DateInput = sc.next();
									//get new course date
									System.out.println("Please enter the course date, or type 'q' to end. 'MW'");
									if (DateInput.equals("q")) {
										// if quit, go back to the previous menu
										continue;
										}
									else {
									// get the course date
									date = DateInput;																		
									}
									
								
									String CapacityInput = sc.next();
									//get new course capacity
									System.out.println("Please enter the course capacity, or type 'q' to end. eg. '72'");
									if (CapacityInput.equals("q")) {
										// if quit, go back to the previous menu
										continue;
										}
									else {
									// get the course capacity
									capacity = CapacityInput;																		
									}
									
									
									
									String lectureIdInput = sc.next();
									//get new course lecturer's id
									System.out.println("Please enter the course lecturer's id, or type 'q' to end. eg. '001'");
									if (lectureIdInput.equals("q")) {
										// if quit, go back to the previous menu
										continue;
										}
									else {
									// get the course lecturer id
								    lecturerId = lectureIdInput;																		
									}
									
								// get the lecture name with the lecturerId
								for (int i = 0; i < Professor.PROFESSORS.size(); i++) {
									// get the i professor
									Professor p = Professor.PROFESSORS.get(i);
									if (p.getId().equals(lecturerId)) {
										//get the professor name
										profName = p.getName();
									}
										}	
								
								// create a new course with the given information	
								Course newCourse = new Course(id, name, profName, date, startTime, endTime, capacity);
								// print the course
								System.out.println(newCourse);
								System.out.println("------------------------------");																
								}
								
								
								
								if (inputA == 3) {
								
															
							}
						}
				}
				}
								
					
				
				
				
				
				
				// 4--Quit the system
				if (userNum == 4) {
					// break the while loop
					break;
				} 
						
				// if the input is integers but not 1, 2, 3, 4
				else {
					System.out.println("invalid input");
					continue;
				}
						
				// if the input is not integers
			}catch(Exception e) {
				// prints out the error input and ask for input again
				System.out.println("invalid input");
				continue;
			}
	}			
			
		System.out.println("-------System closed-------");
		System.out.println("----------------------------");
		}
				}
		
	

		