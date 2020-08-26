package com.intelaf.mysql;

import com.intelaf.clases.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class ActualizarClienteMysql {

    public boolean ActualizarClienteMysql(Cliente cliente) {
        boolean bandera = false;
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "UPDATE Cliente SET Nombre = ?, Telefono = ?, DPI = ?,Direccion = ?, Correo = ?, Credito = ? WHERE NIT ='"+cliente.getNIT()+"'";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getTelefono());
            pst.setString(3, cliente.getDPI());
            pst.setString(4, cliente.getDireccion());
            pst.setString(5, cliente.getCorreo());
            pst.setDouble(6, cliente.getCreditoCompra());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
            JOptionPane.showMessageDialog(null, "Recuerde actualizar la tabla");
            bandera = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
            System.err.println("Error al actualizar Cliente: " + e);
        }
        
        return bandera;
    }

}
