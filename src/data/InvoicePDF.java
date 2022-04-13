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
import data.SqlQuery;
import java.util.ArrayList;



/**
 *
 * @author Friday
 */
public class InvoicePDF {


    public static void generateInvoicePDF(String weight, String shippingCost, String description, String searchPath, String orderNr) {

        try {
//            String fileName = "C:\\Users\\Friday\\Desktop\\UNI\\Scrum & eXtreme Programming\\PDF\\testar.pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(searchPath));

            document.open();

            Paragraph paragraph = new Paragraph("Fraktsedel");

            document.add(paragraph);

            //ska de ha en standardadress?
            paragraph = new Paragraph("Avsändaradress: Hattmakargatan 69, 66666, Örebro, Sverige");
            document.add(paragraph);

            HashMap<String, String> deliveryAddress = SqlQuery.getRow("SELECT * FROM address WHERE Address_ID IN "
                    + "(SELECT Delivery_Address FROM orders WHERE Orders_ID = " + orderNr + ");");
            paragraph = new Paragraph("Leveransadress: " + deliveryAddress.get("Street") + ", " + deliveryAddress.get("Postal") + ", " + deliveryAddress.get("City") + ", " + deliveryAddress.get("Country"));
            document.add(paragraph);

            paragraph = new Paragraph("Vikt: " + weight);
            document.add(paragraph);

            paragraph = new Paragraph("Fraktkostnad: " + shippingCost);
            document.add(paragraph);
            
            if(!deliveryAddress.get("Country").equalsIgnoreCase("Sverige")){
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

            if (!otherHats.isEmpty()) {
                for (HashMap<String, String> hs : otherHats) {

                    table.addCell(hs.get("Name"));
                    table.addCell(hs.get("Price"));
                    totalPrice += Double.parseDouble(hs.get("Price"));
                }
            }
            //standardhattar
            ArrayList<HashMap<String, String>> standardHats = SqlQuery.getMultipleRows(query2);

            if (!standardHats.isEmpty()) {
                for (HashMap<String, String> hs : standardHats) {

                    table.addCell(hs.get("Name"));
                    table.addCell(hs.get("Price"));
                    totalPrice += Double.parseDouble(hs.get("Price"));
                }
            }

            table.setHeaderRows(1);

            document.add(table);

            //pris och moms
            paragraph = new Paragraph("Pris innehåll: " + totalPrice + ", varav moms: " + totalPrice * 0.25);
            document.add(paragraph);
            
            paragraph = new Paragraph("Beskrivning av innehållet: " + description);
            document.add(paragraph);

            document.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
