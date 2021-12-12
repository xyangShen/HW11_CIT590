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
										
										// add the enrolledCourses list specific for this student
										student.addEnrolledCourse();
				
										break;		
									}										
								}
								
								
								// use a boolean value to keep the login status of the user
								boolean isQuit = false;
								
								while(isQuit == false) {
									
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
												+ "Or enter 'q' to return to the previous menu");

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
												+ "Or enter 'q' to return to the previous menu");
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
										// change the isQuit value
										isQuit = true;
									}
							
								}
								}
							
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
												
										// print the couseList
								  		System.out.println("-----------The course list---------------");
								  		for (int n = 0; n < professor.getCourseList().size(); n++) {
									    System.out.println(professor.getCourseList().get(n));
											  }
											

										}
									
									if (inputP == 2) {
  
										// print the couseList
								  		System.out.println("-----------The course list---------------");
								  		for (int n = 0; n < professor.getCourseList().size(); n++) {
									    System.out.println(professor.getCourseList().get(n));
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
										for (int n = 0; n < professor.getCourseList().size(); n++) {
											// get the student list of the specific course
											if (profInput.equals(professor.getCourseList().get(n).getId())){
					                         System.out.println("Students in your course " + profInput + " " + professor.getCourseList().get(n).getName() + ":");	   
					                         // print the arrayList of Students
					                         for (int m = 0; m < professor.getCourseList().get(n).getAddStudent().size(); m++) {
					                        	 System.out.println(professor.getCourseList().get(n).getAddStudent().get(m));
					                         }				           
											}
											}
										}
										}									
									
								}
									
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
						
								// create the local variable
								String id = null;
								String name = null;
								String startTime;
								String endTime;
								String date;
								String capacity;
								String lecturerId = null;
								String profName = null;
								Professor p = null;			
								String idInput;
								
								//check whether the new course is already in the system
								boolean flag = false;
								
								while (!flag) {
									idInput = sc.next();
									//get new course ID
									System.out.println("Please enter the course ID, or type 'q' to end.");
								
								if (idInput == "q")	{
									break;
								}else {
					
								for (int b = 0; b < Course.COURSELIST.size(); b++) {
									if (Course.COURSELIST.get(b).getId().equals(idInput)) {
										break;
									}
								}
								   // the course doesn't exist in the system and leave the loop
								    id = idInput;
								    flag = true;
								
								}		
								}
													
								
								String nameInput = sc.next();
								// get new course name
								System.out.println("Please enter the course name, or type 'q' to end.");
								
								if (nameInput.equals("q")) {
									// if quit, go back to the previous menu
									continue;
									}
																
								else {
								// get the course name
								name = nameInput;																		
								}
								
												
								String startInput = sc.next();
								//get new course start time
								System.out.println("Please enter the course start time, or type 'q' to end. eg. '19:00'");
								if (startInput.equals("q")) {
									// if quit, go back to the previous menu
									continue;
									}
								else {
								// get the course startTime
								startTime = startInput;																		
								}
								
								
								String endInput = sc.next();
								//get new course end time
								System.out.println("Please enter the course end time, or type 'q' to end. eg. '20:00'");
								if (endInput.equals("q")) {
									// if quit, go back to the previous menu
									continue;
									}
								else {
								// get the course endTime
								endTime = endInput;																		
								}
								
											
								String dateInput = sc.next();
								//get new course date
								System.out.println("Please enter the course date, or type 'q' to end. 'MW'");
								if (dateInput.equals("q")) {
									// if quit, go back to the previous menu
									continue;
									}
								else {
								// get the course date
								date = dateInput;																		
								}
								
							
								String capacityInput = sc.next();
								//get new course capacity
								System.out.println("Please enter the course capacity, or type 'q' to end. eg. '72'");
								if (capacityInput.equals("q")) {
									// if quit, go back to the previous menu
									continue;
									}
								else {
								// get the course capacity
								capacity = capacityInput;																		
								}
								
									
								String lectureIdInput = sc.next();
								//get new course lecturer's id
								System.out.println("Please enter the course lecturer's id, or type 'q' to end. eg. '001'");
								if (lectureIdInput.equals("q")) {
									// if quit, go back to the previous menu
									continue;
									}
								
								//If the lecturer of the course we want to add does not exist in the system
								//we add the new lecturer to the arrayList
								else if (!admin.checkProfessorId(lecturerId)) {
									System.out.println("The professor isn't in the system, please add this professor first");
									//get the professor id
									System.out.println("Please enter the professor's ID, or type 'q' to quit");
									String input = sc.next();
									String pId = input;
									
									//get the professor name
									System.out.println("Please enter professor's name, or type 'q' to quit");
									input = sc.next();
									String pName = input;
									
									//get the professor userName
									System.out.println("Please enter a userName");
									input = sc.next();
									String pUserName = input;
									
									//get the professor password
									System.out.println("Please enter a password");
									input = sc.next();
									String pPassword = input;
									
									//create a professor and put him into the arrayList
									Professor newP = new Professor(pName, pId, pUserName, pPassword);
									Professor.PROFESSORS.add(newP);
									System.out.println("Successfully added the new professor: ");
									System.out.print(newP.getId() + newP.getName());
									// get the course lecturer id
								    lecturerId = lectureIdInput;	
									
								}
								
								else {
								// get the course lecturer id
							    lecturerId = lectureIdInput;																		
								}
										
								
							// get the lecture name with the lecturerId
							for (int i = 0; i < Professor.PROFESSORS.size(); i++) {
								// get the i professor
								p = Professor.PROFESSORS.get(i);
								if (p.getId().equals(lecturerId)) {
									//get the professor name
									profName = p.getName();
									break;
									}
								}	
							
							// create a new course with the given information	
							Course newCourse = new Course(id, name, profName, date, startTime, endTime, capacity);
							
							//the program needs to check if the course has a time conflict with all of the lecturer��s other courses.
							// check if there's a time conflict with other course					
							if (newCourse.noTimeConflict(p, newCourse, p.getCourseList()) == false) {
								System.out.println("The course you selected has time conflict with other courses: ");
								
								// iterate over time conflict courses and print the conflict course(s)
								for(int a = 0; a < newCourse.getConflictCourses().size(); a++) {
									System.out.print(newCourse.getConflictCourses().get(a));
									// print the unable-new course
									System.out.println("Unable to add new course: ");
									System.out.print(newCourse);
								}			
							}else {	
								// After adding a new course, we can see the newly added course in the system.
								Course.COURSELIST.add(newCourse);
								// print the course
								System.out.println("Successfully added the course: ");
								System.out.print(newCourse);
								System.out.println("------------------------------");	
								
							}	
																			
							}
							
							

							//delete
							if (inputA == 3) {
								
								
							}
							
							
																
						}
							// 4--Add new professor
							if(inputA == 4) {
								
								// string to store the id of the professor
								String professorID;
								
								// use a boolean value to track is the id is invalid
								boolean isIDValid = false;
								
							
								while(isIDValid == false) {
									
									// get the next token as the id of the professor
									System.out.println("Please enter the professor's ID, or type 'q' to quit");
									
									String proID = sc.next();
									
									if(proID.equals("q")) {
										continue;
									}
									else {
										
										// check if the id is in the system
										if(Professor.isIDOccupied(proID) == false) {
											
											// if the id is valid, set the professorID to proID
											professorID = proID;
											
											// change the boolean value and break the loop
											isIDValid = true;
										}						
										}
								}
								
								
								
								// get the next token as the professor's name
								System.out.println("Please enter the professor's ID, or type 'q' to quit");		
								String professorName = sc.next();
								
								if(professorName.equals("q")) {
									continue;	
								}
								
								
								
								// String to store the username for this professor
								String professorUsername;
								
								// boolean value to track if the user name is valid
								boolean isUsernameValid = false;
								
								while(isUsernameValid == false) {
									
									System.out.println("Please enter a username, or type 'q' to quit");
									String proUN = sc.next();
									
									if(proUN.equals("q")) {
										continue;
									}
									else {
										
										// check is the username is in the system
										if(Professor.isUserNameOccupied(proUN)== false) {
											
											// if the user name is valid
											professorUsername = proUN;
											
											isUsernameValid = true;
										}
										
										}
								}
									
									// get the next token as the professor's password
									System.out.println("Please enter a password, or type 'q' to quit");		
									String professorPW = sc.next();
									
									if(professorPW.equals("q")) {
										continue;	
									}
									
									// create the new professor
									Professor addProfessor = new Professor(professorName, professorID, professorUsername, professorPW);
									
									// add this professor into the professor list
									Admin.addProfessor(addProfessor);
									
		
								}
					
							
							//5--delete professor
							if(inputA == 5) {
								
								// use a boolean value to see if the professor is in the list
								boolean isProInList = false;
								
								while(isProInList == false) {
									
									System.out.println("Please enter the professor ID to delete, or type 'q' to quit");
									String proID = sc.next();
									
									if(proID.equals("q")) {
										continue;
									}
									else {
										
										// if the professor is in the list
										if(Professor.isIDOccupied(proID) == true) {
											
											// delete this professor
											Admin.delProfessor(proID);	
										}
									}
								
							     }
								
							}
							
							
							
							//6--add new student
							if(inputA == 6) {
								
								// string to store the id of the student
								String studentID;
								
								// use a boolean value to track is the id is invalid
								boolean isIDValid = false;
								
							
								while(isIDValid == false) {
									
									// get the next token as the id of the professor
									System.out.println("Please enter the student's ID, or type 'q' to quit");
									
									String stuID = sc.next();
									
									if(stuID.equals("q")) {
										continue;
									}
									else {
										
										// check if the id is in the system
										if(Student.isIDOccupied(stuID) == false) {
											
											// if the id is valid, set the professorID to proID
											studentID = stuID;
											
											// change the boolean value and break the loop
											isIDValid = true;
										}						
										}
								}
								
								
								
								// get the next token as the student's name
								System.out.println("Please enter the student's ID, or type 'q' to quit");		
								String studentName = sc.next();
								
								if(studentName.equals("q")) {
									continue;	
								}
								
								
								
								// String to store the username for this student
								String studentUsername;
								
								// boolean value to track if the user name is valid
								boolean isUsernameValid = false;
								
								while(isUsernameValid == false) {
									
									System.out.println("Please enter a username, or type 'q' to quit");
									String stuUN = sc.next();
									
									if(stuUN.equals("q")) {
										continue;
									}
									else {
										
										// check is the username is in the system
										if(Student.isUserNameOccupied(stuUN)== false) {
											
											// if the user name is valid
											studentUsername = stuUN;
											
											isUsernameValid = true;
										}
										
										}
								}
									
									// get the next token as the student's password
									System.out.println("Please enter a password, or type 'q' to quit");		
									String studentPW = sc.next();
									
									if(studentPW.equals("q")) {
										continue;	
									}
									
									// get the information about the student's enrolled courses
									Map<String, String> addCourseList = new HashMap<String, String>();
									
									// use boolean value to check is all courses are added
									boolean isAddCourseOver = false;
									
									while(isAddCourseOver == false) {
										
										System.out.println("Please enter ID of a course which this student already took, one in a time");
										System.out.println("Type 'q' to quit, type 'n' to stop adding");
										
										String courseID = sc.next();
										
										// check if the course is in the list
										
										if(courseID.equals("q")) {
											continue;
										}else {
											
											// check if the course is in list
											if(Course.isCourseInList(courseID) == true) {
												// if the course is valid
									            System.out.println("Please enter the grade, eg 'A'");
									            String courseGrade = sc.next();
									
									            // put the course and the grade in the map
									            addCourseList.put(courseID, courseGrade);
											
											
										      }
											else {
												break;
										}
											
											
										}	
									}
									
									// create the new student
									Student addStudent = new Student(studentID, studentName, studentUsername, studentPW, addCourseList);
									
									Admin.addStudent(addStudent);
																			
									}
									
									
							
							//7--delete student
							if(inputA == 7) {
								
								// use a boolean value to see if the student is in the list
								boolean isStuInList = false;
								
								while(isStuInList == false) {
									
									System.out.println("Please enter the student ID to delete, or type 'q' to quit");
									String stuID = sc.next();
									
									if(stuID.equals("q")) {
										continue;
									}
									else {
										
										// if the student is in the list
										if(Student.isIDOccupied(stuID) == true) {
											
											// delete this professor
											Admin.delStudent(stuID);	
										}
									}
								
							     }
								
								
								
							}
							
							//8--return to the previous menu
							if(inputA == 8) {
								
								continue;
							}
	
			}
							
				
			}
			
			// 4--Quit the system
			if (userNum == 4) {
				
				// break the while loop
				break;	
				
			}
					
			
		}
			
		
	System.out.println("-------System closed-------");
	System.out.println("----------------------------");
	}
			}
	


	