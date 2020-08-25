package com.intelaf.mysql;

import com.intelaf.clases.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class NuevoPedidoMysql {


    public boolean RealizarPedido(Pedido pedido){
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO Pedido VALUES(?,?,?,?,?,?,?,?)";
        if (VerificarPedido(pedido.getCodigoPedido())) {
            JOptionPane.showMessageDialog(null, "El codigo de pedido ya esta registrado");
        } else {
            try (Connection connection = conexion.getConnection()) {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, pedido.getCodigoPedido());
                pst.setInt(2, pedido.getCodigoTet());
                pst.setString(3, pedido.getFechaSalida());
                pst.setString(4, pedido.getCodigoVendedor());
                pst.setString(5, pedido.getNIT());
                pst.setDouble(6, pedido.getAnticipo());
                pst.setBoolean(7, pedido.isRetrasado());
                pst.setBoolean(8, pedido.isEntregado());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pedido registrado con exito");
                return true;
            } catch (SQLException e) {
                System.err.println("Error al agregar Nuevo Pedido: " + e);
                JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
            }
        }
        return false;
    }

public boolean VerificarPedido(String CodPedido) {
        Conexion conexion = new Conexion();
        String sql = "SELECT CodigoPedido FROM Pedido WHERE CodigoPedido = '" + CodPedido + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar CodPedido en nuevo cliente: " + e);
        }
        return false;
    }
}
