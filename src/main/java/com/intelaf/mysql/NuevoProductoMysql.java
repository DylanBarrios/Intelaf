package com.intelaf.mysql;

import com.intelaf.clases.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class NuevoProductoMysql {

    public NuevoProductoMysql(Producto producto) {
        if (VerificarProducto(producto.getCodigoProducto())) {
            JOptionPane.showMessageDialog(null, "El codigo de producto ya existe");
        } else {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO Producto VALUES(?,?,?,?,?,?)";

            try (Connection connection = conexion.getConnection()) {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, producto.getCodigoProducto());
                pst.setString(2, producto.getFabricante());
                pst.setString(3, producto.getNombre());
                pst.setDouble(4, producto.getPrecio());
                pst.setString(5, producto.getDescripcion());
                pst.setInt(6, producto.getGarantia());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Nuevo Producto Registrado, \n ahora puede agregar unidades a la tienda");
            } catch (SQLException e) {
                System.out.println("Error al Crear Nuevo Producto: " + e);
            }
        }
    }

    private boolean VerificarProducto(String Codigo) {
        Conexion conexion = new Conexion();
        String sql = "SELECT Codigo FROM Producto WHERE Codigo = '" + Codigo + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar Codigo en nuevo producto: " + e);
        }
        return false;
    }
}
