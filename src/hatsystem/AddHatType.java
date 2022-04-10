/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatsystem;

import data.Employee;
import data.Fabric;
import data.SpecialHat;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import data.SqlQuery;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import data.StandardHat;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.DefaultListModel;

/**
 * @author luna
 */
public class AddHatType extends javax.swing.JFrame {

    //konstr
    public AddHatType() {
        initComponents();
        fillFabricsComboBox();
        fillFabricComboBox();
        fillEmployeeComboBox();
        lblSpecialError.setVisible(false);
        fillList();
    }

     /**
     * Fills the fabric combo box with fabric options.
     */
    private void fillFabricsComboBox() {

        HashSet<String> fabrics = Fabric.getAllFabricNames();

        for (String s : fabrics) {
            cmbSpecialFabrics.addItem(s);
        }
    }

    private void fillEmployeeComboBox(){
        ArrayList<String> employees = Employee.getEmployee();

        for (String e : employees) {
            cmbSpecialResponsible.addItem(e);
        }
    }

    private void fillColorsComboBox(String fabricName) {

        cmbSpecialColors.removeAllItems();

        ArrayList<String> colors = Fabric.getFabricColors(fabricName);

        for (String s : colors) {
            cmbSpecialColors.addItem(s);
        }
    }



    /**
     * WARNING: Do NOT modify this code.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_standardHat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btn_addHat = new javax.swing.JButton();
        lbl_size = new javax.swing.JLabel();
        panel_customHat = new javax.swing.JPanel();
        scrollPane_CustomHat = new javax.swing.JScrollPane();
        lstCustHat = new javax.swing.JList<>();
        lbl_customFabric = new javax.swing.JLabel();
        lbl_customColor = new javax.swing.JLabel();
        lbl_customSize = new javax.swing.JLabel();
        textField_customDescription = new javax.swing.JTextField();
        lbl_customDescription = new javax.swing.JLabel();
        lbl_customPrice = new javax.swing.JLabel();
        textField_customPrice = new javax.swing.JTextField();
        cmb_customFabric = new javax.swing.JComboBox<>();
        cmb_customColor = new javax.swing.JComboBox<>();
        cmb_customSize = new javax.swing.JComboBox<>();
        lbl_customTitle = new javax.swing.JLabel();
        btn_customAddToOrder = new javax.swing.JButton();
        panel_specialHat = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbSpecialFabrics = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbSpecialColors = new javax.swing.JComboBox<>();
        txtfSpecialName = new javax.swing.JTextField();
        btnSpecialSave = new javax.swing.JButton();
        txtfSpecialPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtfSpecialDescription = new javax.swing.JTextField();
        lblSpecialError = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        lblImageTxt = new javax.swing.JLabel();
        btbAddImage = new javax.swing.JButton();
        lblImageText = new javax.swing.JLabel();
        lblSpecialSize = new javax.swing.JLabel();
        cmbSpecialSize = new javax.swing.JComboBox<>();
        lblSpecialResponsible = new javax.swing.JLabel();
        cmbSpecialResponsible = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        btn_addHat.setText("Lägg till hatt");

        lbl_size.setText("Storlek");

        javax.swing.GroupLayout panel_standardHatLayout = new javax.swing.GroupLayout(panel_standardHat);
        panel_standardHat.setLayout(panel_standardHatLayout);
        panel_standardHatLayout.setHorizontalGroup(
            panel_standardHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_standardHatLayout.createSequentialGroup()
                .addGap(114, 715, Short.MAX_VALUE)
                .addComponent(lbl_size)
                .addGap(226, 226, 226))
            .addGroup(panel_standardHatLayout.createSequentialGroup()
                .addGroup(panel_standardHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_standardHatLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_standardHatLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btn_addHat)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_standardHatLayout.setVerticalGroup(
            panel_standardHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_standardHatLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(lbl_size)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(btn_addHat)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Standardhatt", panel_standardHat);

        lstCustHat.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstCustHat.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCustHatValueChanged(evt);
            }
        });
        scrollPane_CustomHat.setViewportView(lstCustHat);

        lbl_customFabric.setText("Tyg");

        lbl_customColor.setText("Färg");

        lbl_customSize.setText("Storlek");

        textField_customDescription.setText("Beskriv din hatt här");

        lbl_customDescription.setText("Beskrivning");

        lbl_customPrice.setText("Pris");

        cmb_customFabric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_customFabricActionPerformed(evt);
            }
        });

        cmb_customSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "XXS", "XS", "S", "M", "L", "XL", "XXL" }));

        lbl_customTitle.setFont(new java.awt.Font("Apple Braille", 0, 18)); // NOI18N
        lbl_customTitle.setText("Lägg till anpassad standardhatt");

        btn_customAddToOrder.setText("Lägg till hatt i order");

        javax.swing.GroupLayout panel_customHatLayout = new javax.swing.GroupLayout(panel_customHat);
        panel_customHat.setLayout(panel_customHatLayout);
        panel_customHatLayout.setHorizontalGroup(
            panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_customHatLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_customHatLayout.createSequentialGroup()
                        .addComponent(scrollPane_CustomHat)
                        .addGap(18, 18, 18)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_customHatLayout.createSequentialGroup()
                                .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_customDescription)
                                    .addComponent(lbl_customPrice))
                                .addGap(18, 18, 18)
                                .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textField_customDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(textField_customPrice)))
                            .addGroup(panel_customHatLayout.createSequentialGroup()
                                .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_customFabric)
                                    .addComponent(lbl_customColor)
                                    .addComponent(lbl_customSize))
                                .addGap(49, 49, 49)
                                .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_customFabric, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmb_customColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmb_customSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(74, 74, 74))
                    .addGroup(panel_customHatLayout.createSequentialGroup()
                        .addComponent(lbl_customTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(574, Short.MAX_VALUE))))
            .addGroup(panel_customHatLayout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(btn_customAddToOrder)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_customHatLayout.setVerticalGroup(
            panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_customHatLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_customTitle)
                .addGap(33, 33, 33)
                .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_customHatLayout.createSequentialGroup()
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_customFabric, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_customFabric))
                        .addGap(27, 27, 27)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_customColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_customColor))
                        .addGap(26, 26, 26)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmb_customSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_customSize))
                        .addGap(63, 63, 63)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textField_customDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_customDescription)))
                    .addComponent(scrollPane_CustomHat, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_customPrice)
                    .addComponent(textField_customPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_customAddToOrder)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Anpassad hatt", panel_customHat);

        jLabel4.setText("Beskrivning");

        jLabel8.setText("Tyg");

        cmbSpecialFabrics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSpecialFabricsActionPerformed(evt);
            }
        });

        jLabel9.setText("Färg");

        btnSpecialSave.setText("Spara");
        btnSpecialSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpecialSaveActionPerformed(evt);
            }
        });

        jLabel10.setText("Registerera ny standardmodell av hatt ");

        lblSpecialError.setForeground(new java.awt.Color(204, 0, 51));
        lblSpecialError.setText("Vänligen fyll i alla fält");

        jLabel11.setText("Namn");

        jLabel12.setText("Pris");

        btbAddImage.setText("Lägg Till Bild");
        btbAddImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbAddImageActionPerformed(evt);
            }
        });

        lblSpecialSize.setText("Storlek");

        cmbSpecialSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "XXS", "XS", "S", "M", "L", "XL", "XXL" }));
        cmbSpecialSize.setToolTipText("");

        lblSpecialResponsible.setText("Ansvarig");

        javax.swing.GroupLayout panel_specialHatLayout = new javax.swing.GroupLayout(panel_specialHat);
        panel_specialHat.setLayout(panel_specialHatLayout);
        panel_specialHatLayout.setHorizontalGroup(
            panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_specialHatLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_specialHatLayout.createSequentialGroup()
                                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                                        .addGap(134, 134, 134)
                                        .addComponent(btnSpecialSave))
                                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11)
                                            .addComponent(lblSpecialSize)
                                            .addComponent(lblSpecialResponsible))
                                        .addGap(38, 38, 38)
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbSpecialFabrics, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtfSpecialDescription)
                                            .addComponent(txtfSpecialPrice)
                                            .addComponent(txtfSpecialName)
                                            .addComponent(cmbSpecialColors, 0, 175, Short.MAX_VALUE)
                                            .addComponent(cmbSpecialSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbSpecialResponsible, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
                            .addGroup(panel_specialHatLayout.createSequentialGroup()
                                .addComponent(btbAddImage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                                        .addComponent(lblSpecialError, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblImageText, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(945, 945, 945))
                                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                                        .addComponent(lblImageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panel_specialHatLayout.setVerticalGroup(
            panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_specialHatLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addGap(36, 39, Short.MAX_VALUE)
                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_specialHatLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(256, 256, 256))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_specialHatLayout.createSequentialGroup()
                                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSpecialResponsible)
                                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                                        .addComponent(txtfSpecialName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtfSpecialPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtfSpecialDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cmbSpecialFabrics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cmbSpecialColors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cmbSpecialSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblSpecialSize))
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbSpecialResponsible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btbAddImage)
                                    .addComponent(lblImageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblImageText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSpecialError))))
                .addGap(18, 18, 18)
                .addComponent(btnSpecialSave)
                .addGap(82, 82, 82))
        );

        jTabbedPane1.addTab("Specialsydd hatt", panel_specialHat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 978, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cmbSpecialFabricsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSpecialFabricsActionPerformed
        String chosenFabric = cmbSpecialFabrics.getSelectedItem().toString();
        fillColorsComboBox(chosenFabric);
    }//GEN-LAST:event_cmbSpecialFabricsActionPerformed

    private void btnSpecialSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpecialSaveActionPerformed
        String name = txtfSpecialName.getText();
        String price = txtfSpecialPrice.getText();
        String description = txtfSpecialDescription.getText();
        String fabric = cmbSpecialFabrics.getSelectedItem().toString();
        String colour = cmbSpecialColors.getSelectedItem().toString();
        String image = lblImageTxt.getText();
        String size = cmbSpecialSize.getSelectedItem().toString();
        String worker = cmbSpecialResponsible.getSelectedItem().toString();

        if (name.isBlank() || price.isBlank()) {
            lblSpecialError.setText("Vänligen fyll i alla fält");
            lblSpecialError.setVisible(true);
        }
            else {
            int fabricComboID = Fabric.getFabricID(fabric, colour);
            int employeeComboID = Employee.getEmployeeID(worker);
            boolean isUniqueHatAndFabricCombo = SpecialHat.isUniqueCombination(name, fabricComboID);
            if (isUniqueHatAndFabricCombo) {
                SpecialHat.addHat(name, price, size, description, fabricComboID, employeeComboID);
                SpecialHat.addSpecialHat(name, price, fabricComboID, image);
                //TODO validering för om hatten verkligen kom in i databasen.
                JOptionPane.showMessageDialog(null, "Hatten är registrerad!");
                this.dispose();

                //TODO Lägg in automatisk kodning av status
            } else {
                lblSpecialError.setText("Denna kombinationen är redan registrerad som en hatt");
                lblSpecialError.setVisible(true);
            }
        }

    }//GEN-LAST:event_btnSpecialSaveActionPerformed

    private void btbAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbAddImageActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String filename = file.getAbsolutePath();
        //TODO Validering för att det endast går att lägga in bild.

        lblImageTxt.setText(filename);

        ImageIcon icon = new ImageIcon(new ImageIcon(filename).getImage());

        //Vi kan här ändra värdet i "frame" för att få den storlek vi vill ha på ramen, men att bilden
        //fortfarande behåller sitt ursprungliga bildförhållande relativt till ramen.
        double frameWidth = 300;
        double frameHeight = 350;
        double selectedImgWidth = icon.getIconWidth();
        double selectedImgHeight = icon.getIconHeight();

        double widthRatio = frameWidth/selectedImgWidth;
        double heightRatio = frameHeight/selectedImgHeight;
        double ratio = Math.min(widthRatio, heightRatio);

        int resizedWidth = (int)(selectedImgWidth*ratio);
        int resizedHeight = (int)(selectedImgHeight*ratio);

        ImageIcon iconNew = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(resizedWidth, resizedHeight, Image.SCALE_DEFAULT));

        lblImage.setIcon(iconNew);

    }//GEN-LAST:event_btbAddImageActionPerformed

    private void lstCustHatValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCustHatValueChanged

        String stringID = lstCustHat.getSelectedValue().substring(0, 8);
        String newString = stringID.replaceAll("\\s", "");
        int hatID = Integer.parseInt(newString);
        setValues(hatID);

    }//GEN-LAST:event_lstCustHatValueChanged

    private void cmb_customFabricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_customFabricActionPerformed
        String chosenFabric = cmb_customFabric.getSelectedItem().toString();
        fillColorComboBox(chosenFabric);
    }//GEN-LAST:event_cmb_customFabricActionPerformed

        private void fillList() {
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        lstCustHat.setModel(listModel);
        
        ArrayList<HashMap<String, String>> allHats = StandardHat.getAllStandardHats();
        int index = 0;
        while (index < allHats.size()) {
            HashMap<String, String> currentHat = allHats.get(index);
            String fabricID = currentHat.get("Hat_Fabric");
            HashMap<String, String> currentFabric = Fabric.getFabricFromID(fabricID);
            
            listModel.addElement(String.format("%-10s %-20s %-20s %-20s" + currentHat.get("Price"), currentHat.get("Standard_Hat_ID"), currentHat.get("Name"), currentFabric.get("Name"), currentFabric.get("Color")));
            
            index++;
        }
        
        Font defaultListFont = lstCustHat.getFont();
        lstCustHat.setFont(new Font("monospaced", defaultListFont.getStyle(), defaultListFont.getSize()));
    }

    private void setValues(int hatID) {
        // get fabric for chosen hat
        HashMap<String, String> chosenHat = StandardHat.getHat(hatID);
        String fabricID = chosenHat.get("Hat_Fabric");
        HashMap<String, String> defaultFabric = Fabric.getFabricFromID(fabricID);
        String fabricName = defaultFabric.get("Name");
        // set values in fabric cmb
        cmb_customFabric.setSelectedItem(fabricName);
        fillColorComboBox(fabricName);
        
        // TODO: nåt fel med cmb för color, den byter inte färg som den ska när man byter hatt i listan
    }
  

    /**
     * Fills the fabric combo box with fabric options.
     */
    private void fillFabricComboBox() {

        HashSet<String> fabrics = Fabric.getAllFabricNames();

        for (String s : fabrics) {
            cmb_customFabric.addItem(s);
        }
    }

