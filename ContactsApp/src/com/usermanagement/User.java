package com.usermanagement;

import java.util.UUID;

public  class User {
	private String id;
	private String email;
	private String password;
	private String name;
	private String userName;
	private String userType;
	// taking all required inputs
	
	public User(String email, String password, String name, String userName, String userType) {
		// making constructor and passing the paramenters
		if(!Validation.isValidEmail(email)) {
			throw new IllegalArgumentException("Ivalid Email format");
		}
		
		if(!Validation.isValidPassword(password)) {
			throw new IllegalArgumentException("password must be at least 6 characters long");
		}
		
		// validated email and password
		
		this.id = UUID.randomUUID().toString();
		this.email = email;
		this.password = Hash.hashPassword(password);
		this.name = name;
		this.userName = userName;
		this.userType = userType;
	}
	
	public String getEmail() {return email;}
	public String getName() {return name;}
	public String getUserType() {return userType;}
	public String getUsername() {return userName;}
	
	// calling the getter methods
	
	
	public void setName(String name) {
		this.name = name; // setting new name
	}
	
	public void setEmail(String email) {
		this.email = email; // setting new mail
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkPassword(String inputPassword) {
		return this.password.equals(Hash.hashPassword(inputPassword));
		
		// checking the password by encrypting it first then comparing it with the correct password
	}
}
