package com.usermanagement;

import java.util.regex.Pattern;

public class Validation {
	public static boolean isValidEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		return Pattern.matches(regex, email);
	}
	
	public static boolean isValidPassword(String password) {
		return password != null && password.length() >= 6;
	}
}
