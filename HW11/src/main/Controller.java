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
									Student student;
									
									// get the student in the student ArrayList
									for (int i = 0; i < Student.STUDENTS.size(); i++) {
										if (Student.STUDENTS.get(i).getUserName().equals(studentInput)) {
											// create the student instance
											student = Student.STUDENTS.get(i);
											break;		
										}										
									}
									
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
										
										List<String> coursesInfo = FileInfoReader.getAllCoursesInfo();
										
								        // print all the information line by line
										coursesInfo.forEach(System.out::println);
		
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
											// call the add course method in the student class
											student.addCourse(inputCourse);								
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
											student.addCourse(inputCourse);								
											continue;
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
								Professor professor;
								
								// get the professor in the professor ArrayList
								for (int i = 0; i < Professor.PROFESSORS.size(); i++) {
									if (Professor.PROFESSORS.get(i).getUserName().equals(profInput)) {
										// create the professor instance
										professor = Professor.PROFESSORS.get(i);
										break;
												
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
								Admin admin;
								
								// get the admin in the admin ArrayList
								for (int i = 0; i < Admin.ADMINS.size(); i++) {
									if (Admin.ADMINS.get(i).getUserName().equals(adminInput)) {
										// create the admin instance
										admin = Admin.ADMINS.get(i);
										break;
												
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
									}
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
		
	

		