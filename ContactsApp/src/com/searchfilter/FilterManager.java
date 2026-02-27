package com.searchfilter;

import java.util.List;
import java.util.Scanner;

import com.contactmanagement.*;


// for use case 10
public class FilterManager {
	public void applyFilter(ContactManager manager) {

        if (manager.getContacts().isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("\nFilter By:");
        System.out.println("1. Tag (Person, Organization, Work, Home)");
        System.out.println("2. Date Added (yyyy-mm-dd)");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter filter value: ");
        String value = sc.nextLine();

        FilterStrategy strategy = null;

        switch (choice) {
            case 1:
                strategy = new FilterTag();
                break;
            case 2:
                strategy = new FilterDate();
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        List<Contact> results = strategy.filter(manager.getContacts(), value);

        if (results.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nFiltered Results:");

            for (Contact c : results) {

                System.out.print("[" + c.getType() + "] "
                        + c.getName() + " | "
                        + c.getPhone() + " | "
                        + c.getEmail()
                        + " | Added: " + c.getDateAdded());

                if (c instanceof Person) {
                    Person p = (Person) c;
                    System.out.print(" | " + p.getCategory());
                }

                System.out.println();
            }
        }
    }
}
