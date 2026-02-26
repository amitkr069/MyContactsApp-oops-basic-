package com.contactmanagement;

import java.util.ArrayList;

public class ContactManager {

    private ArrayList<Contact> contacts = new ArrayList<>();
    // creating List of Contact type
    // it will contain contact objects

    public ArrayList<Contact> getContacts() {
        return contacts;
        // return list of contacts;
    }
}
