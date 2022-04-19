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

        String employeeToCheck = SqlQuery.getValue("SELECT Employee_ID FROM Employee WHERE Username = 'Ottoadmin'");
        int employeeID = Integer.parseInt(employeeToCheck);
        return employeeID;
    }
}
