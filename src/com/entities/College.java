package com.entities;

/**
 * Created by abatewongc on 3/28/2016.
 */
public class College {
    private int collegeID;
    private String collegeName;

    public College(int collegeID, String collegeName) {
        this.collegeID = collegeID;
        this.collegeName = collegeName;
    }

    public int getCollegeID() {

        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}
