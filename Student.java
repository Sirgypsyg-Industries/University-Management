//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Student.java
//  @ Date : 20.05.2024
//  @ Author : 
//
//

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Desktop;

public class Student extends User {
	public Student(String fullName, String password, String index) {
		super(fullName, password, index);
	}

	public ArrayList<Course> classes;
	public University university;


	public void registerOnCourse(Course course, String password) {
			/*if(classes.contains(course)){
				System.out.println("You are already registered on this course!");
			}*/
				if (!course.name.equals(course.name)) {
					// jeśli hasło sie zgadza to dodajemy kurs do listy
					if (course.getPassword().equals(password)) {
						classes.add(course);
						System.out.println("Student " + this.getFullName() + " registered on course " + course.name);
					} else {
						System.out.println("Wrong password for course " + course.name);
					}
				}
			
	}
	
	public void viewGrades() {
		StringBuilder stringBuilder = new StringBuilder();
		boolean studentFound = false;

		for (Course course : classes) {
			Grade grade = course.grades.get(this.getIndex());

			if (grade != null) {
				studentFound = true;
				stringBuilder.append("Course: ").append(course.name)
						.append(" - Grade: ").append(grade.name()).append("\n");
			}
		}

		if (!studentFound) {
			stringBuilder.append("No grade found for student ID: ").append(this.getIndex()).append("\n");
		}
		System.out.println(stringBuilder.toString());
	}
	
	public void viewMaterial(Course course, String nameOfFile) {
		if(classes.contains(course) == false){
			System.out.println("Student isn't registered on such course!");
		}
			if (course.materials.contains(nameOfFile) == false){
				System.out.println("There is no such file");
			}
			else {
				File file = new File(nameOfFile);

        
        		if (!Desktop.isDesktopSupported()) {
         	   		System.err.println("Desktop is not supported on this system.");
          	  		return;
      	    	}

       			Desktop desktop = Desktop.getDesktop();

        		try {
            		if (file.exists()) {
                		desktop.open(file);
            		} else {
               			System.err.println("File does not exist: " + nameOfFile);
            		}
        		} catch (IOException e) {
            		System.err.println("An error occurred while opening the file: " + e.getMessage());
        		}
			}
	}
}