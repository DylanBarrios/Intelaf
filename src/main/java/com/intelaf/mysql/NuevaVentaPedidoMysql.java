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
public class NuevaVentaPedidoMysql {

    public NuevaVentaPedidoMysql(Venta venta) {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO Venta VALUES(?,?,?,?,?,?,?)";
        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, venta.getCodigoVenta());
            System.out.println("CodVenta "+venta.getCodigoVenta());
            pst.setString(2, venta.getCodigoProducto());
            System.out.println("CodProd "+venta.getCodigoProducto());
            pst.setString(3, venta.getCodigoVendedor());
            System.out.println("CodVende "+venta.getCodigoVendedor());
            pst.setString(4, venta.getNIT());
            System.out.println("NIT "+venta.getNIT());
            pst.setInt(5, venta.getCantidad());
            System.out.println("CANTIDAD "+venta.getCantidad());
            pst.setDouble(6, venta.getTotal());
            System.out.println("Total "+venta.getTotal());
            pst.setString(7, venta.getFechaRealizada());
            System.out.println("Fecha "+venta.getFechaRealizada());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al hacer Venta: " + e);
        }
    }
    
}
