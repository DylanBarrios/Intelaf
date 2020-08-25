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
public class NuevaTiendaMysql {

    public NuevaTiendaMysql(Tienda tienda) {
        if (VerificarCliente(tienda.getCodigoTienda())) {
            JOptionPane.showMessageDialog(null, "El codigo ya esta registrado");
        } else {
            Conexion conexion = new Conexion();
            Connection connection = conexion.getConnection();
            String sql = "INSERT INTO Tienda VALUES(?,?,?,?,?,?,?)";

            try (PreparedStatement pst = connection.prepareStatement(sql)) {
                pst.setString(1, tienda.getCodigoTienda());
                pst.setString(2, tienda.getNombre());
                pst.setString(3, tienda.getDireccion());
                pst.setString(4, tienda.getTelefono1());
                pst.setString(5, tienda.getTelefono2());
                pst.setString(6, tienda.getCorreo());
                pst.setString(7, tienda.getHorario());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Tienda agregada exitosamente");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
                System.err.println("Error al agregar Nueva Tienda: " + e);
            }
        }
    }

    public boolean VerificarCliente(String Codigo) {
        Conexion conexion = new Conexion();
        String sql = "SELECT Codigo FROM Tienda WHERE Codigo = '" + Codigo + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar NIT en nuevo cliente: " + e);
        }
        return false;
    }
}
