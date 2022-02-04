package com.bridgelabz;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddressBook1 {
    //Created Scanner class object
    Scanner sc = new Scanner(System.in);
    //ArrayList created for storing contacts
    ArrayList<Contacts1> list = new ArrayList<Contacts1>();

    public boolean equalsFirstName(Contacts1 contacts1) {
        for (Contacts1 contacts :list){
            if (contacts.equals(contacts)){
                return true;
            }
        }
        return false;
    }
    public void addContacts() {
        Contacts1 contacts = new Contacts1();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Contact details");
        System.out.println("Enter the First Name :");
        contacts.setFirstname(sc.next());
        if(!equalsFirstName(contacts)){
            System.out.println("Enter the Last Name :");
            contacts.setLastname(sc.next());
            System.out.println("Enter the Address :");
            contacts.setAddress(sc.next());
            System.out.println("Enter the City :");
            contacts.setCity(sc.next());
            System.out.println("Enter the State :");
            contacts.setState(sc.next());
            System.out.println("Enter the Zip Code :");
            contacts.setZip(sc.next());
            System.out.println("Enter the Phone Number :");
            contacts.setPhone_number(sc.next());
            System.out.println("Enter the EMail ID :");
            contacts.setEmail(sc.next());
            list.add(contacts);
            System.out.println("Contact added Successfully");
        }else{
            System.out.println("Contact already Exists");
        }

    }

    //Method to Show the Contact Details
    public void showContacts() {
        for (Contacts1 contacts : list) {
                System.out.println("Contact Details -");
                System.out.println("First Name : " + contacts.getFirstname());
                System.out.println("Last Name : " + contacts.getLastname());
                System.out.println("Address : " + contacts.getAddress());
                System.out.println("City : " + contacts.getCity());
                System.out.println("State : " + contacts.getState());
                System.out.println("Zip Code : " + contacts.getZip());
                System.out.println("Phone Number : " + contacts.getPhone_number());
                System.out.println("EMail ID : " + contacts.getEmail());
            }

        }



    public void editContact() {
        //getting first name from user to find that contact which you wat to edit
        System.out.println("Enter the first name");
        String firstName = sc.next();
        boolean isAvailable = false;

        for (Contacts1 contacts : list) {
            if (firstName.equalsIgnoreCase(contacts.getFirstname())) {
                isAvailable = true;
                System.out.println("Enter the Last Name :");
                contacts.setLastname(sc.next());
                System.out.println("Enter the Address :");
                contacts.setAddress(sc.next());
                System.out.println("Enter the City :");
                contacts.setCity(sc.next());
                System.out.println("Enter the State :");
                contacts.setState(sc.next());
                System.out.println("Enter the Zip Code :");
                contacts.setZip(sc.next());
                System.out.println("Enter the Phone Number :");
                contacts.setPhone_number(sc.next());
                System.out.println("Enter the EMail ID :");
                contacts.setEmail(sc.next());
                break;
            }
        }
        if (!isAvailable) {
            System.out.println("Contact Number Not found ");
        }
    }

    @Override
    public String toString() {
        return "AddressBook1{" +
                "list=" + list +
                '}';
    }

    public void deleteContact() {


        System.out.println("Enter the first name");
        String firstName = sc.next();

        boolean isAvailable = false;
        for (Contacts1 contacts : list) {
            if (firstName.equalsIgnoreCase(contacts.getFirstname())) {
                isAvailable = true;
                list.remove(contacts);
                System.out.println("Contact Deleted ");
                break;
            }
            if (!isAvailable) {
                System.out.println("Contact Number Not found ");
            }

        }

    }

    public void chooseoptionforcontact(){
    int choice;
        do {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kindly Enter choice \n 1. Add new Contact \n 2. Edit Contact details \n 3. Display details  \n 4 Delete Contact \n 5. Quit");
        choice = scan.nextInt();
        switch (choice) {
            case 1:
                addContacts();
                break;
            case 2:
                editContact();
                break;
            case 3:
                showContacts();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                System.out.println("Thank you.");
                break;
        }
    }while (choice != 5);
}

}



