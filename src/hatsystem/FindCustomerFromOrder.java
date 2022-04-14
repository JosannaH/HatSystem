/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatsystem;

import data.Customer;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.DefaultListModel;

/**
 *
 * @author Lisa
 */
public class FindCustomerFromOrder extends javax.swing.JFrame {

    /**
     * Creates new form FindCustomerFromOrder
     */
    private static DefaultListModel<String> customerListModel = new DefaultListModel<>();
    private Font defaultListFontOther;
    
    private LoginMenu test;
    
    public FindCustomerFromOrder(LoginMenu test) {
        initComponents();
        jListResult.setModel(customerListModel);
        defaultListFontOther = jListResult.getFont();
        jListResult.setFont(new Font("monospaced", defaultListFontOther.getStyle(), defaultListFontOther.getSize()));
        LoginMenu.listAllCustomers(customerListModel);
        
        this.test = test;
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreateCustomer = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        spResult = new javax.swing.JScrollPane();
        jListResult = new javax.swing.JList<>();
        btnSelectCustomer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCreateCustomer.setText("Skapa ny kund");
        btnCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCustomerActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblHeader.setText("Välj kund");

        spResult.setViewportView(jListResult);

        btnSelectCustomer.setText("Välj kund");
        btnSelectCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreateCustomer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelectCustomer)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spResult, javax.swing.GroupLayout.PREFERRED_SIZE, 1114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(66, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(spResult, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateCustomer)
                    .addComponent(btnSelectCustomer))
                .addGap(119, 119, 119))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateCustomerActionPerformed

    private void btnSelectCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectCustomerActionPerformed
        // TODO add your handling code here:
        String selectedCustomer = customerListModel.getElementAt(jListResult.getSelectedIndex());
        String customerNr = selectedCustomer.substring(0, 8);
        HashMap<String, String> customer = Customer.getCustomer(customerNr);
        test.addCustomerInfoToOrder(customer);
        customerListModel.clear();
        dispose();
    }//GEN-LAST:event_btnSelectCustomerActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FindCustomerFromOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FindCustomerFromOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FindCustomerFromOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FindCustomerFromOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FindCustomerFromOrder().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateCustomer;
    private javax.swing.JButton btnSelectCustomer;
    private javax.swing.JList<String> jListResult;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JScrollPane spResult;
    // End of variables declaration//GEN-END:variables
}
