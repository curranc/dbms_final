package com.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Created by Christian on 11/24/2015.
 */
public class connectionConfig {
    public static Connection getConnectionPerson() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(reference.DATABASE_ADDRESS, reference.DATABASE_ADMIN, reference.DATABASE_PASSWORD);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static Connection getChinookConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(reference.CHINOOK_ADDRESS, reference.CHINOOK_ADMIN, reference.CHINOOK_PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static Connection getConnection(String address, String admin, String password) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(address, admin, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }


}
