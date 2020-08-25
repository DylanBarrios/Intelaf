package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class ExtraerDiasPedidoMysql {
     
    public int DiasPrevistos(String CodigoPedido) {
        int DiasPrevistos = 0;
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT CodigoTET FROM Pedido WHERE CodigoPedido = '" + CodigoPedido + "'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int CodigoTET = rs.getInt("CodigoTET");
                DiasPrevistos = Dias(CodigoTET);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener CodigoTET al extraer Dias " + e);
        }
        return DiasPrevistos;
    }

    private int Dias(int CodigoTET) {
        int Dias = 0;
        Conexion conexion = new Conexion();
        String sql = "SELECT TiempoET FROM TET WHERE CodigoTET = " + CodigoTET;
        
        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Dias = rs.getInt("TiempoET");
            }
        } catch (SQLException e) {
            System.out.println("Erro al extraer dias de pedido " + e);
        }
        return Dias;
    }
}
