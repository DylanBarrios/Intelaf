package com.intelaf.mysql;

import com.intelaf.clases.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class NuevaTiendaMysql {

    public NuevaTiendaMysql(Tienda tienda) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "INSERT INTO Tienda VALUES(?,?,?,?,?,?,?)";
        
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, tienda.getCodigoTienda());
            pst.setString(2, tienda.getNombre());
            pst.setString(3, tienda.getDireccion());
            pst.setString(4, tienda.getTelefono1());
            pst.setString(5, tienda.getTelefono2());
            pst.setString(6, tienda.getCorreo());
            pst.setString(7, tienda.getHorario());
            pst.executeUpdate();
            System.out.println("EEEEXITO");
        } catch (SQLException e) {
            System.err.println("Error al agregar Nueva Tienda: " + e);
        }
    }
}
