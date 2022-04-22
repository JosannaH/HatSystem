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
import data.Employee;
import data.GeneratePDF;
import data.Validation;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author luna
 */
public class LoginMenu extends javax.swing.JFrame {

    /**
     * Creates new form LoginMenu
     */
    private static String username;
    // A HashMap that stores id and size from class AddHatType.
    private static HashMap<String, String> hashMapStandardHat = new HashMap<>();
    // An Array that stores id from class AddHatType.
    private static ArrayList<Integer> arrayOtherHat = new ArrayList<Integer>();
    private static DefaultListModel<String> orderListModel = new DefaultListModel<>();
    private Font defaultListFontOther;
    private static DefaultListModel<String> listModel = new DefaultListModel<>();

    private static HashMap<String, String> hashMapListPrice = new HashMap<>();
    //Had to create a static label variable that references to the non-static lable
    //to be able to use it with static methods.
    private static JLabel totalPriceLabel;

    // refers to current LoginMenu object
    private static LoginMenu mainLoginMenu;

    public LoginMenu(String username) {
        this.username = username;
        initComponents();

        jListAllOrders.setModel(orderListModel);
        defaultListFontOther = jListAllOrders.getFont();
        jListAllOrders.setFont(new Font("monospaced", defaultListFontOther.getStyle(), defaultListFontOther.getSize()));
        jPanelOrderAddress.setVisible(false);
        listFoundResults.setModel(listModel);
        Font defaultListFont = jListAllOrders.getFont();
        jListAllOrders.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));
        listFoundResults.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));

        this.mainLoginMenu = mainLoginMenu;
        lblErrorMessageCategory.setVisible(false);
        totalPriceLabel = lblTotalPrice;
        // Belongs to "Sök" tab
        Customer.listAllCustomers(listModel);

    }

    /**
     * Returns the logged in username
     *
     * @return
     */
    public static String getUsername() {
        return username;
    }

    /**
     * Retrieves one standard hats compeleteID and size, and adds them to the
     * jList "listFoundResults". Used in the "Sök" tab.
     */
    public static void addToListStandardHat(String completeHatIdentifier, String size) {
        hashMapStandardHat.put(completeHatIdentifier, size);

    }

    /**
     * Retrives one custum or special hats id and adds it to the ArrayList. Is
     * then used for retrieving the hat from db.
     *
     * @param hatID
     */
    public static void addToListOtherHat(int hatID) {

        arrayOtherHat.add(hatID);

    }

    private static double getTotalPrice() {
        double totalPrice = 0;
        for (String i : hashMapListPrice.keySet()) {
            Double price = Double.parseDouble(hashMapListPrice.get(i));

            totalPrice += price;

        }
        return totalPrice;
    }

    private double getTotalPriceNonStatic() {
        double totalPrice = 0;
        for (String i : hashMapListPrice.keySet()) {
            Double price = Double.parseDouble(hashMapListPrice.get(i));

            totalPrice += price;
        }
        return totalPrice;
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

                hashMapListPrice.put(completeID, currentHat.get("Price"));
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
                hashMapListPrice.put(currentHat.get("Hat_ID"), currentHat.get("Price"));
                index2++;

            }

        }
        String totalPrice = String.valueOf(getTotalPrice());
        totalPriceLabel.setText(totalPrice);
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
        hashMapListPrice.clear();
        lblTotalPrice.setText(String.valueOf(getTotalPriceNonStatic()));
    }

    public void setCustomerStuff(HashMap<String, String> customerInfo) {
        // TODO Vad har vi tänkt här??
    }

    public void addCustomerInfoToOrder(HashMap<String, String> customerInfo, String customerNr) {

        lblCustomerName.setText(customerInfo.get("First_Name") + " " + customerInfo.get("Last_Name"));

        HashMap<String, String> address = Address.getAddressFromID(customerInfo.get("Address"));

        txtDeliveryAdress.setText(address.get("Street"));
        txtPostCode.setText(address.get("Postal"));
        txtCity.setText(address.get("City"));
        txtCountry.setText(address.get("Country"));
        jPanelOrderAddress.setVisible(true);
        lblCustomerNumber.setText(customerNr);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
        lblCustomerNumber = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panel_register = new javax.swing.JPanel();
        btnRegisterCustomer = new javax.swing.JButton();
        btnRegisterStandardHat = new javax.swing.JButton();
        btnRegisterFabric = new javax.swing.JButton();
        panel_search = new javax.swing.JPanel();
        lblChooseCategory = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFoundResults = new javax.swing.JList<>();
        btnEditCatergory = new javax.swing.JButton();
        lblErrorMessageCategory = new javax.swing.JLabel();
        btnUpdateCategory = new javax.swing.JButton();
        txtSearchWord = new javax.swing.JTextField();
        cmbSearchSpecific = new javax.swing.JComboBox<>();
        btnSearchSpecific = new javax.swing.JButton();
        lblErrorValidateSearchWord = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnGenerateMomsPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFocusable(false);

        lbl_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_title.setText("Välkommen "+ username);

        btn_logout.setText("Logga ut");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

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
                        .addGap(332, 332, 332)
                        .addGroup(panel_startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_startLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(btn_logout))
                            .addComponent(btn_changePassword)))
                    .addGroup(panel_startLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(301, Short.MAX_VALUE))
        );
        panel_startLayout.setVerticalGroup(
            panel_startLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_startLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(btn_changePassword)
                .addGap(33, 33, 33)
                .addComponent(btn_logout)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        lbl_title.getAccessibleContext().setAccessibleDescription("");

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

        jLabel7.setText("Kundnummer");

        jLabel9.setText("Summa");

        javax.swing.GroupLayout panel_createOrderLayout = new javax.swing.GroupLayout(panel_createOrder);
        panel_createOrder.setLayout(panel_createOrderLayout);
        panel_createOrderLayout.setHorizontalGroup(
            panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_createOrderLayout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_createOrderLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(panel_createOrderLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(31, 31, 31)))
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExpectedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addComponent(jPanelOrderAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCustomerNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(btnCreateNewCustomerFromOrder))
                    .addGroup(panel_createOrderLayout.createSequentialGroup()
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddNewHatType)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel_createOrderLayout.createSequentialGroup()
                                .addComponent(btnSaveOrder)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btbDeleteChosenHat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4))))
                .addGap(63, 63, 63))
        );
        panel_createOrderLayout.setVerticalGroup(
            panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_createOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomerNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(btnCreateNewCustomerFromOrder)))
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
                .addGroup(panel_createOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveOrder)
                    .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
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
        btnRegisterFabric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterFabricActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_registerLayout = new javax.swing.GroupLayout(panel_register);
        panel_register.setLayout(panel_registerLayout);
        panel_registerLayout.setHorizontalGroup(
            panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_registerLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addGroup(panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_registerLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnRegisterCustomer))
                    .addComponent(btnRegisterStandardHat)
                    .addGroup(panel_registerLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnRegisterFabric)))
                .addContainerGap(337, Short.MAX_VALUE))
        );
        panel_registerLayout.setVerticalGroup(
            panel_registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_registerLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(btnRegisterCustomer)
                .addGap(50, 50, 50)
                .addComponent(btnRegisterStandardHat)
                .addGap(45, 45, 45)
                .addComponent(btnRegisterFabric)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrera", panel_register);

        lblChooseCategory.setText("Ange sökkategori:");

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kunder", "Ordrar", "Standardhattar" }));
        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listFoundResults);

        btnEditCatergory.setText("Redigera");
        btnEditCatergory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCatergoryActionPerformed(evt);
            }
        });

        lblErrorMessageCategory.setForeground(new java.awt.Color(153, 0, 0));
        lblErrorMessageCategory.setText("Vänligen välj något objekt att redigera först");

        btnUpdateCategory.setText("Uppdatera");
        btnUpdateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCategoryActionPerformed(evt);
            }
        });

        txtSearchWord.setToolTipText("");

        cmbSearchSpecific.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Förnamn", "Efternamn" }));

        btnSearchSpecific.setText("Sök kund");
        btnSearchSpecific.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSpecificActionPerformed(evt);
            }
        });

        lblErrorValidateSearchWord.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout panel_searchLayout = new javax.swing.GroupLayout(panel_search);
        panel_search.setLayout(panel_searchLayout);
        panel_searchLayout.setHorizontalGroup(
            panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_searchLayout.createSequentialGroup()
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_searchLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblChooseCategory)
                        .addGap(18, 18, 18)
                        .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_searchLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_searchLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel_searchLayout.createSequentialGroup()
                                .addComponent(txtSearchWord, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErrorValidateSearchWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchSpecific, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(216, 216, 216)
                                .addComponent(btnUpdateCategory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditCatergory))
                            .addGroup(panel_searchLayout.createSequentialGroup()
                                .addComponent(cmbSearchSpecific, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblErrorMessageCategory)))))
                .addGap(63, 63, 63))
        );
        panel_searchLayout.setVerticalGroup(
            panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_searchLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblChooseCategory))
                .addGap(34, 34, 34)
                .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_searchLayout.createSequentialGroup()
                        .addComponent(lblErrorMessageCategory)
                        .addGap(12, 12, 12)
                        .addGroup(panel_searchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditCatergory)
                            .addComponent(btnUpdateCategory)
                            .addComponent(btnSearchSpecific)))
                    .addComponent(lblErrorValidateSearchWord, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_searchLayout.createSequentialGroup()
                        .addComponent(cmbSearchSpecific, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sök", panel_search);

        btnGenerateMomsPDF.setText("Generera årssammanställning");
        btnGenerateMomsPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateMomsPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(btnGenerateMomsPDF)
                .addContainerGap(330, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnGenerateMomsPDF)
                .addContainerGap(455, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Statistik", jPanel1);

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
        new ChangePsw(username).setVisible(true);
    }//GEN-LAST:event_btn_changePasswordActionPerformed

    private void btnAddNewHatTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewHatTypeActionPerformed
        new AddHatType().setVisible(true);
    }//GEN-LAST:event_btnAddNewHatTypeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        deleteNonOrderedHats();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed

        fillCorrectCategory();
    }//GEN-LAST:event_cbCategoryActionPerformed

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
        String totalPrice = lblTotalPrice.getText();
        String deliveryDate = txtExpectedDate.getText();
        String orderDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String status = cmbStatus.getSelectedItem().toString();

        String streetAddress = txtDeliveryAdress.getText();
        String postCode = txtPostCode.getText();
        String city = txtCity.getText();
        String country = txtCountry.getText();
        HashMap<String, String> chosenAddress = Address.getAddress(streetAddress, postCode, city, country);
        String addressID = chosenAddress.get("Address_ID");

        // TODO validering för om kund/adress/datum är valt
        String customerNr = lblCustomerNumber.getText();
        String customerID = Customer.getCustomerID(customerNr);

        int employeeID = Employee.getEmployeeID(username);

        if (hashMapStandardHat.isEmpty() && arrayOtherHat.isEmpty()) {

        } else {

            boolean exists = Address.doesAddressExist(streetAddress, postCode, city, country);
            if (!exists) {
                Address.addAddress(streetAddress, postCode, city, country);
                addressID = Address.getAddressID();

            }

            boolean success = Order.addToOrder(totalPrice, deliveryDate, orderDate, status, addressID, customerID, employeeID);
            if (success) {
                JOptionPane.showMessageDialog(null, "Ordern är skapad!");
            }
            int orderID = Order.getOrderID();

            if (!hashMapStandardHat.isEmpty()) {
                for (String i : hashMapStandardHat.keySet()) {
                    String size = hashMapStandardHat.get(i);
                    String standardHatID = i.substring(0, i.indexOf("."));
                    int hatID = Integer.parseInt(standardHatID);

                    Order.addToOrderedStandardHat(size, hatID, orderID);
                }

            }
            if (!arrayOtherHat.isEmpty()) {
                for (int id : arrayOtherHat) {
                    Order.addToOrderedHat(id, orderID);
                }
            }
            hashMapStandardHat.clear();
            arrayOtherHat.clear();
            hashMapListPrice.clear();
            lblCustomerName.setText("");
            lblCustomerNumber.setText("");
            txtDeliveryAdress.setText("");
            txtCity.setText("");
            txtCountry.setText("");
            txtPostCode.setText("");
            txtExpectedDate.setText("");
            listOrderItems();
        }

        //fraktsedel
        if (cmbStatus.getSelectedIndex() == 2) {
            int x = JOptionPane.showConfirmDialog(null, "Vill du generera en fraktsedel för ordern?", "Fraktsedel", JOptionPane.YES_NO_OPTION);

            if (x == JOptionPane.YES_OPTION) {
                String addedOrder = SqlQuery.getValue("SELECT MAX(Orders_ID) FROM orders;");

                new GenerateInvoicePDF(addedOrder).setVisible(true);
            }
        }

        cmbStatus.setSelectedIndex(0);
    }//GEN-LAST:event_btnSaveOrderActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        deleteNonOrderedHats();
    }//GEN-LAST:event_formWindowClosing

    /**
     * Deletes choosen hat from jList, db and static lists.
     *
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
            hashMapListPrice.remove(customHatID);

        } else {
            hashMapStandardHat.remove(standardHatID);
            hashMapListPrice.remove(standardHatID);
        }
        listOrderItems();
        //lblTotalPrice.setText(String.valueOf(getTotalPriceNonStatic()));

    }//GEN-LAST:event_btbDeleteChosenHatActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btnEditCatergoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCatergoryActionPerformed
        lblErrorMessageCategory.setVisible(false);

        String category = cbCategory.getSelectedItem().toString();
        String objectToEdit = listFoundResults.getSelectedValue();
        if (objectToEdit == null) {
            lblErrorMessageCategory.setVisible(true);
        } else {
            switch (category) {
                case "Kunder":
                    String customerNr = objectToEdit.substring(0, 9);
                    new EditCustomer(customerNr).setVisible(true);
                    break;
                case "Ordrar":
                    String orderToEdit = objectToEdit.substring(0, 10).trim();
                    new EditOrder(Integer.parseInt(orderToEdit)).setVisible(true);
                    break;
                case "Standardhattar":
                    String hatID = objectToEdit.substring(0, 10).trim();
                    new EditStandardHat(hatID).setVisible(true);
                    break;

            }
        }
    }//GEN-LAST:event_btnEditCatergoryActionPerformed

    private void btnUpdateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCategoryActionPerformed
        fillCorrectCategory();
    }//GEN-LAST:event_btnUpdateCategoryActionPerformed

    private void btnGenerateMomsPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateMomsPDFActionPerformed
        new GenerateMomsPDF().setVisible(true);
    }//GEN-LAST:event_btnGenerateMomsPDFActionPerformed

    private void btnRegisterFabricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterFabricActionPerformed
        new AddFabric().setVisible(true);
    }//GEN-LAST:event_btnRegisterFabricActionPerformed

    private void btnSearchSpecificActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSpecificActionPerformed

        //hämta in vad användaren vill söka efter
        String category = cmbSearchSpecific.getSelectedItem().toString();
        //hämta in sökord
        String searchWord = txtSearchWord.getText();

        //TODO fixa så att errormeddelande försvinner till nästa sökning
        if(Validation.onlyLetters(searchWord, lblErrorValidateSearchWord)){
        switch (category) {
            case "Förnamn":
                Customer.listCustomersFromFirstName(searchWord, listModel);
                break;
            case "Efternamn":
                Customer.listCustomerFromLastName(searchWord, listModel);
                break;
            case "Under utvärdering":
                Order.listOrdersByStatus(category, listModel);
                break;
            case "Pågående":
                Order.listOrdersByStatus(category, listModel);
                break;
            case "Redo att skickas":
                Order.listOrdersByStatus(category, listModel);
                break;
            case "Skickad":
                Order.listOrdersByStatus(category, listModel);
                break;
            case "Hattnamn":
                break;
            case "Tyg":
                break;
            default:
                throw new AssertionError();
        }
        }
    }//GEN-LAST:event_btnSearchSpecificActionPerformed
    /**
     * Fill listmodel with data depending on user's choice in combobox
     */
    public void fillCorrectCategory() {

        String category = cbCategory.getSelectedItem().toString();
        cmbSearchSpecific.removeAllItems();

        switch (category) {
            case "Kunder": {
                Customer.listAllCustomers(listModel);
                txtSearchWord.setEnabled(true);
                btnSearchSpecific.setText("Sök kund");
                cmbSearchSpecific.addItem("Förnamn");
                cmbSearchSpecific.addItem("Efternamn");
                break;
            }
            case "Ordrar": {
                Order.listAllOrders(listModel);
                btnSearchSpecific.setText("Sök order");
                txtSearchWord.setEnabled(false);
                cmbSearchSpecific.addItem("Under utvärdering");
                cmbSearchSpecific.addItem("Pågående");
                cmbSearchSpecific.addItem("Redo att skickas");
                cmbSearchSpecific.addItem("Skickad");
                break;
            }
            case "Standardhattar": {
                StandardHat.listAllStandardHats(listModel);
                txtSearchWord.setEditable(true);
                btnSearchSpecific.setText("Sök hatt");
                cmbSearchSpecific.addItem("Hattnamn");
                cmbSearchSpecific.addItem("Tyg");
                break;
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbDeleteChosenHat;
    private javax.swing.JButton btnAddNewHatType;
    private javax.swing.JButton btnCreateNewCustomerFromOrder;
    private javax.swing.JButton btnEditCatergory;
    private javax.swing.JButton btnGenerateMomsPDF;
    private javax.swing.JButton btnRegisterCustomer;
    private javax.swing.JButton btnRegisterFabric;
    private javax.swing.JButton btnRegisterStandardHat;
    private javax.swing.JButton btnSaveOrder;
    private javax.swing.JButton btnSearchSpecific;
    private javax.swing.JButton btnUpdateCategory;
    private javax.swing.JButton btn_changePassword;
    private javax.swing.JButton btn_logout;
    private javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JComboBox<String> cmbSearchSpecific;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListAllOrders;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelOrderAddress;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblChooseCategory;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblCustomerNumber;
    private javax.swing.JLabel lblErrorMessageCategory;
    private javax.swing.JLabel lblErrorValidateSearchWord;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JList<String> listFoundResults;
    private javax.swing.JPanel panel_createOrder;
    private javax.swing.JPanel panel_register;
    private javax.swing.JPanel panel_search;
    private javax.swing.JPanel panel_start;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtDeliveryAdress;
    private javax.swing.JTextField txtExpectedDate;
    private javax.swing.JTextField txtPostCode;
    private javax.swing.JTextField txtSearchWord;
    // End of variables declaration//GEN-END:variables
}
