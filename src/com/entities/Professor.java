package com.entities;

/**
 * Created by abatewongc on 3/28/2016.
 */
public class Professor {

    private int professorID, departmentID;
    private String fName, lName, email, title, linkedInUrl, facebookURL, twitterURL, phoneNumber, extensionNumber, officeNumber;
    private String[] otherSocialMediaURLS;
    private CourseSection[] sectionsTaught;

    public Professor(){}

    public Professor(int professorID, String fName, String lName, String title, String email) {
        this.professorID = professorID;
        this.title = title;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
    }

    public CourseSection[] getSectionsTaught() {
        return sectionsTaught;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSectionsTaught(CourseSection[] sectionsTaught) {
        this.sectionsTaught = sectionsTaught;
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(String extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
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

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
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

    public String[] getOtherSocialMediaURLS() {
        return otherSocialMediaURLS;
    }

    public void setOtherSocialMediaURLS(String[] otherSocialMediaURLS) {
        this.otherSocialMediaURLS = otherSocialMediaURLS;
    }
}
