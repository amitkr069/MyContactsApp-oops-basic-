package com.usermanagement;

import java.util.Scanner;

public class ProfileManager {

    private User user;

    public ProfileManager(User user) { // passing the user object as parameter to constructor
        this.user = user;
    }

    public void manageProfile() {

        Scanner sc = new Scanner(System.in);

        UpdateName updateName = new UpdateName(); // making UpdateName object
        UpdateEmail updateEmail = new UpdateEmail(); // making updateEmail object
        ChangePassword changePassword = new ChangePassword(); // making changePassword obect

        while (true) { // while we dont press back the loop continues

            System.out.println("\n--- Profile Management ---");
            System.out.println("1. Update Name");
            System.out.println("2. Update Email");
            System.out.println("3. Change Password");
            System.out.println("4. Back");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1:
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();
                        updateName.update(user, newName); // calling update method to update name
                        break;

                    case 2:
                        System.out.print("Enter New Email: ");
                        String newEmail = sc.nextLine();
                        updateEmail.update(user, newEmail);  // calling update method to update email
                        break;

                    case 3:
                        System.out.print("Enter Old Password: ");
                        String oldPass = sc.nextLine(); // taking old password as input to check if its correct or not

                        System.out.print("Enter New Password: ");
                        String newPass = sc.nextLine();

                        changePassword.update(user, oldPass, newPass);  // calling update method to update password
                        break;

                    case 4:
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

