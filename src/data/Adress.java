/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Friday
 */
public class Adress {

    public Adress() {
    }

    public void addAdress(String street, String postal, String city, String country) {

        String query = "INSERT INTO address (Street, Postal, City, Country) VALUES ('"+ street +"', '"+ postal +"', '"+ city +"', '"+ country +"');";
        SqlQuery.add(query);
    }
    
    
}