    private void fillColorComboBox(String fabricName) {

        cmb_customColor.removeAllItems();

        ArrayList<String> colors = Fabric.getFabricColors(fabricName);

        for (String s : colors) {
            cmb_customColor.addItem(s);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbAddImage;
    private javax.swing.JButton btnSpecialSave;
    private javax.swing.JButton btn_addHat;
private javax.swing.JButton btn_customAddToOrder;
private javax.swing.JComboBox<String> cmb_customColor;
private javax.swing.JComboBox<String> cmb_customFabric;
private javax.swing.JComboBox<String> cmb_customSize;
    private javax.swing.JComboBox<String> cmbSpecialColors;
    private javax.swing.JComboBox<String> cmbSpecialFabrics;
    private javax.swing.JComboBox<String> cmbSpecialResponsible;
    private javax.swing.JComboBox<String> cmbSpecialSize;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImageText;
    private javax.swing.JLabel lblImageTxt;
    private javax.swing.JLabel lblSpecialError;
    private javax.swing.JLabel lblSpecialResponsible;
    private javax.swing.JLabel lblSpecialSize;
    private javax.swing.JLabel lbl_customColor;
    private javax.swing.JLabel lbl_customDescription;
    private javax.swing.JLabel lbl_customFabric;
    private javax.swing.JLabel lbl_customPrice;
    private javax.swing.JLabel lbl_customSize;
    private javax.swing.JLabel lbl_customTitle;
    private javax.swing.JLabel lbl_size;
    private javax.swing.JList<String> lstCustHat;
    private javax.swing.JPanel panel_customHat;
    private javax.swing.JPanel panel_specialHat;
    private javax.swing.JPanel panel_standardHat;
    private javax.swing.JTextField txtfSpecialDescription;
    private javax.swing.JTextField txtfSpecialName;
    private javax.swing.JTextField txtfSpecialPrice;
    private javax.swing.JScrollPane scrollPane_CustomHat;
    private javax.swing.JTextField textField_customDescription;
    private javax.swing.JTextField textField_customPrice;
    // End of variables declaration//GEN-END:variables
}
