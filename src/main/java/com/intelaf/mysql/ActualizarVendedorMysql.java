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
public class ActualizarVendedorMysql {

    public boolean ActualizarVendedorMysql(Vendedor vendedor) {
        boolean bandera = false;
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "UPDATE Vendedor SET Nombre = ?, Telefono = ?, DPI = ?, NIT = ?, Direccion = ?, Correo = ? WHERE Codigo ='"+vendedor.getCodigo()+"'";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, vendedor.getNombre());
            pst.setString(2, vendedor.getTelefono());
            pst.setString(3, vendedor.getDPI());
            pst.setString(4, vendedor.getNIT());
            pst.setString(5, vendedor.getDireccion());
            pst.setString(6, vendedor.getTelefono());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Vendedor actualizado correctamente");
            JOptionPane.showMessageDialog(null, "Recuerde actualizar la tabla");
            bandera = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
            System.err.println("Error al actualizar vendedor: " + e);
        }
        
        return bandera;
    }

}
