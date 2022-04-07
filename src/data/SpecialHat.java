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
 
    public static void addImage(int ID, String imagePath){
        String query = "Update Special_hat SET image_path = '" + imagePath + "' WHERE hat_id = " + ID;
        SqlQuery.update(query);
    }
    
}
