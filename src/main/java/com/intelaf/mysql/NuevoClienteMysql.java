package com.intelaf.mysql;

import com.intelaf.clases.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class NuevoClienteMysql {

    public NuevoClienteMysql(Cliente cliente) {
        Conexion conexion = new Conexion();
        String sql = "INSERT INTO Cliente VALUES(?,?,?,?,?,?,?)";
        if (VerificarCliente(cliente.getNIT())) {
            JOptionPane.showMessageDialog(null, "El cliente ya esta registrado");
        } else {
            try (Connection connection = conexion.getConnection()) {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, cliente.getNIT());
                pst.setString(2, cliente.getNombre());
                pst.setString(3, cliente.getTelefono());
                pst.setString(4, cliente.getDPI());
                pst.setString(5, cliente.getDireccion());
                pst.setString(6, cliente.getCorreo());
                pst.setDouble(7, cliente.getCreditoCompra());

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente registrado con exito");
            } catch (SQLException e) {
                System.err.println("Error al agregar Nueva Tienda: " + e);
                JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
            }
        }
    }

    public boolean VerificarCliente(String NIT) {
        Conexion conexion = new Conexion();
        String sql = "SELECT NIT FROM Cliente WHERE NIT = '" + NIT + "'";

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
