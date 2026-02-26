package com.usermanagement;

public class PremiumUser extends User{
	public PremiumUser(String email, String password, String name, String userName) {
		super(email, password, name, userName, "PREMIUM");
	}
}
