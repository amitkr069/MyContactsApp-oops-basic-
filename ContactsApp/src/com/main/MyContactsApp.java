/**
 * @author AmIT
 * @version 10.0
 * 
 * This is updated for use case 10 Filter Contacts
 */

package com.main;

import com.usermanagement.*;
import com.contactmanagement.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class MyContactsApp {

    private static List<User> users = new ArrayList<>();
    // making a list of User type. it contains objects
    
    private static User loggedInUser = null;
    
//    private static ContactManager contactManager = new ContactManager();
    // creating object of ContactManager class

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) { //continuing the loop until we exit

            System.out.println("\n===== MyContacts App =====");

            if (loggedInUser == null) { // if not logged in the register
                System.out.println("1. Register");
                System.out.println("2. Login (Basic)");
                System.out.println("3. Login (Open)");
                System.out.println("4. Exit");
            } else {
            	// if logged in then do profile management, contact management or logout.
                System.out.println("1. Profile Management");
                System.out.println("2. Contact Management");
                System.out.println("3. Logout");
                System.out.println("4. Exit");
            }

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (loggedInUser == null) {

                switch (choice) {
                    case 1 -> Register.registerUser(users);
                    case 2 -> basicLogin();
                    case 3 -> openLogin();
                    case 4 -> { return; }
                    default -> System.out.println("Invalid choice!");
                    // calling different methods based on the input
                }

            } else {

                switch (choice) {
                    case 1 -> profileManagement();
                    case 2 -> Manage.contactManagement(loggedInUser);
                    case 3 -> logout();
                    case 4 -> { return; }
                    default -> System.out.println("Invalid choice!");
                 // calling different methods based on the input
                }
            }
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
        	loggedInUser = user; // changing logged in from null to and object
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
        	loggedInUser = user;
            System.out.println("Open Login Successful!");
            System.out.println("Welcome " + user.getName());
        } else {
            System.out.println("Invalid Email or Password");
        }
    }
    
    // Profile Management
    private static void profileManagement() {

        if (loggedInUser == null) {
            System.out.println("Please login first!");
            return;
        }

        ProfileManager manager = new ProfileManager(loggedInUser); // passing the particular user object
        manager.manageProfile(); // calling the method to update profile
    }
    
    
    // Logout
    private static void logout() {
        loggedInUser = null;
        // if i log out then the loggedIn object will be null;
        System.out.println("Logged out successfully!");
    }
}
