//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : User.java
//  @ Date : 20.05.2024
//  @ Author : 
//
//




public abstract class User {
	private String fullName;
	private String password;
	private String index;
	public boolean authenticate(String password, String index) {
		return false;
	}
	public User(String fullName, String password, String index){
		this.fullName = fullName;
		this.password = password;
		this.index = index;
	}
}
