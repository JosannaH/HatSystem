/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Friday
 */
public class Validation {
    
    /**
     * Check if a String only contains numbers and can be converted to an Integer.
     * @param stringToCheck
     * @return True if the conversion succeeded, otherwise false.
     */
    public static boolean isInteger(String stringToCheck){
        boolean isInteger = false;
        try {
            Integer.parseInt(stringToCheck);
            isInteger = true;
        } catch (NumberFormatException e) {
            
        }
        return isInteger;
    }
    
    /**
     * Check if a String only contains numbers and can be converted to a Double.
     * @param stringToCheck
     * @return True if the conversion succeeded, otherwise false.
     */
    public static boolean isDouble(String stringToCheck){
        boolean isDouble = false;
        try {
            Double.parseDouble(stringToCheck);
            isDouble = true;
        } catch (NumberFormatException e) {
            
        }
        return isDouble;
    }

}
