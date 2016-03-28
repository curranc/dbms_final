package com.entities;

/**
 * Created by abatewongc on 3/28/2016.
 */
public class Section {
    private int sectionID, courseID, locationID, TimeID;

    public Section(int sectionID, int courseID, int locationID, int timeID) {
        this.sectionID = sectionID;
        this.courseID = courseID;
        this.locationID = locationID;
        TimeID = timeID;
    }

    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getTimeID() {
        return TimeID;
    }

    public void setTimeID(int timeID) {
        TimeID = timeID;
    }
}
