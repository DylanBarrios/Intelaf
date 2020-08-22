package com.intelaf.gui.empleado;

import com.intelaf.clases.TiempoEntreTiendas;
import com.intelaf.mysql.ExtraerCodigoTIenda;
import com.intelaf.mysql.Conexion;
import com.intelaf.mysql.NuevaTiendaMysql;
import com.intelaf.mysql.NuevoTET_Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class NuevoTiempo extends javax.swing.JInternalFrame {

    String CodigoTienda;

    public NuevoTiempo(String CodigoTienda) {
        initComponents();
        this.CodigoTienda = CodigoTienda;
        CargarProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxTienda = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Wallpaper = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane().add(cbxTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 144, 38));

        jLabel3.setText("Tienda Destino");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setText("Tiempo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, -1));

        txtTiempo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtTiempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTiempoKeyTyped(evt);
            }
        });
        getContentPane().add(txtTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 80, 38));

        jLabel1.setText("dias");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, 50));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 255));
        jLabel6.setText("Tiempo Entre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 290, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 255));
        jLabel5.setText("Tiendas");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 170, 40));

        Wallpaper.setBackground(new java.awt.Color(255, 255, 204));
        Wallpaper.setOpaque(true);
        getContentPane().add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTiempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiempoKeyTyped
        char tipeado = evt.getKeyChar();
        if (Character.isLetter(tipeado)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTiempoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CapturarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JComboBox<String> cbxTienda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables

    private void CargarProductos() {
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "Select Codigo from Tienda WHERE Codigo <> '" + CodigoTienda + "'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String tienda = rs.getString("Codigo");
                cbxTienda.addItem(tienda);
            }
        } catch (SQLException e) {
        }
    }

    private void CapturarDatos() {
        int CodigoTET = 0;
        String CodTiendaOrigen = CodigoTienda;
        String CodTiendaDestino = (String) cbxTienda.getSelectedItem();
        String TiempoETstring = txtTiempo.getText();
        if (TiempoETstring.equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor escriba el tiempo de transporte");
        } else {
            int TiempoET = Integer.parseInt(TiempoETstring);
            TiempoEntreTiendas tet = new TiempoEntreTiendas(CodigoTET, CodTiendaOrigen, CodTiendaDestino, TiempoET);
            NuevoTET_Mysql tetMysql = new NuevoTET_Mysql(tet);
        }
    }
}
