package com.intelaf.gui.reportes;

import com.intelaf.mysql.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class PedidosRetrasados extends javax.swing.JInternalFrame {

    String CodigoTienda;
    DefaultTableModel modelo = null;

    public PedidosRetrasados(String CodigoTienda) {
        this.CodigoTienda = CodigoTienda;
        initComponents();
        Titulos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        txtHoy = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 49, 548, 371));
        getContentPane().add(txtHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 7, 200, 29));

        jLabel1.setText("Fecha de hoy");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 14, -1, -1));

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 6, -1, -1));

        jButton2.setText("Exportar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 6, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtHoy.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Por favor escriba una fecha");
        else {
            Limpiar();
            agregarATabla();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                Exportar e = new Exportar();
        try {
            e.generar(modelo, "Pedidos Retrasados");
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
    private javax.swing.JTextField txtHoy;
    // End of variables declaration//GEN-END:variables

    private void agregarATabla() {
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT CodigoTET,TiempoET FROM TET WHERE CodTiendaDestino = '" + CodigoTienda + "'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int CodigoTET = rs.getInt("CodigoTET");
                int TiempoEstimado = rs.getInt("TiempoET");
                AgregarPedidos(CodigoTET, TiempoEstimado);
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }

    }

    private void AgregarPedidos(int CodigoTET, int TiempoEstimado) {
        Conexion conexion = new Conexion();
        String sql = "SELECT * from Pedido WHERE Recibido = 0 AND CodigoTET = " + CodigoTET;

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Salida = rs.getString("FechaSalida");
                String[] FechaSalida = Salida.split("/");
                int dia = Integer.parseInt(FechaSalida[0]);
                int mes = Integer.parseInt(FechaSalida[1]);
                int anio = Integer.parseInt(FechaSalida[2]);
                int diasTranscurridos = DiasTardados(dia, mes, anio);
                if (diasTranscurridos > TiempoEstimado) {
                    String CodPedido = rs.getString("CodigoPedido");
                    int NIT = rs.getInt("NIT");
                    Object datos[] = {CodPedido, Salida, NIT};
                    modelo.addRow(datos);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }
    }

    private void Titulos() {
        String[] Titulos = {"Codigo Pedido", "Fecha Salida", "NIT"};
        modelo = new DefaultTableModel(null, Titulos);
        tablePedidos.setModel(modelo);
    }

    public int DiasTardados(int dia, int mes, int anio) {
        int dias = 0;

        Calendar FechaSalida = Calendar.getInstance();
        FechaSalida.set(anio, mes - 1, dia);
        FechaSalida.set(Calendar.HOUR, 0);
        FechaSalida.set(Calendar.HOUR_OF_DAY, 0);
        FechaSalida.set(Calendar.MINUTE, 0);
        FechaSalida.set(Calendar.SECOND, 0);

        String FechaActual = txtHoy.getText();
        String[] fechaSeparada = FechaActual.split("/");
        int diaS = Integer.parseInt(fechaSeparada[0]);
        int mesS = Integer.parseInt(fechaSeparada[1]);
        int anioS = Integer.parseInt(fechaSeparada[2]);
        Calendar FechaHoy = Calendar.getInstance();
        FechaHoy.set(anioS, mesS - 1, diaS);
        FechaHoy.set(Calendar.HOUR, 0);
        FechaHoy.set(Calendar.HOUR_OF_DAY, 0);
        FechaHoy.set(Calendar.MINUTE, 0);
        FechaHoy.set(Calendar.SECOND, 0);

        long finMS = FechaHoy.getTimeInMillis();
        long inicioMS = FechaSalida.getTimeInMillis();

        dias = (int) ((finMS - inicioMS) / (1000 * 60 * 60 * 24));
        return dias;
    }

    public void Limpiar() {
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }

    }

}
