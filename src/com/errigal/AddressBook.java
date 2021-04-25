package com.errigal;

import com.errigal.sorters.FirstNameSorter;
import com.errigal.sorters.SurnameSorter;

import java.util.ArrayList;

/**
 * The AddressBook class stores methods used to manipulate
 * data stored in the contacts ArrayList
 * @author Ben Capper
 */
public class AddressBook {

    //ArrayList of Contact objects initialised
    protected ArrayList<Contact> contacts = new ArrayList<>();

    /**
     * Returns a Contact specified by user
     * @param index integer of chosen ArrayList element
     * @return contact
     */
    public Contact getContact(int index) {
        if ((index >= 0) && (index <= contacts.size())) {
            return contacts.get(index);
        } else {
            return null;
        }
    }

    /**
     * Adds a Contact object to contacts ArrayList
     * @param contact to be added to ArrayList of Contacts
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    /**
     * Returns the length of contacts ArrayList
     * @return contacts.size()
     */
    public int contactCounter(){
        return contacts.size();
    }

    /**
     * Returns all Information on all Contact
     * @return list
     */
    public String viewAllContactInfo() {
        String list = "";
        if (contacts.size() != 0) {
            for (int i = 0; i < contacts.size(); i++) {
                list = list + contacts.get(i) + "\n";
            }
            return list;
        } else {
                return "There are no contacts to display";
        }
    }

    /**
     * Returns the Full Names of all Contacts
     * @return list
     */
    public String viewAllContactNames() {
        String list = "\n";
        if (contacts.size() != 0) {
            for (int i = 0; i < contacts.size(); i++) {
                list = list + " -   " + contacts.get(i).getFirstName() + " " + contacts.get(i).getLastName() + "\n";
            }
            return list;
        } else {
            return "There are no contacts to display";
        }
    }

    /**
     * Returns an ArrayList of all Full Names
     * sorted by First Name using the FirstNameSorter class
     * which implements Comparator.
     * @return contacts
     */
    public ArrayList<Contact> viewFirstNameSort() {
        contacts.sort(new FirstNameSorter());
        if (contacts.size() != 0) {
            return contacts;
        } else {
            return null;
        }
    }

    /**
     * Returns an ArrayList of all Full Names
     * sorted by Surname using the SurnameSorter class
     * which implements the Comparator class.
     * @return contacts
     */
    public ArrayList<Contact> viewSurnameSort() {
        contacts.sort(new SurnameSorter());
        if (contacts.size() != 0) {
            return contacts;
        } else {
            return null;
        }
    }

    /**
     * Returns an ArrayList of all Full Names
     * sorted by First Name using the FirstNameSorter class
     * which implements Comparator.
     * @param fullName of Contact to be searched
     * @return foundContact
     */
    public Contact searchForContact(String fullName){
        Contact foundContact = null;
        for (int i = 0; i < contacts.size(); i++) {
            String fName = contacts.get(i).getFirstName();
            String lName = contacts.get(i).getLastName();
            String full = fName + " " + lName;
            String fullNoSpace = fName + lName;
            if(full.equalsIgnoreCase(fullName) || fullNoSpace.equalsIgnoreCase(fullName)){
                foundContact = contacts.get(i);
            }
        }
        return foundContact;
    }

    /**
     * Deletes a user-specified Contact from the contacts ArrayList
     * via fullName after checking whether a Contact with that name exists.
     * @param fullName of Contact to be searched
     */
    public void deleteContact(String fullName){
        for (int i = 0; i < contacts.size(); i++) {
            String fName = contacts.get(i).getFirstName();
            String lName = contacts.get(i).getLastName();
            String full = fName + " " + lName;
            String fullNoSpace = fName + lName;
            if(full.equalsIgnoreCase(fullName) || fullNoSpace.equalsIgnoreCase(fullName)){
                contacts.remove(i);
            }
        }
    }

    /**
     * Updates a user-specified Contact in the contacts ArrayList
     * via fullName after checking whether a Contact with that name exists.
     * @param fullName full name of Contact to be updated
     * @param fName  first name of Contact to be updated
     * @param lName last name of Contact to be updated
     * @param phoneNo phone number of Contact to be updated
     * @param email email address of Contact to be updated
     * @param address address of Contact to be updated
     * @param github github username of Contact to be updated
     * @param twitter twitter username of Contact to be updated
     * @param linkedIn linkedIn username of Contact to be updated
     * @param facebook facebook username of Contact to be updated
     */
    public void updateContact(String fullName, String fName, String lName, String phoneNo, String email, String address,
                              String github, String twitter, String linkedIn, String facebook) {
        for (int i = 0; i < contacts.size(); i++) {
            String firstName = contacts.get(i).getFirstName();
            String lastName = contacts.get(i).getLastName();
            String full = firstName + " " + lastName;
            String fullNoSpace = firstName + lastName;
            if (full.equalsIgnoreCase(fullName) || fullNoSpace.equalsIgnoreCase(fullName)) {
                Contact contact = contacts.get(i);
                contact.setFirstName(fName);
                contact.setLastName(lName);
                contact.setPhoneNo(phoneNo);
                contact.setEmail(email);
                contact.setAddress(address);
                contact.setGithub(github);
                contact.setTwitter(twitter);
                contact.setLinkedIn(linkedIn);
                contact.setFacebook(facebook);
            }
            }
    }
    }
