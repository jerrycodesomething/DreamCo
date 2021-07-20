
package dreamco;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeremiah
 */
public class UpdateUser extends javax.swing.JFrame {

    public static String newname;
    public static String newpass;
    public static String userID;
    
    public UpdateUser() {
        initComponents();
    }
       
    public UpdateUser(String userID) {
        initComponents();
        this.userID=userID;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(121, 194, 234));
        jPanel1.setLayout(null);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(70, 60, 260, 30);

        jButton1.setText("cancel");
        jPanel1.add(jButton1);
        jButton1.setBounds(260, 100, 68, 32);

        jButton2.setText("ok");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(70, 100, 44, 32);

        jButton3.setText("cancel");
        jPanel1.add(jButton3);
        jButton3.setBounds(260, 230, 68, 32);

        jButton4.setText("ok");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(70, 230, 44, 32);

        jButton5.setText("cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(160, 280, 77, 32);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(70, 190, 260, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 30, 260, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Reset Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 160, 260, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      newname=jTextField1.getText();
      MyTree t = new MyTree();
      t.addUser();
      t.setNewName(userID, newname);
        try {
            t.appendUserClearFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " System File Not Found!", " System File Error!", JOptionPane.ERROR_MESSAGE);
        }
      
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        newpass=jTextField2.getText();
        if(newpass.length()>=8){
            MyTree t = new MyTree();
            t.addUser();
            t.setNewPassword(userID, newpass);
            try {
            t.appendUserClearFile();
            }
            catch (IOException ex) {
            JOptionPane.showMessageDialog(null, " System File Not Found!", " System File Error!", JOptionPane.ERROR_MESSAGE);
            }
        }   
        else{
            JOptionPane.showMessageDialog(null, "  New password must be at least 8 characters. Please try again!", "  Password Too Short!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    dispose();
    }//GEN-LAST:event_jButton5ActionPerformed
    
    public String getNewName(){
        return newname;
    }
    public String getNewPass(){
        return newpass;
    }

    public void runUpdateUser() {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
