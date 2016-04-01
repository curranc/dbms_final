package com.daoimpl;

import com.dao.IScheduleManager;
import com.entities.*;
import com.util.connectionConfig;
import com.util.privateLib;
import com.util.reference;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

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
    private static void closeConnection(PreparedStatement preparedStatement, ResultSet resultSet) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
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
                    preparedStatement = connection.prepareStatement("SELECT * FROM College WHERE CollegeID IN ?");
                    return preparedStatement;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case SECTION:
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM CourseSection WHERE SectionID IN ?");
                    return preparedStatement;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case STUDENT:
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM Student WHERE StudentID IN ?");
                    return preparedStatement;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            case PROFESSOR:
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM Professor WHERE ProfessorID IN ?");
                    return preparedStatement;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case DEPARTMENT:
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM Department WHERE DepartmentID IN ?");
                    return preparedStatement;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case COURSE:
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM Course WHERE CourseID IN ?");
                    return preparedStatement;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case TIME_SLOT:

            case LOCATION:
                try {
                    preparedStatement = connection.prepareStatement("SELECT * FROM Location WHERE LocationID IN ?");
                    return preparedStatement;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        privateLib.writeStringToConsole("Nonvalid Entity-Type, returning null because I'm a dick!");
        return preparedStatement;
    }



    /**
     * One of the most atrocious methods I've ever written. God help us all.
     * Only call this when you want every possible field filled out (NOT CHILD OBJECTS ATM)
     * @param objects the original list of objects
     * @param resultSet the data
     * @return an object ArrayList with the non-array values filled out from the resultSet
     */
    private static ArrayList<Object> loadArrayResultSet(ArrayList<Object> objects, ResultSet resultSet, EntityType entityType) {
        int i = 0;
        switch(entityType) {
            case COLLEGE:

                try {
                    while (resultSet.next()) {
                        College college = new College();
                        college.setCollegeID(resultSet.getInt("collegeID"));
                        college.setCollegeName(resultSet.getString("collegeName"));
                        college.setDeanID(resultSet.getInt("deanID"));

                        objects.add(college);
                        i++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return objects;
            case COURSE:
                try {

                    while (resultSet.next()) {
                        Course course = new Course();
                        course.setCourseID(resultSet.getString("courseID"));
                        course.setCourseTitle(resultSet.getString("courseTitle"));
                        course.setDepartmentID(resultSet.getInt("departmentID"));

                        objects.add(course);
                        i++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return objects;
            case DEPARTMENT:
                try {
                    while (resultSet.next()) {
                        Department department = new Department();
                        department.setCollegeID(resultSet.getInt("collegeID"));
                        department.setDepartmentChairID(resultSet.getInt("departmentChairID"));
                        department.setDepartmentID(resultSet.getInt("departmentID"));
                        department.setDepartmentName(resultSet.getString("departmentName"));
                        department.setWebsiteURL(resultSet.getString("websiteURL"));

                        objects.add(department);
                        i++;
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return objects;
            case PROFESSOR:
                try {
                    while (resultSet.next()) {
                        Professor professor = new Professor();
                        professor.setDepartmentID(resultSet.getInt("departmentID"));
                        professor.setEmail(resultSet.getString("email"));
                        professor.setExtensionNumber(resultSet.getString("extensionNumber"));
                        professor.setFacebookURL(resultSet.getString("facebookURL"));
                        professor.setLinkedInUrl(resultSet.getString("linkedInURL"));
                        professor.setfName(resultSet.getString("fName"));
                        professor.setlName(resultSet.getString("lName"));
                        professor.setOfficeNumber(resultSet.getString("officeNumber"));
                        professor.setPhoneNumber(resultSet.getString("phoneNumber"));
                        professor.setProfessorID(resultSet.getInt("professorID"));
                        professor.setTwitterURL(resultSet.getString("twitterURL"));

                        objects.add(professor);
                        i++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return objects;
            case SECTION:
                try {
                    while (resultSet.next()) {
                        CourseSection section = new CourseSection();
                        section.setCourseID(resultSet.getInt("courseID"));
                        section.setLocationID(resultSet.getInt("locationID"));
                        section.setProfessorID(resultSet.getInt("professorID"));
                        section.setTimeSlot(new TimeSlot(resultSet.getString("timeStart"), resultSet.getString("timeEnd"), resultSet.getInt("day")));

                        objects.add(section);
                        i++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                return objects;
            case STUDENT:
                try {
                    while (resultSet.next()) {
                        Student student = new Student();

                        student.setEmail(resultSet.getString("email"));
                        student.setFacebookURL(resultSet.getString("facebook"));
                        student.setfName(resultSet.getString("fname"));
                        student.setGradYear(resultSet.getInt("gradyear"));
                        student.setLinkedInURL(resultSet.getString("linkedin"));
                        student.setlName(resultSet.getString("lname"));
                        student.setPhoneNumber(resultSet.getString("phone"));
                        student.setStudentID(resultSet.getInt("studentID"));
                        student.setTwitterURL(resultSet.getString("twitter"));

                        objects.add(student);
                        i++;

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return objects;
            case TIME_SLOT:
                privateLib.writeStringToConsole("What the heck just happened? We can't load a TimeSlot! There's no TimeTable!");
                return objects;
            case LOCATION:
                try {
                    while (resultSet.next()) {
                        Location location = new Location();

                        location.setLocationID(resultSet.getInt("locationID"));
                        location.setName(resultSet.getString("buildingName"));
                        location.setRoomNumber(resultSet.getInt("roomNum"));
                        i++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return objects;
        }
        return null;
    }
    @Override
    public void createScheduleManagerDB() {

    }

    @Override
    public void insertAccount(boolean isStudent, String fName, String lName, String email, String password, String confirmPassword) {

    }

    // Query methods
    @Override
    public ArrayList<Object> selectByID(ArrayList<Integer> ids, EntityType entityType) {
        ArrayList<Object> objects = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionConfig.getConnection(reference.DBMS_FINAL, reference.DBMS_ADMIN, reference.DBMS_PASS);
            preparedStatement = prepareStatementForEnum(entityType, preparedStatement, connection);
            if(preparedStatement != null) {
                preparedStatement.setArray(1, connection.createArrayOf("int", ids.toArray()));
                resultSet = preparedStatement.executeQuery();
                objects = loadArrayResultSet(objects, resultSet, entityType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, preparedStatement, resultSet);
        }
        return objects;
    }
    @SuppressWarnings("JpaQueryApiInspection")
    @Override
    public Course[] getCoursesForID(int id, EntityType entityType, Connection connection) {
        ArrayList<Object> courses = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //TODO: JOINS
            switch (entityType) {
                case PROFESSOR:
                    preparedStatement = connection.prepareStatement("SELECT DISTINCT *\n" +
                            "FROM Course\n" +
                            "WHERE Course.CourseID IN (\n" +
                            "\tSELECT CourseSection.CourseID\n" +
                            "\tFROM CourseSection\n" +
                            "\tWHERE CourseSection.ProfessorID = ?\n" +
                            ")");
                    preparedStatement.setInt(1, id);
                    resultSet = preparedStatement.executeQuery();
                    courses = loadArrayResultSet(courses, resultSet, EntityType.COURSE);
                    return (Course[]) courses.toArray();
                case STUDENT:
                    preparedStatement = connection.prepareStatement("SELECT DISTINCT *\n" +
                            "FROM Course\n" +
                            "WHERE Course.CourseID IN (\n" +
                            "\tSELECT Section.CourseID\n" +
                            "\tFROM Section\n" +
                            "\tWHERE Section.SectionID IN (\n" +
                            "\t\tSELECT Students_In_Section.SectionID\n" +
                            "\t\tFROM Students_In_Section\n" +
                            "\t\tWHERE Students_In_Section.StudentID = ?\n" +
                            ")");
                    preparedStatement.setInt(1, id);
                    resultSet = preparedStatement.executeQuery();
                    courses = loadArrayResultSet(courses, resultSet, EntityType.COURSE);
                    return (Course[]) courses.toArray();
                case DEPARTMENT:
                    preparedStatement = connection.prepareStatement("SELECT DISTINCT *\n" +
                            "FROM Course\n" +
                            "WHERE Course.CourseID IN (\n" +
                            "\tSELECT CourseSection.CourseID\n" +
                            "\tFROM CourseSection\n" +
                            "\tWHERE CourseSection.ProfessorID IN (\n" +
                            "\t\tSELECT Professor.ProfessorID\n" +
                            "\t\tFROM Professor\n" +
                            "\t\tWHERE Department.DepartmentID = ?\n" +
                            ")");
                    preparedStatement.setInt(1, id);
                    resultSet = preparedStatement.executeQuery();
                    courses = loadArrayResultSet(courses, resultSet, EntityType.COURSE);
                    return (Course[]) courses.toArray();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return null;
    }
    @Override
    public CourseSection[] getSectionsForCourseID(int id, Connection connection) {
        ArrayList<Object> sections = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //TODO: JOINS!
            preparedStatement = connection.prepareStatement("SELECT * \n" +
                    "FROM Section\n" +
                    "WHERE Section.CourseID = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            sections = loadArrayResultSet(sections, resultSet, EntityType.SECTION);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }

        return (CourseSection[]) sections.toArray();
    }
    @Override
    public TimeSlot[] getUnavailableTimesForID(int id, EntityType entityType) {
        Object object = getEntityTypeForEnum(entityType);
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(id);
        if(!(object instanceof Student) && !(object instanceof Professor))
            return null;
        object = selectByID(ids, entityType).get(0);
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
        privateLib.writeStringToConsole("Impossible message and return result.");
        return null;
    }
    @Override
    public Professor[] getProfessorsForCourseID(String id, Connection connection) {
        ArrayList<Object> professors = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //TODO: JOINS
            preparedStatement = connection.prepareStatement("SELECT * \n" +
                    "FROM Professor\n" +
                    "WHERE ProfessorID IN (\n" +
                    "\tSELECT professorID\n" +
                    "\tFROM Section\n" +
                    "\tWHERE Section.CourseID in ?\n" +
                    ")");
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();

            professors = loadArrayResultSet(professors, resultSet, EntityType.PROFESSOR);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return (Professor[]) professors.toArray();
    }
    @Override
    public int getIDFromEmail(String email, EntityType entityType, Connection connection) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            if(entityType == EntityType.STUDENT) {
                preparedStatement = connection.prepareStatement("SELECT StudentContact.StudentID\n" +
                        "FROM StudentContact\n" +
                        "WHERE StudentContact.Email = ?");
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();

                return resultSet.getInt(1);
            }
            if(entityType == EntityType.PROFESSOR) {
                preparedStatement = connection.prepareStatement("SELECT ProfessorContact.ProfID\n" +
                        "FROM ProfessorContact\n" +
                        "WHERE ProfessorContact.Email = ?");
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();

                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return -1;
    }
    @Override
    public int getCourseIDFromTitle(String courseTitle, Connection connection) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {

                preparedStatement = connection.prepareStatement("SELECT Course.CourseID\n" +
                        "FROM Course\n" +
                        "WHERE Course.CourseTitle = ?");
                preparedStatement.setString(1, courseTitle);
                resultSet = preparedStatement.executeQuery();

                return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(preparedStatement, resultSet);
        }
        return -1;
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