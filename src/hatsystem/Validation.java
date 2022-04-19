/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hatsystem;

import javax.swing.JOptionPane;

/**
 *
 * @author Friday
 */
public class Validation {

    
    public static boolean isInteger(String stringToCheck) {
        boolean isInteger = false;
        try {
            Integer.parseInt(stringToCheck);
            isInteger = true;
        } catch (NumberFormatException e) {
        }
        return isInteger;
    }
    
    public static boolean isDouble(String stringToCheck) {
        boolean isDouble = false;
        try {
            Double.parseDouble(stringToCheck);
            isDouble = true;
        } catch (NumberFormatException e) {
        }
        return isDouble;
    }

    public static boolean isDate(String stringToCheck) {
        boolean returBoolean = true;

        if (stringToCheck.length() == 10) {
            String subText1 = stringToCheck.substring(0, 4) + stringToCheck.substring(5, 7) + stringToCheck.substring(8, 10);
            String subText2 = stringToCheck.substring(4, 5) + stringToCheck.substring(7, 8);
            if (!(isInteger(subText1) && subText2.equals("--"))) {
                returBoolean = false;
            }
        } else {
            returBoolean = false;
        }
        return returBoolean;
    }
    
}
