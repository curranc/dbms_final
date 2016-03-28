package com.daoimpl;

import com.dao.PersonDao;
import com.entities.Person;
import com.util.connectionConfig;
import com.util.privateLib;

import java.sql.*;
import java.util.List;

/**
 * Created by abatewongc on 11/24/2015.
 */
public class PersonDaoImpl implements PersonDao {
    private static Person loadResultSet(ResultSet resultSet, Person person) {
        try {
            while(resultSet.next()) {
                person.setId(resultSet.getInt("id"));
                person.setUserName(resultSet.getString("userName"));
                person.setPassword(resultSet.getString("password"));
                person.setBalance(resultSet.getInt("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }


    @Override
    public void createPersonEntry() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = connectionConfig.getConnectionPerson();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS person (id int primary key unique auto_increment," +
                    "userName varchar(55), password varchar(55), balance decimal(10,2));");
        } catch( Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null){
                try {
                    statement.close();
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
        }
    }
    @Override
    public void insert(Person person) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionConfig.getConnectionPerson();
            preparedStatement = connection.prepareStatement("INSERT INTO person (userName,password,balance)" +
                "VALUES (?,?,?);");
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.setDouble(3, 0.00);
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO person (userName,password,balance)" +
                    "VALUES (?,?,?);");
        } catch(Exception e){
            e.printStackTrace();
        } finally {
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
        }
    }
    @Override
    public Person selectByID(int id) {
        Person person = new Person();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionConfig.getConnectionPerson();
            preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            loadResultSet(resultSet, person);

        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(preparedStatement != null) {
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

        }
        return person;
    }
    @Override
    public Person selectByUsername(String userName) {
        Person person = new Person();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionConfig.getConnectionPerson();
            preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE userName = ?;");
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();

            loadResultSet(resultSet, person);
        }catch (Exception e) {
            e.printStackTrace();

        } finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(preparedStatement != null) {
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

        }
        return person;
    }
    @Override
    public List<Person> selectAll() {
        return null;
    }
    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionConfig.getConnectionPerson();
            preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            privateLib.writeStringToConsole("");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(preparedStatement != null) {
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
        }
    }
    @Override
    public void updateBalance(Person person, double balance, double value) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionConfig.getConnectionPerson();
            preparedStatement = connection.prepareStatement("UPDATE person SET " +
                "userName = ?, password = ?, balance = ? WHERE id = " + person.getId() + ";");
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.setDouble(3, balance + value);
            preparedStatement.executeUpdate();

            System.out.println("UPDATE person SET " +
                    "userName = ?, password = ?, balance = ?;");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            }
    }
    @Override
    public void depositBalance(Person person, double value) {
        updateBalance(person, person.getBalance(), value);
    }
    @Override
    public void withdrawBalance(Person person, double value) {
        updateBalance(person, person.getBalance(), (value * -1));
    }
    @Override
    public void createAccount(String userName, String password, String passwordConfirm) {
        if(password.equals(passwordConfirm)) {

            Person person = new Person(userName, password);
            insert(person);
        }
        else {
            //say the shit was incorrect and make them try again
        }
    }



}
