package com.intelaf.gui.reportes;

import com.intelaf.mysql.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class PedidosPorCliente extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = null;

    public PedidosPorCliente() {
        initComponents();
        Titulos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtNIT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePedidos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, 616, 376));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 9, -1, -1));
        getContentPane().add(txtNIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 13, 145, -1));

        jLabel1.setText("NIT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 17, -1, -1));

        jButton2.setText("Exportar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 9, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtNIT.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Por favor escriba un NIT");
        else {
            Limpiar();
            AgregarVentas(Integer.parseInt(txtNIT.getText()));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                Exportar e = new Exportar();
        try {
            e.generar(modelo, "Pedidos Por Cliente");
        } catch (IOException ex) {
            Logger.getLogger(PedidosPorLlegar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePedidos;
    private javax.swing.JTextField txtNIT;
    // End of variables declaration//GEN-END:variables

    private void AgregarVentas(int NIT) {
        Conexion conexion = new Conexion();
        String sql = "SELECT * FROM Pedido WHERE Recibido = 0 AND NIT = " + NIT;

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String CodigoPedido = rs.getString("CodigoPedido");
                int Anticipo = rs.getInt("Anticipo");
                String Fecha = rs.getString("FechaSalida");
                Object datos[] = {CodigoPedido, NIT, Anticipo, Fecha};
                modelo.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }
    }

    private void Titulos() {
        String[] Titulos = {"Codigo Pedido", "NIT", "Anticipo", "Fecha de Compra"};
        modelo = new DefaultTableModel(null, Titulos);
        tablePedidos.setModel(modelo);
    }

    public void Limpiar() {
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }

    }
}
