package com.usermanagement;

import java.util.List;
import java.util.Scanner;

public class Register {
	
	public static void registerUser(List<User> users) {
		Scanner sc = new Scanner(System.in);
		
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
            
            // taking all necessary inputs

            User user;

            if (type.equalsIgnoreCase("FREE")) {
                user = new FreeUser(email, password, name, userName);
            } else if (type.equalsIgnoreCase("PREMIUM")) {
                user = new PremiumUser(email, password, name, userName);
            } else {
                System.out.println("Invalid user type!");
                return;
            }
            // making user object based on the userType(Free of premium)

            users.add(user);
            System.out.println("User Registered Successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Registration Failed: " + e.getMessage());
        }
    }
}
