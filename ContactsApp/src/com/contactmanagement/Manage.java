package com.contactmanagement;

import com.searchfilter.SearchManager;
import java.util.Scanner;
import com.usermanagement.*;
import com.searchfilter.*;
public class Manage {
	private static ContactManager contactManager = new ContactManager();
	private static TagManager tagManager = new TagManager();
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
        BulkOperation bulk = new BulkOperation();
        while (true) {

            System.out.println("\n--- Contact Management ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Bulk Delete Contact");
            System.out.println("6. Bulk Assign Tag");
            System.out.println("7. Search Contacts");
            System.out.println("8. Filter Contacts");
            System.out.println("9. Create Tag");
            System.out.println("10. View All Tags");
            System.out.println("11. Assign Tags to Contacts");
            System.out.println("12. Remove Tag from Contacts");
            System.out.println("13. Back");

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
                    	
                    	bulk.bulkDelete(contactManager, loggedInUser);
                    	break;
                    case 6:
                    	if(contactManager.getContacts().size() == 0) {
                    		System.out.println("No contacts to assign tag");
                    		break;
                    	}
                    	
                    	bulk.assignBulk(contactManager, tagManager);
                    	break;
                    case 7:
                    	SearchManager searchManager = new SearchManager();
                    	searchManager.search(contactManager);
                    	break;
                    case 8:
                    	FilterManager filterManager = new FilterManager();
                    	filterManager.applyFilter(contactManager);
                    	break;
                    case 9:
                    	tagManager.createTag();
                        break;
                    case 10:
                    	tagManager.viewTags();
                        break;
                    case 11:
                    	AddTags addtag = new AddTags();
                        addtag.assign(contactManager, tagManager);
                        break;
                    case 12:
                    	RemoveTag removetag = new RemoveTag();
                    	removetag.remove(contactManager, tagManager);
                    	break;
                    case 13:
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
