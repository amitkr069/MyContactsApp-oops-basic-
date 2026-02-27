package com.contactmanagement;

import com.usermanagement.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class BulkOperation {

    public void bulkDelete(ContactManager manager, User loggedInUser) {

        if (manager.getContacts().isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        Scanner sc = new Scanner(System.in);

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
}
