package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Christian on 11/25/2015.
 */
public class privateLib {
    public static void writeStringToConsole(String string) {
        System.out.println(string);
    }
    public static void writeNSStringToConsole(String string) {
        System.out.print(string);
    }
    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
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


}
