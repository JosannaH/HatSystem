/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatsystem;

import com.mysql.cj.log.Log;
import data.Fabric;
import data.SqlQuery;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import data.Address;
import data.Validation;
import data.Customer;
import data.GeneratePDF;
import data.Order;
import data.StandardHat;
import java.io.File;
import javax.swing.JFileChooser;

/*
TODO om man redigerar en customthatfromorder och sparar den så uppdateras priset på hatten,
men totalpriset på ordern ändras inte i databasen även om man trycker på spara kund och orderuppgifter
 */
 /*
TODO jag redigerade en order med tre hattar:  raderade en hatt, totalpriset på ordern uppdaterades i
databasen men det blev fel pris, den räknade bara en av hattarna som var kvar i ordern
 */
/**
 *
 * @author Friday
 */
public class EditOrder extends javax.swing.JFrame {

    private int orderID;
    private String oldCustomerID;
    private String oldStreet;
    private String oldPostal;
    private String oldCity;
    private String oldCountry;
    private String oldDeliveryDate;
    private String oldStatus;
    DefaultListModel<String> listModel = new DefaultListModel<>();
    private LoginMenu loginMenu;
    private EditCustomer mainEditCustomer;

    /**
     * Creates new form EditOrder
     */
    public EditOrder(int orderID) {
        initComponents();
        this.orderID = orderID;
        fillHatList();
        fillOrderInfo();
        lblErrorMessage.setVisible(false);
        lblErrorMessage2.setVisible(false);
        lstListOrderedHats.setModel(listModel);
        Font defaultListFont = lstListOrderedHats.getFont();
        lstListOrderedHats.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));
    }

    /**
     * For aditing from Sök-lista i LoginMenu
     */
    public EditOrder(int orderID, LoginMenu loginMenu) {
        initComponents();
        this.orderID = orderID;
        this.loginMenu = loginMenu;
        fillHatList();
        fillOrderInfo();
        lblErrorMessage.setVisible(false);
        lblErrorMessage2.setVisible(false);
        lstListOrderedHats.setModel(listModel);
        Font defaultListFont = lstListOrderedHats.getFont();
        lstListOrderedHats.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));
    }
    public EditOrder(int orderID, EditCustomer mainEditCustomer) {
        initComponents();
        this.orderID = orderID;
        this.mainEditCustomer = mainEditCustomer;
        fillHatList();
        fillOrderInfo();
        lblErrorMessage.setVisible(false);
        lblErrorMessage2.setVisible(false);
        lstListOrderedHats.setModel(listModel);
        Font defaultListFont = lstListOrderedHats.getFont();
        lstListOrderedHats.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstListOrderedHats = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        lblOrderNr = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfStreet = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblTotPrice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        lblOrderDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfExpectedDeliveryDate = new javax.swing.JTextField();
        tfPostal = new javax.swing.JTextField();
        tfCity = new javax.swing.JTextField();
        tfCountry = new javax.swing.JTextField();
        btnDeleteOrder = new javax.swing.JButton();
        btnDeleteHat = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblErrorMessage = new javax.swing.JLabel();
        btnEditHat = new javax.swing.JButton();
        lblErrorMessage2 = new javax.swing.JLabel();
        btnGenerateInvoice = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblCustomerNr = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Redigera orderuppgifter");

        lstListOrderedHats.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstListOrderedHats);

        jLabel2.setText("Ordernummer:");

        lblOrderNr.setText("jLabel3");

        jLabel4.setText("Kund och nummer");

        jLabel5.setText("Leveransadress");

        tfStreet.setToolTipText("Gatuadress");

        jLabel6.setText("Redigera hattuppgifter");

        lblTotPrice.setText("------");

        jLabel3.setText("Orderstatus");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Under utvärdering", "Pågående", "Redo att skickas", "Skickad" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        lblOrderDate.setText("jLabel7");

        jLabel8.setText("Orderdatum:");

        jLabel7.setText("Förväntat leveransdatum");

        tfPostal.setToolTipText("Postnummer");

        tfCity.setToolTipText("Stad");

        tfCountry.setToolTipText("Land");

        btnDeleteOrder.setBackground(new java.awt.Color(153, 0, 0));
        btnDeleteOrder.setForeground(new java.awt.Color(204, 204, 204));
        btnDeleteOrder.setText("Radera order");
        btnDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrderActionPerformed(evt);
            }
        });

        btnDeleteHat.setText("Ta bort hatt");
        btnDeleteHat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteHatActionPerformed(evt);
            }
        });

        jLabel9.setText("Totalpris:");

        btnSave.setText("Spara kund- och orderuppgifter");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblName.setText("Bertil Bertilsson");

        lblErrorMessage.setForeground(new java.awt.Color(153, 0, 0));
        lblErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErrorMessage.setText("jLabel10");

        btnEditHat.setText("Redigera hatt");
        btnEditHat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditHatActionPerformed(evt);
            }
        });

        lblErrorMessage2.setForeground(new java.awt.Color(153, 0, 51));
        lblErrorMessage2.setText("Vänligen välj en hatt i listan först");

        btnGenerateInvoice.setText("Generera fraktsedel");
        btnGenerateInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateInvoiceActionPerformed(evt);
            }
        });

        jButton1.setText("Generera orderöversikt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblCustomerNr.setText("-----------");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btnDeleteHat, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEditHat))
                                    .addComponent(lblErrorMessage2, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblTotPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(155, 155, 155)
                                        .addComponent(btnDeleteOrder))))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfExpectedDeliveryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblOrderNr, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(tfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblOrderDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 235, Short.MAX_VALUE)
                                                .addComponent(btnGenerateInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCustomerNr, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))))
                        .addGap(33, 33, 33))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnDeleteOrder))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnGenerateInvoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(lblOrderNr))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(lblOrderDate))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addComponent(tfExpectedDeliveryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblName)
                            .addComponent(lblCustomerNr))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(24, 24, 24)
                .addComponent(lblErrorMessage2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteHat)
                    .addComponent(btnEditHat)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotPrice)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(lblErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrderActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill radera denna order?", "Varning!", JOptionPane.YES_NO_OPTION);

        if (x == JOptionPane.YES_OPTION) {
            SqlQuery.update("UPDATE orders SET Active = 0 WHERE Orders_ID = " + orderID + ";");

            if (mainEditCustomer != null) {
                mainEditCustomer.fillOrderList();

            }
            else{
              loginMenu.fillCorrectCategory();
            }
                this.dispose();

        }

    }//GEN-LAST:event_btnDeleteOrderActionPerformed

    private void btnDeleteHatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteHatActionPerformed
        double totalPrice = Double.parseDouble(SqlQuery.getValue("SELECT Total_Price FROM orders WHERE Orders_ID = " + orderID + ";"));
        int x = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill radera denna hatt från ordern?", "Varning!", JOptionPane.YES_NO_OPTION);

        if (x == JOptionPane.YES_OPTION) {
            String chosenHat = lstListOrderedHats.getSelectedValue();
            if (chosenHat.substring(0, 1).equalsIgnoreCase("S")) {
                String hatID = chosenHat.substring(1, 9).trim();
                SqlQuery.delete("DELETE FROM ordered_st_hat WHERE Standard_Hat = " + hatID + " AND Order_Nr = " + orderID + ";");
                HashMap<String, String> hat = StandardHat.getHat(Integer.parseInt(hatID));
                totalPrice -= Double.parseDouble(hat.get("Price"));
                SqlQuery.update("UPDATE orders SET Total_Price = " + totalPrice + " WHERE Orders_ID = " + orderID + ";");
            } else {
                String hatID = chosenHat.substring(1, 9).trim();
                totalPrice -= Double.parseDouble(SqlQuery.getValue("SELECT Price FROM hat WHERE Hat_ID = " + hatID + ";"));
                SqlQuery.update("UPDATE orders SET Total_Price = " + totalPrice + " WHERE Orders_ID = " + orderID + ";");

                SqlQuery.delete("DELETE FROM custom_hat WHERE Hat_ID = " + hatID + ";");
                SqlQuery.delete("DELETE FROM special_hat WHERE Hat_ID = " + hatID + ";");
                SqlQuery.delete("DELETE FROM ordered_hat WHERE Hat_ID = " + hatID + ";");
                SqlQuery.delete("DELETE FROM hat WHERE Hat_ID = " + hatID + ";");
            }
        }

        fillHatList();
    }//GEN-LAST:event_btnDeleteHatActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        lblErrorMessage.setVisible(false);

        String chosenDeliveryDate = tfExpectedDeliveryDate.getText();
        String chosenCustomerNr = lblCustomerNr.getText();
        String chosenStreet = tfStreet.getText();
        String chosenPostal = tfPostal.getText();
        String chosenCity = tfCity.getText();
        String chosenCountry = tfCountry.getText();
        String chosenStatus = cmbStatus.getSelectedItem().toString();

        if (chosenDeliveryDate.isBlank() || chosenCustomerNr.isBlank() || chosenStreet.isBlank() || chosenPostal.isBlank() || chosenCity.isBlank() || chosenCountry.isBlank()) {
            lblErrorMessage.setText("Vänligen se till att alla fält är ifyllda");
            lblErrorMessage.setVisible(true);
        } else {
            if (chosenCustomerNr.length() == 8) {
                if (Validation.isDate(chosenDeliveryDate)) {
                    if (Validation.isInteger(chosenCustomerNr)) {
                        if (Validation.isInteger(chosenPostal)) {
                            if (Validation.isValidMonthAndDay(chosenDeliveryDate.substring(5, 7), chosenDeliveryDate.substring(8, 10))) {
                                HashMap<String, String> foundCustomer = Customer.getCustomer(chosenCustomerNr);
                                if (!foundCustomer.isEmpty()) {
                                    setDeliveryDate(chosenDeliveryDate);
                                    setCustomer(chosenCustomerNr);
                                    setDeliveryAddress();
                                    setOrderStatus(chosenStatus);
                                    fillOrderInfo();
                                    JOptionPane.showMessageDialog(null, "Ändringar sparade");
                                    if(mainEditCustomer != null){
                                        mainEditCustomer.fillOrderList();
                                    }
                                    else{
                                        loginMenu.fillCorrectCategory();
                                    }
                                    dispose();
                                } else {
                                    lblErrorMessage.setText("Kund med angivet kundnummer existerar inte");
                                    lblErrorMessage.setVisible(true);
                                }
                            } else {
                                lblErrorMessage.setText("Vänligen ange ett giltigt datum");
                                lblErrorMessage.setVisible(true);
                            }
                        } else {
                            lblErrorMessage.setText("Postnummer måste bestå av endast siffror");
                            lblErrorMessage.setVisible(true);
                        }
                    } else {
                        lblErrorMessage.setText("Kundnummer måste bestå av endast siffror");
                        lblErrorMessage.setVisible(true);
                    }
                } else {
                    lblErrorMessage.setText("Vänligen ange datum i formatet yyyy-mm-dd");
                    lblErrorMessage.setVisible(true);
                }
            }
            else {
                    lblErrorMessage.setText("Kundrumret ska bestå av 8 siffror");
                    lblErrorMessage.setVisible(true);
                }

        }

