package com.errigal;

import com.errigal.sorters.FirstNameSorter;
import com.errigal.sorters.SurnameSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * The AddressBookTest class stores unit tests
 * designed to prove the logic contained in the program
 * @author Ben Capper
 */
public class AddressBookTest {

    AddressBook addressBook;
    Contact contact;


    @BeforeEach
    public void setup(){
       addressBook = new AddressBook();
       contact = new Contact("Ben", "Capper", "0851121720", "BenCapper19@Gmail.com",
                "The Garden, Arthurstown, New Ross, Wexford", "BenCapper", "Bcapper", "Ben-Capper", "bCapper");
       addressBook.addContact(contact);
    }

    @Test
    @DisplayName("Add Contact to ArrayList")
    public void shouldCreateContact() {
        Assertions.assertEquals(1, addressBook.contactCounter());
        Contact newContact = new Contact("Ellie", "Zane", "0857530242", "EllieZane31@Microsoft.com",
                "10 Key Lane, Herbert Street, Dublin", "ElleMS", "EllieZ", "Ellie-Zane", "EllieZane");
        addressBook.addContact(newContact);
        Assertions.assertEquals(2, addressBook.contactCounter());
    }

    @Test
    @DisplayName("Get a Contact by Index")
    public void shouldGetSpecificContactByIndex() {
        Assertions.assertTrue(addressBook.getContact(0).getFirstName().matches(contact.getFirstName()));
        Assertions.assertEquals(contact, addressBook.getContact(0));
    }

    @Test
    @DisplayName("Get ArrayList Length")
    public void shouldReturnContactsArrayLength(){
        Assertions.assertEquals(1, addressBook.contactCounter());
    }

    @Test
    @DisplayName("Add Contact toString to a String Variable")
    public void shouldAddObjectInArrayToString(){
        String addedContact = addressBook.getContact(0).toString();
        Assertions.assertFalse(addedContact.isEmpty());
        Assertions.assertTrue(addedContact.substring(6,9).matches(contact.getFirstName()));
    }

    @Test
    @DisplayName("Make Full Name from Separate First Name and Surname")
    public void shouldAddFirstAndLastNamesToString(){
        String name = addressBook.getContact(0).getFirstName() + " " + addressBook.getContact(0).getLastName();
        Assertions.assertEquals("Ben Capper", name);
    }

    @Test
    @DisplayName("Sorting By First Name")
    public void shouldSortContactsByFirstName() {
        Contact newContact = new Contact("Ellie", "Zane", "0857530242", "EllieZane31@Microsoft.com",
                "10 Key Lane, Herbert Street, Dublin", "ElleMS", "EllieZ", "Ellie-Zane", "EllieZane");
        Contact newContact1 = new Contact("Amy", "Johnson", "0876542524", "AmyJ21@Gmail.com",
                "3 Harbour st, Tullamore, Offaly", "AmyJ21", "AmyJ1", "Amy-Johnson", "AlexJohnson");
        addressBook.addContact(newContact);
        addressBook.addContact(newContact1);
        Assertions.assertEquals("Ben", addressBook.getContact(0).getFirstName());
        Assertions.assertEquals("Ellie", addressBook.getContact(1).getFirstName());
        Assertions.assertEquals("Amy", addressBook.getContact(2).getFirstName());
        addressBook.contacts.sort(new FirstNameSorter());
        Assertions.assertEquals("Amy", addressBook.getContact(0).getFirstName());
        Assertions.assertEquals("Ben", addressBook.getContact(1).getFirstName());
        Assertions.assertEquals("Ellie", addressBook.getContact(2).getFirstName());
    }

