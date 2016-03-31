package com.entities;


/**
 * Created by abatewongc on 3/28/2016.
 */


public class CourseSection {
    private int sectionID, courseID, professorID, locationID;
    private TimeSlot timeSlot;

    public CourseSection(int sectionID, int courseID, int professorID, int locationID, TimeSlot timeSlot) {
        this.sectionID = sectionID;
        this.courseID = courseID;
        this.professorID = professorID;
        this.locationID = locationID;
        this.timeSlot = timeSlot;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public CourseSection(){}

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
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
