package com.company;


import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    private static Phone phone;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        phone = new Phone("8 600 77777");

        startApp();
        printActionList();
        boolean finish = false;

        while (!finish) {
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Phone shutting down. Good Bye...");
                    finish = true;
                    break;

                case 1:
                    printActionList();
                    break;

                case 2:
                    phone.printContacts();
                    break;

                case 3:
                    callContact();
                    break;

                case 4:
                    addContact();
                    break;

                case 5:
                    updateContact();
                    break;

                case 6:
                    deleteContact();
                    break;
            }
        }
    }

    private static void addContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.next();
        System.out.println("Enter new phone number: ");
        String phoneNumber = scanner.next();
        Contact contact = Contact.createContact(name, phoneNumber);
        phone.addNewContact(contact);
            System.out.println("Contact was created");
    }

    public static void updateContact() {
        System.out.println("Enter contact name you want to update: ");
        String name = scanner.next();
        Contact contact = phone.callContact(name);
        if (contact == null) {
            System.out.println("Contact does not exist");
        }
        System.out.println("Please enter new contact: ");
        String newContactName = scanner.next();
        System.out.println("Please, enter phone number of new contact: ");
        String newNumber = scanner.next();
        Contact newCont = Contact.createContact(newContactName, newNumber);
        phone.updateContact(contact, newCont);
            System.out.println("Contact was updated");
        }

        private  static void deleteContact() {
            System.out.println("Enter contact name you want to delete: ");
            String name = scanner.next();
            Contact contact = phone.callContact(name);
            if (contact == null) {
                System.out.println("Contact does not exist");
            }
            phone.deleteContact(contact);
            System.out.println("Contact " + name + " has been deleted");
        }

        public static void callContact() {
            System.out.println("Enter contact name: ");
            String name = scanner.next();
            Contact contact = phone.callContact(name);
            if (contact == null) {
                System.out.println("Contact does not exist");
            }
            System.out.println("Contact: " + contact.getName() + "- " + contact.getPhoneNumber());
        }

        private  static void startApp() {
            System.out.println("Phone is starting...");
        }

        private  static  void printActionList() {
            System.out.println("Please, select the following steps: ");
            System.out.println("0 - shut down the phone");
            System.out.println("1 - print action list");
            System.out.println("2 - print list of all contacts");
            System.out.println("3 - call existing contact");
            System.out.println("4 - add new contact");
            System.out.println("5 - update contact");
            System.out.println("6 - delete contact");
        }
    }



