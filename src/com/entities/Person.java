package com.entities;

/**
 * Created by Christian on 11/24/2015.
 */
public class Person {
    private String userName;
    private String password;
    private int balance;
    private int id;



    public Person() {

    }

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
