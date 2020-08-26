package com.intelaf.gui.empleado;

import com.intelaf.gui.reportes.*;

/**
 *
 * @author dylan
 */
public class Menu extends javax.swing.JFrame {
    
    static String CodigoTienda;
    String CodigoUsuario;
    
    public Menu(String codigoTienda, String codigoUsuario) {
        this.CodigoTienda = codigoTienda;
        this.CodigoUsuario = codigoUsuario;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public Menu() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        principal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuProducto = new javax.swing.JMenuItem();
        MenuEmpleado = new javax.swing.JMenuItem();
        MenuTienda = new javax.swing.JMenuItem();
        MenuTiempo = new javax.swing.JMenuItem();
        MenuCliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem10.setText("jMenuItem10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1259, Short.MAX_VALUE)
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );

        jMenu1.setText("Nuevo");

        MenuProducto.setText("Nuevo Cliente");
        MenuProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuProductoActionPerformed(evt);
            }
        });
        jMenu1.add(MenuProducto);

        MenuEmpleado.setText("Nuevo Producto");
        MenuEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(MenuEmpleado);

        MenuTienda.setText("Nuevo Empleado");
        MenuTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTiendaActionPerformed(evt);
            }
        });
        jMenu1.add(MenuTienda);

        MenuTiempo.setText("Nueva Tienda");
        MenuTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuTiempoActionPerformed(evt);
            }
        });
        jMenu1.add(MenuTiempo);

        MenuCliente.setText("Tiempo Entre Tiendas");
        MenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClienteActionPerformed(evt);
            }
        });
        jMenu1.add(MenuCliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ventas");

        jMenuItem6.setText("Nueva Venta");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Recibir Pedido");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem3.setText("Entregar Pedido");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Listados");

        jMenuItem1.setText("Pedidos por llegar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem4.setText("Pedidos en tiempo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Pedidos retrasados");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem8.setText("Pedidos enviados");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Compras por cliente");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem11.setText("Pedidos por cliente");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        NuevaVenta venta = new NuevaVenta(CodigoUsuario,CodigoTienda);
        principal.add(venta);
        venta.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void MenuProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuProductoActionPerformed
        NuevoCliente cliente = new NuevoCliente();
        principal.add(cliente);
        cliente.setVisible(true);
    }//GEN-LAST:event_MenuProductoActionPerformed

    private void MenuEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEmpleadoActionPerformed
        NuevoProducto NuevoProducto = new NuevoProducto();
        AgregarProductoTienda producto = new AgregarProductoTienda(NuevoProducto, CodigoTienda);
        principal.removeAll();
        principal.repaint();
        principal.add(producto);
        producto.setVisible(true);
        principal.add(NuevoProducto);
        NuevoProducto.setVisible(false);
    }//GEN-LAST:event_MenuEmpleadoActionPerformed

    private void MenuTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTiendaActionPerformed
        NuevoVendedor vendedor = new NuevoVendedor();
        principal.add(vendedor);
        vendedor.setVisible(true);
    }//GEN-LAST:event_MenuTiendaActionPerformed

    private void MenuTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuTiempoActionPerformed
        NuevaTienda tienda = new NuevaTienda();
        principal.add(tienda);
        tienda.setVisible(true);
    }//GEN-LAST:event_MenuTiempoActionPerformed

    private void MenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClienteActionPerformed
        NuevoTiempo tiempo = new NuevoTiempo(CodigoTienda);
        principal.add(tiempo);
        tiempo.setVisible(true);
    }//GEN-LAST:event_MenuClienteActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        RecibirPedido recibir = new RecibirPedido(CodigoTienda);
        principal.add(recibir);
        recibir.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        EntregarPedido entregarPedido = new EntregarPedido(CodigoUsuario, CodigoTienda);
        principal.add(entregarPedido);
        entregarPedido.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        PedidosPorLlegar pedido = new PedidosPorLlegar(CodigoTienda);
        principal.add(pedido);
        pedido.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        PedidosEnTiempo enTiempo = new PedidosEnTiempo(CodigoTienda);
        principal.add(enTiempo);
        enTiempo.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        PedidosRetrasados retrasados = new PedidosRetrasados(CodigoTienda);
        principal.add(retrasados);
        retrasados.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        PedidosEnviados enviados = new PedidosEnviados(CodigoTienda);
        principal.add(enviados);
        enviados.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        ComprasPorCliente comprasCliente = new ComprasPorCliente();
        principal.add(comprasCliente);
        comprasCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        PedidosPorCliente PedidosCliente = new PedidosPorCliente();
        principal.add(PedidosCliente);
        PedidosCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCliente;
    private javax.swing.JMenuItem MenuEmpleado;
    private javax.swing.JMenuItem MenuProducto;
    private javax.swing.JMenuItem MenuTiempo;
    private javax.swing.JMenuItem MenuTienda;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public static javax.swing.JDesktopPane principal;
    // End of variables declaration//GEN-END:variables

    public String getCodigoTienda(){
        return CodigoTienda;
    }

    public void Mostrar(NuevoProducto NuevoProducto) {
        NuevoProducto.setVisible(true);
    }
}
