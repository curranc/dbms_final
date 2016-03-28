package com.entities;

/**
 * Created by abatewongc on 3/28/2016.
 */
public class Professor {
    //TODO: Add in all values, constructors, and g/s methods

    private int professorID, departmentID, pSocialID, phoneNumber, extensionNumber, officeNumber;
    private String fName, lName, email, linkedInUrl, facebookURL, twitterURL;
    private String[] otherSocialMediaURLS;

    public Professor(){}

    public Professor(int professorID, String fName, String lName, String email) {
        this.professorID = professorID;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
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

    public int getPSocialID() {
        return pSocialID;
    }

    public void setPSocialID(int PSocialID) {
        this.pSocialID = PSocialID;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(int extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
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
