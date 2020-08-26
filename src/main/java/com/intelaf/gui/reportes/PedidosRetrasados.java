package com.intelaf.gui.reportes;

import com.intelaf.mysql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
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

        jLabel1.setText("Fecha de hoy");

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoy, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
