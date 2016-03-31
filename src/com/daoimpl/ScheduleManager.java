package com.daoimpl;

import com.dao.IScheduleManager;
import com.entities.*;
import com.util.connectionConfig;
import com.util.privateLib;
import com.util.reference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by abatewongc on 3/28/2016.
 */
public class ScheduleManager implements IScheduleManager {
    private static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private static Object getEntityTypeForEnum(EntityType entityType) {
        switch(entityType) {
            case COLLEGE:
                return new College();
            case SECTION:
                return new Section();
            case STUDENT:
                return new Student();
            case PROFESSOR:
                return new Professor();
            case DEPARTMENT:
                return new Department();
            case COURSE:
                return new Course();
            case TIME_SLOT:
                return new TimeSlot();
        }
        privateLib.writeStringToConsole("Nonvalid Entity-Type, returning null because I'm a dick!");
        return null;

    }
    private static String getEntityNameForEnum(EntityType entityType){
        switch(entityType) {
            case COLLEGE:
                return "college";
            case SECTION:
                return "section";
            case STUDENT:
                return "student";
            case PROFESSOR:
                return "professor";
            case DEPARTMENT:
                return "department";
            case COURSE:
                return "course";
            case TIME_SLOT:
                return "time_slot";
        }
        privateLib.writeStringToConsole("Nonvalid Entity-Type, returning null because I'm a dick!");
        return null;
    }
    private static Object loadResultSet(Object object, ResultSet resultSet){

        if(object instanceof College) {
            try {
                while(resultSet.next()){
                    ((College) object).setCollegeID(resultSet.getInt("collegeID"));
                    ((College) object).setCollegeName(resultSet.getString("collegeName"));
                    ((College) object).setDeanID(resultSet.getInt("deadID"));
                    return object;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if(object instanceof Course) {
            try {
                while(resultSet.next()){
                    ((Course) object).getCourseID();
                    ((Course) object).getCourseTitle();
                    ((Course) object).getDepartmentID();
                    ((Course) object).getSectionIDs();
                    ((Course) object).getCourseDescription();
                    return object;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if(object instanceof Department) {
            try {
                while(resultSet.next()){
                    ((Department) object).getDepartmentID();
                    ((Department) object).getCollegeID();
                    ((Department) object).getCourseIDs();
                    ((Department) object).getDepartmentChairID();
                    ((Department) object).getDepartmentName();
                    ((Department) object).getWebsiteURL();

                    return object;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if(object instanceof Professor) {
            try {
                while(resultSet.next()){
                    ((Professor) object).getDepartmentID();
                    ((Professor) object).getSectionIDs();
                    ((Professor) object).getEmail();
                    ((Professor) object).getExtensionNumber();
                    ((Professor) object).getFacebookURL();
                    ((Professor) object).getfName();
                    ((Professor) object).getlName();
                    ((Professor) object).getLinkedInUrl();
                    ((Professor) object).getOfficeNumber();
                    ((Professor) object).getOtherSocialMediaURLS();
                    ((Professor) object).getProfessorID();
                    ((Professor) object).getPhoneNumber();
                    ((Professor) object).getTwitterURL();
                    return object;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if(object instanceof Section) {
            try {
                while(resultSet.next()){
                    ((Section) object).getProfessorID();
                    ((Section) object).getCourseID();
                    ((Section) object).getLocationID();
                    ((Section) object).getSectionID();
                    ((Section) object).getTimeSlot();
                    return object;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if(object instanceof Student) {

        } else if(object instanceof TimeSlot) {

        }
        return object;
    }

    @Override
    public void createScheduleManagerDB() {

    }

    @Override
    public void insertAccount(boolean isStudent, String fName, String lName, String email, String password, String confirmPassword) {

    }

    @SuppressWarnings("JpaQueryApiInspection")
    @Override
    public Object selectByID(int id, EntityType entityType) {
        Object object = getEntityTypeForEnum(entityType);
        String tableName = getEntityNameForEnum(entityType);
        if(object != null){
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                connection = connectionConfig.getConnection(reference.DBMS_FINAL, reference.DBMS_ADMIN, reference.DBMS_PASS);
                preparedStatement = connection.prepareStatement("SELECT * FROM ? WHERE ? = ?");
                preparedStatement.setString(1, tableName);
                preparedStatement.setString(2, tableName.concat("ID"));
                preparedStatement.setInt(3, id);

                resultSet = preparedStatement.executeQuery();
                loadResultSet(object, resultSet);
            }catch (Exception e) {
                e.printStackTrace();

            } finally {
               closeConnection(connection, preparedStatement, resultSet);

            }

        }
        return object;
    }

    @Override
    public Course[] getCoursesForID(int id, EntityType entityType) {
        return new Course[0];
    }

    @Override
    public Section[] getSectionsForCourseID(int id) {
        return new Section[0];
    }

    @Override
    public TimeSlot[] getUnvailableTimesForID(int id, EntityType entityType) {
        return new TimeSlot[0];
    }

    @Override
    public Professor[] getProfessorsForCourseID(int id, EntityType entityType) {
        return new Professor[0];
    }

    @Override
    public Professor[] getProfessorsForDepartmentID(int id, EntityType entityType) {
        return new Professor[0];
    }

    @Override
    public void insert(Object object, EntityType entityType) {

    }

    @Override
    public void clearCourseInformation(int id) {

    }

    @Override
    public void delete(int id) {

    }
}
