package com.usermanagement;


// this class is used to validate and update mail id
public class UpdateEmail {

    public void update(User user, String newEmail) {

        if (!Validation.isValidEmail(newEmail)) { // first validating the mail format
            throw new IllegalArgumentException("Invalid Email Format");
        }

        user.setEmail(newEmail); // if validated then setting new mail
        System.out.println("Email updated successfully!");
    }
}

