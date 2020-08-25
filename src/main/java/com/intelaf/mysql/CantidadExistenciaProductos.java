package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dylan
 */
public class CantidadExistenciaProductos {
    
    public int CantidadExistenciaProductos(String CodigoProducto, String CodigoTienda){
        int CantidadExistencia = 0;
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT Cantidad FROM Tener WHERE CodigoProducto = '"+CodigoProducto+"' AND CodigoTienda = '"+CodigoTienda+"'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                CantidadExistencia = rs.getInt("Cantidad");
                return CantidadExistencia;
            }
        } catch (SQLException e) {System.out.println("Error al obtener cantidad de productos "+e);
        }
        
        return CantidadExistencia;
    }        
}
