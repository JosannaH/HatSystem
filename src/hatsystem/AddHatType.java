/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatsystem;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author luna
 */
public class AddHatType extends javax.swing.JFrame {

    /**
     * Creates new form AddHatType
     */
    public AddHatType() {
        initComponents();
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
        panel_standardHat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        btn_addHat = new javax.swing.JButton();
        lbl_size = new javax.swing.JLabel();
        panel_customHat = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
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
                .addGap(114, 641, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btn_addHat)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Standardhatt", panel_standardHat);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel1.setText("Tyg");

        jLabel2.setText("Färg");

        jLabel3.setText("Storlek");

        jLabel5.setText("Text (valfritt)");

        jTextField1.setText("Beskriv din hatt här");

        jLabel6.setText("Beskrivning");

        jTextField2.setText("jTextField2");

        jLabel7.setText("Pris");

        jTextField3.setText("jTextField3");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panel_customHatLayout = new javax.swing.GroupLayout(panel_customHat);
        panel_customHat.setLayout(panel_customHatLayout);
        panel_customHatLayout.setHorizontalGroup(
            panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_customHatLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel_customHatLayout.createSequentialGroup()
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(jTextField3)))
                    .addGroup(panel_customHatLayout.createSequentialGroup()
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(74, 74, 74))
        );
        panel_customHatLayout.setVerticalGroup(
            panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_customHatLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_customHatLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(panel_customHatLayout.createSequentialGroup()
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel_customHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
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

        javax.swing.GroupLayout panel_specialHatLayout = new javax.swing.GroupLayout(panel_specialHat);
        panel_specialHat.setLayout(panel_specialHatLayout);
        panel_specialHatLayout.setHorizontalGroup(
            panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_specialHatLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImageTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_specialHatLayout.createSequentialGroup()
                                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSpecialError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_specialHatLayout.createSequentialGroup()
                                                .addComponent(btnSpecialSave)
                                                .addGap(209, 209, 209))))
                                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(38, 38, 38)
                                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbSpecialFabrics, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtfSpecialDescription)
                                            .addComponent(txtfSpecialPrice)
                                            .addComponent(txtfSpecialName)
                                            .addComponent(cmbSpecialColors, 0, 175, Short.MAX_VALUE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panel_specialHatLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btbAddImage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblImageText, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(945, 945, 945))))
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
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)
                        .addGap(36, 36, 36)
                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel_specialHatLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel12)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel4)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel8)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel9))
                            .addGroup(panel_specialHatLayout.createSequentialGroup()
                                .addComponent(txtfSpecialName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtfSpecialPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(txtfSpecialDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(cmbSpecialFabrics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(cmbSpecialColors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btbAddImage)
                            .addComponent(lblImageText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_specialHatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_specialHatLayout.createSequentialGroup()
                        .addComponent(lblImageTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_specialHatLayout.createSequentialGroup()
                        .addComponent(lblSpecialError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSpecialSave)
                        .addGap(19, 19, 19))))
        );

        jTabbedPane1.addTab("Specialsydd hatt", panel_specialHat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSpecialFabricsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSpecialFabricsActionPerformed
        
    }//GEN-LAST:event_cmbSpecialFabricsActionPerformed

    private void btnSpecialSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpecialSaveActionPerformed
           
        

    }//GEN-LAST:event_btnSpecialSaveActionPerformed

    private void btbAddImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbAddImageActionPerformed
        
       
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String filename = file.getAbsolutePath();
        
        lblImageTxt.setText(filename);
        
        ImageIcon icon = new ImageIcon(new ImageIcon(filename).getImage());
        
        //Vi kan här ändra värdet i "frame" för att få den storlek vi vill ha på ramen, men att bilden
        //fortfarande behåller sitt ursprungliga bildförhållande.
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

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbAddImage;
    private javax.swing.JButton btnSpecialSave;
    private javax.swing.JButton btn_addHat;
    private javax.swing.JComboBox<String> cmbSpecialColors;
    private javax.swing.JComboBox<String> cmbSpecialFabrics;
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
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImageText;
    private javax.swing.JLabel lblImageTxt;
    private javax.swing.JLabel lblSpecialError;
    private javax.swing.JLabel lbl_size;
    private javax.swing.JPanel panel_customHat;
    private javax.swing.JPanel panel_specialHat;
    private javax.swing.JPanel panel_standardHat;
    private javax.swing.JTextField txtfSpecialDescription;
    private javax.swing.JTextField txtfSpecialName;
    private javax.swing.JTextField txtfSpecialPrice;
    // End of variables declaration//GEN-END:variables
}
