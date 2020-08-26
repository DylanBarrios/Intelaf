package com.intelaf.gui.empleado;

import com.intelaf.clases.Venta;
import com.intelaf.mysql.CantidadExistenciaProductos;
import com.intelaf.mysql.Conexion;
import com.intelaf.mysql.ExtraerCreditoMysql;
import com.intelaf.mysql.ExtraerTiempoET;
import com.intelaf.mysql.NuevaVentaMysql;
import com.intelaf.mysql.NuevaVentaPedidoMysql;
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
public class EntregarPedido extends javax.swing.JInternalFrame {

    String CodigoTienda = null;
    String CodigoUsuario = null;
    Double Anticipo = 0.0;
    DefaultTableModel modelo = null;

    public EntregarPedido(String CodigoUsuario, String CodigoTienda) {
        initComponents();
        this.CodigoTienda = CodigoTienda;
        this.CodigoUsuario = CodigoUsuario;
        CargarPedidos();
        Titulos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAgregado = new javax.swing.JTable();
        cbxPedido = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtNIT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCredito = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblAnticipo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblResto = new javax.swing.JLabel();
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 620, 660));

        cbxPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(cbxPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 215, 40));

        jLabel1.setText("Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txtNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNITKeyTyped(evt);
            }
        });
        getContentPane().add(txtNIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 215, 40));

        jLabel2.setText("NIT");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel4.setText("Total");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 215, 40));

        jLabel5.setText("Fecha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 215, 40));

        txtEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEfectivoKeyTyped(evt);
            }
        });
        getContentPane().add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 134, 39));

        jLabel6.setText("Efectivo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel7.setText("Credito");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        txtCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 134, 39));

        jButton1.setBackground(new java.awt.Color(55, 255, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("VENDER");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 150, 60));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Anticipo Pagado:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 60));

        lblAnticipo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        getContentPane().add(lblAnticipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 140, 50));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Pago Restante:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        lblResto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        getContentPane().add(lblResto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 140, 50));

        Wallpaper.setBackground(new java.awt.Color(255, 255, 204));
        Wallpaper.setOpaque(true);
        getContentPane().add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 950, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPedidoActionPerformed
        Limpiar();
        clickComboProductos();
    }//GEN-LAST:event_cbxPedidoActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableAgregado;
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JComboBox<String> cbxPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnticipo;
    private javax.swing.JLabel lblResto;
    private javax.swing.JTextField txtCredito;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNIT;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void Titulos() {
        String[] Titulos = {"Producto", "Cantidad", "SubTotal"};
        modelo = new DefaultTableModel(null, Titulos);
        TableAgregado.setModel(modelo);
    }

    private void Limpiar() {
        txtNIT.setText("");
        txtFecha.setText("");
        txtEfectivo.setText("");
        txtCredito.setText("");
        lblAnticipo.setText("");
        if (modelo != null) {
            int filas = modelo.getRowCount();

            for (int i = 0; i < filas; i++) {
                modelo.removeRow(0);
            }
        }
    }

    private void vender() {
        int filas = modelo.getRowCount();
        if (txtFecha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor escriba una fecha de venta");
        } else {
            String NIT = txtNIT.getText();
            ExtraerCreditoMysql credito = new ExtraerCreditoMysql();
            if (credito.Credito(NIT)) {
                Double CreditoDB = credito.getCredito();
                if (Pagar(CreditoDB)) {
                    for (int i = 0; i < filas; i++) {
                        String producto = (String) modelo.getValueAt(i, 0);
                        int Cantidad = Integer.parseInt(modelo.getValueAt(i, 1).toString());
                        Double Total = Double.parseDouble(modelo.getValueAt(i, 2).toString());
                        String CodigoVendedor = CodigoUsuario;
                        String FechaRealizada = txtFecha.getText();
                        int CodigoVenta = 0;
                        Venta venta = new Venta(producto, CodigoVendedor, FechaRealizada, NIT, CodigoVenta, Cantidad, Total);
                        NuevaVentaPedidoMysql ventaMysql = new NuevaVentaPedidoMysql(venta);
                        Entregar(cbxPedido.getSelectedItem().toString());
                        if (verificarRetraso(cbxPedido.getSelectedItem().toString())) {
                            aumentarCredito(venta.getNIT(),CreditoDB,VerificarPagoTotal());
                        }
                        cbxPedido.removeAllItems();
                        CargarPedidos();
                    }
                    Limpiar();
                }
            }
        }
    }

    private boolean Pagar(Double CreditoDB) {
        Double Total = Double.parseDouble(lblResto.getText());
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

    private void CargarPedidos() {
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT CodigoTET FROM TET WHERE CodTiendaDestino = '" + CodigoTienda + "'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int CodigoTET = rs.getInt("CodigoTET");
                AgregarPedidos(CodigoTET);
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }
    }

    private void AgregarPedidos(int CodigoTET) {
        Conexion conexion = new Conexion();
        String sql = "SELECT CodigoPedido FROM Pedido WHERE CodigoTET = " + CodigoTET + " AND Recibido = 1 AND Entregado = 0";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cbxPedido.addItem(rs.getString("CodigoPedido"));
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }
    }

    private void clickComboProductos() {
        Conexion conexion = new Conexion();
        String producto = cbxPedido.getSelectedItem().toString();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT * FROM Pertenecer WHERE CodigoPedido = '" + producto + "'";               //Consulta que se hara a la D.B. para obtener el precio y cantidad producto
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Producto = rs.getString("CodigoProducto");
                int Cantidad = rs.getInt("CantidadProductos");
                Double SubTotal = rs.getDouble("SubTotal");
                Object datos[] = {Producto, Cantidad, SubTotal};
                modelo.addRow(datos);
                DatosVenta();

            }
        } catch (SQLException e) {
            System.out.println("Error al dar click en combo " + e);
        }
    }

    private void DatosVenta() {
        Conexion conexion = new Conexion();
        String producto = cbxPedido.getSelectedItem().toString();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT * FROM Pedido WHERE CodigoPedido = '" + producto + "'";               //Consulta que se hara a la D.B. para obtener el precio y cantidad producto
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String NIT = rs.getString("NIT");
                Double Anticipo = rs.getDouble("Anticipo");
                Double Total = ventaTotaDial();
                Double PagoRestante = Total - Anticipo;
                txtNIT.setText(NIT);
                txtTotal.setText(String.valueOf(Total));
                lblAnticipo.setText(String.valueOf(Anticipo));
                lblResto.setText(String.valueOf(PagoRestante));
            }
        } catch (SQLException e) {
            System.out.println("Error al dar click en combo " + e);
        }
    }

    private Double ventaTotaDial() {
        int filas = modelo.getRowCount();
        Double Total = 0.0;
        for (int i = 0; i < filas; i++) {
            Total = Total + Double.parseDouble(modelo.getValueAt(i, 2).toString());
        }
        return Total;
    }

    public boolean Entregar(String CodigoPedido) {
        Conexion conexion = new Conexion();
        String sql = "UPDATE Pedido SET Entregado = 1 WHERE CodigoPedido = '" + CodigoPedido + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
            System.err.println("Error al entregar pedido: " + e);
        }
        return false;
    }

    public boolean verificarRetraso(String CodigoPedido) {
        Conexion conexion = new Conexion();
        String producto = cbxPedido.getSelectedItem().toString();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT Retrasado FROM Pedido WHERE CodigoPedido = '" + CodigoPedido + "'";               //Consulta que se hara a la D.B. para obtener el precio y cantidad producto
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getBoolean("Retrasado")) {
                    
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al aumentar credito " + e);
        }
        return false;
    }

    public void aumentarCredito(String NIT, Double CreditoDB, boolean PagoTotal) {
        Double TotalP = Double.parseDouble(txtTotal.getText());
        Double NuevoCredito;
        Conexion conexion = new Conexion();
        if(PagoTotal)
            NuevoCredito = CreditoDB + (TotalP*0.05);
        else
            NuevoCredito = CreditoDB + (TotalP*0.02);
        String sql = "UPDATE Cliente SET Credito = " + NuevoCredito + " WHERE NIT = '" + NIT + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al restar Credito al vender: " + e);
        }
    }
    
    private boolean VerificarPagoTotal(){
        Double Anticipo = Double.parseDouble(lblAnticipo.getText());
        Double Total = Double.parseDouble(txtTotal.getText());
        if(Anticipo == Total)
            return true;
        return false;            
    }
}
