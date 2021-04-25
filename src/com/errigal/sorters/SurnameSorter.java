package com.errigal.sorters;

import com.errigal.Contact;

import java.util.Comparator;
/**
 * Class to implement Comparator methods allowing for sorting based on Surnames
 */
public class SurnameSorter implements Comparator<Contact>
{
    /**
     * Compares two contact object lastName attributes, returning result of
     * each comparison to the sort method which calls it.
     */
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    }
}