package com.usermanagement;

import java.util.regex.Pattern;

// used regex to validate email id.
public class Validation {
	public static boolean isValidEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; // defining the regex pattern
		return Pattern.matches(regex, email);
	}
	
	public static boolean isValidPassword(String password) {
		return password != null && password.length() >= 6;
	}
}
