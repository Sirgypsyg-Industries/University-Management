//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Course.java
//  @ Date : 20.05.2024
//  @ Author : 
//
//

import java.util.ArrayList;
import java.util.Map;

public class Course {
	public String name;
	public ArrayList<String> materials;
	public ArrayList<Student> students;
	public Professor professor;
	public Map<String, Grade> grades;
	private String password;
	public Course(String name, Professor professor, String password) {
		this.password = password;
		this.name = name;
		this.professor = professor;
	}
}
