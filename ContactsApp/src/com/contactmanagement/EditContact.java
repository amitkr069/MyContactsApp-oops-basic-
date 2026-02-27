package com.contactmanagement;

public class EditContact {
	public void update(ContactManager manager, int index, String newName, String newPhone, String newEmail) {
		if(index < 0 || index >= manager.getContacts().size()) {
			System.out.println("Invalid input");
		}
		
		//old contact
		Contact oldContact = manager.getContacts().get(index);
		
		//copy constructor
		Contact newContact = new Contact(oldContact);
		
		// modifyin the copy
		newContact.setName(newName);
		newContact.setPhone(newPhone);
		newContact.setEmail(newEmail);
		
		manager.getContacts().set(index, newContact);
		
		System.out.println("contact updated");
	}
}
