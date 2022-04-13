/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Friday
 */
public class Customer {

    public Customer() {
    }

    /**
     * Adds a customer to the database. User inputs should be checked before calling this method.
     *
     * @param customerNr
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param addressID
     * @param comment
     */
    public static void addCustomer(String firstName, String lastName, String email, String phone, String addressID, String comment) {

        boolean searching = true;
        ArrayList<String> allNrs = getAllCustomerNrs();

        while (searching) {

            String customerNr = generateCustomerNr();

            if (allNrs.contains(customerNr)) {
                //do nothing and repeat
            } else {
                searching = false;
                String query = "INSERT INTO customer (Customer_Nr, First_Name, Last_Name, Email, Phone_Nr, Address, Comment) VALUES (" + customerNr + ", '" + firstName + "', '" + lastName + "', '" + email + "', '" + phone + "', " + addressID + ", '" + comment + "');";
                SqlQuery.add(query);
            }
        }
    }

    /**
     * Used to generate a random customer number having 8 numbers.
     *
     * @return The generated customer number.
     */
    private static String generateCustomerNr() {

        int x = 10000000 + new Random().nextInt(90000000);
        String number = Integer.toString(x);
        return number;
    }

    private static ArrayList<String> getAllCustomerNrs() {

        ArrayList<String> allNrs = SqlQuery.getColumn("SELECT Customer_Nr FROM customer;");

        return allNrs;
    }

    /**
     * Retrieves a customer from the database using a specified Customer_Nr.
     *
     * @param customerNr
     * @return A HashMap containing the customer, empty if no customer having the specified id exits.
     */
    public static HashMap<String, String> getCustomer(String customerNr) {

        String query = "SELECT * FROM customer WHERE Customer_Nr = '" + customerNr + "';";
        HashMap<String, String> customer = SqlQuery.getRow(query);

        return customer;
    }

    /**
     * Retrieves a customer from the database using specified values. Can be used to check if a customer with entered details already exists.
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @return A HashMap containing the customer, empty if no match was found.
     */
    public static HashMap<String, String> checkIfCustomerExists(String firstName, String lastName, String email, String phone) {
        String query = "SELECT * FROM customer WHERE First_Name = '" + firstName + "' AND Last_Name = '" + lastName + "' AND Email = '" + email + "' AND Phone_Nr = '" + phone + "';";
        HashMap<String, String> customer = SqlQuery.getRow(query);

        return customer;

    }
    
    public static ArrayList<HashMap<String, String>> getAllCustomers(){
        ArrayList<HashMap<String, String>> allCustomers = new ArrayList<>();
        
        allCustomers = SqlQuery.getMultipleRows("SELECT * FROM customer where Active = 1;");
        
        return allCustomers;
    }
}
