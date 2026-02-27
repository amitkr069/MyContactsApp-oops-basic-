package com.contactmanagement;

public class Person extends Contact{
	private String dateOfBirth;
	private String category;
	
	public Person(String name, String phone, String email, String dateOfBirth, String category) {
		super(name, phone, email);
		
		if(!category.equalsIgnoreCase("Work") && !category.equalsIgnoreCase("Home")) {
			throw new IllegalArgumentException("Wrong Input");
		}
		this.dateOfBirth = dateOfBirth;
		this.category = category;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	@Override
	public String getCategory() {
		return category;
	}
	
	@Override
	public String getType() {
		return "Person";
	}
}
