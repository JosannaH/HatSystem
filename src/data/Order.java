/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author Lisa
 */
public class Order {
    
    public static void addToOrderedHat(int hatID, int orderID) {
        String query = "INSERT INTO ordered_hat (Hat_ID, Order_Nr) VALUES ('" + hatID + "', '" + orderID +"');";
        SqlQuery.add(query);
    }
    
    public static void addToOrderedStandardHat(String size, int hatID, int orderID) {
        String query = "INSERT INTO ordered_st_hat (Size, Standard_Hat, Order_Nr) VALUES ('" + size + "', " + hatID + ", '" + orderID + ");";
        SqlQuery.add(query);
    }

    public static void addToOrder(String totalPrice, String deliveryDate, String orderDate, String status, String deliveryAddress, String customer, String createdBy) {
        String query = "Insert INTO orders(Total_Price, Delivery_Date, Order_Date, Status, Delivery_Address, Customer, Created_By, Active) "
                + "VALUES('" + totalPrice + "', '" + deliveryDate + "', '" + orderDate + "', '" + status + "', '" + deliveryAddress + "', '" + customer + "', '" + createdBy + "', 1);";
        SqlQuery.add(query);
    }   
    
    
      
    
}
