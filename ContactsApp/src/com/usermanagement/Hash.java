package com.usermanagement;


// in this class the password is hashed and storing the hashed password
import java.security.MessageDigest;
public class Hash {
	public static String hashPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); //encrypting using the SHA-256 algorithm
			byte[] bytes = md.digest(password.getBytes()); // getting the encrypted password and storing it in bytes.
			
			StringBuilder sb = new StringBuilder();
			
			for(byte b: bytes) {
				sb.append(String.format("%02x", b)); // making the bytes in hexadecimal format and storing it in sb
			}
			
			return sb.toString(); // StringBuilder to String
		}
		
		catch(Exception e) {
			throw new RuntimeException("Error while hashing");
		}
	}
}
