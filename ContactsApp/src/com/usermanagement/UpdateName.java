package com.usermanagement;

// this class is used to update name
public class UpdateName {

    public void update(User user, String newName) {
        user.setName(newName);
        System.out.println("Name updated successfully!");
    }
}

