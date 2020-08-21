package com.mycompany.intelaf;

import com.intelaf.gui.empleado.Menu;
import pruebas.PruebaCargaDeDatos;
import com.intelaf.mysql.Conexion;

/**
 *
 * @author dylan
 */
public class Main {

    public static void main(String[] args) {
        Conexion conexion  = new Conexion();
        if(conexion.getConnection().equals("")){
            System.out.println("cagada");
        }else{
            System.out.println("nitido");
            Menu menu = new Menu();
            menu.setVisible(true);
        }

//        PruebaCargaDeDatos p = new PruebaCargaDeDatos();
//        p.setVisible(true);
    }
    
}
