package com.contactmanagement;

public class AddContact {

    public void add(ContactManager manager, Contact contact) {
        manager.getContacts().add(contact);
        // getting the list from the manager object and adding the contact details in the list.
        System.out.println("Contact added successfully!");
    }
}