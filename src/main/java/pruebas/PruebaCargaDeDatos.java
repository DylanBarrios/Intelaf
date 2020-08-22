package pruebas;

import com.intelaf.clases.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author dylan
 */
public class PruebaCargaDeDatos extends javax.swing.JFrame {

    /**
     * Creates new form PruebaCargaDeDatos
     */
    public PruebaCargaDeDatos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Cargar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 191, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        JFileChooser jf = new JFileChooser();
//        jf.showOpenDialog(this);
//        File archivo = jf.getSelectedFile();
//
//        String fichero = archivo.getAbsolutePath();
//        jTextField1.setText(fichero);
//        ArrayList al = new ArrayList();
//
//        try {
//            FileReader fr = new FileReader(fichero);
//            BufferedReader br = new BufferedReader(fr);
//
//            String linea;
//            while ((linea = br.readLine()) != null) {
//                al.add(linea);
//                txtArea.setText(txtArea.getText() + "\n" + linea);
//            }
//            fr.close();
//        } catch (Exception e) {
//            System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
//        }
//        System.out.println("Inica el for");
//        for (int i = 0; i < al.size(); i++) {
//            String linea = String.valueOf(al.get(i));
//            String[] palabras = linea.split(",");
//            switch (palabras[0]) {
//                case "TIENDA":
//                    String NombreT = palabras[1];
//                    String DireccionT = palabras[2];
//                    String CodTienda = palabras[1];
//                    int Telefono1 = Integer.parseInt(palabras[3]);
//                    int Telefono2 = 0;
//                    String CorreoT = null;
//                    String Horario = null;
//                    Tienda tienda = new Tienda(CodTienda, Telefono1, Telefono2, NombreT, DireccionT, CorreoT, Horario);
//                    break;
//                case "TIEMPO":
//                    String TiendaOrigen = palabras[1];
//                    String TiendaDestino = palabras[2];
//                    int TiempoET = Integer.parseInt(palabras[3]);
//                    TiempoEnTienda tet = new TiempoEnTienda(0, TiempoET, TiendaOrigen, TiendaDestino);
//                    break;
//                case "PRODUCTO":
//                    String NombreP = palabras[1];
//                    String FabricanteP = palabras[2];
//                    String CodProducto = palabras[3];
//                    int CantidadP = Integer.parseInt(palabras[4]);
//                    Double PrecioP = Double.parseDouble(palabras[5]);
//                    String CodTiendaP = palabras[6];
//                    String DescripcionP = null;
//                    int Garantia = 0;
//                    Producto producto = new Producto(CodTiendaP, CodProducto, CantidadP, NombreP, FabricanteP, DescripcionP, PrecioP, Garantia);
//                    break;
//                case "CLIENTE":
//                    String NombreC = palabras[1];
//                    int NIT = Integer.parseInt(palabras[2]);
//                    int TelefonoC = Integer.parseInt(palabras[3]);
//                    double CreditoCompra = Double.parseDouble(palabras[4]);
//                    int DPIc = 0;
//                    String DireccionC = null;
//                    String CorreoC = null;
//                    Cliente cliente = new Cliente(DPIc, TelefonoC, NombreC, DireccionC, CorreoC, NIT, CreditoCompra);
//                    break;
//                case "EMPLEADO":
//                    String NombreE = palabras[1];
//                    int CodEmpleado = Integer.parseInt(palabras[2]);
//                    int TelefonoE = Integer.parseInt(palabras[3]);
//                    int DPIe = Integer.parseInt(palabras[4]);
//                    String DireccionE = null;
//                    String CorreoE = null;
//                    Vendedor vendedor = new Vendedor(CodEmpleado, DPIe, TelefonoE, NombreE, DireccionE, CorreoE);
//                    break;
//                case "PEDIDO":
//                    int CodigoPedido = Integer.parseInt(palabras[1]);
//                    String TiendaOrigenP = palabras[2];
//                    String TiendaDestinoP = palabras[3];                    
//                    int CodigoTET = CodigoTET(TiendaOrigenP, TiendaDestinoP);
//                    String FechaSalida = palabras[4];
//                    int CodigoCliente = Integer.parseInt(palabras[5]);
//                    int CodigoProducto = Integer.parseInt(palabras[6]);
//                    int CantidadPP = Integer.parseInt(palabras[7]);
//                    double Total = Double.parseDouble(palabras[8]);
//                    double Anticipo = Double.parseDouble(palabras[9]);
//                    boolean Entregado = false;
//                    Pedido pedido = new Pedido(CodigoPedido, CodigoProducto, CodigoCliente, CodigoTET, Anticipo, CantidadPP, Total, FechaSalida, Entregado);
//                    break;
////            }
//            System.out.println("");
//        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables

    public int CodigoTET(String TiendaOrigen, String TiendaDestino){
        int CodigoTET = 0;
        //CONECTAR
        String sql = "SELECT CodigoTET FROM T.E.T. WHERE (TiendaOrigen = '"+TiendaOrigen+"' OR TiendaOrigen = '"+TiendaDestino+"') AND "
                    + "(TiendaDestino = '"+TiendaDestino+"' OR TiendaDestino = '"+TiendaOrigen+"')";
        
        return CodigoTET;
    }
    
}
