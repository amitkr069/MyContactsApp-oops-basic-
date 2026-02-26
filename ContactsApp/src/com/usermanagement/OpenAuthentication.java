package com.usermanagement;

import java.util.List;

public class OpenAuthentication {

    private List<User> users;

    public OpenAuthentication(List<User> users) {
        this.users = users;
    }

    public User login(String email, String password) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)
                    && user.checkPassword(password)) {

                return user;
            }
        }

        return null;
    }
}