    @Test
    @DisplayName("Sorting By Surname")
    public void shouldSortContactsBySurname() {
        Contact newContact = new Contact("Ellie", "Zane", "0857530242", "EllieZane31@Microsoft.com",
                "10 Key Lane, Herbert Street, Dublin", "ElleMS", "EllieZ", "Ellie-Zane", "EllieZane");
        Contact newContact1 = new Contact("Amy", "Johnson", "0876542524", "AmyJ21@Gmail.com",
                "3 Harbour st, Tullamore, Offaly", "AmyJ21", "AmyJ1", "Amy-Johnson", "AlexJohnson");
        addressBook.addContact(newContact);
        addressBook.addContact(newContact1);
        Assertions.assertEquals("Capper", addressBook.getContact(0).getLastName());
        Assertions.assertEquals("Zane", addressBook.getContact(1).getLastName());
        Assertions.assertEquals("Johnson", addressBook.getContact(2).getLastName());
        addressBook.contacts.sort(new SurnameSorter());
        Assertions.assertEquals("Capper", addressBook.getContact(0).getLastName());
        Assertions.assertEquals("Johnson", addressBook.getContact(1).getLastName());
        Assertions.assertEquals("Zane", addressBook.getContact(2).getLastName());
    }


    @Test
    @DisplayName("Search for a Contact by Full Name")
    public void shouldSearchForSpecificContactByName() {
        Contact foundContact = addressBook.searchForContact("BenCapper");
        Assertions.assertEquals("Ben", foundContact.getFirstName());

        Contact foundContact1 = addressBook.searchForContact("BeN cApPeR");
        Assertions.assertEquals("Ben", foundContact1.getFirstName());

        Contact foundContact2 = addressBook.searchForContact("bencapper");
        Assertions.assertEquals("Ben", foundContact2.getFirstName());
    }

    @Test
    @DisplayName("Deleting a Contact by Full Name using Capitals")
    public void shouldDeleteContactByNameCapitals() {
        assertEquals(1, addressBook.contactCounter());
        addressBook.deleteContact("Ben Capper");
        Assertions.assertEquals(0, addressBook.contactCounter());

        addressBook.addContact(contact);

        assertEquals(1, addressBook.contactCounter());
        addressBook.deleteContact("BenCapper");
        Assertions.assertEquals(0, addressBook.contactCounter());
    }

    @Test
    @DisplayName("Deleting a Contact by Full Name using Lowercase")
    public void shouldDeleteContactByNameLowercase() {
        assertEquals(1, addressBook.contactCounter());
        addressBook.deleteContact("ben capper");
        Assertions.assertEquals(0, addressBook.contactCounter());

        addressBook.addContact(contact);

        assertEquals(1, addressBook.contactCounter());
        addressBook.deleteContact("bencapper");
        Assertions.assertEquals(0, addressBook.contactCounter());
    }

    @Test
    @DisplayName("Updating all Contact attributes")
    public void shouldUpdateContactSpecifiedByName() {
        Contact updateContact = addressBook.getContact(0);

        Assertions.assertEquals("Ben", updateContact.getFirstName());
        updateContact.setFirstName("First Name");
        Assertions.assertEquals("First Name", updateContact.getFirstName());

        Assertions.assertEquals("Capper", updateContact.getLastName());
        updateContact.setLastName("Surname");
        Assertions.assertEquals("Surname", updateContact.getLastName());

        Assertions.assertEquals("0851121720", updateContact.getPhoneNo());
        updateContact.setPhoneNo("Phone Number");
        Assertions.assertEquals("Phone Number", updateContact.getPhoneNo());

        Assertions.assertEquals("BenCapper19@Gmail.com", updateContact.getEmail());
        updateContact.setEmail("Email Address");
        Assertions.assertEquals("Email Address", updateContact.getEmail());

        Assertions.assertEquals("The Garden, Arthurstown, New Ross, Wexford", updateContact.getAddress());
        updateContact.setAddress("Address");
        Assertions.assertEquals("Address", updateContact.getAddress());

        Assertions.assertEquals("BenCapper", updateContact.getGithub());
        updateContact.setGithub("GitHub");
        Assertions.assertEquals("GitHub", updateContact.getGithub());

        Assertions.assertEquals("Bcapper", updateContact.getTwitter());
        updateContact.setTwitter("Twitter");
        Assertions.assertEquals("Twitter", updateContact.getTwitter());

        Assertions.assertEquals("Ben-Capper", updateContact.getLinkedIn());
        updateContact.setLinkedIn("LinkedIn");
        Assertions.assertEquals("LinkedIn", updateContact.getLinkedIn());

        Assertions.assertEquals("bCapper", updateContact.getFacebook());
        updateContact.setFacebook("Facebook");
        Assertions.assertEquals("Facebook", updateContact.getFacebook());
    }

}
