package com.contactmanagement;
import java.util.Scanner;

import com.usermanagement.User;
public class DeleteContact {
	public void delete(ContactManager manager, int index, User loggedIn) {
		if(index < 0 || index > manager.getContacts().size()) {
			System.out.print("Invalid input");
			return;
		}
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter Password to delete");
		String pass = sc.nextLine();
		
		// first validating the user with the password
		if(!loggedIn.checkPassword(pass)){
			System.out.print("Invalid Password");
			return;
		}
		
		//removing the contact from the list
		manager.getContacts().remove(index);
		System.out.println("Contact deleted");
	
	}
}
