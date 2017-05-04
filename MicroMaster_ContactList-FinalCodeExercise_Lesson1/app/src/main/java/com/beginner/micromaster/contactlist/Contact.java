package com.beginner.micromaster.contactlist;

public class Contact {

    private String name;
    private String lastName;
    private String email;
    private int phoneNumber;

    public Contact(String name, String lastName, String email, int phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "name:" + name + ", " +
            "lastName:" + lastName + ", " +
            "email:" + email + ", " +
            "phoneNumber:" + phoneNumber;

    }
}
