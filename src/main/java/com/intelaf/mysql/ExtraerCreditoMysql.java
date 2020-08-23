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
public class ExtraerCreditoMysql {
    
    Double credito = 0.0;
    
    public boolean VerificarNIT(String NIT){
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = " SELECT Credito from Cliente Where NIT = '"+NIT+"'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                credito = rs.getDouble("Credito");
                return true;
            }
        } catch (SQLException e) {System.out.println("Error al obtener cantidad de credito "+e);
        }
        
        return false;
    }

    public Double getCredito() {
        return credito;
    }
    
    
}
