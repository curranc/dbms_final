package com.daoimpl;

import com.dao.ChinookDao;
import com.util.connectionConfig;
import com.util.privateLib;

import java.sql.*;

/**
 * Created by abatewongc on 2/18/2016.
 */
public class ChinookDaoImpl implements ChinookDao {

    public void test() {
        this.getCustomersByCountry("Germany");
        this.getCustomersServed(4);
        this.getCustomerList();
        this.getEmployeeList();
        this.getCustomerInvoiceList(59);
    }
    private void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
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

    @Override
    public void getCustomersByCountry(String country) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionConfig.getChinookConnection();
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) as customers_in_city " +
                    "FROM Customer " +
                    "WHERE Customer.Country = ?" + ";");
            preparedStatement.setString(1, country);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                privateLib.writeStringToConsole(country + " has " + resultSet.getString("customers_in_city") + " customers in it.");
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, preparedStatement, resultSet);
        }
    }
    @Override
    public void getEmployeeList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionConfig.getChinookConnection();
            preparedStatement = connection.prepareStatement("SELECT Employee.EmployeeId AS  employee_id, Employee.FirstName as employee_fn, Employee.LastName as employee_ln, Employee.Title as employee_title\n" +
                    "FROM Employee\n" +
                    "ORDER BY Employee.EmployeeId");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                privateLib.writeStringToConsole(resultSet.getString("employee_id") + ". " + resultSet.getString("employee_fn") + " " + resultSet.getString("employee_ln") + " (" + resultSet.getString("employee_title") + ")");
            }
            privateLib.writeStringToConsole(" ");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, preparedStatement, resultSet);
        }
    }
    @Override
    public void getCustomersServed(int i) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionConfig.getChinookConnection();
            preparedStatement = connection.prepareStatement("SELECT COUNT(*) as customers_served\n" +
                    "FROM Customer\n" +
                    "WHERE Customer.SupportRepId =" + i + ";");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                privateLib.writeStringToConsole("This representative serves " + resultSet.getString(1) + " customers.");
            }
            privateLib.writeStringToConsole(" ");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, preparedStatement, resultSet);
        }
    }
    @Override
    public void getCustomerList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionConfig.getChinookConnection();
            preparedStatement = connection.prepareStatement("SELECT Customer.CustomerId AS  employee_id, Customer.FirstName as employee_fn, Customer.LastName as employee_ln, Customer.City as employee_title, Customer.State as customer_state, Customer.Country as customer_country\n" +
                    "FROM Customer\n" +
                    "ORDER BY Customer.CustomerId");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                privateLib.writeStringToConsole(resultSet.getString("employee_id") + ". " + resultSet.getString("employee_fn") + " " + resultSet.getString("employee_ln") + " (" + resultSet.getString("employee_title") + " " + resultSet.getString("customer_state") + " " + resultSet.getString("customer_country")+ ")");
            }
            privateLib.writeStringToConsole(" ");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, preparedStatement, resultSet);
        }

    }
    @Override
    public void getCustomerInvoiceList(int i) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int length = 0;
        try {
            connection = connectionConfig.getChinookConnection();
            preparedStatement = connection.prepareStatement("SELECT  InvoiceId, SUM(InvoiceLine.Quantity * InvoiceLine.UnitPrice) as total " +
                    "FROM InvoiceLine " +
                    "WHERE InvoiceLine.InvoiceId In ( " +
                    "SELECT Invoice.InvoiceId " +
                    "FROM Invoice " +
                    "WHERE Invoice.CustomerId = "+ i +
                    ") " +
                    "GROUP BY InvoiceLine.InvoiceId");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                length++;
             }
            resultSet.first();
            double[] table = new double[length];
            int count = 0;
            while(count < length) {
                table[count] = resultSet.getDouble(2);
                resultSet.next();
                count++;
            }
            count = 0;

            resultSet.first();

            preparedStatement = connection.prepareStatement("" +
                    "SELECT InvoiceLine.InvoiceId as invoice_id, InvoiceLine.InvoiceLineId as invoiceline_id, Track.Name as track_name, Album.Title as album_title, Artist.Name as artist_name, InvoiceLine.Quantity as quantity, InvoiceLine.UnitPrice as unit_price\n" +
                    "FROM InvoiceLine INNER JOIN Track ON InvoiceLine.TrackId = Track.TrackId INNER JOIN Album ON Track.AlbumId = Album.AlbumId INNER JOIN Artist ON Album.ArtistId = Artist.ArtistId\n" +
                    "WHERE InvoiceLine.InvoiceId IN (\n" +
                    "\tSELECT Invoice.InvoiceId\n" +
                    "\tFROM Invoice\n" +
                    "  WHERE Invoice.CustomerId = " + i + "\n" +
                    ")\n" +
                    "ORDER BY InvoiceLine.InvoiceId, invoiceline_id;");
            resultSet = preparedStatement.executeQuery();
            int invoice = 0;
            while (resultSet.next()) {
                if(resultSet.getInt(1) != invoice) {
                    invoice = resultSet.getInt(1);
                    privateLib.writeStringToConsole("\nInvoice #" + invoice + " ($" + table[count] + ")");
                    count++;
                }
                privateLib.writeStringToConsole(" " + resultSet.getString("invoiceline_id") + ": '" + resultSet.getString("track_name") + "' on '" + resultSet.getString("album_title") + "' by '" + resultSet.getString("artist_name") + "' (" + resultSet.getString("quantity") + " @ " + resultSet.getString("unit_price") + ")");
             }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, preparedStatement, resultSet);
        }
    }

}
