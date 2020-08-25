package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dylan
 */
public class ExtraerTiempoET {

    private int CodigoTET =0; 
    
    public int ExtraerTiempoET(String Origen, String Destino) {
        int TiempoET = 0;
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "Select TiempoET,CodigoTET FROM TET WHERE CodTiendaOrigen = '" + Origen + "' AND CodTiendaDestino = '" + Destino + "'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                TiempoET = rs.getInt("TiempoET");
                CodigoTET = rs.getInt("CodigoTET");
                return TiempoET;
            }else{
                JOptionPane.showMessageDialog(null, "No existe tiempo entre estas dos tiendas");
            }
        } catch (SQLException e) {
            System.out.println("Error al extraer TET " + e);
        }
        return TiempoET;
    }

    public int getCodigoTET() {
        return CodigoTET;
    }

    

}
