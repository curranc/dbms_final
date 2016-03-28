package com.entities;

/**
 * Created by abatewongc on 3/28/2016.
 */
public class Department {
    private int departmentID, departmentChairID, collegeID;
    private int[] courseIDs;
    private String departmentName;
    private String websiteURL;

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getDepartmentChairID() {
        return departmentChairID;
    }

    public void setDepartmentChairID(int departmentChairID) {
        this.departmentChairID = departmentChairID;
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public int[] getCourseIDs() {
        return courseIDs;
    }

    public void setCourseIDs(int[] courseIDs) {
        this.courseIDs = courseIDs;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public Department(int departmentID, int departmentChairID, int collegeID, int[] courseIDs, String departmentName, String websiteURL) {
        this.departmentID = departmentID;
        this.departmentChairID = departmentChairID;
        this.collegeID = collegeID;
        this.courseIDs = courseIDs;
        this.departmentName = departmentName;
        this.websiteURL = websiteURL;
    }
    public Department(){}


}
