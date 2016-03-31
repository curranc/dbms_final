package com.entities;

/**
 * Created by abatewongc on 3/28/2016.
 */
public class College {
    private int collegeID, deanID;
    private String collegeName;

    public College(int collegeID, String collegeName) {
        this.collegeID = collegeID;
        this.collegeName = collegeName;
    }
    public College(){}

    public int getCollegeID() {

        return collegeID;
    }

    public int getDeanID() {
        return deanID;
    }

    public void setDeanID(int deanID) {
        this.deanID = deanID;
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
