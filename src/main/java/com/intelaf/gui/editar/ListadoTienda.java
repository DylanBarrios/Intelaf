package com.intelaf.gui.editar;

import com.intelaf.clases.Tienda;
import com.intelaf.gui.empleado.Menu;
import com.intelaf.mysql.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dylan
 */
public class ListadoTienda extends javax.swing.JInternalFrame {

    DefaultTableModel modelo = null;
    Tienda tienda;

    public ListadoTienda() {
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
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 85, 166, 36));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 166, 166, 35));

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 58, -1, -1));

        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 139, -1, -1));

        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 229, 106, 49));

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 6, -1, -1));

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTiendas;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void Filtrar() {
        Conexion conexion = new Conexion();
        String nombre = txtNombre.getText();
        String codigo = txtCodigo.getText();

        String sql = "select * from Tienda WHERE Codigo LIKE '%" + codigo + "%' AND Nombre LIKE '%" + nombre + "%' ORDER BY Nombre ASC";
        System.out.println(sql);

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String CodigoTienda = rs.getString("Codigo");
                String Nombre = rs.getString("Nombre");
                String Direccion = rs.getString("Direccion");
                String Telefono1 = rs.getString("Telefono1");
                String Telefono2 = rs.getString("Telefono2");
                String Correo = rs.getString("Correo");
                String Horario = rs.getString("Horario");
                Object datos[] = {CodigoTienda, Nombre, Direccion, Telefono1, Horario};
                modelo.addRow(datos);
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }
    }

    private void Titulos() {
        String[] Titulos = {"Codigo", "Nombre", "Direccion", "Telefono", "Horario"};
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
                    String CodigoTienda = (String) modelo.getValueAt(FilaClick, ColumanClick);
                    DatosTienda(CodigoTienda);
                    EditarTienda editar = new EditarTienda(tienda);
                    Menu.principal.add(editar);
                    editar.toFront();
                    editar.setVisible(true);
                }
            }

        });
    }

    public void DatosTienda(String CodigoTienda) {
        Conexion conexion = new Conexion();
        String nombre = txtNombre.getText();
        String codigo = txtCodigo.getText();

        String sql = "select * from Tienda WHERE Codigo = '" + CodigoTienda + "'";
        System.out.println(sql);

        try (Connection connection = conexion.getConnection()) {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String Nombre = rs.getString("Nombre");
                String Direccion = rs.getString("Direccion");
                String Telefono1 = rs.getString("Telefono1");
                String Telefono2 = rs.getString("Telefono2");
                String Correo = rs.getString("Correo");
                String Horario = rs.getString("Horario");
                tienda = new Tienda(CodigoTienda, Nombre, Direccion, Telefono1, Telefono2, Correo, Horario);
            }
        } catch (SQLException e) {
            System.out.println("Erro al cargar pedidos en recibir " + e);
        }
    }
}
