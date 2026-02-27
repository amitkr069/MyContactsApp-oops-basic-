package com.contactmanagement;

public class Person extends Contact{
	private String dateOfBirth;
	
	public Person(String name, String phone, String email, String dateOfBirth) {
		super(name, phone, email);
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	@Override
	public String getType() {
		return "Person";
	}
}
