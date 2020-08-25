package com.intelaf.mysql;

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
public class AgregarProductoTiendaMysql {

    public AgregarProductoTiendaMysql(TenerProductoTienda tener) {
        if (VerificarExistenciaProducto(tener.getCodigoTienda(), tener.getCodigoProducto())) {
            JOptionPane.showMessageDialog(null, "Ya cuenta con unidades de este producto en la tienda");
        } else {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO Tener VALUES(?,?,?,?)";

            try (Connection connection = conexion.getConnection()) {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setInt(1, 0);
                pst.setString(2, tener.getCodigoProducto());
                pst.setString(3, tener.getCodigoTienda());
                pst.setInt(4, tener.getCantidad());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Unidades agregadas exitosamente");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base da datos, contacte con el desarrollador");
                System.err.println("Error al agregar Nueva Tienda: " + e);
            }
        }
    }

    public boolean VerificarExistenciaProducto(String CodigoTienda, String CodigoProducto) {
        Conexion conexion = new Conexion();
        String sql = " SELECT CodigoTienda FROM Tener WHERE CodigoTienda = '" + CodigoTienda + "' AND CodigoProducto = '" + CodigoProducto + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar duplicidad al agregar unidades " + e);
        }
        return false;
    }

}
