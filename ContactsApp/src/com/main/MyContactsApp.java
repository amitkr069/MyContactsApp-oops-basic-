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
            System.out.println("2. Login (Basic - Username)");
            System.out.println("3. Login (Open - Email)");

            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    basicLogin();
                    break;
                case 3:
                    openLogin();
                    break;
                case 4:
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
    
    // USE CASE 2
    
 //  BASIC AUTH 
    private static void basicLogin() {

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        BasicAuthentication auth = new BasicAuthentication(users);
        User user = auth.login(username, password);

        if (user != null) {
            System.out.println("Basic Login Successful!");
            System.out.println("Welcome " + user.getName());
        } else {
            System.out.println("Invalid Username or Password");
        }
    }

    //  OPEN AUTH

    private static void openLogin() {

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        OpenAuthentication auth = new OpenAuthentication(users);
        User user = auth.login(email, password);

        if (user != null) {
            System.out.println("Open Login Successful!");
            System.out.println("Welcome " + user.getName());
        } else {
            System.out.println("Invalid Email or Password");
        }
    }

   
}
