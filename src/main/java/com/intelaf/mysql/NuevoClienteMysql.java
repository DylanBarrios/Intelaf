package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class NuevoClienteMysql {
    
    public NuevoClienteMysql(double CreditoCompra, String Nombre, String Telefono, String DPI, String NIT, String Direccion, String Correo){
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "INSERT INTO Cliente VALUES(?,?,?,?,?,?,?)";
        
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, NIT);
            pst.setString(2, Nombre);
            pst.setString(3, Telefono);
            pst.setString(4, DPI);
            pst.setString(5, Direccion);
            pst.setString(6, Correo);
            pst.setDouble(7, CreditoCompra);
            pst.executeUpdate();
            System.out.println("EEEEXITO");
        } catch (SQLException e) {
            System.err.println("Error al agregar Nueva Tienda: " + e);
        }
    }
}
