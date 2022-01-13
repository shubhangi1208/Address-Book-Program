package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain1 {

    public static void main(String[] args) {
        int choice;
        AddressBook1 Ab = new AddressBook1();
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to Address Book Program");
            System.out.println("Kindly Enter choice \n 1. Add new Contact \n 2. Edit Contact details \n 3. Display details  \n 4 Delete Contact \n 5. Quit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Ab.addContacts();
                    break;
                case 2:
                    break;
                case 3:
                    Ab.showContacts();
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }while (choice != 5);
    }

}
