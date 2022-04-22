/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import data.SqlQuery;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;

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
    public static void addStandardHat(String chosenName, String chosenPrice, String chosenDescription, int chosenFabricID) {

        String query = "INSERT INTO standard_hat (Name, Price, Description, Hat_Fabric) VALUES ('" + chosenName + "', " + chosenPrice + ", '" + chosenDescription + "', " + chosenFabricID + ");";
        SqlQuery.add(query);
    }

    /**
     * Retrieves all standard hats from the database and stores them in an ArrayList of HashMap.
     *
     * @return All standard hats in the database.
     */
    public static ArrayList<HashMap<String, String>> getAllStandardHats() {

        ArrayList<HashMap<String, String>> allStandardHats =
        SqlQuery.getMultipleRows("SELECT * FROM standard_hat ORDER BY Name;");

        return allStandardHats;
    }

    /**
     * Checks whether a specific hat name and fabric combination already exists.
     *
     * @param hatName Hat name to check.
     * @param fabricID FabricID to check.
     * @return True if combination is unique, otherwise false.
     */
    public static boolean isUniqueCombination(String hatName, int fabricID) {

        boolean isUnique = false;
        String id = SqlQuery.getValue("SELECT Standard_Hat_ID FROM standard_hat WHERE Name = '" + hatName + "' AND Hat_Fabric = " + fabricID + ";");

        if (id == null) {
            isUnique = true;
        }

        return isUnique;
    }

    public static HashMap<String, String> getHat(int hatID) {
        HashMap<String, String> foundHat = SqlQuery.getRow("SELECT * FROM standard_hat WHERE Standard_Hat_ID = " + hatID + ";");
        return foundHat;
    }
    
        /**
     * Fills the jList with standard hats from db.
     */
    public static void listAllStandardHats(DefaultListModel listModel) {

        // Tror ej denna behövs:
        //hashMapListPrice.clear();

        listModel.clear();

        ArrayList<HashMap<String, String>> allHats = StandardHat.getAllStandardHats();
        int index = 0;
        while (index < allHats.size()) {
            HashMap<String, String> currentHat = allHats.get(index);
            String fabricID = currentHat.get("Hat_Fabric");
            HashMap<String, String> currentFabric = Fabric.getFabricFromID(fabricID);

            listModel.addElement(String.format("%-10s %-20s %-20s %-20s" + currentHat.get("Price"), currentHat.get("Standard_Hat_ID"), currentHat.get("Name"), currentFabric.get("Name"), currentFabric.get("Color")));

            index++;
        }
    }
}
