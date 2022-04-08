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
 
    public static void addImage(String imagePath){
        String id = "SELECT MAX(hat_id) FROM special_hat";
        String query = "Update Special_hat SET image_path = '" + imagePath + "' WHERE hat_id = " + id;
        SqlQuery.update(query);
    }
    
    public static boolean isUniqueCombination(String hatName, int fabricID){
        
        boolean isUnique = false;
        String id = SqlQuery.getValue("SELECT hat_id FROM special_hat WHERE Name = '"+ hatName +"' AND Hat_Fabric = "+ fabricID +";");
        
        if(id == null){
            isUnique = true;
        }
        
        return isUnique;
    }
    
    public static void addSpecialHat(String chosenName, String chosenPrice, String chosenDescription, int chosenFabricID) {

        String query = "INSERT INTO special_hat (Name, Price, Description, Hat_Fabric) VALUES ('" + chosenName + "', " + chosenPrice + ", '" + chosenDescription + "', " + chosenFabricID + ");";
        SqlQuery.add(query);
    }
    
}
