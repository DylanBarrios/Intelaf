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
        jLabel3 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 23, -1, -1));

        getContentPane().add(cbxPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 56, 193, 36));

        jLabel2.setText("Fecha De Recibido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 110, -1, -1));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 143, 200, 35));

        jButton1.setText("Recibir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 196, 174, 51));

        jLabel3.setBackground(new java.awt.Color(255, 255, 204));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 280));

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
    private javax.swing.JLabel jLabel3;
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
