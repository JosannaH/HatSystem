/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Friday
 */
public class GeneratePDF {

    public static void generateMomsPDF(String year, String searchPath) {
        try {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(searchPath + ".pdf"));

            document.open();

            Paragraph paragraph = new Paragraph("Totalförsäljning år " + year);

            document.add(paragraph);

            ArrayList<HashMap<String, String>> allOrders = SqlQuery.getMultipleRows("SELECT * FROM orders WHERE Order_Date LIKE '" + year + "%';");

            int nrOfOrders = 0;
            int nrOfHats = 0;
            int nrOfStandardHats = 0;
            int nrOfCustomHats = 0;
            int nrOfSpecialHats = 0;

            double totalPrice = 0;

            for (HashMap<String, String> order : allOrders) {
                totalPrice += Double.parseDouble(order.get("Total_Price"));
                nrOfOrders += 1;

                String currentOrderID = order.get("Orders_ID");
                ArrayList<String> orderedStandardHats = SqlQuery.getColumn("SELECT Standard_Hat FROM ordered_st_hat WHERE Order_Nr = " + currentOrderID + ";");
                ArrayList<String> orderedCustomHats = SqlQuery.getColumn("SELECT Hat_ID FROM ordered_hat WHERE Order_Nr = " + currentOrderID + ";");
                ArrayList<String> allCustomHats = SqlQuery.getColumn("SELECT Hat_ID FROM custom_hat");
                ArrayList<String> allSpecialHats = SqlQuery.getColumn("SELECT Hat_ID FROM special_hat");

                for (String standardHat : orderedStandardHats) {
                    nrOfHats += 1;
                    nrOfStandardHats += 1;
                }
                for (String customHat : orderedCustomHats) {
                    nrOfHats += 1;

                    if (allCustomHats.contains(customHat)) {
                        nrOfCustomHats += 1;
                    }
                    if (allSpecialHats.contains(customHat)) {
                        nrOfSpecialHats += 1;
                    }
                }
            }
            paragraph = new Paragraph(" ");
            document.add(paragraph);
            
            String totalPriceTwoDecimals = Validation.setTwoDecimals(totalPrice);
            
            paragraph = new Paragraph("Totalförsäljning: " + totalPriceTwoDecimals + " SEK");
            document.add(paragraph);

            Double totalPriceMoms = totalPrice * 0.25;
            String totalPriceMomsTwoDecimals = Validation.setTwoDecimals(totalPriceMoms);
            
            paragraph = new Paragraph("   Varav moms: " + totalPriceMomsTwoDecimals + " SEK");
            document.add(paragraph);
            
            paragraph = new Paragraph(" ");
            document.add(paragraph);

            paragraph = new Paragraph("Antal ordrar: " + nrOfOrders);
            document.add(paragraph);
            
            paragraph = new Paragraph(" ");
            document.add(paragraph);

            paragraph = new Paragraph("Antal sålda hattar: " + nrOfHats);
            document.add(paragraph);

            paragraph = new Paragraph("   Varav standardhattar: " + nrOfStandardHats);
            document.add(paragraph);
            
            paragraph = new Paragraph("   Varav anpassade hattar: " + nrOfCustomHats);
            document.add(paragraph);
            
            paragraph = new Paragraph("   Varav specialhattar: " + nrOfSpecialHats);
            document.add(paragraph);

            document.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public static void generateInvoicePDF(String weight, String shippingCost, String description, String searchPath, String orderNr) {

        try {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(searchPath + ".pdf"));

            document.open();

            Paragraph paragraph = new Paragraph("Fraktsedel");

            document.add(paragraph);

            //ska de ha en standardadress?
            paragraph = new Paragraph("Avsändaradress: Hattmakargatan 69, 66666, Örebro, Sverige");
            document.add(paragraph);
            
            
            
            HashMap<String, String> customer = SqlQuery.getRow("SELECT * FROM customer WHERE Customer_ID IN (SELECT Customer FROM orders WHERE Orders_ID = " + orderNr + ");");
            
            paragraph = new Paragraph("Kund: " + customer.get("First_Name") + " " + customer.get("Last_Name"));
            document.add(paragraph);

            HashMap<String, String> deliveryAddress = SqlQuery.getRow("SELECT * FROM address WHERE Address_ID IN "
                    + "(SELECT Delivery_Address FROM orders WHERE Orders_ID = " + orderNr + ");");
            paragraph = new Paragraph("Leveransadress: " + deliveryAddress.get("Street") + ", " + deliveryAddress.get("Postal") + ", " + deliveryAddress.get("City") + ", " + deliveryAddress.get("Country"));
            document.add(paragraph);

            paragraph = new Paragraph("Vikt: " + weight + " kg");
            document.add(paragraph);

            paragraph = new Paragraph("Fraktkostnad: " + shippingCost + " SEK");
            document.add(paragraph);

            if (!deliveryAddress.get("Country").equalsIgnoreCase("Sverige")) {
                paragraph = new Paragraph("Varukod: 52081300");
                document.add(paragraph);
            }

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(95);
            table.setSpacingBefore(11f);
            table.setSpacingAfter(11f);

            //skapar headers till tabellen
            PdfPCell c1 = new PdfPCell(new Phrase("Hatt"));
            PdfPCell c2 = new PdfPCell(new Phrase("Pris"));
            //lägger till headers i tabellen
            table.addCell(c1);
            table.addCell(c2);
            //lägger till innehåll i tabellen, från vänster till höger

            String query1 = "SELECT Name, Price FROM hat WHERE Hat_ID IN (SELECT Hat_ID FROM ordered_hat WHERE Order_Nr = " + orderNr + ");";
            String query2 = "SELECT Name, Price FROM standard_hat WHERE Standard_Hat_ID IN (SELECT Standard_Hat FROM ordered_st_hat WHERE Order_Nr = " + orderNr + ");";

            double totalPrice = 0;

            //custom och special hattar
            ArrayList<HashMap<String, String>> otherHats = SqlQuery.getMultipleRows(query1);

            for (HashMap<String, String> hs : otherHats) {

                table.addCell(hs.get("Name"));
                table.addCell(hs.get("Price"));
                totalPrice += Double.parseDouble(hs.get("Price"));
            }

            //standardhattar
            ArrayList<HashMap<String, String>> standardHats = SqlQuery.getMultipleRows(query2);

            for (HashMap<String, String> hs : standardHats) {

                table.addCell(hs.get("Name"));
                table.addCell(hs.get("Price"));
                totalPrice += Double.parseDouble(hs.get("Price"));
            }

            table.setHeaderRows(1);

            document.add(table);

            //pris och moms
            paragraph = new Paragraph("Pris innehåll: " + totalPrice
                    + " SEK, varav moms: " + totalPrice * 0.25 + " SEK");
            document.add(paragraph);

            paragraph = new Paragraph("Beskrivning av innehållet: " + description);
            document.add(paragraph);

            document.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void generateOrderPDF(String orderNr, String searchPath) {

        try {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(searchPath + ".pdf"));

            document.open();

            HashMap<String, String> order = SqlQuery.getRow("SELECT * FROM orders WHERE Orders_ID = 1;");
            HashMap<String, String> deliveryAddress = SqlQuery.getRow("SELECT * FROM address WHERE Address_ID IN (SELECT Delivery_Address FROM orders WHERE Orders_ID = " + orderNr + ");");

            Paragraph paragraph = new Paragraph("Ordersammanställning: " + orderNr);
            document.add(paragraph);

            //hämtar kunden
            HashMap<String, String> customer = SqlQuery.getRow("SELECT First_Name, Last_Name FROM customer WHERE Customer_ID IN (SELECT Customer FROM orders WHERE Orders_ID = " + orderNr + ");");
            paragraph = new Paragraph("Kund: " + customer.get("First_Name") + " " + customer.get("Last_Name"));
            document.add(paragraph);

            paragraph = new Paragraph("Leveransadress: "
                    + deliveryAddress.get("Street") + ", "
                    + deliveryAddress.get("Postal") + ", "
                    + deliveryAddress.get("City") + ", "
                    + deliveryAddress.get("Country"));
            document.add(paragraph);

            paragraph = new Paragraph("Beställningsdatum: " + order.get("Order_Date"));
            document.add(paragraph);

            paragraph = new Paragraph("Förväntat leveransdatum: " + order.get("Delivery_Date"));
            document.add(paragraph);

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(95);
            table.setSpacingBefore(11f);
            table.setSpacingAfter(11f);

            //skapar headers till tabellen
            PdfPCell c1 = new PdfPCell(new Phrase("Hatt"));
            PdfPCell c2 = new PdfPCell(new Phrase("Pris"));
            PdfPCell c3 = new PdfPCell(new Phrase("Storlek"));
            PdfPCell c4 = new PdfPCell(new Phrase("Tyg"));
            PdfPCell c5 = new PdfPCell(new Phrase("Färg"));
            PdfPCell c6 = new PdfPCell(new Phrase("Beskrivning"));
            //lägger till headers i tabellen
            table.addCell(c1);
            table.addCell(c2);
            table.addCell(c3);
            table.addCell(c4);
            table.addCell(c5);
            table.addCell(c6);

            //hämtar alla standardhattar som tillhör ordern
            String query1 = "SELECT * FROM standard_hat WHERE Standard_Hat_ID IN "
                    + "(SELECT Standard_Hat FROM ordered_st_hat WHERE Order_Nr = " + orderNr + ");";
            ArrayList<HashMap<String, String>> standardHats = SqlQuery.getMultipleRows(query1);

            double totalPrice = 0;

            for (HashMap<String, String> hm : standardHats) {

                String currentHatID = hm.get("Standard_Hat_ID");
                //hämtar tyget till nuvarande standardhatt
                HashMap<String, String> currentHatFabric = SqlQuery.getRow("SELECT * FROM fabric WHERE Fabric_ID IN"
                        + "(SELECT Hat_Fabric FROM standard_hat WHERE Standard_Hat_ID = " + currentHatID + ");");
                //hämtar storlek till nuvarande standardhatt
                String size = SqlQuery.getValue("SELECT Size FROM ordered_st_hat WHERE Standard_Hat = " + currentHatID + " AND Order_Nr = " + orderNr + ";");

                table.addCell(hm.get("Name"));
                table.addCell(hm.get("Price"));
                table.addCell(size);
                table.addCell(currentHatFabric.get("Name"));
                table.addCell(currentHatFabric.get("Color"));
                table.addCell(hm.get("Description"));

                totalPrice += Double.parseDouble(hm.get("Price"));
            }

            //hämtar alla andra hattar (special och custom)
            String query2 = "SELECT * FROM hat WHERE Hat_ID IN "
                    + "(SELECT Hat_ID FROM ordered_hat WHERE Order_Nr = " + orderNr + ");";
            ArrayList<HashMap<String, String>> otherHats = SqlQuery.getMultipleRows(query2);

            for (HashMap<String, String> hm : otherHats) {
                //hämtar nuvarande hatts ID
                String currentHatID = hm.get("Hat_ID");
                //hämtar nuvarande hatts tyg
                HashMap<String, String> currentHatFabric = SqlQuery.getRow("SELECT * FROM fabric WHERE Fabric_ID IN"
                        + "(SELECT Hat_Fabric FROM hat WHERE Hat_ID = " + currentHatID + ");");

                table.addCell(hm.get("Name"));
                table.addCell(hm.get("Price"));
                table.addCell(hm.get("Size"));
                table.addCell(currentHatFabric.get("Name"));
                table.addCell(currentHatFabric.get("Color"));
                table.addCell(hm.get("Description"));

                totalPrice += Double.parseDouble(hm.get("Price"));
            }

            table.setHeaderRows(1);

            document.add(table);

            //pris och moms
            paragraph = new Paragraph("Pris innehåll: " + totalPrice + " SEK, varav moms: " + totalPrice * 0.25 + " SEK");
            document.add(paragraph);

            document.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
