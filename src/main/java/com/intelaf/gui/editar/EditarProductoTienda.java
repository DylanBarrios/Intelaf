package com.intelaf.gui.editar;

import com.intelaf.clases.Cliente;
import com.intelaf.clases.TenerProductoTienda;
import com.intelaf.mysql.ActualizarClienteMysql;
import com.intelaf.mysql.ActualizarTenerMysql;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class EditarProductoTienda extends javax.swing.JInternalFrame {

    TenerProductoTienda producto;

    public EditarProductoTienda(TenerProductoTienda producto) {
        initComponents();
        this.producto = producto;
        setProducto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTienda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Cantidad");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        txtProducto.setEditable(false);
        getContentPane().add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 140, 30));

        txtCantidad.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 90, 40));

        jLabel2.setText("Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 95, -1, -1));

        jButton2.setBackground(new java.awt.Color(51, 255, 0));
        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 121, 50));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("AGREGAR PRODUCTO A LA TIENDA");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel7.setText("Tienda");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtTienda.setEditable(false);
        getContentPane().add(txtTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 30));

        jLabel3.setText("id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        txtId.setEditable(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 53, 140, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 4, 380, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CapturarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        
    }//GEN-LAST:event_txtCantidadKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtTienda;
    // End of variables declaration//GEN-END:variables
   
    private void CapturarDatos() {
        if (txtCantidad.getText().equals("")) 
            JOptionPane.showMessageDialog(null, "Por favor escriba una cantidad");
         else {
            int id = Integer.parseInt(txtId.getText());
            String CodigoProducto = txtProducto.getText();
            String CodigoTienda = txtTienda.getText();
            int Cantidad = Integer.parseInt(txtCantidad.getText());
            producto = new TenerProductoTienda(id, Cantidad, CodigoProducto, CodigoTienda);
            ActualizarTenerMysql tenerMysql = new ActualizarTenerMysql();
            if(tenerMysql.ActualizarTenerMysql(producto))
                   this.setVisible(false);
        }
    }
    
    private void setProducto(){
        txtId.setText(String.valueOf(producto.getIdTener()));
        txtProducto.setText(producto.getCodigoProducto());
        txtTienda.setText(producto.getCodigoTienda());
        txtCantidad.setText(String.valueOf(producto.getCantidad()));
    }
      
}
