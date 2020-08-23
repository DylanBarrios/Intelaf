package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class VerificarUsuario {
 
    public boolean VerificarNIT(String NIT){
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT NIT from Cliente Where NIT = '"+NIT+"'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {System.out.println("Error al verificar NIT "+e);
        }        
        return false;
    }    

    public boolean VerificarVendedor(String CodigoVendedor){
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT Nombre FROM Vendedor WHERE Codigo = '"+CodigoVendedor+"'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {System.out.println("Error al verificar NIT "+e);
        }        
        return false;
    }
}