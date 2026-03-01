package com.contactmanagement;

import com.usermanagement.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class BulkOperation {
	Scanner sc = new Scanner(System.in);
    public void bulkDelete(ContactManager manager, User loggedInUser) {

        if (manager.getContacts().isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        

        // Show contacts first
        new ViewContact().viewContact(manager);

        System.out.print("Enter contact numbers to delete (comma separated): ");
        String input = sc.nextLine();

        System.out.print("Enter your password to confirm deletion: ");
        String password = sc.nextLine();

        // Password verification
        if (!loggedInUser.checkPassword(password)) {
            System.out.println("Incorrect password.");
            return;
        }

        try {

            String[] numbers = input.split(",");
            ArrayList<Integer> indexes = new ArrayList<>();

            for (String num : numbers) {
                int index = Integer.parseInt(num.trim()) - 1;

                if (index >= 0 && index < manager.getContacts().size()) {
                    indexes.add(index);
                } else {
                    System.out.println("Invalid contact number: " + (index + 1));
                }
            }

            // Sort in descending order
            Collections.sort(indexes, Collections.reverseOrder());

            for (int index : indexes) {
                manager.getContacts().remove(index);
            }

            System.out.println("Contacts deleted successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }
    
    public void assignBulk(ContactManager manager, TagManager tagManager) {

        if (manager.getContacts().isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        if (tagManager.getAllTags().isEmpty()) {
            System.out.println("No tags created.");
            return;
        }

        //Scanner sc = new Scanner(System.in);

        new ViewContact().viewContact(manager);

        System.out.print("Enter contact numbers (comma separated): ");
        String input = sc.nextLine();

        tagManager.viewTags();

        System.out.print("Enter tag name to assign: ");
        String tagName = sc.nextLine();

        Tag tag = new Tag(tagName);

        if (!tagManager.getAllTags().contains(tag)) {
            System.out.println("Tag does not exist.");
            return;
        }

        try {
            String[] numbers = input.split(",");

            for (String num : numbers) {

                int index = Integer.parseInt(num.trim()) - 1;

                if (index >= 0 && index < manager.getContacts().size()) {

                    manager.getContacts().get(index).addTag(tag);
                }
            }

            System.out.println("Tag assigned to selected contacts!");

        } catch (Exception e) {
            System.out.println("Invalid input format.");
        }
    }
}
