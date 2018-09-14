package PasswordManager;

import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main_Program extends javax.swing.JFrame {

    DefaultTableModel model;

    //created to add entry
    public String[] getdata = new String[2];

    //Various variables as public static to ensure they can be accessed from all Jforms   
    public static String SavingLocation = null;
    public static String username1 = null;
    public static String password1 = null;
    public static int counter = 0;
    public static int NewPassword = 0;

    //Array used to save login  + jtable data 
    public static String[][] Data = new String[100][3];
    public static String[][] DataOut = new String[100][3];

    public Main_Program() {
        initComponents();
        model = (DefaultTableModel) jTable1.getModel();

        //Load jtable from data string array       
        for (int i = 0; i < counter - 2; i++) {
            model.insertRow(model.getRowCount(), new Object[]{Data[i + 1][0], Data[i + 1][1], Data[i + 1][2]});
        }
    }

    //Hashing algorithm SHA_256
    public static String get_SHA_256_SecurePassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b1 : bytes) {
            sb.append(Integer.toHexString(b1 & 0xff));
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnAdd = new javax.swing.JButton();
        BtnRemove = new javax.swing.JButton();
        BtnModify = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JTextField();
        Description = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnAdd.setText("Add");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        BtnRemove.setText("Remove");
        BtnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRemoveActionPerformed(evt);
            }
        });

        BtnModify.setText("Modify");
        BtnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModifyActionPerformed(evt);
            }
        });

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        Username.setText("Username");
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });

        Password.setText("Password");

        Description.setText("Description");
        Description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionActionPerformed(evt);
            }
        });

        jButton2.setText("Change Master Password");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(79, 79, 79)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BtnRemove))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnModify)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(Description)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRemove)
                    .addComponent(BtnAdd)
                    .addComponent(BtnModify))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Reference for Add, Remove and Modify buttons:
    //https://www.youtube.com/watch?v=22MBsRYuM4Q    

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        //add button
        model.insertRow(model.getRowCount(), new Object[]{Username.getText(), Password.getText(), Description.getText()});

        System.out.println(username1 + " " + password1);
    }//GEN-LAST:event_BtnAddActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void DescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionActionPerformed

    private void BtnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRemoveActionPerformed

        // Confirm Deletion of entry
        int Confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this entry", "Confirm Deletion", JOptionPane.YES_NO_CANCEL_OPTION);

        //Remove Selected Row from table
        if (Confirm == 0) {
            DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
            model1.removeRow(jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_BtnRemoveActionPerformed

    private void BtnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModifyActionPerformed
        DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
        //Used to show error
        if (jTable1.getSelectedRow() == -1) {
            if (jTable1.getRowCount() == 0) {
                System.out.println("Table is empty");
            } else {
                System.out.println("You much select a row");
            }
        } else {
            //update selected row in the table with the value in the add fields 
            model2.setValueAt(Username.getText(), jTable1.getSelectedRow(), 0);
            model2.setValueAt(Password.getText(), jTable1.getSelectedRow(), 1);
            model2.setValueAt(Description.getText(), jTable1.getSelectedRow(), 2);
        }
    }//GEN-LAST:event_BtnModifyActionPerformed
//Reference for row select mouse click: 
//https://www.youtube.com/watch?v=91Rp2MA0i94
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        //Copy selected row to the add fields 
        DefaultTableModel model3 = (DefaultTableModel) jTable1.getModel();
        Username.setText(model3.getValueAt(jTable1.getSelectedRow(), 0).toString());
        Password.setText(model3.getValueAt(jTable1.getSelectedRow(), 1).toString());
        Description.setText(model3.getValueAt(jTable1.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//Reference for Jtable Export: 
//https://www.youtube.com/watch?v=tg7M9YvYDqo&t=14s

        //Temporary storage for data in plaintext 
        FileWriter fw = null;
        try {
            File file = new File(SavingLocation);
            fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            //Pass username and old or new password for saving 
            int rows = jTable1.getRowCount();
            DataOut[0][0] = Data[0][0];
            DataOut[0][1] = Data[0][1];

            if (NewPassword == 0) {
                DataOut[0][2] = Data[0][2];
            }
            
            //Save Jtable content to String Array  
            for (int a = 0; a < jTable1.getRowCount(); a++) {
                for (int b = 0; b < jTable1.getColumnCount(); b++) {
                    DataOut[a + 1][b] = jTable1.getModel().getValueAt(a, b) + "";
                    System.out.println(DataOut[a][b]);
                }
            }
            for (int a = 0; a < rows + 1; a++) {
                int b = 0;
                for (b = 0; b < 3; b++) {
                    bw.write(DataOut[a][b] + "");
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(Main_Program.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }

        //Encrypt file   
        try {

            FileInputStream file = new FileInputStream(SavingLocation); //plaintext
            FileOutputStream outStream = new FileOutputStream(SavingLocation + ".txt"); // encrypted text 
            byte k[] = "0VladimirIsCool0".getBytes();
            SecretKeySpec key = new SecretKeySpec(k, "AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while ((read = file.read(buf)) != -1) {
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            JOptionPane.showMessageDialog(null, "Successfully Saved");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        //Reference for Delete planitext file
        //https://www.mkyong.com/java/how-to-delete-file-in-java/
        File L1 = new File(SavingLocation);
        if (L1.delete()) {
        } else {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Error in saving please restart the program ");
        }

        // Reference to rename file: 
        //http://stackoverflow.com/questions/1158777/rename-a-file-using-java
        File file = new File(SavingLocation + ".txt");
        File file2 = new File(SavingLocation);

        if (file2.exists()) {
            try {
                throw new java.io.IOException("file exists");
            } catch (IOException ex) {
                Logger.getLogger(Main_Program.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        boolean success = file.renameTo(file2);

        if (!success) {
            Component frame = null;
            JOptionPane.showMessageDialog(frame, "Error in saving please restart the program ");
        }

        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            String password = jPasswordField1.getText();
            jPasswordField1.setText((get_SHA_256_SecurePassword(password)));
            System.out.println("New Password " + jPasswordField1.getText());
            //String NewPassword = jPasswordField1.getText();
            DataOut[0][2] = jPasswordField1.getText();;
            System.out.println("output " + DataOut[0][2]);
            NewPassword = 1;
            JOptionPane.showMessageDialog(null, "Master Password Changed");
        } catch (NoSuchAlgorithmException ex) {
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
            java.util.logging.Logger.getLogger(Main_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Program().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnModify;
    private javax.swing.JButton BtnRemove;
    private javax.swing.JTextField Description;
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
