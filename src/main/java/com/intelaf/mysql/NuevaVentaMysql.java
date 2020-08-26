package com.intelaf.mysql;

import com.intelaf.clases.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class NuevaVentaMysql {

    public NuevaVentaMysql(Venta venta, String CodigoTienda) {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO Venta VALUES(?,?,?,?,?,?,?)";
        RestarCantidad(venta, CodigoTienda);
        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, venta.getCodigoVenta());
            pst.setString(2, venta.getCodigoProducto());
            pst.setString(3, venta.getCodigoVendedor());
            pst.setString(4, venta.getNIT());
            pst.setInt(5, venta.getCantidad());
            pst.setDouble(6, venta.getTotal());
            pst.setString(7, venta.getFechaRealizada());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al hacer Venta: " + e);
        }
    }

    public int ObtenerCantidad(Venta venta, String CodigoTienda) {
        int cantidad = 0;
        Conexion conexion = new Conexion();
        String sql = "SELECT Cantidad FROM Tener WHERE CodigoTienda = '" + CodigoTienda + "' AND CodigoProducto = '" + venta.getCodigoProducto() + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt("Cantidad");
                return cantidad;
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la catnidad en NUeva Venta: " + e);
        }
        return cantidad;
    }
    
    public void RestarCantidad(Venta venta, String CodigoTienda){
        Conexion conexion = new Conexion();
        int NuevaCantidad = ObtenerCantidad(venta, CodigoTienda) - venta.getCantidad();
        String sql = "UPDATE Tener SET Cantidad = "+NuevaCantidad+" WHERE CodigoTienda = '"+CodigoTienda+"' AND CodigoProducto = '"+venta.getCodigoProducto()+"'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al restar de la tabla Tener: " + e);
        }
    }
}
