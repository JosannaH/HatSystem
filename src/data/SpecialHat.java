/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author Lisa
 */
public class SpecialHat {

    public static void addImage(String name, String imagePath) {
        String id = "SELECT hat_id FROM special_hat WHERE name = '" + name;
        String query = "Update Special_hat SET image_path = '" + imagePath + "' WHERE hat_id = " + id;
        SqlQuery.update(query);
    }

    public static boolean isUniqueCombination(String hatName, int fabricID) {

        boolean isUnique = false;
        String id = SqlQuery.getValue("SELECT hat_id FROM hat WHERE Name = '" + hatName + "' AND Hat_Fabric = " + fabricID + ";");

        if (id == null) {
            isUnique = true;
        }

        return isUnique;
    }

    public static void addHat(String chosenName, String chosenPrice, String chosenSize, String chosenDescription, int chosenFabricID, int chosenWorkerID) {

        String query = "INSERT INTO hat (Name, Price, Size, Description, Hat_Fabric, Worker) VALUES ('" + chosenName + "', " + chosenPrice + ", '" + chosenSize + "','" + chosenDescription + "', " + chosenFabricID + ", " + chosenWorkerID + ");";
        SqlQuery.add(query);
    }

    public static void addSpecialHat(String chosenName, String chosenPrice, int chosenFabricID, String image) {
        String id = "SELECT hat_id FROM hat WHERE name = '" + chosenName + "' AND price = '" + chosenPrice + "' AND Hat_fabric = " + chosenFabricID;
        String hatID = SqlQuery.getValue(id);
        String query = "INSERT INTO special_hat VALUES ('" + hatID + "', '" + image + "');";
        SqlQuery.add(query);
    }

    public static void addSpecialHatNoImage(String chosenName, String chosenPrice, int chosenFabricID) {

        String id = "SELECT hat_id FROM hat WHERE name = '" + chosenName + "' AND price = '" + chosenPrice + "' AND Hat_fabric = " + chosenFabricID;
        String hatID = SqlQuery.getValue(id);
        String query = "INSERT INTO special_hat (Hat_ID) VALUES ('" + hatID + "');";
        SqlQuery.add(query);
    }
    
    /**
     * Get hat_ID as it is written i DB
     * @param hatID
     * @return 
     */
    public static String getHatID(String hatID){
        String db_ID = hatID.substring(1, 6).trim();

        return db_ID;
    }

    public static boolean isSpecialHat(String hatID) {
        boolean result = true;
        String checkID = getHatID(hatID);
        String query = "SELECT count(*) FROM special_hat WHERE Hat_ID = '" + checkID + "';";
        String answer = SqlQuery.getValue(query);
        System.out.println(answer);
        if (answer.equals("0")) {
            result = false;
        }
        return result;
    }

    public static String getImageFilePath(String hatID) {
        String checkID = getHatID(hatID);
        System.out.println("getImageFilePath checkID:" + checkID);
        String query = "SELECT image_path FROM special_hat WHERE ID = " + checkID + ";";

        String path = SqlQuery.getValue(query);
        System.out.println("getImageFilePath path: " + path);

        return path;
    }
    
    public static void chooseFile(JLabel lblImage, JLabel lblFileName){
         JFileChooser chooser = new JFileChooser();
        int isFileChosen = chooser.showOpenDialog(null);

        if (isFileChosen == 1) {

        } else {

            File file = chooser.getSelectedFile();
            String filename = file.getAbsolutePath();
            if (filename.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)")) {

                //TODO Validering för att det endast går att lägga in bild.
                lblFileName.setText(filename);
                lblFileName.setForeground(new Color(60, 63, 65));

                ImageIcon icon = new ImageIcon(new ImageIcon(filename).getImage());

                //Vi kan här ändra värdet i "frame" för att få den storlek vi vill ha på ramen, men att bilden
                //fortfarande behåller sitt ursprungliga bildförhållande relativt till ramen.
                double frameWidth = 300;
                double frameHeight = 350;
                double selectedImgWidth = icon.getIconWidth();
                double selectedImgHeight = icon.getIconHeight();

                double widthRatio = frameWidth / selectedImgWidth;
                double heightRatio = frameHeight / selectedImgHeight;
                double ratio = Math.min(widthRatio, heightRatio);

                int resizedWidth = (int) (selectedImgWidth * ratio);
                int resizedHeight = (int) (selectedImgHeight * ratio);

                ImageIcon iconNew = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(resizedWidth, resizedHeight, Image.SCALE_DEFAULT));

                lblImage.setIcon(iconNew);
            } else {
                lblFileName.setText("Fel filformat");
                lblFileName.setForeground(new Color(204, 0, 51));
            }
        }
    }
    
    public static void showImage(JLabel lblImage, JLabel lblFilename, String hatID){
                //String hat = getHatID(hatID);
                String filename = getImageFilePath(hatID);
                System.out.println(filename);
                lblFilename.setText(filename);
                lblFilename.setForeground(new Color(60, 63, 65));

                ImageIcon icon = new ImageIcon(new ImageIcon(filename).getImage());

                //Vi kan här ändra värdet i "frame" för att få den storlek vi vill ha på ramen, men att bilden
                //fortfarande behåller sitt ursprungliga bildförhållande relativt till ramen.
                double frameWidth = 300;
                double frameHeight = 350;
                double selectedImgWidth = icon.getIconWidth();
                double selectedImgHeight = icon.getIconHeight();

                double widthRatio = frameWidth / selectedImgWidth;
                double heightRatio = frameHeight / selectedImgHeight;
                double ratio = Math.min(widthRatio, heightRatio);

                int resizedWidth = (int) (selectedImgWidth * ratio);
                int resizedHeight = (int) (selectedImgHeight * ratio);

                ImageIcon iconNew = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(resizedWidth, resizedHeight, Image.SCALE_DEFAULT));

                lblImage.setIcon(iconNew);
    }
}
