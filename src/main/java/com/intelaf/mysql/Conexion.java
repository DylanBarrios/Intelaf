package com.intelaf.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author dylan
 */
public class Conexion {

    Connection connection = null;

    public Conexion() {
        String url = "jdbc:mysql://localhost:3306/Intelaf";
        String user = "root";
        String password = "00";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            this.connection = con;
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
        if (connection == null) {
            System.out.println("Desconectado");
        }
    }
}
