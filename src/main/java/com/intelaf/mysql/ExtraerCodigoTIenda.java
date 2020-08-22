package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class ExtraerCodigoTIenda {

    public String ExtraerCodigoTIenda(String nombre) {
        String codigo = null;
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "Select Codigo from Tienda WHERE Nombre = '" + nombre + "'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                codigo = rs.getString("Codigo");
                System.out.println("eEn extraer "+codigo);
                return codigo;
            }
        } catch (SQLException e) {
        }
        return codigo;
    }
        
}
