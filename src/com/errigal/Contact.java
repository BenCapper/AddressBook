package com.errigal;


/**
 * The Contact class stores the data that forms a Contact object
 * which can be manipulated via getters and setters.
 * @author Ben Capper
 */
public class Contact {

     //Contact attributes initialized
    private String fName, lName, phoneNo, email, address, github, twitter, linkedIn, facebook;

    /**
     * Contact constructor
     * @param fName Contacts First Name
     * @param lName Contacts Last Name
     * @param phoneNo Contacts Phone Number
     * @param email Contacts Email Address
     * @param address Contacts Address
     * @param github Contacts Github Username
     * @param twitter Contacts Twitter Username
     * @param linkedIn Contacts LinkedIn Username
     * @param facebook Contacts Facebook Username
     */
    public Contact(String fName, String lName, String phoneNo, String email, String address,
                   String github, String twitter, String linkedIn, String facebook){
        this.fName = fName;
        this.lName = lName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.github = github;
        this.twitter = twitter;
        this.linkedIn = linkedIn;
        this.facebook = facebook;
    }

    /**
     * Contact constructor
     * @param fName Contacts First Name
     * @param lName Contacts Last Name
     * @param phoneNo Contacts Phone Number
     * @param email Contacts Email Address
     * @param address Contacts Address
     */
    public Contact(String fName, String lName, String phoneNo, String email, String address){
        this.fName = fName;
        this.lName = lName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
    }

    /**
     * Returns Contact's First Name
     * @return fName
     */
    public String getFirstName() {
        return fName;
    }

    /**
     * Sets Contact's First Name
     * @param fName Contacts First Name
     */
    public void setFirstName(String fName) {
        this.fName = fName;
    }

    /**
     * Returns Contact's Surname
     * @return lName
     */
    public String getLastName() {
        return lName;
    }

    /**
     * Sets Contact's Surname
     * @param lName Contacts Surname
     */
    public void setLastName(String lName) {
        this.lName = lName;
    }

    /**
     * Returns Contact's Phone Number
     * @return phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets Contact's Phone Number
     * @param phoneNo Contacts Phone Number
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Returns Contact's Email Address
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets Contact's Email Address
     * @param email Contacts Email Address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns Contact's Address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets Contact's Address
     * @param address Contacts Address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns Contact's Github Username
     * @return github
     */
    public String getGithub() {
        return github;
    }

    /**
     * Sets Contact's Github Username
     * @param github Contacts Github Username
     */
    public void setGithub(String github) {
        this.github = github;
    }

    /**
     * Returns Contact's Twitter Username
     * @return twitter
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * Sets Contact's Twitter Username
     * @param twitter Contacts Twitter Username
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    /**
     * Returns Contact's LinkedIn Username
     * @return linkedIn
     */
    public String getLinkedIn() {
        return linkedIn;
    }

    /**
     * Sets Contact's LinkedIn Username
     * @param linkedIn Contacts linkedIn Username
     */
    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    /**
     * Returns Contact's Facebook Username
     * @return facebook
     */
    public String getFacebook() {
        return facebook;
    }

    /**
     * Sets Contact's Facebook Username
     * @param facebook Contacts Facebook Username
     */
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    /**
     * Returns all Contact Information
     * @return Contact
     */
    @Override
    public String toString() {
        return
                "Name: " + fName + " " + lName + "\n" +
                " -   Phone Number: " + phoneNo + "\n" +
                " -   Email Address: " + email + "\n" +
                " -   Address: " + address + "\n" +
                " -   GitHub: " + github + "\n" +
                " -   Twitter: " + twitter + "\n" +
                " -   LinkedIn: " + linkedIn + "\n" +
                " -   Facebook: " + facebook + "\n";
    }
}