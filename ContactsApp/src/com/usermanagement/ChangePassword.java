package com.usermanagement;

public class ChangePassword {

    public void update(User user, String oldPassword, String newPassword) {
    	// first checking if the old password is correct or not.
        if (!user.checkPassword(oldPassword)) {
            throw new IllegalArgumentException("Old password incorrect");
        }
        
        // now checking if the new password is valid or not
        if (!Validation.isValidPassword(newPassword)) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
        
        // new password is hashed and given to the user object to set the password.
        user.setPassword(Hash.hashPassword(newPassword));
        System.out.println("Password changed successfully!");
    }
}

