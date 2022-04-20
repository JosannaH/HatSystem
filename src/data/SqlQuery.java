/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Friday
 */
public class SqlQuery {

    private static InfDB idb;

    
    public static void setDatabase(InfDB idb){
        SqlQuery.idb = idb;
    }
    
    /**
     * Retrieves a single value from the database and stores the result in a String.
     *
     * @param query Query to the database.
     * @return A String containing the result, null if no matches were found.
     */
    public static String getValue(String query) {
        
        String returnString = "";

        try {
            returnString = idb.fetchSingle(query);
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }

        return returnString;
    }

    /**
     * Retrieves a single row from the database and stores the result in a HashMap - the keys being the column names from the database.
     *
     * @param query Query to the database.
     * @return A HashMap containing the result, empty if no matches were found.
     */
    public static HashMap getRow(String query) {

        HashMap<String, String> returnMap = new HashMap<>();

        try {
            returnMap = idb.fetchRow(query);
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            System.out.println(ex.getMessage());
        }

        return returnMap;
    }

    /**
     * Retrieves multiple rows from the database and stores the result in an ArrayList of HashMaps.
     *
     * @param query Query to the database.
     * @return An ArrayList containing the results, empty if no matches were found.
     */
    public static ArrayList<HashMap<String, String>> getMultipleRows(String query) {

        ArrayList<HashMap<String, String>> returnArrayList = new ArrayList<>();

        try {
            returnArrayList = idb.fetchRows(query);
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }

        return returnArrayList;
    }

    /**
     * Retrieves a column from the database and stores the result in an ArrayList of Strings.
     *
     * @param query Query to the database.
     * @return An ArrayList containing the result, empty if no matches were found.
     */
    public static ArrayList<String> getColumn(String query) {

        ArrayList<String> returnColumn = new ArrayList<>();

        try {
            returnColumn = idb.fetchColumn(query);
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }

        return returnColumn;
    }

    /**
     * Inserts/adds a row to the database.
     *
     * @param query Query to the database.
     * @return If query succeeded true/false;
     */
    public static boolean add(String query) {

        boolean successful = false;

        try {
            idb.insert(query);
            successful = true;
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
        }

        return successful;
    }

    /**
     * Deletes a row from the database.
     *
     * @param query Query to the database.
     * @return If query succeeded true/false;
     */
    public static boolean delete(String query) {

        boolean successful = false;

        try {
            idb.delete(query);
            successful = true;
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
        }

        return successful;
    }

    /**
     * Updates a single value or a row in the database.
     *
     * @param query Query to the database.
     * @return If query succeeded true/false;
     */
    public static boolean update(String query) {

        boolean successful = false;

        try {
            idb.update(query);
            successful = true;
        } catch (InfException ex) {
            JOptionPane.showMessageDialog(null, "Databasfel");
            System.out.println(ex.getMessage());
        }

        return successful;
    }

}
