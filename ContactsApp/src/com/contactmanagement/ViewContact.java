package com.contactmanagement;


public class ViewContact {
	
	public void viewContact(ContactManager manager) {
		int index = 1;
		for(Contact c: manager.getContacts()) {
			System.out.println(index + " "
			+ c.getName() + " " + 
			c.getEmail() + " " +
			c.getPhone() + " " +
			c.getCategory()
			);
			
			index++;
			
		}
	}
}
