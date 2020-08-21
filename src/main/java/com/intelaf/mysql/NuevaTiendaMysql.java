package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class NuevaTiendaMysql {

    public NuevaTiendaMysql(String Codigo, String Nombre, String Direccion, String Telefono1, String Telefono2, String Correo, String Horario) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "INSERT INTO Tienda VALUES(?,?,?,?,?,?,?)";
        
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, Codigo);
            pst.setString(2, Nombre);
            pst.setString(3, Direccion);
            pst.setString(4, Telefono1);
            pst.setString(5, Telefono2);
            pst.setString(6, Correo);
            pst.setString(7, Horario);
            pst.executeUpdate();
            System.out.println("EEEEXITO");
        } catch (SQLException e) {
            System.err.println("Error al agregar Nueva Tienda: " + e);
        }
    }
}
