package com.intelaf.mysql;

import com.intelaf.clases.Cliente;
import com.intelaf.clases.TenerProductoTienda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class ActualizarTenerMysql {

    public boolean ActualizarTenerMysql(TenerProductoTienda producto) {
        boolean bandera = false;
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "UPDATE Tener SET CodigoProducto = ?, CodigoTienda = ?,Cantidad = ? WHERE CodigoTener ='" + producto.getIdTener() + "'";

        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, producto.getCodigoProducto());
            pst.setString(2, producto.getCodigoTienda());
            pst.setInt(3, producto.getCantidad());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
            JOptionPane.showMessageDialog(null, "Recuerde actualizar la tabla");
            bandera = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
            System.err.println("Error al actualizar Cliente: " + e);
        }

        return bandera;
    }

}
