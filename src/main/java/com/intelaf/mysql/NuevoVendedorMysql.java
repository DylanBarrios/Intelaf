package com.intelaf.mysql;

import com.intelaf.clases.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class NuevoVendedorMysql {
     public NuevoVendedorMysql(Vendedor vendedor) {
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "INSERT INTO Vendedor VALUES(?,?,?,?,?,?,?)";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, vendedor.getCodigo());
            pst.setString(2, vendedor.getNombre());
            pst.setString(3, vendedor.getTelefono());
            pst.setString(4, vendedor.getDPI());
            pst.setString(5, vendedor.getNIT());
            pst.setString(6, vendedor.getDireccion());
            pst.setString(7, vendedor.getCorreo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException e) {System.out.println("Error al Crear Nuevo Producto: "+e);}
    }
}
