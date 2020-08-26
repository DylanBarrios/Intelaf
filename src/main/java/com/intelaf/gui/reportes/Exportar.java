package com.intelaf.gui.reportes;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class Exportar {

    public void generar(DefaultTableModel modelo, String nombre) throws IOException {
        FileWriter fichero = new FileWriter("/home/dylan/Escritorio/Progra 2/Proyectos/1/Intelaf/"+nombre+".html");
        fichero.write("<!DOCTYPE HTML5>");
        fichero.write(" <html>");
        fichero.write("<head>");
        fichero.write("<title>Ejercicios prácticos HTML5</title>");
        fichero.write("<meta charset='utf-8'>");
        fichero.write("<meta name='author' content=''>");
        fichero.write("<meta name='description' content='Ejercicios prácticos HTML5'>");
        fichero.write("<meta name='keywords' content='Ejercicios, Soluciones, Prácticas, HTML5'>");
        fichero.write("</head>");
        fichero.write("<body>");
        fichero.write("<table border='1' align='center'>");
        fichero.write("<caption>REPORTE DE "+nombre+"</caption>");
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            fichero.write("<tr>");
            int columnas = modelo.getColumnCount();
            for (int j = 0; j < columnas; j++) {
                fichero.write("<th>" + modelo.getValueAt(i, j) + "</th>");
            }
            fichero.write("</tr>");
        }
        fichero.write("</table>");
        fichero.write("</body>");
        fichero.write("</html>");
        fichero.close();
    }
}
