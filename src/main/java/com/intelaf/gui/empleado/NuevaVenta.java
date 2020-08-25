package com.intelaf.gui.empleado;

import com.intelaf.clases.Venta;
import com.intelaf.mysql.CantidadExistenciaProductos;
import com.intelaf.mysql.Conexion;
import com.intelaf.mysql.ExtraerCreditoMysql;
import com.intelaf.mysql.NuevaVentaMysql;
import com.intelaf.mysql.NuevoCreditoMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class NuevaVenta extends javax.swing.JInternalFrame {

    String CodigoTienda = null;
    String CodigoUsuario = null;
    DefaultTableModel modelo;

    public NuevaVenta(String CodigoUsuario, String CodigoTienda) {
        initComponents();
        this.CodigoTienda = CodigoTienda;
        this.CodigoUsuario = CodigoUsuario;
        lblNombre.setText("Bienvenid@ " + CodigoUsuario);
        CargarProductos();
        Titulos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAgregado = new javax.swing.JTable();
        cbxProducto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtNIT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCredito = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        Wallpaper = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TableAgregado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableAgregado);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 620, 520));

        cbxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProductoActionPerformed(evt);
            }
        });
        getContentPane().add(cbxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 63, 215, 37));

        jLabel1.setText("Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNITKeyTyped(evt);
            }
        });
        getContentPane().add(txtNIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 215, 43));

        jLabel2.setText("NIT");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel3.setText("Cantidad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 214, 39));

        jLabel4.setText("Total");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 114, 48));

        jLabel5.setText("Fecha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 215, 44));

        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
        });
        getContentPane().add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 134, 39));

        jLabel6.setText("Efectivo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel7.setText("Credito");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, -1, -1));

        txtCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 134, 39));

        jButton1.setBackground(new java.awt.Color(55, 255, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("VENDER");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 520, 100, 50));

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setText("AGREGAR");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 100, 48));

        jLabel8.setText("SubTotal");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        txtSubTotal.setEditable(false);
        getContentPane().add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 214, 38));

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 102, 255));
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 6, 290, 45));

        jLabel10.setText("Precio");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtPrecio.setEditable(false);
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 215, 40));

        jButton3.setBackground(new java.awt.Color(102, 204, 255));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("PEDIDO ENTRE TIENDAS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 530, 570, 50));

        Wallpaper.setBackground(new java.awt.Color(255, 255, 204));
        Wallpaper.setOpaque(true);
        getContentPane().add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 950, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProductoActionPerformed
        clickComboProductos();

    }//GEN-LAST:event_cbxProductoActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char tipeado = evt.getKeyChar();
        if (Character.isLetter(tipeado)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        if (!txtCantidad.getText().equals("")) {
            double Subtotal = Double.parseDouble(txtPrecio.getText()) * Integer.parseInt(txtCantidad.getText());
            txtSubTotal.setText(String.valueOf(Subtotal));
        }
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        agregarVentaTabla();
        ventaTotaDial();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        vender();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNITKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNITKeyTyped
        char tipeado = evt.getKeyChar();
        if (Character.isLetter(tipeado)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNITKeyTyped

    private void txtEfectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEfectivoKeyTyped
        char tipeado = evt.getKeyChar();
        if (Character.isLetter(tipeado)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtEfectivoKeyTyped

    private void txtCreditoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCreditoKeyTyped
        char tipeado = evt.getKeyChar();
        if (Character.isLetter(tipeado)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCreditoKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        NuevoPedido pedido = new NuevoPedido(CodigoUsuario, CodigoTienda);
        Menu.principal.add(pedido);
        pedido.toFront();
        pedido.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableAgregado;
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNIT;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void CargarProductos() {
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String CodigoProd = "SELECT Nombre,Codigo FROM Producto P INNER JOIN Tener T ON (P.Codigo = T.CodigoProducto) AND (T.CodigoTienda = '" + CodigoTienda + "')";
            PreparedStatement pst = connection.prepareStatement(CodigoProd);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cbxProducto.addItem(rs.getString("Nombre") + " :" + rs.getString("Codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar prodcuctos en venta " + e);
        }
    }

    private void clickComboProductos() {
        Conexion conexion = new Conexion();
        String producto = cbxProducto.getSelectedItem().toString();
        String[] codigoProducto = producto.split(":");

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT Precio FROM Producto WHERE Codigo = '" + codigoProducto[1] + "'";               //Consulta que se hara a la D.B. para obtener el precio y cantidad producto
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                txtPrecio.setText(rs.getString("Precio"));
                txtCantidad.setText("");
            }
        } catch (SQLException e) {
            System.out.println("Error al dar click en combo " + e);
        }
    }

    private void agregarVentaTabla() {
        Double SubTotal = Double.parseDouble(txtSubTotal.getText());
        String Producto = String.valueOf(cbxProducto.getSelectedItem());
        if (txtCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor escriba una cantidad");
        } else {
            int Cantidad = Integer.parseInt(txtCantidad.getText());
            String[] CodigoProducto = Producto.split(":");
            CantidadExistenciaProductos existencia = new CantidadExistenciaProductos();
            int CantidaExistente = existencia.CantidadExistenciaProductos(CodigoProducto[1], CodigoTienda);
            if (CantidaExistente >= Cantidad) {
                Object datos[] = {Producto, Cantidad, SubTotal};
                modelo.addRow(datos);
                txtCantidad.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Solo cuenta con " + CantidaExistente + " en bodega");
            }
        }
    }

    private void Titulos() {
        String[] Titulos = {"Producto", "Cantidad", "SubTotal"};
        modelo = new DefaultTableModel(null, Titulos);
        TableAgregado.setModel(modelo);
    }

    private void ventaTotaDial() {
        int filas = modelo.getRowCount();
        Double Total = 0.0;
        for (int i = 0; i < filas; i++) {
            Total = Total + Double.parseDouble(modelo.getValueAt(i, 2).toString());
        }
        txtTotal.setText(String.valueOf(Total));
    }

    private void vender() {
        int filas = modelo.getRowCount();
        if (txtNIT.getText().equals("") || txtFecha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
        } else {
            String NIT = txtNIT.getText();
            ExtraerCreditoMysql credito = new ExtraerCreditoMysql();
            if (credito.Credito(NIT)) {
                if (Pagar(credito.getCredito())) {
                    for (int i = 0; i < filas; i++) {
                        String producto = (String) modelo.getValueAt(i, 0);
                        String[] CodigoProducto = producto.split(":");
                        int Cantidad = Integer.parseInt(modelo.getValueAt(i, 1).toString());
                        Double Total = Double.parseDouble(modelo.getValueAt(i, 2).toString());
                        String CodigoVendedor = CodigoUsuario;
                        String FechaRealizada = txtFecha.getText();
                        int CodigoVenta = 0;
                        Venta venta = new Venta(CodigoProducto[1], CodigoVendedor, FechaRealizada, NIT, CodigoVenta, Cantidad, Total);
                        NuevaVentaMysql ventaMysql = new NuevaVentaMysql(venta, CodigoTienda);
                    }
                    Limpiar();
                }
            }
        }
    }

    private void Limpiar() {
        txtNIT.setText("");
        txtFecha.setText("");
        txtEfectivo.setText("");
        txtCredito.setText("");
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }

    }

    private boolean Pagar(Double CreditoDB) {
        Double Total = Double.parseDouble(txtTotal.getText());
        Double Efectivo = 0.0;
        Double Credito = 0.0;

        if (txtEfectivo.getText().equals("") && txtCredito.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por Favor Escriba un metodo de pago");
        } else {

            if (!txtCredito.getText().equals("")) {
                Credito = Double.parseDouble(txtCredito.getText());
            }
            if (!txtEfectivo.getText().equals("")) {
                Efectivo = Double.parseDouble(txtEfectivo.getText());
            }

            if (Credito == 0) {
                if (PagoEnEfectivo(Efectivo, Total)) {
                    return true;
                }
            } else {
                if (PagoConCredito(Efectivo, Credito, CreditoDB, Total)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean PagoConCredito(Double Efectivo, Double Credito, Double CreditoDB, Double Total) {
        if ((Efectivo + Credito) >= Total) {
            if (Credito <= CreditoDB) {
                Double NuevoCredito = CreditoDB - Credito;
                NuevoCreditoMysql CreditoMysql = new NuevoCreditoMysql(NuevoCredito, txtNIT.getText());
                JOptionPane.showMessageDialog(null, "Pago realizado con exito");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El credito no es suficientes, solo cuenta con: Q " + CreditoDB);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El pago no es suficientes");
        }
        return false;
    }

    private boolean PagoEnEfectivo(Double Efectivo, Double Total) {
        if (Efectivo >= Total) {
            JOptionPane.showMessageDialog(null, "Pago realizado, el vuelto es de: Q " + (Efectivo - Total));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El pago no es suficientes");
        }
        return false;
    }
}
