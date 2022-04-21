/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatsystem;

import data.Address;
import data.Customer;
import java.util.HashMap;
import javax.swing.JOptionPane;
import data.SqlQuery;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
/**
 *
 * @author Friday
 */
public class EditCustomer extends javax.swing.JFrame {
    
    private static String customerID;
    private String oldFirstName;
    private String oldLastName;
    private String oldEmail;
    private String oldTelephone;
    private String oldComment;
    private String oldStreetAddress;
    private String oldPostCode;
    private String oldCity;
    private String oldCountry;
    /**
     * Creates new form EditInformation
     */
    public EditCustomer() {
        initComponents();
        this.customerID = "1";
        fillOrderList();
        fillCustomerInfo();   
    }
    
    private void fillOrderList(){
                
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listCustomerOrders.setModel(listModel);
        Font defaultListFont = listCustomerOrders.getFont();
        listCustomerOrders.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));
        
        ArrayList<HashMap<String, String>> orders = SqlQuery.getMultipleRows("SELECT * FROM orders WHERE Customer = "+ customerID +";");
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
    
    private void fillCustomerInfo(){
        HashMap<String, String> customer = SqlQuery.getRow("SELECT * FROM customer WHERE Customer_ID = "+ customerID +";");
        HashMap<String, String> address = Address.getAddressFromID(customer.get("Address"));
        
        oldFirstName = customer.get("First_Name");
        txt_firstName.setText(oldFirstName);
        oldLastName = customer.get("Last_Name");
        txt_lastName.setText(oldLastName);
        oldEmail = customer.get("Email");
        txt_email.setText(oldEmail);
        oldTelephone = customer.get("Phone_Nr");
        txt_telephone.setText(oldTelephone);
        oldComment = customer.get("Comment");
        txt_comment.setText(oldComment);
        
        oldStreetAddress = address.get("Street");
        txt_streetAddress.setText(oldStreetAddress);
        oldPostCode = address.get("Postal");
        txt_postCode.setText(oldPostCode);
        oldCity = address.get("City");
        txt_city.setText(oldCity);
        oldCountry = address.get("Country");
        txt_country.setText(oldCountry);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_firstName = new javax.swing.JTextField();
        lbl_firstName = new javax.swing.JLabel();
        lbl_lastName = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_telephone = new javax.swing.JLabel();
        lbl_streetAddress = new javax.swing.JLabel();
        lbl_postCode = new javax.swing.JLabel();
        lbl_city = new javax.swing.JLabel();
        lbl_comment = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_comment = new javax.swing.JTextArea();
        txt_lastName = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_telephone = new javax.swing.JTextField();
        txt_streetAddress = new javax.swing.JTextField();
        txt_postCode = new javax.swing.JTextField();
        txt_city = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        lbl_redigera_kunduppifter = new javax.swing.JLabel();
        btn_Delete = new javax.swing.JButton();
        txt_country = new javax.swing.JTextField();
        lbl_country = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listCustomerOrders = new javax.swing.JList<>();
        lbl_kundens_tidigare_ordrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbl_firstName.setText("Förnamn");

        lbl_lastName.setText("Efternamn");

        lbl_email.setText("E-post");

        lbl_telephone.setText("Telefonnummer");

        lbl_streetAddress.setText("Gatuadress");

        lbl_postCode.setText("Postnummer");

        lbl_city.setText("Stad");

        lbl_comment.setText("Kommentar");

        txt_comment.setColumns(20);
        txt_comment.setRows(5);
        jScrollPane1.setViewportView(txt_comment);

        btn_save.setText("Spara ändringar");

        lbl_redigera_kunduppifter.setText("Redigera kunduppgifter");

        btn_Delete.setText("Radera kund");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        lbl_country.setText("Land");

        listCustomerOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listCustomerOrders.setToolTipText("");
        jScrollPane2.setViewportView(listCustomerOrders);

        lbl_kundens_tidigare_ordrar.setText("Kundens tidigare ordrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_country)
                                    .addComponent(lbl_lastName)
                                    .addComponent(lbl_firstName)
                                    .addComponent(lbl_telephone)
                                    .addComponent(lbl_email)
                                    .addComponent(lbl_streetAddress)
                                    .addComponent(lbl_postCode)
                                    .addComponent(lbl_city))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_comment)
                                .addGap(30, 30, 30)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_lastName)
                                    .addComponent(txt_firstName)
                                    .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txt_streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_postCode, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(lbl_redigera_kunduppifter))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btn_save)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(513, 513, 513)
                        .addComponent(btn_Delete)
                        .addContainerGap(90, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_kundens_tidigare_ordrar)
                        .addGap(280, 280, 280))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_redigera_kunduppifter)
                    .addComponent(lbl_kundens_tidigare_ordrar))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_firstName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_lastName))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_telephone)
                            .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_email))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_streetAddress))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_postCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_postCode))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_city))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_country))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_comment)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_Delete))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        boolean deActivated = false;
        String deActivateCustQuery = "update customer set Active = 0 where Customer_ID = "+customerID+";";
        if (JOptionPane.showConfirmDialog(null, "Är du säker?", "VARNING! Detta kommer att radera vald kund!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            deActivated = SqlQuery.update(deActivateCustQuery);
        } else {
            // no option
        }
        if (deActivated) {
            JOptionPane.showMessageDialog(null, "Kunden är nu raderad!");
        } else {
            JOptionPane.showMessageDialog(null, "Ingen kund har raderats!");
        }
    }//GEN-LAST:event_btn_DeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Delete;
    private javax.swing.JButton btn_save;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_city;
    private javax.swing.JLabel lbl_comment;
    private javax.swing.JLabel lbl_country;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_firstName;
    private javax.swing.JLabel lbl_kundens_tidigare_ordrar;
    private javax.swing.JLabel lbl_lastName;
    private javax.swing.JLabel lbl_postCode;
    private javax.swing.JLabel lbl_redigera_kunduppifter;
    private javax.swing.JLabel lbl_streetAddress;
    private javax.swing.JLabel lbl_telephone;
    private javax.swing.JList<String> listCustomerOrders;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextArea txt_comment;
    private javax.swing.JTextField txt_country;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_firstName;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_postCode;
    private javax.swing.JTextField txt_streetAddress;
    private javax.swing.JTextField txt_telephone;
    // End of variables declaration//GEN-END:variables
}
