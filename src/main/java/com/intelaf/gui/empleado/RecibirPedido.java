package com.intelaf.gui.empleado;

import com.intelaf.mysql.Conexion;
import com.intelaf.mysql.ExtraerDiasPedidoMysql;
import com.intelaf.mysql.ExtraerFechaPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class RecibirPedido extends javax.swing.JInternalFrame {

    String CodigoTienda;

    public RecibirPedido(String CodigoTienda) {
        initComponents();
        this.CodigoTienda = CodigoTienda;
        CargarPedidos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbxPedido = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Pedido");

        jLabel2.setText("Fecha De Recibido");

        jButton1.setText("Recibir");
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbxPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbxPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String CodigoPedido = cbxPedido.getSelectedItem().toString();
        if(Recibir(CodigoPedido))
            if(VerificarRetraso(CodigoPedido))
                JOptionPane.showMessageDialog(null, "El pedido fue registrado con retraso");
            else
                JOptionPane.showMessageDialog(null, "El pedido fue recibido a tiempo");
        cbxPedido.removeAllItems();
        txtFecha.setText("");
        CargarPedidos();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables

    public boolean Recibir(String CodigoPedido) {
        Conexion conexion = new Conexion();
        String sql = "UPDATE Pedido SET Recibido = 1 WHERE CodigoPedido = '" + CodigoPedido + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
            System.err.println("Error al recibir pedido: " + e);
        }
        return false;
    }

    public boolean VerificarRetraso(String CodigoPedido) {
        Conexion conexion = new Conexion();
        ExtraerDiasPedidoMysql diasPedido = new ExtraerDiasPedidoMysql();
        String fecha = txtFecha.getText();
        String[] fechaSeparada = fecha.split("/");
        int dia = Integer.parseInt(fechaSeparada[0]);
        int mes = Integer.parseInt(fechaSeparada[1]);
        int anio = Integer.parseInt(fechaSeparada[2]);
        int diasTardados = DiasTardados(dia, mes, anio, CodigoPedido);
        int diasPrevistos = diasPedido.DiasPrevistos(cbxPedido.getSelectedItem().toString());
        if (diasTardados > diasPrevistos) {
            if(setAtrasado(cbxPedido.getSelectedItem().toString()))
                return true;
        }
        return false;
    }

    public int DiasTardados(int dia, int mes, int anio, String CodigoPedido) {
        int dias = 0;

        Calendar FechaLlegada = Calendar.getInstance();
        FechaLlegada.set(anio, mes - 1, dia);
        FechaLlegada.set(Calendar.HOUR, 0);
        FechaLlegada.set(Calendar.HOUR_OF_DAY, 0);
        FechaLlegada.set(Calendar.MINUTE, 0);
        FechaLlegada.set(Calendar.SECOND, 0);

        ExtraerFechaPedido extraerFechaPedido = new ExtraerFechaPedido();
        String FechaPedido = extraerFechaPedido.FechaPedido(CodigoPedido);
        String[] fechaSeparada = FechaPedido.split("/");
        int diaS = Integer.parseInt(fechaSeparada[0]);
        int mesS = Integer.parseInt(fechaSeparada[1]);
        int anioS = Integer.parseInt(fechaSeparada[2]);
        Calendar FechaSalida = Calendar.getInstance();
        FechaSalida.set(anioS, mesS - 1, diaS);
        FechaSalida.set(Calendar.HOUR, 0);
        FechaSalida.set(Calendar.HOUR_OF_DAY, 0);
        FechaSalida.set(Calendar.MINUTE, 0);
        FechaSalida.set(Calendar.SECOND, 0);

        long finMS = FechaLlegada.getTimeInMillis();
        long inicioMS = FechaSalida.getTimeInMillis();

        dias = (int) ((finMS - inicioMS) / (1000 * 60 * 60 * 24));
        return dias + 1;
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
        String sql = "SELECT CodigoPedido FROM Pedido WHERE CodigoTET = " + CodigoTET+" AND Recibido <> 1";

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

    public boolean setAtrasado(String CodigoPedido) {
        Conexion conexion = new Conexion();
        String sql = "UPDATE Pedido SET Retrasado = 1 WHERE CodigoPedido = '" + CodigoPedido + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
            System.err.println("Error al setAtraso en recibir pedido: " + e);
        }
        return false;
    }
}
