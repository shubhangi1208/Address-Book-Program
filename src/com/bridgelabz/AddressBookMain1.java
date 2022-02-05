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
        if(addressBookMap.containsKey(addressbookName)) {
            System.out.println("Entered AddressBook is Already Available");
        } else {
            AddressBook1 addressBook = new AddressBook1();
            addressBookMap.put(addressbookName,addressBook);
        }
    }

    public static void displayAddressBooks() {
        for( Map.Entry<String,AddressBook1> entry:  addressBookMap.entrySet()){
            System.out.println(entry.getKey());
            entry.getValue().showContacts();
           //System.out.println(key);
            //String addressbookName=key;
            //addressBookMap.get(addressbookName).showContacts();
        }
    }
public static void searchPersonthroughCityorstate(){
        String choice;
    System.out.println("Enter the choice ");
    choice =sc.next();
    System.out.println("Enter the City or State");
    String searchParameter=sc.next();

    List<Contacts1> searchcontactlist= new ArrayList<>();

    for( Map.Entry<String,AddressBook1> entry:addressBookMap.entrySet()) {
        System.out.println(entry.getKey());
        List<Contacts1> contactlist = entry.getValue().list;
        contactlist.stream().filter(contacts1 ->choice.equalsIgnoreCase("city")? searchParameter.equalsIgnoreCase(contacts1.city): searchParameter.equalsIgnoreCase(contacts1.state))
                .collect(Collectors.toList()).forEach(contacts1 -> searchcontactlist.add(contacts1));
    }
    System.out.println("Result is " + searchcontactlist);
}


    public static void editAddressBook() {
        displayAddressBooks();
        System.out.println("Enter the Address Book Name :");
        String addressbookName = sc.next();
        if(addressBookMap.containsKey(addressbookName)) {
            addressBookMap.get(addressbookName).chooseoptionforcontact();
        } else {
            System.out.println("Entered Address Book Name is Not Present ");
        }
    }


    public static void deleteAddressBook() {
        displayAddressBooks();
        System.out.println("Enter the Address Book Name :");
        String addressbookName = sc.next();
        if(addressBookMap.containsKey(addressbookName)) {
            addressBookMap.remove(addressbookName);
            System.out.println("Address Book is Deleted");
        } else {
            System.out.println("Entered Address Book Name is Not Present");
        }
    }


        public static void main (String[]args){
            System.out.println("Welcome to Address Book Program");
            int choice;
            do {
                Scanner scan = new Scanner(System.in);
                System.out.println("Kindly Enter choice \n 1. Add New Address Book \n 2. Edit Address Book  \n 3. Display Address Book  \n 4. Delete Address book" +
                        " \n 5. Search Person through City or State \n 6. Quit");
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
                        System.out.println("Thank you.");
                        break;
                }
            } while (choice != 6);
        }

    }

