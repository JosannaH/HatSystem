/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

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
    public void addAdress(String street, String postal, String city, String country) {

        String query = "INSERT INTO address (Street, Postal, City, Country) VALUES ('"+ street +"', '"+ postal +"', '"+ city +"', '"+ country +"');";
        SqlQuery.add(query);
    }
    
    
}
