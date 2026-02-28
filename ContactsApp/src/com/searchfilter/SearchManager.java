package com.searchfilter;

import java.util.List;
import java.util.Scanner;
import com.contactmanagement.*;
public class SearchManager {

    public void search(ContactManager manager) {

        if (manager.getContacts().isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("\nSearch By:");
        System.out.println("1. Name");
        System.out.println("2. Phone");
        System.out.println("3. Email");
        System.out.println("4. Tag -> Person, Organization");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter search keyword: ");
        String keyword = sc.nextLine();

        SearchStrategy strategy = null;

        switch (choice) {
            case 1:
                strategy = new SearchByName();
                break;
            case 2:
                strategy = new SearchByPhone();
                break;
            case 3:
                strategy = new SearchByEmail();
                break;
            case 4:
                strategy = new SearchByType();
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        List<Contact> results = strategy.search(manager.getContacts(), keyword);

        if (results.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nSearch Results:");
            for (Contact c : results) {

                System.out.print("[" + c.getType() + "] "
                        + c.getName() + " | "
                        + c.getPhone() + " | "
                        + c.getEmail());

//                if (c instanceof Person) {
//                    Person p = (Person) c;
//                    System.out.print(" | " + p.getCategory());
//                }

                System.out.println();
            }
        }
    }
}
