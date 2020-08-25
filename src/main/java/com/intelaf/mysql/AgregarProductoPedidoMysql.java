package com.intelaf.mysql;

import com.intelaf.clases.PertenecerProductoPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class AgregarProductoPedidoMysql {

    public AgregarProductoPedidoMysql(PertenecerProductoPedido pertenecer) {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO Pertenecer VALUES(?,?,?,?,?)";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, 0);
            pst.setString(2, pertenecer.getCodigoProducto());
            pst.setString(3, pertenecer.getCodigoPedido());
            pst.setDouble(4, pertenecer.getSubTotal());
            pst.setDouble(5, pertenecer.getCantidadProductos());
            pst.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base da datos, contacte con el desarrollador");
            System.err.println("Error al agregar Nueva Tienda: " + e);
        }
    }

}
