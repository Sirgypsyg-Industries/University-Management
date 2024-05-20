//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : University.java
//  @ Date : 20.05.2024
//  @ Author : 
//
//

import java.util.ArrayList;

public class University {
	public ArrayList<Department> departments;
	public ArrayList<Student> students;
	public String name;
	public int index = 1111;
	public User reg(boolean isTeacher, String fullName, String password, Department department) {
		
		User user = null;
		if (isTeacher) {
			user = department.addTeacher(fullName, password, index++);
		}
		else {
			Student student = new Student(fullName, password, index++);
			students.add(student);
			user = student;
		}

		System.out.println("User " + fullName + " registered successfully. Your index is " + index);
		++index;
		return true;
	}

	
	
	public User logIn(boolean isTeacher, String password, String index, String departmentName) {
		
		return null;
	}
	
	public Student getStudent(String index, String password) {
		// for(Student student: students) {
		// 	if (student.getIndex().equals(index) && student.getPassword().equals(password)) {
		// 		return student;
		// 	}
		// }
		return null;
	}
	
	public University(String name) {
        this.name = name;
        departments = new ArrayList<Department>();
		students = new ArrayList<Student>();

		departments.add(new Department("Mathematics"));
        departments.add(new Department("Computer Science"));
        departments.add(new Department("Physics"));
		departments.add(new Department("Neurobiology"));
		departments.add(new Department("Cosmology"));
    }
}
