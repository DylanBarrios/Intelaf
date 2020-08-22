package com.intelaf.gui.empleado;

import com.intelaf.clases.TenerProductoTienda;
import com.intelaf.mysql.AgregarProductoTiendaMysql;
import com.intelaf.mysql.Conexion;
import com.intelaf.mysql.ExtraerCodigoProducto;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class AgregarProductoTienda extends javax.swing.JInternalFrame {

    NuevoProducto Nuevo;
    String CodigoTienda;
    
    public AgregarProductoTienda(NuevoProducto Nuevo, String codigoTienda) {
        initComponents();
        this.Nuevo = Nuevo;
        this.CodigoTienda = codigoTienda;
        CargarProductos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cbxProductos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        LabelTienda = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cantidad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 99, -1, -1));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 95, 177, -1));

        jLabel2.setText("Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 63, -1, -1));

        jLabel4.setText("agreguelo presionando");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 151, -1, -1));

        jButton1.setForeground(new java.awt.Color(0, 51, 255));
        jButton1.setText("Nuevo");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, 15));

        jLabel3.setText("Si el producto no aparece ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 130, 200, -1));

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 52, 121, 66));

        cbxProductos.setEditable(true);
        getContentPane().add(cbxProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 58, 177, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("AGREGAR PRODUCTO A LA TIENDA");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 6, -1, -1));

        LabelTienda.setText("jLabel6");
        getContentPane().add(LabelTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 31, 132, 21));

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 4, 410, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu menu = new Menu();
        menu.Mostrar(Nuevo);
        LabelTienda.setText(menu.getCodigoTienda());
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!txtCantidad.getText().equals("")) {
            ExtraerCodigoProducto codigo = new ExtraerCodigoProducto();
            int Cantidad = Integer.parseInt(txtCantidad.getText());
            String CodigoProducto = codigo.ExtraerCodigoProducto((String) cbxProductos.getSelectedItem());
            TenerProductoTienda tener = new TenerProductoTienda(0, Cantidad, CodigoProducto, CodigoTienda);
            AgregarProductoTiendaMysql tenerMysql = new AgregarProductoTiendaMysql(tener);
        }else{
            JOptionPane.showMessageDialog(null, "Por favor escriba una cantidad");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTienda;
    private javax.swing.JComboBox<String> cbxProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables

    private void CargarProductos() {
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "Select Nombre from Producto";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                String producto = rs.getString("Nombre");
                cbxProductos.addItem(producto);
            }
        } catch (SQLException e) {
        }
    }
}
