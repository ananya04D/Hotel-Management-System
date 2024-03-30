/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel.management;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author KIIT
 */
public class BillPrint extends javax.swing.JFrame {
    String id=BillDetails.id;
    String nm;
    String mobile;
    String email;
    String roomnumber;
    String bed;
    String type;
    String indate;
    String outdate;
    String price;
    String days;
    String amount;
    
    /**
     * Creates new form BillPrint
     */
    public BillPrint() {
        initComponents();
        Connect();
        
        txtbill.setText("\n\n\t\t HOTEL MANAGEMENT SYSTEM\n\n");
        txtbill.setText(txtbill.getText()+"***************************************************************************\n");
        txtbill.setText(txtbill.getText()+"\t\t        Bill ID -: "+id+"\n\n");
        txtbill.setText(txtbill.getText()+"\t\t      CUSTOMER DETAILS\n\n");
        txtbill.setText(txtbill.getText()+"Name -: "+nm+"\n");
        txtbill.setText(txtbill.getText()+"Mobile Number -: "+mobile+"\n");
        txtbill.setText(txtbill.getText()+"E-Mail -: "+email+"\n\n");
        txtbill.setText(txtbill.getText()+"****************************************************************************\n");
        txtbill.setText(txtbill.getText()+"\t\t       ROOM DETAILS \n\n");
        txtbill.setText(txtbill.getText()+"Room Number -: "+roomnumber+"\n");
        txtbill.setText(txtbill.getText()+"Type -: "+type+"\n");
        txtbill.setText(txtbill.getText()+"Bed -: "+bed+"\n");
        txtbill.setText(txtbill.getText()+"Price -: "+price+"\n");
        txtbill.setText(txtbill.getText()+"Check-In Date -: "+indate+"\t\tNo. Of Days -: "+days+"\n");
        txtbill.setText(txtbill.getText()+"Check-Out Date -: "+outdate+"\t\tAmount -: "+amount+"\n");
        txtbill.setText(txtbill.getText()+"****************************************************************************\n\n");
        txtbill.setText(txtbill.getText()+"\t\t"+"THANK YOU, PLEASE VISIT AGAIN");
    }
    public void Connect()
    {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","AD041002@#ad");
            pst=con.prepareStatement("select * from customer where BillID=?");
            pst.setString(1,id);
            rs=pst.executeQuery();
            if(rs.next())
            {
                email=rs.getString("E-Mail");
                nm=rs.getString("Name");
                mobile=rs.getString("Mobile");
                roomnumber=rs.getString("RoomNumber");
                bed=rs.getString("Bed");
                type=rs.getString("RoomType");
                indate=rs.getString("JoinDate");
                outdate=rs.getString("OutDate");
                price=rs.getString("Price");
                days=rs.getString("Day");
                amount=rs.getString("Amount");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 0, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, -1, -1));

        txtbill.setColumns(20);
        txtbill.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtbill.setRows(5);
        jScrollPane1.setViewportView(txtbill);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 580, 410));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\KIIT\\OneDrive\\Documents\\NetBeansProjects\\Hotel Management\\Images\\billprint.png")); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            txtbill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillPrint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtbill;
    // End of variables declaration//GEN-END:variables
}