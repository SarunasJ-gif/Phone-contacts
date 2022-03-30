package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Phone {
    private String phoneNumber;
    private ArrayList<Contact> phoneContacts;

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.phoneContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already exists");
            return false;
        }
        phoneContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int findPosition = findContact(oldContact);
        if (findPosition < 0) {
            System.out.println("Contact " + oldContact.getName() + " was not found");
            return false;
        } else if (findContact(newContact) != -1) {
            System.out.println("Contact " + newContact.getName() + " already exists");
            return false;
        }
        this.phoneContacts.set(findPosition, newContact);
        System.out.println(oldContact.getName() + " has been changed to " + newContact.getName());
        return true;
    }

    public boolean deleteContact(Contact contact) {
        int findPosition = findContact(contact);
        if (findPosition < 0) {
            System.out.println(contact.getName() + " was not found");
            return false;
        }
        this.phoneContacts.remove(findPosition);
        System.out.println(contact.getName() + " was deleted");
        return true;
    }



    public String callContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact callContact(String name) {
        int findPosition = findContact(name);
        if (findPosition >= 0) {
            return phoneContacts.get(findPosition);
        }
        return null;
    }

    public void printContacts() {
        System.out.println("List of contacts: ");
        for (int i = 0; i < phoneContacts.size(); i++) {
            System.out.println((i + 1) + ". " + this.phoneContacts.get(i).getName() +
                    ": " + this.phoneContacts.get(i).getPhoneNumber());
        }
    }

    private int findContact(Contact contact) {
        return this.phoneContacts.indexOf(contact);
    }

    private  int findContact(String name) {
        for (int i = 0; i < phoneContacts.size(); i++) {
            Contact contact = this.phoneContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
