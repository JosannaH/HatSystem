/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTextField;

// TODO det blir databasfel om man skriver datum i fel format i Skapa order
/**
 *
 * @author Friday
 */
public class Validation {

    /**
     * Check if a String only contains numbers and can be converted to an Integer.
     *
     * @param stringToCheck
     * @return True if the conversion succeeded, otherwise false.
     */
    public static boolean isInteger(String stringToCheck) {
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
     *
     * @param stringToCheck
     * @return True if the conversion succeeded, otherwise false.
     */
    public static boolean isDouble(String stringToCheck) {
        boolean isDouble = false;
        try {
            Double.parseDouble(stringToCheck);
            isDouble = true;
        } catch (NumberFormatException e) {

        }
        return isDouble;
    }

    /**
     * Checks if a string is in the correct date format, yyyy-mm-dd.
     *
     * @param stringToCheck
     * @return true if correct format, otherwise false
     */
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

    public static boolean isDate(String stringToCheck, JLabel lbl) {
        boolean returBoolean = false;

        if (stringToCheck.length() == 10) {
            String subText1 = stringToCheck.substring(0, 4) + stringToCheck.substring(5, 7) + stringToCheck.substring(8, 10);
            String subText2 = stringToCheck.substring(4, 5) + stringToCheck.substring(7, 8);
            if ((isInteger(subText1) && subText2.equals("--"))) {
                returBoolean = true;
            } else {

                lbl.setText("åååå-mm-dd");
                lbl.setVisible(true);

            }
        } else {
            lbl.setText("åååå-mm-dd");
            lbl.setVisible(true);
        }
        return returBoolean;
    }

    /**
     * Kontrollerar om en angiven day är giltig för angiven månad
     *
     * @param month månaden man vill kolla
     * @param day dagen man vill kolla
     * @return true och datumet är giltigt, annars false
     */
    public static boolean isValidMonthAndDay(String month, String day) {
        HashMap<String, String> monthsAndDays = monthsAndDays();
        boolean isVaild = false;

        if (monthsAndDays.containsKey(month)) {

            int chosenDay = Integer.parseInt(day);
            int nrOfDays = Integer.parseInt(monthsAndDays.get(month));

            if (chosenDay > 0 && chosenDay <= nrOfDays) {
                isVaild = true;
            }
        }
        return isVaild;
    }

    /**
     * En HashMap för att hålla reda på hur många dagar det finns i respektive
     * månad. Används av metoden isValidMonthAndDay Används för att kontrollera
     * användares datum-input. Fungerar inte med skottår.
     *
     * @return En HashMap med månadens nr (01-12) och tillhörande antal dagar i
     * den månaden.
     */
    private static HashMap<String, String> monthsAndDays() {
        HashMap<String, String> monthsAndDays = new HashMap<>();

        monthsAndDays.put("01", "31");
        monthsAndDays.put("02", "28");
        monthsAndDays.put("03", "31");
        monthsAndDays.put("04", "30");
        monthsAndDays.put("05", "31");
        monthsAndDays.put("06", "30");
        monthsAndDays.put("07", "31");
        monthsAndDays.put("08", "31");
        monthsAndDays.put("09", "30");
        monthsAndDays.put("10", "31");
        monthsAndDays.put("11", "30");
        monthsAndDays.put("12", "31");

        return monthsAndDays;
    }

    public static boolean onlyLetters(String text, JLabel lbl) {

        boolean result = true;
        boolean allLetters = text.chars().allMatch(Character::isLetter);

        if (!allLetters) {

            result = false;
            lbl.setVisible(true);
            lbl.setText("Endast bokstäver");
        }

        return result;
    }

    public static boolean onlyDigits(String text, JLabel lbl) {

        boolean result = true;

        if (!text.matches("[0-9]+")) {
            result = false;
            lbl.setVisible(true);
            lbl.setText("Endast siffror");
        }

        return result;

    }

    public static boolean noSpecialCharacters(String text, JLabel lbl) {

        boolean result = true;

        if (!text.matches("[\\p{L}\\d\\s]+")) {
            result = false;
            lbl.setText("Ej specialtecken");
        }

        return result;

    }

    public static boolean isPrice(String text, JLabel lbl) {

        boolean result = true;

        if (!text.matches("^\\d+(\\.\\d{1,2})?$")) {
            result = false;
            lbl.setVisible(true);
            lbl.setText("Endast siffror, punkt, och max 2 decimaler");
        }

        return result;

    }

    public static boolean emailFormat(String text, JLabel lbl) {

        boolean result = true;

        if (!text.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}")) {
            result = false;
            lbl.setText("Fel format");
        }

        return result;

    }

    public static boolean isBlank(JTextField txtField, JLabel lbl) {

        boolean result = false;

        if (txtField.getText().isBlank()) {
            result = true;
            lbl.setVisible(true);
            lbl.setText("Vänligen fyll i fält");
        }

        return result;
      }

        /**
         * Round up to two decimals för doubles
         */
        public static String setTwoDecimals(Double formatDouble) {

            DecimalFormat df = new DecimalFormat("####0.00");
            String formatPrice = df.format(formatDouble);
            return formatPrice;

    }
}
