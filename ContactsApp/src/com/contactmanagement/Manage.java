package com.contactmanagement;

import com.searchfilter.SearchManager;
import java.util.Scanner;
import com.usermanagement.*;
import com.searchfilter.*;
public class Manage {
	private static ContactManager contactManager = new ContactManager();
    public static void contactManagement(User loggedInUser) {

//        if (loggedInUser == null) {// first checking if logged in or not
//            System.out.println("Please login first!");
//            return;
//        }

        Scanner sc = new Scanner(System.in);

        AddContact addContact = new AddContact(); // created Add contact object
        ViewContact viewcontact = new ViewContact(); // created view contact object
        EditContact edit = new EditContact(); // created edit contact object;
        DeleteContact delete = new DeleteContact();
        while (true) {

            System.out.println("\n--- Contact Management ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Bulk Delete Contact");
            System.out.println("6. Search Contacts");
            System.out.println("7. Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        addContact.add(contactManager);
                        // updated the add Contact feature (added Person and Organisation child class);
                        break;

                    case 2: 
                    	if(contactManager.getContacts().size() == 0) {
                    		System.out.println("No contacts to view");
                    		break;
                    		
                    	}
                    	viewcontact.viewContact(contactManager);
                		break;
                    case 3:
                    	if(contactManager.getContacts().size() == 0) {
                    		System.out.println("No contacts to edit");
                    		break;
                    	}
                    	viewcontact.viewContact(contactManager);
                    	System.out.println("Enter the index number to update");
                    	int index = sc.nextInt() - 1;
                    	sc.nextLine();
                    	
                    	System.out.print("New Name");
                    	String newName = sc.nextLine();
                    	
                    	System.out.print("New number");
                    	String newNum = sc.nextLine();
                    	
                    	System.out.print("New mail");
                    	String newMail = sc.nextLine();
                    	
                    	edit.update(contactManager, index, newName, newNum, newMail);
                    	break;
                    case 4:
                    	if(contactManager.getContacts().size() == 0) {
                    		System.out.println("No contacts to delete");

                    		break;
                    	}
                    	viewcontact.viewContact(contactManager);
                    	System.out.println("Enter the index number to delete");
                    	index = sc.nextInt() - 1;
                    	sc.nextLine();
                    	delete.delete(contactManager, index, loggedInUser);
                    	break;
                    case 5:
                    	if(contactManager.getContacts().size() == 0) {
                    		System.out.println("No contacts to delete");
                    		break;
                    	}
                    	
                    	BulkOperation bulk = new BulkOperation();
                    	bulk.bulkDelete(contactManager, loggedInUser);
                    case 6:
                    	SearchManager searchManager = new SearchManager();
                    	searchManager.search(contactManager);
                    case 7:
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
