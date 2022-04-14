/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatsystem;

import data.Address;
import data.Fabric;
import data.StandardHat;
import data.Order;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import data.SqlQuery;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import data.Customer;
import data.Address;
import javax.swing.JList;

/**
 *
 * @author luna
 */
public class LoginMenu extends javax.swing.JFrame {

    /**
     * Creates new form LoginMenu
     */

    // A HashMap that stores id and size from class AddHatType.
    private static HashMap<String, String> hashMapStandardHat = new HashMap<>();
    // An Array that stores id from class AddHatType.
    private static ArrayList<Integer> arrayOtherHat = new ArrayList<Integer>();
    private static DefaultListModel<String> orderListModel = new DefaultListModel<>();
    private Font defaultListFontOther;
    
    private static DefaultListModel<String> listModel = new DefaultListModel<>();
    
    private LoginMenu test;
    

    public LoginMenu() {
        initComponents();
        jListAllOrders.setModel(orderListModel);
        defaultListFontOther = jListAllOrders.getFont();
        jListAllOrders.setFont(new Font("monospaced", defaultListFontOther.getStyle(), defaultListFontOther.getSize()));
        jPanelOrderAddress.setVisible(false);
        //jListAllOrders.setModel(listModel);
        Font defaultListFont = jListAllOrders.getFont();
        jListAllOrders.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));
        
        this.test = test;
    }
    

    /**
     * Retrieves one standard hats compeleteID and size, and adds them to the jList "listFoundResults". Used in the "Sök" tab.
     */
    public static void addToListStandardHat(String completeHatIdentifier, String size) {
        hashMapStandardHat.put(completeHatIdentifier, size);

    }

    /**
     * Retrives one custum or special hats id and adds it to the ArrayList. Is then used for retrieving the hat from db.
     * @param hatID
     */
    public static void addToListOtherHat(int hatID) {

        arrayOtherHat.add(hatID);

    }

    /**
     * Fills the jList with standard hats from db.
     */
    private void listAllStandardHats() {

        DefaultListModel<String> listModel = new DefaultListModel<>();
        listFoundResults.setModel(listModel);

        ArrayList<HashMap<String, String>> allHats = StandardHat.getAllStandardHats();
        int index = 0;
        while (index < allHats.size()) {
            HashMap<String, String> currentHat = allHats.get(index);
            String fabricID = currentHat.get("Hat_Fabric");
            HashMap<String, String> currentFabric = Fabric.getFabricFromID(fabricID);

            listModel.addElement(String.format("%-20s %-20s %-20s" + currentHat.get("Price"), currentHat.get("Name"), currentFabric.get("Name"), currentFabric.get("Color")));

            index++;
        }
        Font defaultListFont = listFoundResults.getFont();
        listFoundResults.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));
    }

    /**
     * Fills the jList with information about all hats for the ongoing order.
     */
    public static void listOrderItems() {

        ArrayList<HashMap<String, String>> addedStandardHats = new ArrayList<>();
        ArrayList<HashMap<String, String>> addedOtherHats = new ArrayList<>();

        ArrayList<String> arrayOfCompleteID = new ArrayList<>();

        orderListModel.clear();

        if (!hashMapStandardHat.isEmpty()) {
                hashMapStandardHat.forEach((key, value) -> {
                String id = key.substring(0, key.indexOf("."));
                HashMap<String, String> fetchedHat = SqlQuery.getRow("SELECT * FROM Standard_Hat WHERE Standard_Hat_ID = " + id + ";");
                addedStandardHats.add(fetchedHat);
                arrayOfCompleteID.add(key);

            });

            for (String currentKey : hashMapStandardHat.keySet()) {
                String key = currentKey;
            }
            int index = 0;

            while (index < hashMapStandardHat.size()) {
                HashMap<String, String> currentHat = addedStandardHats.get(index);
                String completeID = arrayOfCompleteID.get(index);
                String size = hashMapStandardHat.get(completeID);

                String fabricID = currentHat.get("Hat_Fabric");
                HashMap<String, String> currentFabric = Fabric.getFabricFromID(fabricID);

                orderListModel.addElement(String.format("%-7s %-12s %-10s %-10s %-10s" + currentHat.get("Price"),
                        completeID, currentHat.get("Name"), currentFabric.get("Name"),
                        currentFabric.get("Color"), size));
                index++;

            }

        }

        if (!arrayOtherHat.isEmpty()) {
            for (int id : arrayOtherHat) {
                HashMap<String, String> fetchedHat = SqlQuery.getRow("SELECT * FROM Hat WHERE Hat_ID = " + id + ";");
                addedOtherHats.add(fetchedHat);
            }

            int index2 = 0;
            while (index2 < arrayOtherHat.size()) {
                HashMap<String, String> currentHat = addedOtherHats.get(index2);

                String fabricID = currentHat.get("Hat_Fabric");
                HashMap<String, String> currentFabric = Fabric.getFabricFromID(fabricID);

                orderListModel.addElement(String.format("%-7s %-12s %-10s %-10s %-10s" + currentHat.get("Price"), "C"
                        + currentHat.get("Hat_ID"), currentHat.get("Name"), currentFabric.get("Name"),
                        currentFabric.get("Color"), currentHat.get("Size")));

                index2++;

            }

        }
    }

    /**
     * Deletes all hats in jList from db and static lists.
     */
    private void deleteNonOrderedHats() {

        for (int id : arrayOtherHat) {
            SqlQuery.delete("DELETE FROM special_hat WHERE Hat_ID = " + id + ";");
            SqlQuery.delete("DELETE FROM custom_hat WHERE Hat_ID = " + id + ";");
            SqlQuery.delete("DELETE FROM hat WHERE Hat_ID = " + id + ";");
        }
        hashMapStandardHat.clear();
        arrayOtherHat.clear();
        orderListModel.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_start = new javax.swing.JPanel();
        lbl_title = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        btn_changePassword = new javax.swing.JButton();
        panel_createOrder = new javax.swing.JPanel();
        btnSaveOrder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAllOrders = new javax.swing.JList<>();
        btnAddNewHatType = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCreateNewCustomerFromOrder = new javax.swing.JButton();
        txtExpectedDate = new javax.swing.JTextField();
        btbDeleteChosenHat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jPanelOrderAddress = new javax.swing.JPanel();
        txtDeliveryAdress = new javax.swing.JTextField();
        txtPostCode = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        panel_register = new javax.swing.JPanel();
        btnRegisterCustomer = new javax.swing.JButton();
        btnRegisterStandardHat = new javax.swing.JButton();
        btnRegisterFabric = new javax.swing.JButton();
        panel_search = new javax.swing.JPanel();
        lblChooseCategory = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
        tfUserInput = new javax.swing.JTextField();
        btnSearchCategory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFoundResults = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFocusable(false);

        lbl_title.setText("Välkommen");

        btn_logout.setText("Logga ut");

        btn_changePassword.setText("Ändra lösenord");
        btn_changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_startLayout = new javax.swing.GroupLayout(panel_start);
        panel_start.setLayout(panel_startLayout);
        panel_startLayout.setHorizontalGroup(
            panel_startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_startLayout.createSequentialGroup()
                .addGroup(panel_startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_startLayout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(btn_logout))
                    .addGroup(panel_startLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(btn_changePassword))
                    .addGroup(panel_startLayout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(lbl_title)))
                .addContainerGap(356, Short.MAX_VALUE))
        );
        panel_startLayout.setVerticalGroup(
            panel_startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_startLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbl_title)
                .addGap(105, 105, 105)
                .addComponent(btn_changePassword)
                .addGap(33, 33, 33)
                .addComponent(btn_logout)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Start", panel_start);

        btnSaveOrder.setText("Spara order");
        btnSaveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOrderActionPerformed(evt);
            }
        });

        jScrollPane2.setColumnHeaderView(null);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jListAllOrders.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jListAllOrders);

        btnAddNewHatType.setText("Lägg till ny hatt i order");
        btnAddNewHatType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewHatTypeActionPerformed(evt);
            }
        });

        jButton4.setText("Rensa alla hattar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Kund");

        jLabel3.setText("Leveransadress");

        jLabel4.setText("Beräknat leveransdatum");

        jLabel5.setText("Orderstatus");

        btnCreateNewCustomerFromOrder.setText("Lägg till kund");
        btnCreateNewCustomerFromOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewCustomerFromOrderActionPerformed(evt);
            }
        });

        btbDeleteChosenHat.setText("Ta bort vald hatt");
        btbDeleteChosenHat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbDeleteChosenHatActionPerformed(evt);
            }
        });

        jLabel1.setText("Postadress");

        jLabel6.setText("Land");

        lblCustomerName.setText(" ");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Under utvärdering", "Pågående", "Redo att skickas" }));

        javax.swing.GroupLayout jPanelOrderAddressLayout = new javax.swing.GroupLayout(jPanelOrderAddress);
        jPanelOrderAddress.setLayout(jPanelOrderAddressLayout);
        jPanelOrderAddressLayout.setHorizontalGroup(
            jPanelOrderAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDeliveryAdress)
            .addGroup(jPanelOrderAddressLayout.createSequentialGroup()
                .addGroup(jPanelOrderAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCountry)
                    .addGroup(jPanelOrderAddressLayout.createSequentialGroup()
                        .addComponent(txtPostCode, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelOrderAddressLayout.setVerticalGroup(
            jPanelOrderAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOrderAddressLayout.createSequentialGroup()
                .addComponent(txtDeliveryAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOrderAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPostCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel_createOrderLayout = new javax.swing.GroupLayout(panel_createOrder);
        panel_createOrder.setLayout(panel_createOrderLayout);
        panel_createOrderLayout.setHorizontalGroup(
            panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_createOrderLayout.createSequentialGroup()
                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(btnSaveOrder))
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddNewHatType)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btbDeleteChosenHat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_createOrderLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(105, 105, 105)
                                .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnCreateNewCustomerFromOrder))
                            .addGroup(panel_createOrderLayout.createSequentialGroup()
                                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(53, 53, 53)
                                .addComponent(jPanelOrderAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel_createOrderLayout.createSequentialGroup()
                                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtExpectedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(21, 31, Short.MAX_VALUE))
        );
        panel_createOrderLayout.setVerticalGroup(
            panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_createOrderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblCustomerName)
                    .addComponent(btnCreateNewCustomerFromOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addComponent(jPanelOrderAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtExpectedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btbDeleteChosenHat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddNewHatType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveOrder)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Skapa order", panel_createOrder);

        btnRegisterCustomer.setText("Registrera ny kund");
        btnRegisterCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterCustomerActionPerformed(evt);
            }
        });

        btnRegisterStandardHat.setText("Registrera ny standardhatt");
        btnRegisterStandardHat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterStandardHatActionPerformed(evt);
            }
        });

        btnRegisterFabric.setText("Registrera nytt tyg");

        javax.swing.GroupLayout panel_registerLayout = new javax.swing.GroupLayout(panel_register);
        panel_register.setLayout(panel_registerLayout);
        panel_registerLayout.setHorizontalGroup(
            panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_registerLayout.createSequentialGroup()
                .addGroup(panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_registerLayout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(btnRegisterCustomer))
                    .addGroup(panel_registerLayout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(btnRegisterStandardHat))
                    .addGroup(panel_registerLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(btnRegisterFabric)))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        panel_registerLayout.setVerticalGroup(
            panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_registerLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnRegisterCustomer)
                .addGap(50, 50, 50)
                .addComponent(btnRegisterStandardHat)
                .addGap(45, 45, 45)
                .addComponent(btnRegisterFabric)
                .addContainerGap(241, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrera", panel_register);

        lblChooseCategory.setText("Ange sökkategori:");

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kunder", "Ordrar", "Standardhattar" }));
        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });

        btnSearchCategory.setText("Sök");
        btnSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCategoryActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listFoundResults);

        javax.swing.GroupLayout panel_searchLayout = new javax.swing.GroupLayout(panel_search);
        panel_search.setLayout(panel_searchLayout);
        panel_searchLayout.setHorizontalGroup(
            panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_searchLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_searchLayout.createSequentialGroup()
                        .addComponent(lblChooseCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfUserInput)
                            .addComponent(cbCategory, 0, 229, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchCategory)
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_searchLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );
        panel_searchLayout.setVerticalGroup(
            panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_searchLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChooseCategory))
                .addGap(27, 27, 27)
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchCategory))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sök", panel_search);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changePasswordActionPerformed
        new ChangePsw().setVisible(true);
    }//GEN-LAST:event_btn_changePasswordActionPerformed

    private void btnAddNewHatTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewHatTypeActionPerformed
        new AddHatType().setVisible(true);
    }//GEN-LAST:event_btnAddNewHatTypeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        deleteNonOrderedHats();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCategoryActionPerformed

    private void btnSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCategoryActionPerformed

        switch (cbCategory.getSelectedItem().toString()) {
            case "Standardhattar":
                listAllStandardHats();
                break;
            case "Ordrar":
                break;
            case "Kunder":
//TODO listOrderItems();
                
                listAllCustomers(listModel);
                
                break;
        }
    }//GEN-LAST:event_btnSearchCategoryActionPerformed

    private void btnRegisterCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterCustomerActionPerformed
        new AddCustomer().setVisible(true);
    }//GEN-LAST:event_btnRegisterCustomerActionPerformed

    private void btnRegisterStandardHatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterStandardHatActionPerformed
        new AddStandardHat().setVisible(true);
    }//GEN-LAST:event_btnRegisterStandardHatActionPerformed

    private void btnCreateNewCustomerFromOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewCustomerFromOrderActionPerformed
        new FindCustomerFromOrder(this).setVisible(true);
    }//GEN-LAST:event_btnCreateNewCustomerFromOrderActionPerformed

    private void btnSaveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOrderActionPerformed
        String totalPrice = "";
        String deliveryDate = txtExpectedDate.getText();
        String orderDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String status = "Ongoing";

        String streetAddress = "";
        String postCode = "";
        String city = "";
        String country = "";
        HashMap<String, String> chosenAddress = Address.getAddress(streetAddress, postCode, city, country);
        String adressID = chosenAddress.get("Address_ID");

        // TODO få med kunden från sökrutan/skapandet av kund
        String customer = "";
        // TODO få med vem som skapade ordern. Behöver man lagra detta i konstruktorn för att få med vem som är inloggad?
        String createdBy = "";

        // TODO validering för om kund/adress/datum är valt

        if(!hashMapStandardHat.isEmpty()){
            int index = 0;
            while (index < hashMapStandardHat.size()){
                Order.addToOrder(totalPrice, deliveryDate, orderDate, status, adressID, customer, createdBy);
            }
        }
        else{
            for (int id : arrayOtherHat){

            }
        }
        if(!arrayOtherHat.isEmpty()){

        }
    }//GEN-LAST:event_btnSaveOrderActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        deleteNonOrderedHats();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Deletes choosen hat from jList, db and static lists.
     * @param evt
     */
    private void btbDeleteChosenHatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbDeleteChosenHatActionPerformed
        String itemToDelete = orderListModel.getElementAt(jListAllOrders.getSelectedIndex());
        String typeOfHat = itemToDelete.substring(0, 1);
        String customHatID = itemToDelete.substring(1, 7).replaceAll("\\s", "");
        String standardHatID = itemToDelete.substring(0, 7).replaceAll("\\s", "");

        String hatIdentifier;
        if (typeOfHat.equals("C")) {

            //Lambda uttryck som tar bort ALLA element i listan som har värdet av hatID.
            arrayOtherHat.removeIf(s -> s == Integer.parseInt(customHatID));

            SqlQuery.delete("DELETE FROM special_hat WHERE Hat_ID = " + customHatID + ";");
            SqlQuery.delete("DELETE FROM custom_hat WHERE Hat_ID = " + customHatID + ";");
            SqlQuery.delete("DELETE FROM hat WHERE Hat_ID = " + customHatID + ";");

        } else {
            hashMapStandardHat.remove(standardHatID);
        }
        listOrderItems();

    }//GEN-LAST:event_btbDeleteChosenHatActionPerformed

    // från här
    public static void listAllCustomers(DefaultListModel listModel) {


//        DefaultListModel<String> listModel = new DefaultListModel<>();
//        resultList.setModel(listModel);

        ArrayList<HashMap<String, String>> allCustomers = Customer.getAllCustomers();
        int index = 0;
        while (index < allCustomers.size()) {
            HashMap<String, String> currentCustomer = allCustomers.get(index);
            HashMap<String, String> currentAddress = Address.getAddressFromID(currentCustomer.get("Address"));

            listModel.addElement(String.format("%-12s %-15s %-20s %-25s %-20s %-10s %-15s %-15s"
                    + currentCustomer.get("Comment"),
                    currentCustomer.get("Customer_Nr"),
                    currentCustomer.get("First_Name"),
                    currentCustomer.get("Last_Name"),
                    currentCustomer.get("Email"),
                    currentAddress.get("Street"),
                    currentAddress.get("Postal"),
                    currentAddress.get("City"),
                    currentAddress.get("Country")
            ));

            index++;
        }

//        Font defaultListFont = resultList.getFont();
//        resultList.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));
    }
    
    public void setCustomerStuff(HashMap<String, String> customerInfo){
        
    }
    
    public void addCustomerInfoToOrder(HashMap<String, String> customerInfo){
        
        lblCustomerName.setText(customerInfo.get("First_Name") + " " + customerInfo.get("Last_Name"));
        
        HashMap<String, String> address = Address.getAddressFromID(customerInfo.get("Address"));
        
        txtDeliveryAdress.setText(address.get("Street"));
        txtPostCode.setText(address.get("Postal"));
        txtCity.setText(address.get("City"));
        txtCountry.setText(address.get("Country"));
        jPanelOrderAddress.setVisible(true);
              
        
    }

    //till här

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbDeleteChosenHat;
    private javax.swing.JButton btnAddNewHatType;
    private javax.swing.JButton btnCreateNewCustomerFromOrder;
    private javax.swing.JButton btnRegisterCustomer;
    private javax.swing.JButton btnRegisterFabric;
    private javax.swing.JButton btnRegisterStandardHat;
    private javax.swing.JButton btnSaveOrder;
    private javax.swing.JButton btnSearchCategory;
    private javax.swing.JButton btn_changePassword;
    private javax.swing.JButton btn_logout;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jListAllOrders;
    private javax.swing.JPanel jPanelOrderAddress;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblChooseCategory;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JList<String> listFoundResults;
    private javax.swing.JPanel panel_createOrder;
    private javax.swing.JPanel panel_register;
    private javax.swing.JPanel panel_search;
    private javax.swing.JPanel panel_start;
    private javax.swing.JTextField tfUserInput;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtDeliveryAdress;
    private javax.swing.JTextField txtExpectedDate;
    private javax.swing.JTextField txtPostCode;
    // End of variables declaration//GEN-END:variables
}
