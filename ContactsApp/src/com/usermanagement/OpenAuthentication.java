package com.usermanagement;

import java.util.List;
//Authenticate based on email and password
public class OpenAuthentication {

    private List<User> users;
    // in the constructor a list of User object is passed

    public OpenAuthentication(List<User> users) {
        this.users = users;
        // users are assigned to the current class list of users.

    }

    public User login(String email, String password) {

        for (User user : users) {// iterating through all the present users and comparing with the provided input

            if (user.getEmail().equalsIgnoreCase(email)
                    && user.checkPassword(password)) {

                return user;
             // if the user is present then that user is returned.
            }
        }

        return null;
    }
}
