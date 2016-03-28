package com.dao;


import com.entities.Course;
import com.entities.Professor;
import com.entities.Section;
import com.entities.Student;

/**
 * Created by abatewongc on 3/28/2016.
 */
public interface IScheduleManager {

    void createScheduleManagerDB();
    void createAccount(boolean isStudent, String fName, String lName, String email, String password, String confirmPassword);


    Object selectByID(int id);

    Course[] getCoursesForID(int id);

    Section[] getSectionsForCourseID(int id);

    int[] getAvailableTimesForID(int id);

    Professor[] getProfessorsForCourseID(int id);
    Professor[] getProfessorsForDepartmentID(int id);


    void insert(Object object);



    void delete(int id);

}
