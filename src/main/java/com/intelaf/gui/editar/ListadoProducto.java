package com.intelaf.gui.editar;

import com.intelaf.clases.TenerProductoTienda;
import com.intelaf.gui.empleado.Menu;
import com.intelaf.mysql.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class ListadoProducto extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = null;
    TenerProductoTienda producto;

    public ListadoProducto() {
        initComponents();
        Titulos();
        Filtrar();
        ClickTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableTiendas = new javax.swing.JTable();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigoTienda = new javax.swing.JTextField();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableTiendas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableTiendas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 6, 640, 443));
        getContentPane().add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 100, 166, 35));

        jLabel2.setText("Codigo Producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, -1, -1));

        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 239, 106, 49));

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 6, -1, -1));

        jLabel3.setText("Codigo Tienda");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 153, -1, -1));
        getContentPane().add(txtCodigoTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 174, 164, 35));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Limpiar();
        Filtrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Limpiar();
        Filtrar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTiendas;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoTienda;
    // End of variables declaration//GEN-END:variables

    public void Filtrar() {
        Conexion conexion = new Conexion();
        String codigoProd = txtCodigoProducto.getText();
        String codigoTienda = txtCodigoTienda.getText();

        String sql = "SELECT * FROM Tener WHERE CodigoProducto LIKE '%" + codigoProd + "%' AND CodigoTienda LIKE '%" + codigoTienda + "%' ORDER BY CodigoProducto ASC";

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String id = rs.getString("CodigoTener");
                String CodProducto = rs.getString("CodigoProducto");
                String CodTienda = rs.getString("CodigoTienda");
                int Cantidad = rs.getInt("Cantidad");
                
                Object datos[] = {id,CodProducto,CodTienda,Cantidad};
                modelo.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar pedidos en actualizar " + e);
        }
    }

    private void Titulos() {
        String[] Titulos = {"id","Codigo Producto", "Codigo Tienda", "Cantidad"};
        modelo = new DefaultTableModel(null, Titulos);
        tableTiendas.setModel(modelo);
    }

    public void Limpiar() {
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }

    }

    public void ClickTabla() {
        tableTiendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int FilaClick = tableTiendas.rowAtPoint(e.getPoint());
                int ColumanClick = 0;

                if (FilaClick > -1) {
                    String idTener = (String) modelo.getValueAt(FilaClick, ColumanClick);
                    int id = Integer.parseInt(idTener);
                    DatosProducto(id);
                    EditarProductoTienda editar = new EditarProductoTienda(producto);
                    Menu.principal.add(editar);
                    editar.toFront();
                    editar.setVisible(true);
                }
            }

        });
    }

    public void DatosProducto(int id) {
        Conexion conexion = new Conexion();
        
        String sql = "SELECT * FROM Tener WHERE CodigoTener = '" + id + "'";
        System.out.println(sql);

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String CodProducto = rs.getString("CodigoProducto");
                String CodTienda = rs.getString("CodigoTienda");
                int Cantidad = rs.getInt("Cantidad");
                producto = new TenerProductoTienda(id, Cantidad, CodProducto, CodTienda);
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }
    }
}
