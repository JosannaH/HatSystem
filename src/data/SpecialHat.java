/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Lisa
 */
public class SpecialHat {
 
    public static void addImage(String name, String imagePath){
        String id = "SELECT hat_id FROM special_hat WHERE name = '" + name;
        String query = "Update Special_hat SET image_path = '" + imagePath + "' WHERE hat_id = " + id;
        SqlQuery.update(query);
    }
    
    public static boolean isUniqueCombination(String hatName, int fabricID){
        
        boolean isUnique = false;
        String id = SqlQuery.getValue("SELECT hat_id FROM hat WHERE Name = '"+ hatName +"' AND Hat_Fabric = "+ fabricID +";");
        
        if(id == null){
            isUnique = true;
        }
        
        return isUnique;
    }
    
    public static void addHat(String chosenName, String chosenPrice, String chosenSize, String chosenDescription, int chosenFabricID, int chosenWorkerID) {

        String query = "INSERT INTO hat (Name, Price, Size, Description, Hat_Fabric, Worker) VALUES ('" + chosenName + "', " + chosenPrice + ", '" + chosenSize + "','" + chosenDescription + "', " + chosenFabricID + ", " + chosenWorkerID +");";
        SqlQuery.add(query);
    }
    
    public static void addSpecialHat(String chosenName, String chosenPrice, int chosenFabricID, String image) {
        String id = "SELECT hat_id FROM hat WHERE name = '" + chosenName + "' AND price = '" + chosenPrice +"' AND Hat_fabric = " + chosenFabricID;
        String hatID = SqlQuery.getValue(id);
        String query = "INSERT INTO special_hat VALUES ('" + hatID + "', '" + image + "');";
        SqlQuery.add(query);
    }
    
}
