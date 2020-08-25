package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class NuevoCreditoMysql {
    
    public NuevoCreditoMysql(Double NuevoCredito, String NIT){
        Conexion conexion = new Conexion();
        String sql = "UPDATE Cliente SET Credito = "+NuevoCredito+" WHERE NIT = '"+NIT+"'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al restar Credito al vender: " + e);
        }
    }
}