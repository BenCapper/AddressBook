package com.errigal;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * AddressBookSystem starts the program and stores methods
 * which allow the user to interface with the program
 * @author Ben Capper
 */
public class AddressBookSystem {

    /**
     * Initialise Scanner which reads user input.
     * Initialise the contacts AddressBook which will allow
     * objects in contacts ArrayList to be stored and manipulated
     * using methods in the AddressBook class
     */
    protected Scanner input = new Scanner(System.in);
    protected AddressBook contacts = new AddressBook();

    /**
     * Constructs AddressBookSystem object which bootstraps default users
     * and runs MainMenu when instantiated
     */
    public AddressBookSystem() {
        Contact contact = new Contact("Carl", "King", "051849058", "CarlKing@live.ie",
                "45 Castle St, Dalkey, Dublin");
        Contact contact1 = new Contact("Frank", "Roberts", "0855486256", "FrankRoberts@Yahoo.com",
                "20 Main st, Newbridge, Kildare", "FRobert78", "Frank15", "Frank-Roberts", null);
        Contact contact2 = new Contact("David", "Murphy", "054567353", "DavidMurphy@Outlook.ie",
                "3 Eyre st, Woodquay, Galway");
        Contact contact3 = new Contact("Amy", "Johnson", "0876542524", "AmyJ21@Gmail.com",
                "3 Harbour st, Tullamore, Offaly", "AmyJ21", "AmyJ1", "Amy-Johnson", "AlexJohnson");
        Contact contact4 = new Contact("Ellie", "Zane", "0857530242", "EllieZane31@Microsoft.com",
                "10 Key Lane, Herbert Street, Dublin", "ElleMS", "EllieZ", "Ellie-Zane", "EllieZane");
        Contact contact5 = new Contact("Ben", "Capper", "0851121720", "BenCapper19@Gmail.com",
                "The Garden, Arthurstown, New Ross, Wexford", "BenCapper", null, "Ben-Capper", null);
        contacts.addContact(contact);
        contacts.addContact(contact1);
        contacts.addContact(contact2);
        contacts.addContact(contact3);
        contacts.addContact(contact4);
        contacts.addContact(contact5);
        runMainMenu();
    }

    /**
     * Main Method, Instantiates AddressBookSystem and starts the program
     */
    public static void main(String[] args) {
        new AddressBookSystem();
    }

