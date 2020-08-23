package com.intelaf.mysql;

import com.intelaf.clases.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class NuevoVendedorMysql {

    public NuevoVendedorMysql(Vendedor vendedor) {
        if (VerificarVendedor(vendedor.getCodigo())) {
            JOptionPane.showMessageDialog(null, "El codigo ya existe");
        } else {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO Vendedor VALUES(?,?,?,?,?,?,?)";
            try (Connection connection = conexion.getConnection()) {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1, vendedor.getCodigo());
                pst.setString(2, vendedor.getNombre());
                pst.setString(3, vendedor.getTelefono());
                pst.setString(4, vendedor.getDPI());
                pst.setString(5, vendedor.getNIT());
                pst.setString(6, vendedor.getDireccion());
                pst.setString(7, vendedor.getCorreo());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error en la base de datos, contacte con el programador");
                System.out.println("Error al Crear Nuevo Producto: " + e);
            }
        }
    }

    public boolean VerificarVendedor(String Codigo) {
        Conexion conexion = new Conexion();
        String sql = "SELECT Codigo FROM Vendedor WHERE Codigo = '" + Codigo + "'";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Error al verificar Codigo en nuevo vendedor: " + e);
        }
        return false;
    }

}
