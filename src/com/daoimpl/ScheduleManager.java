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
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Object getEntityTypeForEnum(EntityType entityType) {
        switch (entityType) {
            case COLLEGE:
                return new College();
            case SECTION:
                return new CourseSection();
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
            case LOCATION:
                return new Location();
        }
        privateLib.writeStringToConsole("Nonvalid Entity-Type, returning null because I'm a dick!");
        return null;

    }
    private static String getEntityNameForEnum(EntityType entityType) {
        switch (entityType) {
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
            case LOCATION:
                return "location";
        }
        privateLib.writeStringToConsole("Nonvalid Entity-Type, returning null because I'm a dick!");
        return null;
    }
    private static PreparedStatement prepareStatementForEnum(EntityType entityType, PreparedStatement preparedStatement, Connection connection){
        switch (entityType) {
            //TODO: Add joins!
            case COLLEGE:
                try {
                    return preparedStatement = connection.prepareStatement("SELECT * FROM College WHERE CollegeID = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case SECTION:
                try {
                    return preparedStatement = connection.prepareStatement("SELECT * FROM CourseSection WHERE SectionID = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case STUDENT:
                try {
                    return preparedStatement = connection.prepareStatement("SELECT * FROM Student WHERE StudentID = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            case PROFESSOR:
                try {
                    return preparedStatement = connection.prepareStatement("SELECT * FROM Professor WHERE ProfessorID = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case DEPARTMENT:
                try {
                    return preparedStatement = connection.prepareStatement("SELECT * FROM Department WHERE DepartmentID = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case COURSE:
                try {
                    return preparedStatement = connection.prepareStatement("SELECT * FROM Course WHERE CourseID = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case TIME_SLOT:

            case LOCATION:
                try {
                    return preparedStatement = connection.prepareStatement("SELECT * FROM Location WHERE LocationID = ?");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        privateLib.writeStringToConsole("Nonvalid Entity-Type, returning null because I'm a dick!");
        return preparedStatement;
    }



    /**
     * One of the most atrocious methods I've ever written. God help us all.
     * @param object the original object
     * @param resultSet the data
     * @return an object with the non-array values filled out from the resultSet
     */
    private static Object loadNonArrayResultSet(Object object, ResultSet resultSet) {

        if (object instanceof College) {
            try {
                while (resultSet.next()) {
                    ((College) object).setCollegeID(resultSet.getInt("collegeID"));
                    ((College) object).setCollegeName(resultSet.getString("collegeName"));
                    ((College) object).setDeanID(resultSet.getInt("deadID"));


                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (object instanceof Course) {
            try {
                while (resultSet.next()) {
                    ((Course) object).setCourseID(resultSet.getString("courseID"));
                    ((Course) object).setCourseTitle(resultSet.getString("courseTitle"));
                    ((Course) object).setDepartmentID(resultSet.getInt("departmentID"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if (object instanceof Department) {
            try {
                while (resultSet.next()) {
                    ((Department) object).setCollegeID(resultSet.getInt("collegeID"));
                    ((Department) object).setDepartmentChairID(resultSet.getInt("departmentChairID"));
                    ((Department) object).setDepartmentID(resultSet.getInt("departmentID"));
                    ((Department) object).setDepartmentName(resultSet.getString("departmentName"));
                    ((Department) object).setWebsiteURL(resultSet.getString("websiteURL"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if (object instanceof Professor) {
            try {
                while (resultSet.next()) {
                    ((Professor) object).setDepartmentID(resultSet.getInt("departmentID"));
                    ((Professor) object).setEmail(resultSet.getString("email"));
                    ((Professor) object).setExtensionNumber(resultSet.getString("extensionNumber"));
                    ((Professor) object).setFacebookURL(resultSet.getString("facebookURL"));
                    ((Professor) object).setLinkedInUrl(resultSet.getString("linkedInURL"));
                    ((Professor) object).setfName(resultSet.getString("fName"));
                    ((Professor) object).setlName(resultSet.getString("lName"));
                    ((Professor) object).setOfficeNumber(resultSet.getString("officeNumber"));
                    ((Professor) object).setPhoneNumber(resultSet.getString("phoneNumber"));
                    ((Professor) object).setProfessorID(resultSet.getInt("professorID"));
                    ((Professor) object).setTwitterURL(resultSet.getString("twitterURL"));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if (object instanceof CourseSection) {
            try {
                while (resultSet.next()) {
                    ((CourseSection) object).setCourseID(resultSet.getInt("courseID"));
                    ((CourseSection) object).setLocationID(resultSet.getInt("locationID"));
                    ((CourseSection) object).setProfessorID(resultSet.getInt("professorID"));
                    ((CourseSection) object).setTimeSlot(new TimeSlot(resultSet.getString("timeStart"), resultSet.getString("timeEnd"), resultSet.getInt("day")));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } else if (object instanceof Student) {
            try {
                while (resultSet.next()) {
                    ((Student) object).setEmail(resultSet.getString("email"));
                    ((Student) object).setFacebookURL(resultSet.getString("facebook"));
                    ((Student) object).setfName(resultSet.getString("fname"));
                    ((Student) object).setGradYear(resultSet.getInt("gradyear"));
                    ((Student) object).setLinkedInURL(resultSet.getString("linkedin"));
                    ((Student) object).setlName(resultSet.getString("lname"));
                    ((Student) object).setPhoneNumber(resultSet.getString("phone"));
                    ((Student) object).setStudentID(resultSet.getInt("studentID"));
                    ((Student) object).setTwitterURL(resultSet.getString("twitter"));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (object instanceof TimeSlot) {
            privateLib.writeStringToConsole("What the heck just happened? We can't load a TimeSlot! There's no TimeTable!");
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
        if (object != null) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            try {
                connection = connectionConfig.getConnection(reference.DBMS_FINAL, reference.DBMS_ADMIN, reference.DBMS_PASS);
                preparedStatement = prepareStatementForEnum(entityType, preparedStatement, connection);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();
                object = loadNonArrayResultSet(object, resultSet);
            } catch (Exception e) {
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
    public CourseSection[] getSectionsForCourseID(int id) {
        return new CourseSection[0];
    }

    @Override
    public TimeSlot[] getUnavailableTimesForID(int id, EntityType entityType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Object object = getEntityTypeForEnum(entityType);
        object = selectByID(id, entityType);
        if (object instanceof Student) {
            CourseSection[] times = ((Student) object).getSectionsTaken();
            TimeSlot[] timeSlots = new TimeSlot[times.length];
            for(int i = 0; i < times.length; i++) {
                timeSlots[i] = times[i].getTimeSlot();
            }
            return timeSlots;
        }
        if(object instanceof Professor){
            CourseSection[] times = ((Professor) object).getSectionsTaught();
            TimeSlot[] timeSlots = new TimeSlot[times.length];
            for(int i = 0; i < times.length; i++){
                timeSlots[i] = times[i].getTimeSlot();
            }
            return timeSlots;
        }
        return null;
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
    public void clearSectionInformation(int id, EntityType entityType) {

    }

    @Override
    public void delete(int id, EntityType entityType) {

    }
}