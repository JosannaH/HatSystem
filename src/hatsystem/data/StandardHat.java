/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatsystem.data;

import hatsystem.data.SqlQuery;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Friday
 */
public class StandardHat {

    public StandardHat() {
    }

    /**
     * Adds a new standard hat model to the database. User input errors should be checked before calling this method.
     *
     * @param chosenName
     * @param chosenPrice
     * @param chosenDescription
     * @param chosenFabric
     */
    public static void addStandardHat(String chosenName, String chosenPrice, String chosenDescription, String chosenFabricID) {

        String query = "INSERT INTO standard_hat (Name, Price, Description, Hat_Fabric) VALUES ('" + chosenName + "', " + chosenPrice + ", '" + chosenDescription + "', " + chosenFabricID + ");";
        SqlQuery.add(query);
    }

    /**
     * Retrieves all standard hats from the database and stores them in an ArrayList of HashMap.
     *
     * @return All standard hats in the database.
     */
    public static ArrayList<HashMap<String, String>> getAllStandardHats() {

        ArrayList<HashMap<String, String>> allStandardHats = new ArrayList<>();
        allStandardHats = SqlQuery.getMultipleRows("SELECT * FROM standard_hat;");

        return allStandardHats;
    }
    
    /**
     * Checks whether a specific hat name and fabric combination already exists.
     * @param hatName Hat name to check.
     * @param fabricID FabricID to check.
     * @return True if combination is unique, otherwise false.
     */
    public static boolean isUniqueCombination(String hatName, String fabricID){
        
        boolean isUnique = false;
        String id = SqlQuery.getValue("SELECT Standard_Hat_ID FROM standard_hat WHERE Name = '"+ hatName +"' AND Hat_Fabric = "+ fabricID +";");
        
        if(id == null){
            isUnique = true;
        }
        
        return isUnique;
    }

}
