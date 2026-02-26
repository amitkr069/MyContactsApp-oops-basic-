package com.usermanagement;

import java.util.List;

public class BasicAuthentication {

    private List<User> users;

    public BasicAuthentication(List<User> users) {
        this.users = users;
    }

    public User login(String username, String password) {

        for (User user : users) {

            if (user.getUsername().equalsIgnoreCase(username)
                    && user.checkPassword(password)) {

                return user;
            }
        }

        return null;
    }
}
