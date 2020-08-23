package com.intelaf.mysql;

import com.intelaf.clases.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class NuevaVentaMysql {
   
    public NuevaVentaMysql(Venta venta){
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "INSERT INTO Venta VALUES(?,?,?,?,?,?,?,?,?)";
        
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, venta.getCodigoVenta());
            pst.setString(2, venta.getCodigoProducto());
            pst.setString(3, venta.getCodigoVendedor());
            pst.setString(4, venta.getNIT());
            pst.setInt(5, venta.getCantidad());
            pst.setDouble(6, venta.getTotal());
            pst.setDouble(7, venta.getPagoCredito());
            pst.setDouble(8, venta.getPagoEfectivo());
            pst.setString(9, venta.getFechaRealizada());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException e) {
            System.err.println("Error al hacer Venta: " + e);
        }
    }
}
