package com.example.twonotes;

import java.util.Date;

public class Admin extends User {
    public Admin(String username, String password, String firstName, String lastName, Date dateOfBirth) {
        super(username, password, firstName, lastName, dateOfBirth);
    }

    @Override
    public boolean authenticateUserName(String enteredUsername) {
        return enteredUsername.equals(getUserName());
    }

    @Override
    public boolean authenticatePassword(String enteredPassword) {
        return enteredPassword.equals(getPassword());
    }
}