//        InputValidering.isValidMonthAndDay(datum.substring(5, 7), datum.substring(8, 10));

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditHatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditHatActionPerformed
        lblErrorMessage2.setVisible(false);
        String id = lstListOrderedHats.getSelectedValue();
        if (id == null) {
            lblErrorMessage2.setVisible(true);
        } else {
            if (id.substring(0, 1).equals("C")) {
                new EditCustomHatFromOrder(id, this).setVisible(true);
            } else {
                new EditStandardHatFromOrder(id, this).setVisible(true);
            }
        }

    }//GEN-LAST:event_btnEditHatActionPerformed

    private void btnGenerateInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateInvoiceActionPerformed
        new GenerateInvoicePDF(Integer.toString(orderID)).setVisible(true);
    }//GEN-LAST:event_btnGenerateInvoiceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Vill du generera en ordersammanställning?", "Ordersammanställning", JOptionPane.YES_NO_OPTION);

        if (x == JOptionPane.YES_OPTION) {

            JFileChooser fc = new JFileChooser();
            //så användaren endast kan välja mappar
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {

                File file = fc.getSelectedFile();
                //hämtar den valda mappens sökväg
                String searchPath = file.getAbsolutePath();

                searchPath += ("\\Orderoversikt_" + orderID);

                //skapar fraktsedeln
                GeneratePDF.generateOrderPDF(Integer.toString(orderID), searchPath);
                JOptionPane.showMessageDialog(null, "Sammanställning har skapats");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(mainEditCustomer != null){
            mainEditCustomer.fillOrderList();
        }
        else{
            loginMenu.fillCorrectCategory();
        }
    }//GEN-LAST:event_formWindowClosing

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed

    /**
     * Hämtar alla hattar
     */
    public void fillHatList() {

        listModel.clear();

        double totalPrice = 0;

        ArrayList<HashMap<String, String>> orderedStandardHats = SqlQuery.getMultipleRows("SELECT * FROM Standard_Hat WHERE Standard_Hat_ID IN (SELECT Standard_Hat FROM Ordered_St_Hat WHERE Order_Nr = " + orderID + ")");

        int index = 0;
        while (index < orderedStandardHats.size()) {
            HashMap<String, String> currentHat = orderedStandardHats.get(index);
            String fabricID = currentHat.get("Hat_Fabric");
            HashMap<String, String> currentFabric = Fabric.getFabricFromID(fabricID);
            String size = SqlQuery.getValue("SELECT Size FROM ordered_st_hat WHERE Standard_Hat = " + currentHat.get("Standard_Hat_ID") + " AND Order_Nr = " + orderID + ";");

            listModel.addElement(String.format("%-10s %-20s %-8s %-20s %-20s "
                    + currentHat.get("Price"),
                    "S" + currentHat.get("Standard_Hat_ID"),
                    currentHat.get("Name"),
                    size,
                    currentFabric.get("Name"),
                    currentFabric.get("Color")));

            totalPrice += Double.parseDouble(currentHat.get("Price"));

            index++;
        }

        ArrayList<HashMap<String, String>> orderedOtherHats = SqlQuery.getMultipleRows("SELECT * FROM hat WHERE Hat_ID IN (SELECT Hat_ID FROM ordered_hat WHERE Order_Nr = " + orderID + ");");

        index = 0;
        while (index < orderedOtherHats.size()) {
            HashMap<String, String> currentHat = orderedOtherHats.get(index);
            String fabricID = currentHat.get("Hat_Fabric");
            HashMap<String, String> currentFabric = Fabric.getFabricFromID(fabricID);

            listModel.addElement(String.format("%-10s %-20s %-8s %-20s %-20s "
                    + currentHat.get("Price"),
                    "C" + currentHat.get("Hat_ID"),
                    currentHat.get("Name"),
                    currentHat.get("Size"),
                    currentFabric.get("Name"),
                    currentFabric.get("Color")));

            totalPrice += Double.parseDouble(currentHat.get("Price"));

            index++;
        }
        String priceTwoDecimals = Validation.setTwoDecimals(totalPrice);
        String priceDot = priceTwoDecimals.replaceAll(",", ".");

        SqlQuery.update("UPDATE Orders SET Total_Price = " + priceDot + " WHERE Orders_ID = " + orderID + ";");

        lblTotPrice.setText(priceDot);

    }

    public void fillOrderInfo() {
        lblOrderNr.setText(Integer.toString(orderID));

        //fixar orderinfo
        HashMap<String, String> order = SqlQuery.getRow("SELECT * FROM orders WHERE Orders_ID = " + orderID + ";");
        lblOrderDate.setText(order.get("Order_Date"));
        oldDeliveryDate = order.get("Delivery_Date");
        oldStatus = order.get("Status");

        tfExpectedDeliveryDate.setText(oldDeliveryDate);
        cmbStatus.setSelectedItem(oldStatus);

        //fixar adressinfo
        HashMap<String, String> address = SqlQuery.getRow("SELECT * FROM address WHERE Address_ID IN (SELECT Delivery_Address FROM orders WHERE Orders_ID = " + orderID + ");");
        oldStreet = address.get("Street");
        oldPostal = address.get("Postal");
        oldCity = address.get("City");
        oldCountry = address.get("Country");

        tfStreet.setText(oldStreet);
        tfPostal.setText(oldPostal);
        tfCity.setText(oldCity);
        tfCountry.setText(oldCountry);

        //fixar kundinfo
        HashMap<String, String> customer = SqlQuery.getRow("SELECT * FROM customer WHERE Customer_ID IN (SELECT Customer FROM orders WHERE Orders_ID = " + orderID + ");");
        lblName.setText(customer.get("First_Name") + " " + customer.get("Last_Name"));
        oldCustomerID = customer.get("Customer_Nr");

        lblCustomerNr.setText(oldCustomerID);

    }

    public void setOrderStatus(String status) {
        SqlQuery.update("UPDATE orders SET Status = '" + status + "' WHERE Orders_ID = " + orderID + ";");
    }

    public void setDeliveryDate(String date) {
        SqlQuery.update("UPDATE orders SET Delivery_Date = '" + date + "' WHERE Orders_ID = " + orderID + ";");
    }

    public void setCustomer(String customerNr) {
        String id = SqlQuery.getValue("SELECT Customer_ID FROM customer WHERE Customer_Nr = " + customerNr + ";");
        SqlQuery.update("UPDATE orders SET Customer = " + id + " WHERE Orders_ID = " + orderID + ";");
    }

    public void setDeliveryAddress() {
        String street = tfStreet.getText();
        String postal = tfPostal.getText();
        String city = tfCity.getText();
        String country = tfCountry.getText();

        HashMap<String, String> existingAddress = Address.getAddress(street, postal, city, country);
        if (existingAddress.isEmpty()) {
            Address.addAddress(street, postal, city, country);
        }
        HashMap<String, String> address = Address.getAddress(street, postal, city, country);
        String addressID = address.get("Address_ID");
        SqlQuery.update("UPDATE orders SET Delivery_Address = " + addressID + " WHERE Orders_ID = " + orderID + ";");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteHat;
    private javax.swing.JButton btnDeleteOrder;
    private javax.swing.JButton btnEditHat;
    private javax.swing.JButton btnGenerateInvoice;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCustomerNr;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblErrorMessage2;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOrderDate;
    private javax.swing.JLabel lblOrderNr;
    private javax.swing.JLabel lblTotPrice;
    private javax.swing.JList<String> lstListOrderedHats;
    private javax.swing.JTextField tfCity;
    private javax.swing.JTextField tfCountry;
    private javax.swing.JTextField tfExpectedDeliveryDate;
    private javax.swing.JTextField tfPostal;
    private javax.swing.JTextField tfStreet;
    // End of variables declaration//GEN-END:variables
}
