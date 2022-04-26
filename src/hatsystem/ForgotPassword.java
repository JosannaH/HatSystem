/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hatsystem;

import data.SqlQuery;
import data.Employee;
import javax.swing.JOptionPane;
import java.util.Arrays;
/**
 *
 * @author Mo
 */
public class ForgotPassword extends javax.swing.JFrame {
    public String userName;
    public String securityQuestion;
    public String answer;
    private String newPasw;
    public String updatePaswQuery;
    public String rightAnswer;
    
    /**
     * Creates new form ForgotPassword
     */
    public ForgotPassword() {
        initComponents();
        lblError.setVisible(false);
        btnSave.setEnabled(false);
        cbSecurityQuestion.setEnabled(false);
        this.rightAnswer = rightAnswer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblChangePassword = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblSecurityQuestion = new javax.swing.JLabel();
        lblAnswer = new javax.swing.JLabel();
        lblNewPassword = new javax.swing.JLabel();
        lblRepeatPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtAnswer = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnGoBack = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        txtNewPassw = new javax.swing.JPasswordField();
        txtRepeatPasw = new javax.swing.JPasswordField();
        btnSearchUser = new javax.swing.JButton();
        cbSecurityQuestion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);

        lblChangePassword.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblChangePassword.setForeground(new java.awt.Color(225, 0, 0));
        lblChangePassword.setText("Återställ lösenord");

        lblUserName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblUserName.setText("Användarnamn");

        lblSecurityQuestion.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblSecurityQuestion.setText("Säkerhetsfråga");

        lblAnswer.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblAnswer.setText("Svar");

        lblNewPassword.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblNewPassword.setText("Nytt lösenord");

        lblRepeatPassword.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblRepeatPassword.setText("Upprepa lösenord");

        txtUserName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });

        txtAnswer.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnSave.setText("Spara");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnGoBack.setText("Tillbaka");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        lblError.setForeground(new java.awt.Color(225, 0, 0));

        txtNewPassw.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtRepeatPasw.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRepeatPasw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepeatPaswActionPerformed(evt);
            }
        });

        btnSearchUser.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnSearchUser.setText("Sök");
        btnSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchUserActionPerformed(evt);
            }
        });

        cbSecurityQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj din fråga", "_______________", "Vad är din favoritmaträtt?", "Vad heter din första husdjur?", "Vilket bilmärke var din pappas bil?" }));
        cbSecurityQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSecurityQuestionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(lblChangePassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRepeatPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNewPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAnswer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSecurityQuestion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNewPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtUserName)
                                .addGap(18, 18, 18)
                                .addComponent(btnSearchUser))
                            .addComponent(txtRepeatPasw, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(cbSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGoBack)
                        .addGap(32, 32, 32)
                        .addComponent(btnSave)))
                .addGap(84, 84, 84))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblAnswer, lblNewPassword, lblRepeatPassword, lblSecurityQuestion, lblUserName});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGoBack, btnSave});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbSecurityQuestion, txtAnswer, txtNewPassw, txtRepeatPasw});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblChangePassword)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSecurityQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewPassw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRepeatPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRepeatPasw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbSecurityQuestion, lblAnswer, lblNewPassword, lblRepeatPassword, lblSecurityQuestion, lblUserName});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAnswer, txtNewPassw, txtRepeatPasw, txtUserName});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGoBack, btnSave, lblError});

        lblUserName.getAccessibleContext().setAccessibleDescription("");
        lblSecurityQuestion.getAccessibleContext().setAccessibleDescription("");
        lblAnswer.getAccessibleContext().setAccessibleDescription("");
        lblNewPassword.getAccessibleContext().setAccessibleDescription("");
        lblRepeatPassword.getAccessibleContext().setAccessibleDescription("");
        txtUserName.getAccessibleContext().setAccessibleDescription("");
        txtAnswer.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void txtRepeatPaswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepeatPaswActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepeatPaswActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        lblError.setVisible(false);
        answer = txtAnswer.getText();
        char [] newPsw = txtNewPassw.getPassword();
        char [] confirmPsw = txtRepeatPasw.getPassword();
        rightAnswer = Employee.getSecurityAnswer(userName);
        

        if ((!Arrays.equals(newPsw, confirmPsw)) || !(answer.equalsIgnoreCase(rightAnswer)) || !(securityQuestion.equals(cbSecurityQuestion.getSelectedItem().toString()))){  
            lblError.setText("Försök igen");
            lblError.setVisible(true);
        }
        else{        
        boolean updated = false;
        newPasw = new String(newPsw);
        if (JOptionPane.showConfirmDialog(null, "Är du säker?", "Uppdatera ditt lösenord",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // yes option
            updatePaswQuery = "update employee set Password ='"+newPasw+"' where Username ='"+userName+"';";
            updated = SqlQuery.update(updatePaswQuery);
        } else {
            // no option
        }
        if (updated) {
            JOptionPane.showMessageDialog(null, "Lösenordet har uppdaterats!");
        } 
        else {
            JOptionPane.showMessageDialog(null, "Något gick fel.");
        }
        new Login().setVisible(true);
        dispose();
    }                                       // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUserActionPerformed
        lblError.setVisible(false);
        userName = txtUserName.getText();
        securityQuestion = Employee.getSecurityQuestion(userName);
        rightAnswer = Employee.getSecurityAnswer(userName);
        if(rightAnswer != null){
            cbSecurityQuestion.setEnabled(true);
        }
        else{
            lblError.setText("Fel användaruppgifter!");
            lblError.setVisible(true);
        }
    }//GEN-LAST:event_btnSearchUserActionPerformed

    private void cbSecurityQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSecurityQuestionActionPerformed
    
        btnSave.setEnabled(false);
        if("Välj din fråga".equals(cbSecurityQuestion.getSelectedItem().toString())){
            btnSave.setEnabled(false);
        }
        else{
            btnSave.setEnabled(true);            
        }
    }//GEN-LAST:event_cbSecurityQuestionActionPerformed

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameKeyPressed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchUser;
    private javax.swing.JComboBox<String> cbSecurityQuestion;
    private javax.swing.JLabel lblAnswer;
    private javax.swing.JLabel lblChangePassword;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblRepeatPassword;
    private javax.swing.JLabel lblSecurityQuestion;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JPasswordField txtNewPassw;
    private javax.swing.JPasswordField txtRepeatPasw;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
