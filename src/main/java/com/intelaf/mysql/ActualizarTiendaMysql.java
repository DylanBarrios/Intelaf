package com.intelaf.mysql;

import com.intelaf.clases.Tienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class ActualizarTiendaMysql {

    public boolean ActualizarTiendaMysql(Tienda tienda) {
        boolean bandera = false;
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "UPDATE Tienda SET nombre = ?, Direccion = ?,Telefono1 = ?,Telefono2 = ?,Correo = ?,Horario = ? WHERE Codigo ='"+tienda.getCodigoTienda()+"'";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, tienda.getNombre());
            pst.setString(2, tienda.getDireccion());
            pst.setString(3, tienda.getTelefono1());
            pst.setString(4, tienda.getTelefono2());
            pst.setString(5, tienda.getCorreo());
            pst.setString(6, tienda.getHorario());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tienda actualizada correctamente");
            JOptionPane.showMessageDialog(null, "Recuerde actualizar la tabla");
            bandera = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
            System.err.println("Error al actualizar Tienda: " + e);
        }
        
        return bandera;
    }

}
