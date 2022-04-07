/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Friday
 */
public class Customer {

    public Customer() {
    }

    public void addCustomer(String customerNr, String firstName, String lastName, String email, String phone, String adressID, String comment) {

        String query = "INSERT INTO customer (Customer_Nr, First_Name, Last_Name, Email, Phone_Nr, Address, Comment) VALUES ("+ customerNr +", '"+ firstName +"', '"+ lastName+"', '"+ email +"', '"+ phone +"', "+ adressID +", '"+ comment +"');";
        SqlQuery.add(query);
    }
    
    
    
    
}
