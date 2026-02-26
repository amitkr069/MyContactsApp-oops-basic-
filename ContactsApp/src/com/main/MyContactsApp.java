package com.main;

import com.usermanagement.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyContactsApp {

    private static List<User> users = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MyContacts App =====");
            System.out.println("1. Register");
            
            System.out.println("2. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    
    // USE CASE 1 - Registration
    

    private static void registerUser() {

        try {
            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            // Duplicate email check
            for (User u : users) {
                if (u.getEmail().equalsIgnoreCase(email)) {
                    System.out.println("Email already registered!");
                    return;
                }
            }

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter user Name: ");
            String userName = sc.nextLine();

            System.out.print("Enter Type (FREE / PREMIUM): ");
            String type = sc.nextLine();

            User user;

            if (type.equalsIgnoreCase("FREE")) {
                user = new FreeUser(email, password, name, userName);
            } else if (type.equalsIgnoreCase("PREMIUM")) {
                user = new PremiumUser(email, password, name, userName);
            } else {
                System.out.println("Invalid user type!");
                return;
            }

            users.add(user);
            System.out.println("User Registered Successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Registration Failed: " + e.getMessage());
        }
    }


    
}
