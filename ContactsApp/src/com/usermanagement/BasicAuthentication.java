package com.usermanagement;

import java.util.List;


// Authenticate based on user name and password
public class BasicAuthentication {

    private List<User> users;
    // in the constructor a list of User object is passed
    public BasicAuthentication(List<User> users) {
        this.users = users;
        // users are assigned to the current class list of users.
    }

    public User login(String username, String password) {

        for (User user : users) { //iterating through all the present users and comparing with the provided input

            if (user.getUsername().equalsIgnoreCase(username)
                    && user.checkPassword(password)) {

                return user;
                // if the user is present then that user is returned.
            }
        }

        return null;
    }
}
