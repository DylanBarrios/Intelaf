package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class ExtraerFechaPedido {

    public String FechaPedido(String CodigoPedido) {
        String fecha = null;
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT FechaSalida FROM Pedido WHERE CodigoPedido = '"+CodigoPedido+"'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                fecha = rs.getString("FechaSalida");
                System.out.println("eEn extraer "+fecha);
                return fecha;
            }
        } catch (SQLException e) {
            System.out.println("Error al extraer fecha de pedido "+e);
        }
        return fecha;
    }    
}
