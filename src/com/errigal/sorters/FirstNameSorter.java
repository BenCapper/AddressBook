package com.errigal.sorters;

import com.errigal.Contact;

import java.util.Comparator;

/**
 * Class to implement Comparator methods allowing for sorting based on First Names
 */
public class FirstNameSorter implements Comparator<Contact>
{
    /**
     * Compares two contact object firstName attributes, returning result of
     * each comparison to the sort method which calls it.
     */
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
    }
}