package com.contactmanagement;
import java.util.Scanner;
public class AddContact {

	public void add(ContactManager manager) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Contact Type:");
        System.out.println("1. Person");
        System.out.println("2. Organization");
        System.out.print("Enter choice: ");
        int typeChoice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone (10 digits): ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Contact contact = null;

        if (typeChoice == 1) {

            System.out.print("Enter Date of Birth: ");
            String dob = sc.nextLine();

            contact = new Person(name, phone, email, dob);

        } else if (typeChoice == 2) {

            System.out.print("Enter Company Name: ");
            String company = sc.nextLine();

            contact = new Organisation(name, phone, email, company);

        } else {
            System.out.println("Invalid choice");
            return;
        }

        manager.getContacts().add(contact);
        System.out.println(contact.getType() + " added successfully!");
    }
}