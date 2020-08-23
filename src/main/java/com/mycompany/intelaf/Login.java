package com.mycompany.intelaf;

import com.intelaf.gui.empleado.Menu;
import com.intelaf.mysql.VerificarUsuario;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        logo();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCliente = new javax.swing.JButton();
        btnEmpleado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCliente.setBackground(java.awt.Color.orange);
        btnCliente.setFont(new java.awt.Font("Nimbus Sans L", 1, 14)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnCliente.setText("CLIENTE");
        btnCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        getContentPane().add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 110, 50));

        btnEmpleado.setBackground(new java.awt.Color(0, 0, 0));
        btnEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleado.setText("EMPLEADO");
        btnEmpleado.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.orange, 3));
        btnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 120, 50));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 195, 39));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Soy:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, -1, -1));

        lblLogo.setBackground(new java.awt.Color(0, 0, 0));
        lblLogo.setForeground(new java.awt.Color(0, 0, 0));
        lblLogo.setOpaque(true);
        getContentPane().add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 230));

        Wallpaper.setBackground(new java.awt.Color(0, 0, 0));
        Wallpaper.setOpaque(true);
        getContentPane().add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoActionPerformed
        if (txtUsuario.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Porfavor escriba un usuario");
        else {
            String usuario = txtUsuario.getText();
            VerificarUsuario usuarioMysql = new VerificarUsuario();
            if(usuarioMysql.VerificarVendedor(usuario)){
            SeleccionTienda tienda = new SeleccionTienda(usuario);
            this.setVisible(false);
            tienda.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "El Usuario No Existe");
            }
        }
    }//GEN-LAST:event_btnEmpleadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void logo() {
        ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("linkie.png"));
        ImageIcon imagenFormato = new ImageIcon(imagen.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
        lblLogo.setIcon(imagenFormato);
    }
}
