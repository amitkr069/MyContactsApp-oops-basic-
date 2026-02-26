package com.contactmanagement;

public class Contact {

    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {

        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("^[9876]\\d{9}$");
        // number should start form 9,8,7 or 6 and it should have 10 numbers
    }

    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    // getter methods

    public void setName(String name) { this.name = name; }

    public void setPhone(String phone) {
        if (!isValidPhone(phone)) // if num,er is not valid then throw exception
            throw new IllegalArgumentException("Invalid phone number");
        this.phone = phone; 
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    // above 3 are the setter methods
}

