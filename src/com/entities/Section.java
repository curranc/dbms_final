package com.entities;

/**
 * Created by abatewongc on 3/28/2016.
 */


public class Section {
    private int sectionID, courseID, professorID, locationID, timeStart, timeEnd, day;

    public Section(int sectionID, int courseID, int professorID, int locationID, int timeStart, int timeEnd, int day) {
        this.sectionID = sectionID;
        this.courseID = courseID;
        this.professorID = professorID;
        this.locationID = locationID;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.day = day;
    }

    public Section(){}

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(int timeStart) {
        this.timeStart = timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(int timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
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
}
