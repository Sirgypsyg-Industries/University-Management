//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Department.java
//  @ Date : 21.05.2024
//  @ Author : 
//
//

import java.util.ArrayList;

public class Department {
	public ArrayList<Professor> professors;
	public String name;
	
	public Department(String name) {
		this.name = name;
		professors = new ArrayList<>();
	}
	
	public void addProfessor(String fullName, String password, int index) {
		professors.add(new Professor(fullName, password, index, this));
	}

	public Professor getProfessor(int index, String password){
		for(Professor professor: professors){
			if(professor.authenticate(index, password)){
				return professor;
			}
		}
		return null;
	}
}
