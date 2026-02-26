package com.usermanagement;

public class FreeUser extends User{
	public FreeUser(String email, String password, String name, String userName) {
		super(email, password, name, userName, "FREE");
	}
}
