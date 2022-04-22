/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import data.SqlQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComboBox;

/**
 *
 * @author Friday
 */
public class Fabric {

    public Fabric() {
    }

    /**
     * Adds a new fabric to the database. User input errors should be checked
     * before calling this method.
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
     * Retrieves all information of all fabrics from the database and stores
     * them in an ArrayList of HashMaps.
     *
     * @return All fabrics in the database.
     */
    public static ArrayList<HashMap<String, String>> getAllFabrics() {

        ArrayList<HashMap<String, String>> allFabrics = new ArrayList<>();
        allFabrics = SqlQuery.getMultipleRows("SELECT * FROM fabric;");

        return allFabrics;
    }

    /**
     * Retrieves all fabric names from the database and stores them in a
     * HashSet, which can only contain unique values.
     *
     * @return All unique fabric names.
     */
    public static HashSet<String> getAllFabricNames() {

        ArrayList<String> fabrics = SqlQuery.getColumn("SELECT Name FROM fabric;");
        HashSet<String> allFabrics = new HashSet<String>(fabrics);

        return allFabrics;
    }

    /**
     * Retrieves every color option for a specific fabric name and stores them
     * in an ArrayList.
     *
     * @return All colors for a specific fabric,
     */
    public static ArrayList<String> getFabricColors(String fabricName) {

        ArrayList<String> colors = SqlQuery.getColumn("SELECT Color FROM fabric WHERE Name = '" + fabricName + "';");

        return colors;
    }

    /**
     * Returns the id of a fabric with the specified name and color combination.
     *
     * @param fabricName Fabric to check.
     * @param fabricColor Color to check.
     * @return A string containing the fabric ID. Null if no match was found.
     */
    public static int getFabricID(String fabricName, String fabricColor) {

        String fabricToCheck = SqlQuery.getValue("SELECT Fabric_ID FROM fabric WHERE Name = '" + fabricName + "' AND Color = '" + fabricColor + "';");
        int fabricID = Integer.parseInt(fabricToCheck);
        return fabricID;
    }

    public static int getFabricIDFromName(String fabricName) {
        String fabric = SqlQuery.getValue("SELECT Fabric_ID from fabric WHERE Name = '" + fabricName + "';");
        int fabricID = Integer.parseInt(fabric);
        return fabricID;
    }

    /**
     * Retrieves a fabric from the database having the specified id.
     *
     * @param fabricID
     * @return A HashMap containing the fabric, empty if no match was found.
     */
    public static HashMap<String, String> getFabricFromID(String fabricID) {

        HashMap<String, String> fabric = SqlQuery.getRow("SELECT * FROM fabric WHERE Fabric_ID = " + fabricID + ";");
        return fabric;
    }

    /**
     * Checks whether a fabric with the specified values already exists in the
     * db.
     *
     * @param name
     * @param price
     * @param color
     * @param supplier
     * @return true if it exists, otherwise false.
     */
    public static boolean checkIfFabricExists(String name, String price, String color, String supplier) {
        boolean exists = true;

        String query = "SELECT Fabric_ID FROM fabric WHERE Name = '" + name + "' AND Price = " + price + " AND Color = '" + color + "' AND Supplier = '" + supplier + "';";
        String id = SqlQuery.getValue(query);
        if (id == null) {
            exists = false;
        }
        return exists;
    }

    public static void fillCmbWithAllFabrics(JComboBox cmb) {
        cmb.removeAllItems();
        ArrayList<String> fabrics = SqlQuery.getColumn("SELECT Name FROM fabric;");
        for (String f : fabrics) {
            cmb.addItem(f);
        }

    }

    public static ArrayList<HashMap<String, String>> getHatsFromFabric(int fabricID) {

        ArrayList<HashMap<String, String>> hats
                = SqlQuery.getMultipleRows("SELECT * FROM standard_hat WHERE Hat_Fabric = " + fabricID + ";");
        return hats;

    }
}
