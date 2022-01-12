package com.revature.stockYourself.beans;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String username;
	private String passwrd;
	private String email;
	private String phoneNumber;
	private Role role;
	private Portfolio portfolio;
	
	public User() {
		userId = 0;
		firstName = "First";
		lastName = "Last";
		username = "username";
		passwrd = "pass";
		email = "first@123.com";
		phoneNumber = "(123)456-7890";
		role = new Role();
		portfolio = new Portfolio();
	}
	
	

	
}
