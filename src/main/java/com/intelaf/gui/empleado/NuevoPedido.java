package com.intelaf.gui.empleado;

import com.intelaf.clases.Pedido;
import com.intelaf.clases.PertenecerProductoPedido;
import com.intelaf.mysql.CantidadExistenciaProductos;
import com.intelaf.mysql.Conexion;
import com.intelaf.mysql.ExtraerTiempoET;
import com.intelaf.mysql.ExtraerCreditoMysql;
import com.intelaf.mysql.NuevoCreditoMysql;
import com.intelaf.mysql.AgregarProductoPedidoMysql;
import com.intelaf.mysql.NuevoPedidoMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class NuevoPedido extends javax.swing.JInternalFrame {

    String CodigoTienda = null;
    String CodigoUsuario = null;
    Double Anticipo = 0.0;
    DefaultTableModel modelo;

    public NuevoPedido(String CodigoUsuario, String CodigoTienda) {
        initComponents();
        this.CodigoTienda = CodigoTienda;
        this.CodigoUsuario = CodigoUsuario;
        CargarTiendas();
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
        jLabel10 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        cbxTiendas = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblAnticipo = new javax.swing.JLabel();
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
        getContentPane().add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 134, 39));

        jLabel6.setText("Efectivo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, -1, -1));

        jLabel7.setText("Credito");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, -1, -1));

        txtCredito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCreditoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 134, 39));

        jButton1.setBackground(new java.awt.Color(55, 255, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setText("PEDIR");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 100, 50));

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

        jLabel10.setText("Precio");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtPrecio.setEditable(false);
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 215, 40));

        cbxTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTiendasActionPerformed(evt);
            }
        });
        getContentPane().add(cbxTiendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 215, 37));

        jLabel9.setText("Pedir a:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Almenos debe pagar:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 190, 40));

        lblAnticipo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        getContentPane().add(lblAnticipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 140, 40));

        Wallpaper.setBackground(new java.awt.Color(255, 255, 204));
        Wallpaper.setOpaque(true);
        getContentPane().add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 950, 670));

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
        RelizarPedido();
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

    private void cbxTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTiendasActionPerformed
        cbxProducto.removeAllItems();
        CargarProductos();
    }//GEN-LAST:event_cbxTiendasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableAgregado;
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JComboBox<String> cbxTiendas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnticipo;
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
        String Tienda = cbxTiendas.getSelectedItem().toString();
        String[] TiendaCodigo = Tienda.split(":");
        String CodigoTiendaNueva = TiendaCodigo[1];
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String CodigoProd = "SELECT Nombre,Codigo FROM Producto P INNER JOIN Tener T ON (P.Codigo = T.CodigoProducto) AND (T.CodigoTienda = '" + CodigoTiendaNueva + "')";
            PreparedStatement pst = connection.prepareStatement(CodigoProd);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cbxProducto.addItem(rs.getString("Nombre") + " :" + rs.getString("Codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar prodcuctos en venta " + e);
        }
    }

    private void CargarTiendas() {
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String CodigoProd = "SELECT Nombre,Codigo FROM Tienda WHERE Codigo != '" + CodigoTienda + "'";
            PreparedStatement pst = connection.prepareStatement(CodigoProd);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cbxTiendas.addItem(rs.getString("Nombre") + " :" + rs.getString("Codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar prodcuctos en venta " + e);
        }

    }

    private void clickComboProductos() {
        if (cbxProducto.getItemCount() != 0) {
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
    }

    private void agregarVentaTabla() {
        Double SubTotal = Double.parseDouble(txtSubTotal.getText());
        String Producto = String.valueOf(cbxProducto.getSelectedItem());
        String Tienda = String.valueOf(cbxTiendas.getSelectedItem());
        if (txtCantidad.getText().equals("")) {                                                                 //Verifica que haya escrito una cantidad de productos
            JOptionPane.showMessageDialog(null, "Por favor escriba una cantidad");
        } else {
            int Cantidad = Integer.parseInt(txtCantidad.getText());
            String[] CodigoProducto = Producto.split(":");                                                      //Se extrae el codigo y nombre del prodcuto por separado
            CantidadExistenciaProductos existencia = new CantidadExistenciaProductos();
            String[] CodigoTiendaDestino = Tienda.split(":");
            ExtraerTiempoET extraerTiempoTET = new ExtraerTiempoET();
            int CantidaExistente = existencia.CantidadExistenciaProductos(CodigoProducto[1], CodigoTiendaDestino[1]);     //Se extrae cuantos productos hay en la tienda elegida en el combo box
            int TET = extraerTiempoTET.ExtraerTiempoET(CodigoTienda, CodigoTiendaDestino[1]);                             //Se extrae los dias de traslado del pedido entre las tiendas
            if ((CantidaExistente >= Cantidad)) {
                if (TET != 0) {
                    String TiempoET = TET + " días";
                    Object datos[] = {Producto, Cantidad, SubTotal, Tienda, TiempoET};
                    modelo.addRow(datos);
                    txtCantidad.setText("");
                    cbxTiendas.disable();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Solo cuenta con " + CantidaExistente + " en bodega");
            }
        }
    }

    private void Titulos() {
        String[] Titulos = {"Producto", "Cantidad", "SubTotal", "Tienda", "Tiempo"};
        modelo = new DefaultTableModel(null, Titulos);
        TableAgregado.setModel(modelo);
    }

    private void ventaTotaDial() {
        int filas = modelo.getRowCount();
        Double Total = 0.0;
        Double anticipo = 0.0;
        for (int i = 0; i < filas; i++) {
            Total = Total + Double.parseDouble(modelo.getValueAt(i, 2).toString());
            anticipo = Total * 0.25;
        }
        txtSubTotal.setText("0");
        txtTotal.setText(String.valueOf(Total));
        lblAnticipo.setText(String.valueOf(anticipo));
    }

    private void RelizarPedido() {
        int filas = modelo.getRowCount();
        if (txtNIT.getText().equals("") || txtFecha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
        } else {
            String NIT = txtNIT.getText();
            String CodigoPedido = GenerarCodigoPedido();
            ExtraerCreditoMysql credito = new ExtraerCreditoMysql();
            if (credito.Credito(NIT)) {
                if (Pagar(credito.getCredito())) {
                    String TiendaCbx = cbxTiendas.getSelectedItem().toString();
                    String[] TiendaSeparada = TiendaCbx.split(":");
                    ExtraerTiempoET extraerTiempoTET = new ExtraerTiempoET();
                    int TET = extraerTiempoTET.ExtraerTiempoET(CodigoTienda, TiendaSeparada[1]);
                    int CodigoET = extraerTiempoTET.getCodigoTET();
                    String FechaRealizada = txtFecha.getText();
                    String CodigoVendedor = CodigoUsuario;
                    Pedido pedido = new Pedido(CodigoPedido, FechaRealizada, CodigoVendedor, NIT, CodigoET, Anticipo, false, false);
                    NuevoPedidoMysql pedidoMysql = new NuevoPedidoMysql();
                    if (pedidoMysql.RealizarPedido(pedido)) {
                        txtTotal.setText("");
                        cbxTiendas.enable();
                        for (int i = 0; i < filas; i++) {
                            String producto = (String) modelo.getValueAt(i, 0);
                            String[] CodigoProducto = producto.split(":");
                            int Cantidad = Integer.parseInt(modelo.getValueAt(i, 1).toString());
                            Double Total = Double.parseDouble(modelo.getValueAt(i, 2).toString());
                            PertenecerProductoPedido pertenecer = new PertenecerProductoPedido(0, CodigoProducto[1], CodigoPedido, Total, Cantidad);
                            AgregarProductoPedidoMysql productoMysql = new AgregarProductoPedidoMysql(pertenecer,TiendaSeparada[1]);
                        }
                        Limpiar();
                    }
                }
            }
        }
    }

    private void Limpiar() {
        txtNIT.setText("");
        txtFecha.setText("");
        txtEfectivo.setText("");
        txtCredito.setText("");
        lblAnticipo.setText("");
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
                if (AnticipoEnEfectivo(Efectivo, Total)) {
                    return true;
                }
            } else {
                if (AnticipoConCredito(Efectivo, Credito, CreditoDB, Total)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean AnticipoConCredito(Double Efectivo, Double Credito, Double CreditoDB, Double Total) {
        if ((Efectivo + Credito) >= (Total * 0.25)) {
            if (Credito <= CreditoDB) {
                Double NuevoCredito = CreditoDB - Credito;
                NuevoCreditoMysql CreditoMysql = new NuevoCreditoMysql(NuevoCredito, txtNIT.getText());
                Anticipo = Efectivo + Credito;
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El credito no es suficientes, solo cuenta con: Q " + CreditoDB);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El anticipo no es suficientes");
        }
        return false;
    }

    private boolean AnticipoEnEfectivo(Double Efectivo, Double Total) {
        if (Efectivo >= (Total * 0.25)) {
            Anticipo = Efectivo;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El anticipo no es suficientes");
        }
        return false;
    }

    private String GenerarCodigoPedido() {
        String codigo = "";
        String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] numeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int rl = random.nextInt(25);
            codigo += letras[rl];
        }
        for (int i = 0; i < 5; i++) {
            int rn = random.nextInt(9);
            codigo += numeros[rn];
        }
        return codigo;
    }
}
