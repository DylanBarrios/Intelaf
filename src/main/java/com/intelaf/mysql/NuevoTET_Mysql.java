package com.intelaf.mysql;

import com.intelaf.clases.Cliente;
import com.intelaf.clases.TiempoEntreTiendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class NuevoTET_Mysql {

     public NuevoTET_Mysql(TiempoEntreTiendas tet){
        Conexion conexion = new Conexion();
        Connection connection = conexion.getConnection();
        String sql = "INSERT INTO TET VALUES(?,?,?,?)";
        
        try (PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, 0);
            pst.setString(2, tet.getCodTiendaOrigen());
            pst.setString(3, tet.getCodTiendaDestino());
            pst.setInt(4, tet.getTiempoET());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException e) {
            System.err.println("Error al agregar Nueva Tienda: " + e);
        }
    }
}
