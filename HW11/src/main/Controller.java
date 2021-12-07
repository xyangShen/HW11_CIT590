package main;

import java.util.Scanner;

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
					try{
						String studentInput = sc.next();	
						if (studentInput.equals("q")) {
							// if quit, go back to the previous menu
							continue;
						}
						//log in to the student account
						
						
						// view course information
						
						
						// add or drop courses
						
						// view grades
						
						// return to the previous menu
						
						
					}catch(Exception e) {
						// prints out the error input and ask for input again
						System.out.println("invalid input");
						continue;
						
					}
			
					continue;
					
				}
				
				
				//2--Login as a professor
				if (userNum == 2) {
					System.out.println("2");
					continue;
					
				}
				
				//3--Login as an admin
				if(userNum == 3) {
					System.out.println("3");
					continue;
					
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
