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
public class Address {

    public Address() {
    }

    /**
     * Adds a new adress to the database. User inputs should be checked before calling this method.
     * @param street
     * @param postal
     * @param city
     * @param country 
     */
    public static void addAddress(String street, String postal, String city, String country) {

        String query = "INSERT INTO address (Street, Postal, City, Country) VALUES ('"+ street +"', '"+ postal +"', '"+ city +"', '"+ country +"');";
        SqlQuery.add(query);
    }
    
    /**
     * Retrieves an address from the database. Can be used to check if an address with the specified values already exists.
     * @param street
     * @param postal
     * @param city
     * @param country 
     * @return A HashMap containing the address, empty if no address was found.
     */
    public static HashMap<String, String> getAddress(String street, String postal, String city, String country){
        
        String query = "SELECT * FROM address WHERE Street = '"+ street +"' AND Postal = '"+ postal +"' AND City = '"+ city +"' AND Country = '"+ country +"';";
        HashMap<String, String> address = SqlQuery.getRow(query);
        
        return address;
    }
    
}
