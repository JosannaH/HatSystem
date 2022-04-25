/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Lisa
 */
public class Employee {
    
    public static ArrayList<String> getEmployee(){
       
        ArrayList<String> employees = SqlQuery.getColumn("SELECT name FROM employee;");
        
        return employees;
    }
    
    public static int getEmployeeID(String name) {

        String employeeToCheck = SqlQuery.getValue("SELECT Employee_ID FROM Employee WHERE Username = '" + name + "'");
        int employeeID = Integer.parseInt(employeeToCheck);
        return employeeID;
    }
    
    public static int getEmployeeIDAdmin(String name) {

        String employeeToCheck = SqlQuery.getValue("SELECT Employee_ID FROM Employee WHERE name = '" + name + "'");
        int employeeID = Integer.parseInt(employeeToCheck);
        return employeeID;
    }
    
    public static String getSecurityAnswer(String userName){
        String securityAnswer = SqlQuery.getValue("SELECT Security_Answer FROM employee WHERE Username = '" + userName + "'");
        return securityAnswer;
    }
    
    public static String getSecurityQuestion(String userName){
        String securityQuestion = SqlQuery.getValue("SELECT Security_Question FROM employee WHERE Username = '" + userName + "'");
        return securityQuestion;
    }
}
