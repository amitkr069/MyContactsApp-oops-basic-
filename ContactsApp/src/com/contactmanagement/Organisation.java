package com.contactmanagement;

public class Organisation extends Contact{
	private String CompanyName;
	public Organisation(String name, String phone, String email, String ConmapyName) {
		super(name, phone, email);
		this.CompanyName = CompanyName;
	}
	
	public String getCompanyName() {
		return CompanyName;
	}
	
	@Override
	public String getType() {
		return "Organisation";
	}
}
