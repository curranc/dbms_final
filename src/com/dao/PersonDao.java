package com.dao;

import com.entities.Person;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Christian on 11/24/2015.
 */
public interface PersonDao {
    void createPersonEntry();
    void insert(Person person);
    Person selectByUsername(String userName);
    Person selectByID(int id);
    List<Person> selectAll();
    void delete(int id);
    void updateBalance(Person person, double balance, double value);
    void depositBalance(Person person, double value);
    void withdrawBalance(Person person, double value);
    void createAccount(String userName, String password, String passwordConfirm);

}
