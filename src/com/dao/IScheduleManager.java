package com.dao;


import com.entities.*;

/**
 * Created by abatewongc on 3/28/2016.
 */
public interface IScheduleManager {


    enum EntityType {
        COLLEGE,
        COURSE,
        DEPARTMENT,
        PROFESSOR,
        SECTION,
        STUDENT,
        TIME_SLOT,
        LOCATION
    }

    /**
     * Run this once to make the database.
     *
     */
    void createScheduleManagerDB();

    /**
     * Default method for creating accounts (essential information)
     * @param isStudent whether or not to insert into professor or student
     * @param fName first name
     * @param lName last name
     * @param email email address
     * @param password password
     * @param confirmPassword confirm password
     */
    void insertAccount(boolean isStudent, String fName, String lName, String email, String password, String confirmPassword);

    /**
     *  Returns an object
     * @param id the id of the entity we're looking for
     * @param entityType the type of entity we want
     * @return a new object with the relevant data filled out
     */
    Object selectByID(int id, EntityType entityType);

    /**
     * Returns an array of courses taught or taken
     * @param id
     * @param entityType type of entity we're looking up (professor or department)
     * @return an array of new courses with the relevant data filled out
     */
    Course[] getCoursesForID(int id, EntityType entityType);

    /**
     * Returns all of the sections for a course ID
     * @param id course ID
     * @return a list of new sections with the relevant data filled out
     */
    CourseSection[] getSectionsForCourseID(int id);

    /**
     * Returns an array of TimeSlots for ID
     * @param id student/professor id
     * @param entityType type of entity, fails otherwise
     * @return a list of new timeslots with the times that the id is already booked
     *         (because I think it would be easier to do it this way rather than getting the available times)
     */
    TimeSlot[] getUnvailableTimesForID(int id, EntityType entityType);

    /**
     * Returns a list of professors for the id
     * @param id professor id
     * @param entityType professor type, fails otherwise
     * @return a new list of professors with relevant data filled out
     */
    Professor[] getProfessorsForCourseID(int id, EntityType entityType);
    Professor[] getProfessorsForDepartmentID(int id, EntityType entityType);



    void insert(Object object, EntityType entityType);

    /**
     * Clears course information. Used at the end of a semester.
     * //TODO: implement semesters, add an add-to-history method
     * @param id
     * @param entityType
     */
    void clearCourseInformation(int id, EntityType entityType);

    void delete(int id, EntityType entityType);

}
