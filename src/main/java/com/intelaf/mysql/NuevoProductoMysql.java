package com.intelaf.mysql;

import com.intelaf.clases.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class NuevoProductoMysql {

    public NuevoProductoMysql(Producto producto) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "INSERT INTO Producto VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, producto.getCodigoProducto());
            pst.setString(2, producto.getFabricante());
            pst.setString(3, producto.getNombre());
            pst.setDouble(4, producto.getPrecio());
            pst.setString(5, producto.getDescripcion());
            pst.setInt(6, producto.getGarantia());
            pst.executeUpdate();
            System.out.println("Eeeexito");
        } catch (SQLException e) {System.out.println("Error al Crear Nuevo Producto: "+e);}
    }
}
