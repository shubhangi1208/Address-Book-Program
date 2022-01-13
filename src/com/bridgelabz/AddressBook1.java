package com.bridgelabz;
import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook1 {
    //Created Scanner class object
    Scanner sc = new Scanner(System.in);

    //ArrayList created for storing contacts
    ArrayList<Contacts1> list = new ArrayList<Contacts1>();

    public void addContacts() {

        Contacts1 contacts = new Contacts1();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Contact details");
        System.out.println("Enter the First Name :");
        contacts.setFirstname(sc.next());
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


}
