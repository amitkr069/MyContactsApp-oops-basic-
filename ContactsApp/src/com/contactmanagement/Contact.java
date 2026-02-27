package com.contactmanagement;

import java.time.LocalDate;

public class Contact {

    private String name;
    private String phone;
    private String email;
    private LocalDate dateAdded;

    public Contact(String name, String phone, String email) {

        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dateAdded = LocalDate.now();
    }
    
    // Copy Constructor
    public Contact(Contact other) {
    	this.name = other.name;
    	this.phone = other.phone;
    	this.email = other.email;
    	this.dateAdded = other.dateAdded;
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("^[9876]\\d{9}$");
        // number should start form 9,8,7 or 6 and it should have 10 numbers
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    
    
    public String getType() {
    	return "";
    }
    
    public String getCategory() {
    	return "";
    }
    
    public LocalDate getDateAdded() { return dateAdded; }
    // getter methods

    public void setName(String name) { this.name = name; }

    public void setPhone(String phone) {
        if (!isValidPhone(phone)) // if number is not valid then throw exception
            throw new IllegalArgumentException("Invalid phone number");
        this.phone = phone; 
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // above 3 are the setter methods
}

