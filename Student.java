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

import java.util.ArrayList;

public class Student extends User {
	public Student(String fullName, String password, int index) {
		super(fullName, password, index);
	}

	public ArrayList<Course> classes;
	public University university;

	public void registerOnCourse(String nameOfCourse, String nameOfDepartment, Professor professor, String password) {
		
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
			stringBuilder.append("No grades found for student ID: ").append(this.getIndex()).append("\n");
		}
		System.out.println(stringBuilder.toString());
	}
	
	public void viewMaterial(String course, String nameOfFile) {
		for (Course courseString: classes) {
			if (courseString.name.equals(course)) {
				for (String materialName: courseString.materials) {
					if (materialName.equals(nameOfFile)) {
						System.out.println(materialName.toString());
					} else {
						System.out.println("Name of this file cannot be found.");
					}
				}
			} else {
				System.out.println("Course not found.");
			}
		}
	}
}