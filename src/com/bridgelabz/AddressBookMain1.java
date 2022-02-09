package com.bridgelabz;

import java.util.*;
import java.util.stream.*;

public class AddressBookMain1 {

    static Scanner sc = new Scanner(System.in);

    //Using hashmap creating multiple Address book
    static Map<String, AddressBook1> addressBookMap = new HashMap<>();

    public static void addNewAddressBook() {
        System.out.println("Enter the Address Book Name :");
        String addressbookName = sc.next();
        if (addressBookMap.containsKey(addressbookName)) {
            System.out.println("Entered AddressBook is Already Available");
        } else {
            AddressBook1 addressBook = new AddressBook1();
            addressBookMap.put(addressbookName, addressBook);
        }
    }

    public static void displayAddressBooks() {
        for (Map.Entry<String, AddressBook1> entry : addressBookMap.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().showContacts();
            //System.out.println(key);
            //String addressbookName=key;
            //addressBookMap.get(addressbookName).showContacts();
        }
    }

    public static void searchPersonthroughCityorstate() {
        String choice;
        System.out.println("Enter the choice ");
        choice = sc.next();
        System.out.println("Enter the City or State");
        String searchParameter = sc.next();

        List<Contacts1> searchcontactlist = new ArrayList<>();

        for (Map.Entry<String, AddressBook1> entry : addressBookMap.entrySet()) {
            System.out.println(entry.getKey());
            List<Contacts1> contactlist = entry.getValue().list;
            contactlist.stream().filter(contacts1 -> choice.equalsIgnoreCase("city") ? searchParameter.equalsIgnoreCase(contacts1.city) : searchParameter.equalsIgnoreCase(contacts1.state))
                    .collect(Collectors.toList()).forEach(contacts1 -> searchcontactlist.add(contacts1));
        }
        System.out.println("Result is " + searchcontactlist);
        long total = searchcontactlist.stream().count();  //count by City or State
        System.out.println("Number of city or state is " + total);
    }

    public static void viewPersonByCityOrState() {
        Map<String, List<Contacts1 >> stateMap=new HashMap<>();

        Map<String, List<Contacts1>> cityMap = new HashMap<>();
        for (Map.Entry<String, AddressBook1> entry : addressBookMap.entrySet()) {
            System.out.println(entry.getKey());
            List<Contacts1> contactlist = entry.getValue().list;
            contactlist.stream().forEach(contacts1 -> {
                        if (cityMap.containsKey(contacts1.city)) {
                            cityMap.get(contacts1.city).add(contacts1);
                        } else {
                            List<Contacts1> contacts1List = new ArrayList<>();
                            contacts1List.add(contacts1);
                            cityMap.put(contacts1.city, contacts1List);
                        }
                    }
            );
            contactlist.stream().forEach(contacts1 -> {
                        if (stateMap.containsKey(contacts1.state)) {
                            stateMap.get(contacts1.state).add(contacts1);
                        } else {
                            List<Contacts1> contacts1List = new ArrayList<>();
                            contacts1List.add(contacts1);
                            stateMap.put(contacts1.state, contacts1List);
                        }
                    }
            );
        }
        System.out.println("city is" + cityMap);
        System.out.println("state is" + stateMap);
    }

    public static void editAddressBook() {
        displayAddressBooks();
        System.out.println("Enter the Address Book Name :");
        String addressbookName = sc.next();
        if (addressBookMap.containsKey(addressbookName)) {
            addressBookMap.get(addressbookName).chooseoptionforcontact();
        } else {
            System.out.println("Entered Address Book Name is Not Present ");
        }
    }


    public static void deleteAddressBook() {
        displayAddressBooks();
        System.out.println("Enter the Address Book Name :");
        String addressbookName = sc.next();
        if (addressBookMap.containsKey(addressbookName)) {
            addressBookMap.remove(addressbookName);
            System.out.println("Address Book is Deleted");
        } else {
            System.out.println("Entered Address Book Name is Not Present");
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        int choice;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Kindly Enter choice \n 1. Add New Address Book \n 2. Edit Address Book  \n 3. Display Address Book  \n 4. Delete Address book" +
                    " \n 5. Search Person through City or State \n 6. view Person By City Or State \n 8. Quit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addNewAddressBook();
                    break;
                case 2:
                    editAddressBook();
                    break;
                case 3:
                    displayAddressBooks();
                    break;
                case 4:
                    deleteAddressBook();
                    break;
                case 5:
                    searchPersonthroughCityorstate();
                    break;
                case 6:
                    viewPersonByCityOrState();
                    break;
                case 7:
                    System.out.println("Thank you.");
                    break;
            }
        } while (choice != 7);
    }

}



