/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.HashMap;

/**
 *
 * @author Friday
 */
public class Customer {

    public Customer() {
    }

    /**
     * Adds a customer to the database. User inputs should be checked before calling this method.
     * @param customerNr
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param adressID
     * @param comment 
     */
    private void addCustomer(String customerNr, String firstName, String lastName, String email, String phone, String adressID, String comment) {

        String query = "INSERT INTO customer (Customer_Nr, First_Name, Last_Name, Email, Phone_Nr, Address, Comment) VALUES (" + customerNr + ", '" + firstName + "', '" + lastName + "', '" + email + "', '" + phone + "', " + adressID + ", '" + comment + "');";
        SqlQuery.add(query);
    }

    /**
     * Retrieves a customer from the database using a specified Customer_Nr.
     * @param customerNr
     * @return A HashMap containing the customer, empty if no customer having the specified id exits.
     */
    private HashMap getCustomer(String customerNr){
        
        String query = "SELECT * FROM customer WHERE Customer_Nr = '"+ customerNr +"';";
        HashMap<String, String> customer = SqlQuery.getRow(query);
        
        return customer;
    }
   
}