    /**
     * Starts mainMenu() which shows ui in console
     * mainMenu() returns a user-specified int used
     * in switch to run the appropriate method
     */
    private void runMainMenu() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> {
                    runContactsMenu();
                    contactsMenu();
                }
                case 2 -> addContact();
                case 3 -> searchContacts();
                case 4 -> updateContact();
                case 5 -> deleteContact();
                default -> System.out.println("Invalid option entered: " + option);
            }
            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }

    /**
     * Displays options to user, returns user selection to runMainMenu()
     * @return option
     */
    private int mainMenu() {
        System.out.println("------------------------");
        System.out.println("Address Book");
        System.out.println("------------------------");
        System.out.println("Select an Option: ");
        System.out.println("    1 - View Contacts");
        System.out.println("    2 - Add Contact");
        System.out.println("    3 - Search by Full Name");
        System.out.println("    4 - Update Contact");
        System.out.println("    5 - Delete Contact");
        System.out.println("------------------------");
        System.out.println("    0 - Exit Menu.");
        System.out.println("------------------------");
        System.out.print("==> ");
        return input.nextInt();
    }

    /**
     * Starts contactsMenu() which shows ui in console
     * contactsMenu() returns a user-specified int used
     * in switch to run the appropriate method
     */
    private void runContactsMenu() {
        int option = contactsMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> System.out.println("\n" + contacts.viewAllContactInfo());
                case 2 -> System.out.println("\n" + contacts.viewAllContactNames());
                case 3 -> tidyFirstSortOutput();
                case 4 -> tidyLastSortOutput();
                case 9 -> {
                    runMainMenu();
                    mainMenu();
                }
                default -> System.out.println("Invalid option entered: " + option);
            }
            //Pause program so user can read what was printed
            System.out.println("Press enter to continue...");
            input.nextLine();
            input.nextLine();
            option = contactsMenu();
        }
        System.out.println("Exiting program");
        System.exit(0);
    }

    /**
     * Displays options to user, returns user selection to runContactsMenu()
     * @return option
     */
    private int contactsMenu() {
        System.out.println("\nView Contacts");
        System.out.println("------------------------");
        System.out.println("Select an Option: ");
        System.out.println("    1 - View All Contacts");
        System.out.println("    2 - View Names");
        System.out.println("    3 - View Names - Sorted by First Name");
        System.out.println("    4 - View Names - Sorted by Last Name");
        System.out.println("------------------------");
        System.out.println("    9 - Back");
        System.out.println("    0 - Exit Menu");
        System.out.println("------------------------");
        System.out.print("==> ");
        return input.nextInt();
    }

    /**
     * Takes user input to create Contact object
     * which is then added to the contacts ArrayList
     */
    private void addContact() {

        input.nextLine();
        System.out.println("\nEnter First Name: ");
        System.out.print("==> ");
        String fName = input.nextLine();

        System.out.println("Enter Surname: ");
        System.out.print("==> ");
        String lName = input.nextLine();

        System.out.println("Enter Phone Number: ");
        System.out.print("==> ");
        String phoneNo = input.nextLine();

        System.out.println("Enter Email Address: ");
        System.out.print("==> ");
        String email = input.nextLine();

        System.out.println("Enter Address: ");
        System.out.print("==> ");
        String address = input.nextLine();

        System.out.println("Enter GitHub Username: ");
        System.out.print("==> ");
        String github = input.nextLine();

        System.out.println("Enter Twitter Username: ");
        System.out.print("==> ");
        String twitter = input.nextLine();

        System.out.println("Enter Linkedin Username: ");
        System.out.print("==> ");
        String linkedin = input.nextLine();

        System.out.println("Enter Facebook Username: ");
        System.out.print("==> ");
        String facebook = input.nextLine();

        Contact contact = new Contact(fName,lName,phoneNo,email,address,github,twitter,linkedin,facebook);
        contacts.addContact(contact);
        System.out.println("\n" + fName + " " + lName + " successfully added \n");
    }

    /**
     * Prints list of all full names, then takes a user-input
     * name to search for specifically before displaying all
     * information on that contact.
     */
    public void searchContacts(){
        if(contacts.contactCounter() <= 0){
            System.out.println("There are no contacts to search \n");
        } else {
            tidyFirstSortOutput();
            input.nextLine();
            System.out.println("Enter Full Name of Contact to be Searched: ");
            System.out.print("==> ");
            String pick = input.nextLine();
            System.out.println("");
            if(contacts.searchForContact(pick) == null){
                System.out.println("\nContact not Found\n");
            }else {
                System.out.println(contacts.searchForContact(pick));
            }
        }
    }

    /**
     * Prints list of all full names, then takes a user-input
     * name to be deleted. Checks whether name is valid
     */
    public void deleteContact(){
        int count = 0;
        if(contacts.contactCounter() <= 0){
            System.out.println("There are no contacts to display \n");
        } else {
            tidyFirstSortOutput();
            input.nextLine();
            System.out.println("Enter Full Name of Contact to be Deleted: ");
            System.out.print("==> ");
            String pick = input.nextLine();

            for (int i = 0; i < contacts.contactCounter(); i++) {
                String fullName = contacts.getContact(i).getFirstName() + " " + contacts.getContact(i).getLastName();
                String fullNameNoSpace = contacts.getContact(i).getFirstName() + contacts.getContact(i).getLastName();
                count++;
                if(pick.equalsIgnoreCase(fullName) || pick.equalsIgnoreCase(fullNameNoSpace)){
                    contacts.deleteContact(pick);
                    System.out.println("\n" + pick + " successfully deleted \n");
                    break;
                }
                else if (count == contacts.contactCounter()){
                    System.out.println("\n" + pick + " does not match any contact on record \n");
                }
            }

        }
    }

    /**
     * Prints list of all full names which have been
     * sorted by First Name in a tidy output
     */
    public void tidyFirstSortOutput(){
        String list = "\n";
        ArrayList<Contact> newArray = contacts.viewFirstNameSort();
        for (int i = 0; i < newArray.size() ; i++) {
            list = list + " -   " + newArray.get(i).getFirstName() + " " + newArray.get(i).getLastName() + "\n";
        }
        System.out.println(list);
    }

    /**
     * Prints list of all full names which have been
     * sorted by Surname in a tidy output
     */
    public void tidyLastSortOutput(){
        String list = "\n";
        ArrayList<Contact> newArray = contacts.viewSurnameSort();
        for (int i = 0; i < newArray.size() ; i++) {
            list = list + " -   " + newArray.get(i).getFirstName() + " " + newArray.get(i).getLastName() + "\n";
        }
        System.out.println(list);
    }

    /**
     * Prints list of all full names. Requests a user input
     * name which is checked to be valid. Requests updated data.
     * Updates specified contact with new data.
     */
    public void updateContact(){
        int count = 0;
        boolean added = false;
        if(contacts.contactCounter() != 0){
            System.out.println("\n" + contacts.viewAllContactNames());
            input.nextLine();
            System.out.println("Enter Full Name of the Contact to be Updated: ");
            System.out.print("==> ");
            String name = input.nextLine();
            for (int i = 0; i < contacts.contactCounter(); i++) {
                count ++;
                String firstName = contacts.getContact(i).getFirstName();
                String lastName = contacts.getContact(i).getLastName();
                String full = firstName + " " + lastName;
                String fullNoSpace = firstName + lastName;
                if (full.equalsIgnoreCase(name) || fullNoSpace.equalsIgnoreCase(name)) {
                    System.out.println("Enter Updated First Name: ");
                    System.out.print("==> ");
                    String fName = input.nextLine();
                    System.out.println("Enter Updated Surname: ");
                    System.out.print("==> ");
                    String lName = input.nextLine();
                    System.out.println("Enter Updated Phone Number: ");
                    System.out.print("==> ");
                    String phoneNo = input.nextLine();
                    System.out.println("Enter Updated Email Address: ");
                    System.out.print("==> ");
                    String email = input.nextLine();
                    System.out.println("Enter Updated Address: ");
                    System.out.print("==> ");
                    String address = input.nextLine();
                    System.out.println("Enter Updated Github Username: ");
                    System.out.print("==> ");
                    String github = input.nextLine();
                    System.out.println("Enter Updated Twitter Username: ");
                    System.out.print("==> ");
                    String twitter = input.nextLine();
                    System.out.println("Enter Updated LinkedIn Username: ");
                    System.out.print("==> ");
                    String linkedin = input.nextLine();
                    System.out.println("Enter Updated Facebook Username: ");
                    System.out.print("==> ");
                    String fb = input.nextLine();
                    contacts.updateContact(name, fName, lName, phoneNo, email, address, github, twitter, linkedin, fb);
                    System.out.println("\n" + name + " successfully updated\n");
                    added = true;
                }
                }
            if (added == false){
                System.out.println("\nThere are no contacts with that name\n");
                }
            }
        }
    }
