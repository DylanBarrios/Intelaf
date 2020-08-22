package com.intelaf.mysql;

import com.intelaf.clases.TenerProductoTienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class AgregarProductoTiendaMysql {

    public AgregarProductoTiendaMysql(TenerProductoTienda tener) {
     Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "INSERT INTO Tener VALUES(?,?,?,?)";
        
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, 0);
            pst.setString(2, tener.getCodigoProducto());
            pst.setString(3, tener.getCodigoTienda());
            pst.setInt(4, tener.getCantidad());
            pst.executeUpdate();
            System.out.println("EEEEXITO");
        } catch (SQLException e) {
            System.err.println("Error al agregar Nueva Tienda: " + e);
        }
    }
    
}
