package com.intelaf.mysql;

import com.intelaf.clases.PertenecerProductoPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class AgregarProductoPedidoMysql {

    public AgregarProductoPedidoMysql(PertenecerProductoPedido pertenecer, String CodigoTienda  ) {
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
            RestarCantidad(pertenecer, CodigoTienda);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base da datos, contacte con el desarrollador");
            System.err.println("Error al agregar Nueva Tienda: " + e);
        }
    }
    
    public int ObtenerCantidad(PertenecerProductoPedido pertenecer, String CodigoTienda) {
        int cantidad = 0;
        Conexion conexion = new Conexion();
        String sql = "SELECT Cantidad FROM Tener WHERE CodigoTienda = '" + CodigoTienda + "' AND CodigoProducto = '" + pertenecer.getCodigoProducto() + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("Cantidad");
                return cantidad;
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la catnidad en pedido: " + e);
        }
        return cantidad;
    }
    
    public void RestarCantidad(PertenecerProductoPedido pertenecer, String CodigoTienda){
        Conexion conexion = new Conexion();
        int NuevaCantidad = ObtenerCantidad(pertenecer, CodigoTienda) - pertenecer.getCantidadProductos();
        String sql = "UPDATE Tener SET Cantidad = "+NuevaCantidad+" WHERE CodigoTienda = '"+CodigoTienda+"' AND CodigoProducto = '"+pertenecer.getCodigoProducto()+"'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al restar de la tabla Tener al hacer pedido: " + e);
        }
    }

}
