/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatsystem;

import data.Address;
import data.Customer;
import data.SqlQuery;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author barak
 */
public class AddCustomer extends javax.swing.JFrame {


    private FindCustomerFromOrder findCustomerFromOrder;
    private LoginMenu mainLoginMenu;
    /**
     */
    public AddCustomer() {
        initComponents();
        lbl_errorMessage.setVisible(false);
    }
      public AddCustomer(FindCustomerFromOrder selectCustomerFrame, LoginMenu mainLoginMenu) {
        initComponents();
        lbl_errorMessage.setVisible(false);
        this.findCustomerFromOrder = selectCustomerFrame;
        this.mainLoginMenu = mainLoginMenu;
    }
    

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_firstName = new javax.swing.JTextField();
        txt_lastName = new javax.swing.JTextField();
        txt_streetAddress = new javax.swing.JTextField();
        lbl_firstName = new javax.swing.JLabel();
        lbl_lastName = new javax.swing.JLabel();
        lbl_streetAdress = new javax.swing.JLabel();
        txt_postCode = new javax.swing.JTextField();
        lbl_postCode = new javax.swing.JLabel();
        txt_city = new javax.swing.JTextField();
        lbl_city = new javax.swing.JLabel();
        txt_telephoneNumber = new javax.swing.JTextField();
        lbl_telephoneNumber = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        lbl_comment = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        lbl_country = new javax.swing.JLabel();
        txt_country = new javax.swing.JTextField();
        lbl_errorMessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_comment = new javax.swing.JTextArea();
        lblCheckFirstName = new javax.swing.JLabel();
        lblCheckLastName = new javax.swing.JLabel();
        lblCheckPhone = new javax.swing.JLabel();
        lblCheckEmail = new javax.swing.JLabel();
        lblCheckStreet = new javax.swing.JLabel();
        lblCheckPostal = new javax.swing.JLabel();
        lblCheckCity = new javax.swing.JLabel();
        lblCheckCountry = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Registrera ny kund");

        txt_firstName.setMinimumSize(new java.awt.Dimension(150, 22));

        txt_lastName.setMinimumSize(new java.awt.Dimension(150, 22));

        txt_streetAddress.setMinimumSize(new java.awt.Dimension(150, 22));

        lbl_firstName.setText("Förnamn");

        lbl_lastName.setText("Efternamn");

        lbl_streetAdress.setText("Gatuadress");

        txt_postCode.setMinimumSize(new java.awt.Dimension(150, 22));

        lbl_postCode.setText("Postnummer");

        txt_city.setMinimumSize(new java.awt.Dimension(150, 22));

        lbl_city.setText("Stad");

        txt_telephoneNumber.setMinimumSize(new java.awt.Dimension(150, 22));

        lbl_telephoneNumber.setText("Telefonnummer");

        txt_email.setMinimumSize(new java.awt.Dimension(150, 22));

        lbl_email.setText("E-post");

        lbl_comment.setText("Kommentar");

        btn_save.setText("Spara");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        lbl_country.setText("Land");

        lbl_errorMessage.setForeground(new java.awt.Color(153, 0, 0));
        lbl_errorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_errorMessage.setText("Vänligen fyll i alla fält");

        ta_comment.setColumns(20);
        ta_comment.setRows(5);
        jScrollPane1.setViewportView(ta_comment);

        lblCheckFirstName.setForeground(new java.awt.Color(153, 0, 0));

        lblCheckLastName.setForeground(new java.awt.Color(153, 0, 0));

        lblCheckPhone.setForeground(new java.awt.Color(153, 0, 0));

        lblCheckEmail.setForeground(new java.awt.Color(153, 0, 0));

        lblCheckStreet.setForeground(new java.awt.Color(153, 0, 0));

        lblCheckPostal.setForeground(new java.awt.Color(153, 0, 0));

        lblCheckCity.setForeground(new java.awt.Color(153, 0, 0));

