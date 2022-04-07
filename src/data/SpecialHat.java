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
 
    public static void addImage(int ID, String image_path){
        image_path = "Update Special_hat VALUES('"+ image_path +"') WHERE Hat_ID = "+ ID +"" ;
        SqlQuery.add(image_path);
    }
    
}
