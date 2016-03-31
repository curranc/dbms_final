package com.entities;

/**
 * Created by abatewongc on 3/28/2016.
 */
public class Course {

    private String courseID;
    private int[] sectionIDs;
    private String CourseTitle, courseDescription;
    private int DepartmentID;

    public Course(String courseID, String courseTitle, int departmentID){
        this.courseID = courseID;
        this.CourseTitle = courseTitle;
        this.DepartmentID = departmentID;
    }

    public Course() {}

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int[] getSectionIDs() {
        return sectionIDs;
    }

    public void setSectionIDs(int[] sectionIDs) {
        this.sectionIDs = sectionIDs;
    }

    public String getCourseTitle() {
        return CourseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        CourseTitle = courseTitle;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int departmentID) {
        DepartmentID = departmentID;
    }
}
