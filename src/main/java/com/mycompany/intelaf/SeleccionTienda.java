package com.mycompany.intelaf;

import com.intelaf.gui.empleado.Menu;
import com.intelaf.mysql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class SeleccionTienda extends javax.swing.JFrame {

    String codigoUsuario;
    public SeleccionTienda(String codigoUsuario) {
        this.setLocationRelativeTo(null);
        this.codigoUsuario = codigoUsuario;
        initComponents();
        CargarTienda();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxTienda = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tienda En");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 25, -1, -1));

        jLabel2.setText("La Que Trabajara");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 46, -1, -1));

        getContentPane().add(cbxTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 73, 113, 36));

        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 121, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 5, 200, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String CodigoTienda = (String) cbxTienda.getSelectedItem();
        Menu menu = new Menu(CodigoTienda, codigoUsuario);
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTienda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    public void CargarTienda(){
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "Select Codigo from Tienda";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                String producto = rs.getString("Codigo");
                cbxTienda.addItem(producto);
            }
        } catch (SQLException e) {
        }
    }
}
