/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatsystem;

import data.Fabric;
import data.StandardHat;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * @author luna
 */
public class AddHatType extends javax.swing.JFrame {

    //konstr
    public AddHatType() {
        initComponents();
        fillList();
        fillFabricComboBox();
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
                .addGap(114, 709, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
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

        javax.swing.GroupLayout panel_specialHatLayout = new javax.swing.GroupLayout(panel_specialHat);
        panel_specialHat.setLayout(panel_specialHatLayout);
        panel_specialHatLayout.setHorizontalGroup(
            panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 971, Short.MAX_VALUE)
        );
        panel_specialHatLayout.setVerticalGroup(
            panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Specialsydd hatt", panel_specialHat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        HashMap<String, String> chosenHat = StandardHat.getHat(hatID);
        
        String fabricID = chosenHat.get("Hat_Fabric");
        HashMap<String, String> defaultFabric = Fabric.getFabricFromID(fabricID);
        
        String fabricName = defaultFabric.get("Name");
        cmb_customFabric.setSelectedItem(fabricName);
        fillColorComboBox(fabricName);
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
    private javax.swing.JButton btn_addHat;
    private javax.swing.JButton btn_customAddToOrder;
    private javax.swing.JComboBox<String> cmb_customColor;
    private javax.swing.JComboBox<String> cmb_customFabric;
    private javax.swing.JComboBox<String> cmb_customSize;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
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
    private javax.swing.JScrollPane scrollPane_CustomHat;
    private javax.swing.JTextField textField_customDescription;
    private javax.swing.JTextField textField_customPrice;
    // End of variables declaration//GEN-END:variables
}
