package com.intelaf.mysql;

import com.intelaf.clases.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class NuevoClienteMysql {
    
    public NuevoClienteMysql(Cliente cliente){
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "INSERT INTO Cliente VALUES(?,?,?,?,?,?,?)";
        
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, cliente.getNIT());
            pst.setString(2, cliente.getNombre());
            pst.setString(3, cliente.getTelefono());
            pst.setString(4, cliente.getDPI());
            pst.setString(5, cliente.getDireccion());
            pst.setString(6, cliente.getCorreo());
            pst.setDouble(7, cliente.getCreditoCompra());
            pst.executeUpdate();
            System.out.println("EEEEXITO");
        } catch (SQLException e) {
            System.err.println("Error al agregar Nueva Tienda: " + e);
        }
    }
}
