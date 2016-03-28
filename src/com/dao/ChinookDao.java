package com.dao;

/**
 * Created by abatewongc on 2/18/2016.
 */
public interface ChinookDao {
    /**
     * Prints the number of customers in specified country.
     * @param country
     */
    void getCustomersByCountry(String country);

    /**
     * Prints a list of employees, organized by their id number.
     */
    void getEmployeeList();

    /**
     * Print the number of customers this employee serves.
     * @param i employee id
     */
    void getCustomersServed(int i);

    /**
     * Prints a list of customers, sorted by their customer id.
     */
    void getCustomerList();

    /**
     * Prints a summary of a customer's invoices.
     * @param i customer id
     */
    void getCustomerInvoiceList(int i);

}
