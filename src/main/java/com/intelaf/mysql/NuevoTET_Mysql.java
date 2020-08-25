package com.intelaf.mysql;

import com.intelaf.clases.Cliente;
import com.intelaf.clases.TiempoEntreTiendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class NuevoTET_Mysql {

    public NuevoTET_Mysql(TiempoEntreTiendas tet) {
        if (VerificarCliente(tet.getCodTiendaOrigen(), tet.getCodTiendaDestino())) {
            JOptionPane.showMessageDialog(null, "Ya existe un tiempo entre esas tiendas");
        } else {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO TET VALUES(?,?,?,?)";

            try (Connection connection = conexion.getConnection()) {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setInt(1, 0);
                pst.setString(2, tet.getCodTiendaOrigen());
                pst.setString(3, tet.getCodTiendaDestino());
                pst.setInt(4, tet.getTiempoET());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la base de datos, contacte con el programador");
                System.err.println("Error al agregar Nueva Tienda: " + e);
            }
        }
    }

    public boolean VerificarCliente(String Origen, String Destino) {
        Conexion conexion = new Conexion();
        String sql = "SELECT CodTiendaOrigen FROM TET WHERE CodTiendaDestino = '" + Destino + "' AND CodTiendaOrigen ='" + Origen + "'";

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