        lblCheckCountry.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_email, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_streetAdress, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_telephoneNumber, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbl_postCode, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(30, 30, 30)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lbl_lastName)
                                                .addComponent(lbl_firstName))))
                                    .addComponent(lbl_city)
                                    .addComponent(lbl_comment)
                                    .addComponent(lbl_country))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_postCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_lastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_telephoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_streetAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_firstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_city, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCheckFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCheckLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCheckPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCheckEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCheckStreet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCheckPostal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCheckCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCheckCountry, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(btn_save))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(lbl_errorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCheckFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_firstName)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCheckLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_lastName)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCheckPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_telephoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_telephoneNumber)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCheckEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_email)))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_streetAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_streetAdress)
                    .addComponent(lblCheckStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_postCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_postCode)
                    .addComponent(lblCheckPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_city)
                    .addComponent(lblCheckCity, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_country)
                    .addComponent(lblCheckCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_comment)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(lbl_errorMessage)
                .addGap(18, 18, 18)
                .addComponent(btn_save)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        lbl_errorMessage.setVisible(false);

        String firstName = txt_firstName.getText();
        String lastName = txt_lastName.getText();
        String streetAddress = txt_streetAddress.getText();
        String postCode = txt_postCode.getText();
        String city = txt_city.getText();
        String telephone = txt_telephoneNumber.getText();
        String email = txt_email.getText();
        String comment = ta_comment.getText();
        String country = txt_country.getText();

        //Kontrollerar så alla fält är ifyllda
        if (firstName.isBlank() || lastName.isBlank() || email.isBlank() || telephone.isBlank() || streetAddress.isBlank() || postCode.isBlank() || city.isBlank() || country.isBlank()) {
            lbl_errorMessage.setText("Vänligen fyll i alla fält");
            lbl_errorMessage.setVisible(true);
        } else {
            HashMap<String, String> chosenAddress = Address.getAddress(streetAddress, postCode, city, country);
            HashMap<String, String> customer = Customer.checkIfCustomerExists(firstName, lastName, email, telephone);

            if (!customer.isEmpty()) {
                String query = "update customer set Active = 1 where First_Name = '"+ firstName+"' and Last_Name ='"+lastName+"' and Phone_Nr ='"+telephone+"'  and Email ='"+email+"';";
                SqlQuery.update(query);
                lbl_errorMessage.setText("Denna kund finns redan registrerad och har blivit aktiverad igen.");

                lbl_errorMessage.setVisible(true);
            } else {
                if (chosenAddress.isEmpty()) {
                    Address.addAddress(streetAddress, postCode, city, country);
                    HashMap<String, String> addedAddress = Address.getAddress(streetAddress, postCode, city, country);
                    String addedAddressID = addedAddress.get("Address_ID");
                    Customer.addCustomer(firstName, lastName, email, telephone, addedAddressID, comment);
                    String customerID = Customer.getLatestCustomer();
                    String customerNr = Customer.getCustomerNr(customerID);
                    JOptionPane.showMessageDialog(null, "Kunden är registrerad!");
                    if(findCustomerFromOrder.isVisible()){
                         HashMap<String, String> customerMap = Customer.getCustomer(customerNr);
                         mainLoginMenu.addCustomerInfoToOrder(customerMap, customerNr);
                        
                        findCustomerFromOrder.dispose();
                    }
                    this.dispose();
                    //LoginMenu().setVisible(true);
                }
                else{
                    String chosenAddressID = chosenAddress.get("Address_ID");
                    Customer.addCustomer(firstName, lastName, email, telephone, chosenAddressID, comment);
                    JOptionPane.showMessageDialog(null, "Kunden är registrerad!");
                    this.dispose();
                    //new LoginMenu().setVisible(true);
                }
            }
        }
        
        //Behövs validering för att ex kontrollera att ett telefonnummer bara består av siffror osv.

    }//GEN-LAST:event_btn_saveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCheckCity;
    private javax.swing.JLabel lblCheckCountry;
    private javax.swing.JLabel lblCheckEmail;
    private javax.swing.JLabel lblCheckFirstName;
    private javax.swing.JLabel lblCheckLastName;
    private javax.swing.JLabel lblCheckPhone;
    private javax.swing.JLabel lblCheckPostal;
    private javax.swing.JLabel lblCheckStreet;
    private javax.swing.JLabel lbl_city;
    private javax.swing.JLabel lbl_comment;
    private javax.swing.JLabel lbl_country;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_errorMessage;
    private javax.swing.JLabel lbl_firstName;
    private javax.swing.JLabel lbl_lastName;
    private javax.swing.JLabel lbl_postCode;
    private javax.swing.JLabel lbl_streetAdress;
    private javax.swing.JLabel lbl_telephoneNumber;
    private javax.swing.JTextArea ta_comment;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_country;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_firstName;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JTextField txt_postCode;
    private javax.swing.JTextField txt_streetAddress;
    private javax.swing.JTextField txt_telephoneNumber;
    // End of variables declaration//GEN-END:variables
}
