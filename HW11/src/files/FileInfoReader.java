package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import courses.Course;
import roles.Student;

/**
 * to load the files
 * @author Xinyang Shen
 */
public class FileInfoReader {
	
	/**
	 * get the login information(username and password) from a file
	 * @param fileName to read
	 * @return a hashmap has keys as username and values as password
	 */
	public static Map<String, String> LoginInfo(String fileName) {
		
		// create a hashmap to store the username and passwords of students
		Map<String, String> LoginInfo = new HashMap<String, String>();
		
		// create file
		File file = new File(fileName);
		
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			// variable to store each lines
			String line;
			
			// while there is a line to read
			while((line = bufferedReader.readLine()) != null) {
				
		    // string array for each line to store the information
			// 2: username; 3: password, which is correct for all these files
			String[] userInfo = line.split("; ");
			// get the user name
			String userName = userInfo[2];
			// get the password
			String userPassword = userInfo[3];
			// put the user name and password into the map
			LoginInfo.put(userName, userPassword);
			}
			
			} catch (FileNotFoundException e) {
			// print out the name of the file
			System.out.println("File not found " + file.getName());
			} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close the filereader and the bufferedreader
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	return LoginInfo;
	}
	
	/**
	 * get the real name of the user by reading through the file
	 * @param fileName
	 * @return
	 */
	public static String getName(String fileName, String userName){
		// create string to store the real name
		String name = null;
		// create file
		File file = new File(fileName);
				
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			// variable to store each lines
			String line;
			
			// while there is a line to read
			while((line = bufferedReader.readLine()) != null) {
				
		    // string array for each line to store the information
			String[] userInfo = line.split("; ");
			
			// compare the username to the file
			if(userName.equals(userInfo[2])) {
				//1: name, except for professor file, which will reverse the order in the Professor class
				name = userInfo[1];
				break;
				}
			} 
		}catch (FileNotFoundException e) {
			// print out the name of the file
			System.out.println("File not found " + file.getName());
			} 
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close the filereader and the bufferedreader
			try {
				fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		return name;
		
	}
	
	
	/**
	 * get the user id by reading through the file
	 * @param fileName
	 * @return
	 */
	public static String getID(String fileName, String userName) {
		// create string to store name
		String id = null;
		// create file
		File file = new File(fileName);
						
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
					
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
					
			// variable to store each lines
			String line;
					
			// while there is a line to read
			while((line = bufferedReader.readLine()) != null) {
						
		    // string array for each line to store the information
			String[] userInfo = line.split("; ");
			
			// get the right user by the given username
			if(userName.equals(userInfo[2])) {
				// 0: ID, except for professor file, which will reverse the order in the Professor class
				id = userInfo[0];
				break;
				}
			} 
			}catch (FileNotFoundException e) {
					// print out the name of the file
					System.out.println("File not found " + file.getName());
					} 
				catch (IOException e) {
					e.printStackTrace();
				} finally {
					// close the filereader and the bufferedreader
					try {
						fileReader.close();
						bufferedReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					} 
				}
				
				return id;
	}
	
	
	/**
	 * get the course information a student had taken 
	 * @param fileName need to read
	 * @return a map for the courses students have taken. Keys as course ID; value as course grade.
	 */
	public static Map<String, String> getCourses(String userName){
		// create a hashmap to store the course name and its grade
		Map<String, String> courseMap = new HashMap<String, String>();
		
		// creates file
		File file = new File("studentInfo.txt");
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		try {
					
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
					
			// variable to store each lines
			String line;
					
			// while there is a line to read
			while((line = bufferedReader.readLine()) != null) {
						
		    // string array for each line to store the information
			String[] studentInfo = line.split("; ");
			
			// get the student with the username
			if(userName.equals(studentInfo[2])) {
				//get the course information from the student
				String courseInfo = studentInfo[4];
				String[] courses = courseInfo.split(", ");
				// iterate over each course
				for(int i = 0; i < courses.length; i++) {
					String[] eachCourse = courses[i].split(": ");
					// put the information into the map
					// keys as the course id, value as the grade
					courseMap.put(eachCourse[0], eachCourse[1]);
				}	
			}
			} 
			}catch (FileNotFoundException e) {
					// print out the name of the file
					System.out.println("File not found " + file.getName());
					} 
				catch (IOException e) {
					e.printStackTrace();
				} finally {
					// close the filereader and the bufferedreader
					try {
						fileReader.close();
						bufferedReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					} 
				}
		
		
		
		return courseMap;
	}
	
	/**
	 * used to view all courses
	 * @param fileName
	 * @return all the information of the courses in the given format
	 */
	
	public static ArrayList<String> getAllCoursesInfo(String fileName){
		
		// create file
		File file = new File(fileName);
		
		// initialize FR and BR
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		//create the ArrayList
		ArrayList<String> allCoursesInfo = new ArrayList<String>();
		
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			// variable to store each lines
			String line;
					
			// while there is a line to read
			while((line = bufferedReader.readLine()) != null) {
				
				// iterate over each course
				for(int i = 0; i < Course.COURSELIST.size(); i++) {
					
				
				//update the line with the right format
				String newLine = new String();	
				
				// count the number of enrolled students
				int enrolled = 0;
				
				// get the instance of course(i)
				Course c = Course.COURSELIST.get(i);
				
				// update the new line
				newLine = c.getId()  + "|" + c.getName() + ", " + c.getStartTime() + "-" + c.getEndTime() + " on " + c.getDays() + ", " + "with course capacity: " + c.getCapacity() + ", students: " + enrolled + ", lecturer: Professior " + c.getLecturer(); 
				
				// add all the lines to the ArrayList
				allCoursesInfo.add(newLine); 
				
				
				}
				}
			
		} catch (FileNotFoundException e) {
		  System.out.println("No File Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		
		
		return allCoursesInfo;
		
	}
	
	/**
	 * load the file content to the ArrayList of course
	 * @param fileName
	 */
	
     public static void setCourseInfo(String fileName){
		
		// create file
		File file = new File(fileName);
		
		// initialize FR and BR
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		
		//create the ArrayList
		ArrayList<String> allCoursesInfo = new ArrayList<String>();
		
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			// variable to store each lines
			String line;
					
			// while there is a line to read
			while((line = bufferedReader.readLine()) != null) {
				
				//update the line with the right format
				String newLine = new String();
				
				// string array for each line to store the information
				String[] courseInfo = line.split("; ");
				
				// create the course with given information from file
				Course c = new Course(courseInfo[0], courseInfo[1], courseInfo[2], courseInfo[3], courseInfo[4], courseInfo[5], courseInfo[6]);
			
				// add each course to the ArrayList
				Course.COURSELIST.add(c); 
				}
			
		} catch (FileNotFoundException e) {
		  System.out.println("No File Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		
}
     
     /**
 	 * load the file content to the ArrayList of students
 	 * @param fileName
 	 */
 	
      public static void setStudentInfo(String fileName){
 		
 		// create file
 		File file = new File(fileName);
 		
 		// initialize FR and BR
 		FileReader fileReader = null;
 		BufferedReader bufferedReader = null;
 	
 		try {
 			fileReader = new FileReader(file);
 			bufferedReader = new BufferedReader(fileReader);
 			
 			// variable to store each lines
 			String line;
 			
 			// variable to be as map
 			Map<String, String> map = null;
 					
 			// while there is a line to read
 			while((line = bufferedReader.readLine()) != null) {
 			 	
 			    // string array for each line to store the information
				String[] studentInfo = line.split("; ");
				
				// change the string to map
				//get the course information from the student
				String courseInfo = studentInfo[4];
				String[] courses = courseInfo.split(", ");
				// iterate over each course
				for(int i = 0; i < courses.length; i++) {
					String[] eachCourse = courses[i].split(": ");
					// put the information into the map
					// keys as the course id, value as the grade
					map.put(eachCourse[0], eachCourse[1]);
				}
				
 				// create the student with given information from file
 				Student s = new Student(studentInfo[0], studentInfo[1], studentInfo[2], studentInfo[3], map);
 			
 				// add each student to the ArrayList
 				Student.STUDENTS.add(s); 
 				}
 			
  		} catch (FileNotFoundException e) {
 		  System.out.println("No File Found");
 			e.printStackTrace();
 		} catch (IOException e) {
 			System.out.println("IOException");
 			e.printStackTrace();
 		}

}
      
}
	
	
	

