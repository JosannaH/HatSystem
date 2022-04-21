/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.DefaultListModel;

/**
 *
 * @author Friday
 */
public class Customer {

    public Customer() {
    }

    /**
     * Adds a customer to the database. User inputs should be checked before
     * calling this method.
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
     * @return A HashMap containing the customer, empty if no customer having
     * the specified id exits.
     */
    public static HashMap<String, String> getCustomer(String customerNr) {

        String query = "SELECT * FROM customer WHERE Customer_Nr = '" + customerNr + "';";
        HashMap<String, String> customer = SqlQuery.getRow(query);

        return customer;
    }

    /**
     * Get customer ID by generated Customer Nr
     *
     * @param customerNr
     * @return
     */
    public static String getCustomerID(String customerNr) {
        String query = "SELECT Customer_ID from Customer WHERE Customer_Nr = '" + customerNr + "';";
        String customerID = SqlQuery.getValue(query);
        return customerID;
    }

    public static String getCustomerNr(String customerID) {
        String query = "SELECT Customer_Nr from Customer WHERE Customer_ID = '" + customerID + "';";
        String customerNr = SqlQuery.getValue(query);
        return customerNr;
    }

    public static String getLatestCustomer() {
        String query = "SELECT MAX(Customer_ID) FROM Customer";
        String customerID = SqlQuery.getValue(query);
        return customerID;
    }

    /**
     * Retrieves a customer from the database using specified values. Can be
     * used to check if a customer with entered details already exists.
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

    public static ArrayList<HashMap<String, String>> getAllCustomers() {
        ArrayList<HashMap<String, String>> allCustomers = new ArrayList<>();

        allCustomers = SqlQuery.getMultipleRows("SELECT * FROM customer where Active = 1;");

        return allCustomers;
    }

    public static void listCustomerFromNr(String customerNr, DefaultListModel listModel) {
        listModel.clear();
        String ID = getCustomerID(customerNr);
        HashMap<String, String> customer = getCustomer(ID);
        
        HashMap<String, String> address = Address.getAddressFromID(customer.get("Address"));

            listModel.addElement(String.format("%-12s %-15s %-20s %-25s %-20s %-10s %-15s %-15s"
                    + customer.get("Comment"),
                    customer.get("Customer_Nr"),
                    customer.get("First_Name"),
                    customer.get("Last_Name"),
                    customer.get("Email"),
                    address.get("Street"),
                    address.get("Postal"),
                    address.get("City"),
                    address.get("Country")));
    }

    public static void listCustomersFromFirstName(String firstName, DefaultListModel listModel) {
        listModel.clear();
        
         ArrayList<HashMap<String, String>> customers = new ArrayList<>();
        customers = SqlQuery.getMultipleRows("SELECT * FROM Customer where First_Name = '" + firstName + "';");

        int index = 0;
        while (index < customers.size()) {
            HashMap<String, String> currentCustomer = customers.get(index);
            HashMap<String, String> currentAddress = Address.getAddressFromID(currentCustomer.get("Address"));

            listModel.addElement(String.format("%-12s %-15s %-20s %-25s %-20s %-10s %-15s %-15s"
                    + currentCustomer.get("Comment"),
                    currentCustomer.get("Customer_Nr"),
                    currentCustomer.get("First_Name"),
                    currentCustomer.get("Last_Name"),
                    currentCustomer.get("Email"),
                    currentAddress.get("Street"),
                    currentAddress.get("Postal"),
                    currentAddress.get("City"),
                    currentAddress.get("Country")
            ));

            index++;
        }

    }

    public static void listCustomerFromLastName(String lastName, DefaultListModel listModel) {
        listModel.clear();
 ArrayList<HashMap<String, String>> customers = new ArrayList<>();
        customers = SqlQuery.getMultipleRows("SELECT * FROM Customer where First_Name = '" + lastName + "';");

        int index = 0;
        while (index < customers.size()) {
            HashMap<String, String> currentCustomer = customers.get(index);
            HashMap<String, String> currentAddress = Address.getAddressFromID(currentCustomer.get("Address"));

            listModel.addElement(String.format("%-12s %-15s %-20s %-25s %-20s %-10s %-15s %-15s"
                    + currentCustomer.get("Comment"),
                    currentCustomer.get("Customer_Nr"),
                    currentCustomer.get("First_Name"),
                    currentCustomer.get("Last_Name"),
                    currentCustomer.get("Email"),
                    currentAddress.get("Street"),
                    currentAddress.get("Postal"),
                    currentAddress.get("City"),
                    currentAddress.get("Country")
            ));

            index++;
        }
    }

}
