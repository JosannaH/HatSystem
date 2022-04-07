/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatsystem.data;

import hatsystem.data.SqlQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Friday
 */
public class Fabric {

    public Fabric() {
    }

    /**
     * Adds a new fabric to the database. User input errors should be checked before calling this method.
     *
     * @param chosenName
     * @param chosenPrice
     * @param chosenColor
     * @param chosenSupplier
     * @param chosenDescription
     */
    public static void addNewFabric(String chosenName, String chosenPrice, String chosenColor, String chosenSupplier, String chosenDescription) {

        String query = "INSERT INTO fabric (Name, Price, Color, Supplier, Description) VALUES ('" + chosenName + "', " + chosenPrice + ", '" + chosenColor + "', '" + chosenSupplier + "', '" + chosenDescription + "');";
        SqlQuery.add(query);

    }

    /**
     * Retrieves all information of all fabrics from the database and stores them in an ArrayList of HashMaps.
     *
     * @return All fabrics in the database.
     */
    public static ArrayList<HashMap<String, String>> getAllFabrics() {

        ArrayList<HashMap<String, String>> allFabrics = new ArrayList<>();
        allFabrics = SqlQuery.getMultipleRows("SELECT * FROM fabric;");

        return allFabrics;
    }

    /**
     * Retrieves all fabric names from the database and stores them in a HashSet, which can only contain unique values.
     *
     * @return All unique fabric names.
     */
    public static HashSet<String> getAllFabricNames() {

        ArrayList<String> fabrics = SqlQuery.getColumn("SELECT Name FROM fabric;");
        HashSet<String> allFabrics = new HashSet<String>(fabrics);

        return allFabrics;
    }

    /**
     * Retrieves every color option for a specific fabric name and stores them in an ArrayList.
     *
     * @return All colors for a specific fabric,
     */
    public static ArrayList<String> getFabricColors(String fabricName) {

        ArrayList<String> colors = SqlQuery.getColumn("SELECT Color FROM fabric WHERE Name = '" + fabricName + "';");

        return colors;
    }
    
    /**
     * Returns the id of a fabric with the specified name and color combination.
     * @param fabricName Fabric to check.
     * @param fabricColor Color to check.
     * @return A string containing the fabric ID. Null if no match was found.
     */
    public static String getFabricID(String fabricName, String fabricColor) {

 
        String fabricToCheck = SqlQuery.getValue("SELECT Fabric_ID FROM fabric WHERE Name = '" + fabricName + "' AND Color = '" + fabricColor + "';");

        return fabricToCheck;
    }

//    /** KANSKE INTE BEHÖVER DENNA EFTERSOM JAG SKAPAT METODEN OVAN
//     * Checks whether or not a fabric with the specified name and color combination exists.
//     *
//     * @param fabricName Fabric to check.
//     * @param fabricColor Color to check.
//     * @return true if unique combination, false if not.
//     */
//    public static boolean isUniqueCombination(String fabricName, String fabricColor) {
//
//        String fabricToCheck = "";
//        boolean isUnique = false;
//
//        fabricToCheck = SqlQuery.getValue("SELECT Fabric_ID FROM fabric WHERE Name = '" + fabricName + "' AND Color = '" + fabricColor + "';");
//
//        if (fabricToCheck.isBlank()) {
//            isUnique = true;
//        }
//
//        return isUnique;
//    }

    

}
