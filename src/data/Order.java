/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;

/**
 *
 * @author Lisa
 */
public class Order {

    public static void addToOrderedHat(int hatID, int orderID) {
        String query = "INSERT INTO ordered_hat (Hat_ID, Order_Nr) VALUES ('" + hatID + "', '" + orderID + "');";
        SqlQuery.add(query);

    }

    public static void addToOrderedStandardHat(String size, int hatID, int orderID) {
        String query = "INSERT INTO ordered_st_hat (Size, Standard_Hat, Order_Nr) VALUES ('" + size + "', " + hatID + ", " + orderID + ");";
        SqlQuery.add(query);
    }

    public static boolean addToOrder(String totalPrice, String deliveryDate, String orderDate, String status, String deliveryAddress, String customer, int createdBy) {
        String query = "Insert INTO orders(Total_Price, Delivery_Date, Order_Date, Status, Delivery_Address, Customer, Created_By, Active) "
                + "VALUES('" + totalPrice + "', '" + deliveryDate + "', '" + orderDate + "', '" + status + "', '" + deliveryAddress + "', '" + customer + "', " + createdBy + ", 1);";
        boolean success = SqlQuery.add(query);
        return success;
    }

    /**
     * Get the most recent order
     *
     * @return
     */
    public static int getOrderID() {
        String orderID = SqlQuery.getValue("SELECT MAX(Orders_ID) FROM Orders;");
        int orderIDInt = Integer.parseInt(orderID);
        return orderIDInt;
    }

    /**
     * Get all orders from database
     *
     * @return
     */
    public static ArrayList<HashMap<String, String>> getAllOrders() {
        ArrayList<HashMap<String, String>> allOrders = SqlQuery.getMultipleRows("SELECT * FROM orders WHERE Active = 1;");
        return allOrders;
    }

    /**
     * Get all orders with a specific status and list them in listmodel
     *
     * @param orderNr
     * @param listModel
     */
    public static void listOrdersByStatus(String status, DefaultListModel listModel) {
        listModel.clear();
        ArrayList<HashMap<String, String>> orders = SqlQuery.getMultipleRows("SELECT * FROM orders WHERE Status = '" + status + "';");

        if (orders.isEmpty()) {
            listModel.addElement("Inget resultat");
        } else {
            listModel.addElement(String.format("%-10s %-20s %-20s %-20s"
                    + "Summa", "OrderID", "Leveransdatum", "Orderdatum", "Status"));
            int index = 0;
            while (index < orders.size()) {
                HashMap<String, String> currentOrder = orders.get(index);

                listModel.addElement(String.format("%-10s %-20s %-20s %-20s"
                        + currentOrder.get("Total_Price"),
                        currentOrder.get("Orders_ID"),
                        currentOrder.get("Delivery_Date"),
                        currentOrder.get("Order_Date"),
                        currentOrder.get("Status")
                ));

                index++;
            }
        }
    }

    /**
     * List all orders in a listmodel
     */
    public static void listAllOrders(DefaultListModel listModel) {
        listModel.clear();

        ArrayList<HashMap<String, String>> allOrders = Order.getAllOrders();
        int index = 0;
        while (index < allOrders.size()) {
            HashMap<String, String> currentOrder = allOrders.get(index);

            listModel.addElement(String.format("%-10s %-20s %-20s %-20s"
                    + currentOrder.get("Total_Price"),
                    currentOrder.get("Orders_ID"),
                    currentOrder.get("Delivery_Date"),
                    currentOrder.get("Order_Date"),
                    currentOrder.get("Status")
            ));

            index++;
        }
    }

}
