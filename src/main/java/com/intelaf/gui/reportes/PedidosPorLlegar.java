package com.intelaf.gui.reportes;

import com.intelaf.mysql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class PedidosPorLlegar extends javax.swing.JInternalFrame {

    String CodigoTienda;
    DefaultTableModel modelo = null;
        
    
    public PedidosPorLlegar(String CodigoTienda) {
        this.CodigoTienda = CodigoTienda;
        initComponents();
        Titulos();
        agregarATabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();

        setClosable(true);

        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablePedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePedidos;
    // End of variables declaration//GEN-END:variables

    private void agregarATabla() {
        Conexion conexion = new Conexion();

        try (Connection connection = conexion.getConnection()) {
            String sql = "SELECT CodigoTET FROM TET WHERE CodTiendaDestino = '" + CodigoTienda + "'";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int CodigoTET = rs.getInt("CodigoTET");
                AgregarPedidos(CodigoTET);
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }      
        

    }

    private void AgregarPedidos(int CodigoTET) {
        Conexion conexion = new Conexion();
        String sql = "SELECT * from Pedido WHERE Recibido = 0 AND CodigoTET = "+CodigoTET;

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String CodPedido = rs.getString("CodigoPedido");
                String FechaSalida = rs.getString("FechaSalida");
                int NIT = rs.getInt("NIT");
                Object datos[] = {CodPedido, FechaSalida, NIT};
                modelo.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }
    }
    
     private void Titulos() {
        String[] Titulos = {"Codigo Pedido", "Fecha Salida", "NIT"};
        modelo = new DefaultTableModel(null, Titulos);
        tablePedidos.setModel(modelo);
    }


}
