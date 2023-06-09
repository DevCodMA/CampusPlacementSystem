/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campus_placement_system;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author majma
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
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

        jLabel2 = new javax.swing.JLabel();
        uname2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pswd = new javax.swing.JPasswordField();
        uname1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 160, 20));

        uname2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        getContentPane().add(uname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 250, 40));

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 80, -1));
        getContentPane().add(pswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 305, 40));

        uname1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        uname1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "C", "A" }));
        uname1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        uname1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uname1.setFocusCycleRoot(true);
        uname1.setNextFocusableComponent(this);
        uname1.setRequestFocusEnabled(false);
        uname1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(uname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 50, 40));

        jButton1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton1.setText("Register");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 100, 40));

        jButton2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/vector-abstract-technology-background-with-hexagons.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String ustr1, ustr2, pstr;
        ustr1 = uname1.getSelectedItem().toString();
        ustr2 = uname2.getText();
        pstr = String.valueOf(pswd.getPassword());
        LoginPage lp = this;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cps","root","");
            Statement st = con.createStatement();
            ResultSet rs;
            if(ustr1.equals("S")){
               rs = st.executeQuery("select pswd,sname from student where uname='"+ustr2+"'");
               rs.next();
               if(rs.getString("pswd").equals(pstr)){
                   System.err.println("Login Successfull");
                   StudentPage sp = new StudentPage();
                   sp.getInfo(rs.getString("sname"));
                   sp.setVisible(true);
                   lp.dispose();
               }else{
                   JOptionPane.showMessageDialog(this, "Invalid username or password!");
               }
            }else if(ustr1.equals("C")){
               rs = st.executeQuery("select pswd,ename from coordinator where uname='"+ustr2+"'");
               rs.next();
               if(rs.getString("pswd").equals(pstr)){
                   System.err.println("Login Successfull");
                   CoordinatorPage cp = new CoordinatorPage();
                   cp.getInfo(rs.getString("ename"));
                   cp.setVisible(true);
                   lp.dispose();
               }else{
                   JOptionPane.showMessageDialog(this, "Invalid username or password!");
               } 
            }else{
               rs = st.executeQuery("select pswd from admin where uname='"+ustr2+"'");
               rs.next();
               if(rs.getString("pswd").equals(pstr)){
                   System.err.println("Login Successfull");
                   AdminPage ap = new AdminPage();
                   ap.setVisible(true);
                   lp.dispose();
               }else{
                   JOptionPane.showMessageDialog(this, "Invalid username or password!");
               }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pswd;
    private javax.swing.JComboBox<String> uname1;
    private javax.swing.JTextField uname2;
    // End of variables declaration//GEN-END:variables
}
