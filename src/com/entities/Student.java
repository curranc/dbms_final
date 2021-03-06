package com.entities;

/**
 * Created by abatewongc on 3/28/2016.
 */
public class Student {

    private int studentID, gradYear;
    private CourseSection[] sectionsTaken;
    private String fName, lName, email, linkedInURL, facebookURL, phoneNumber, twitterURL;
    private String[] otherSocialMediaURLs;

    public Student(){}

    public Student(int studentID, String fName, String lName, String email) {
        this.studentID = studentID;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CourseSection[] getSectionsTaken() {
        return sectionsTaken;
    }

    public void setSectionsTaken(CourseSection[] sectionsTaken) {
        this.sectionsTaken = sectionsTaken;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedInURL() {
        return linkedInURL;
    }

    public void setLinkedInURL(String linkedInURL) {
        this.linkedInURL = linkedInURL;
    }

    public String getFacebookURL() {
        return facebookURL;
    }

    public void setFacebookURL(String facebookURL) {
        this.facebookURL = facebookURL;
    }

    public String getTwitterURL() {
        return twitterURL;
    }

    public void setTwitterURL(String twitterURL) {
        this.twitterURL = twitterURL;
    }

    public String[] getOtherSocialMediaURLs() {
        return otherSocialMediaURLs;
    }

    public void setOtherSocialMediaURLs(String[] otherSocialMediaURLs) {
        this.otherSocialMediaURLs = otherSocialMediaURLs;
    }
}
