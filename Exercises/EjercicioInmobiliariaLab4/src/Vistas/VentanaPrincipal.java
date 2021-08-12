package Vistas;

import Dto.DtoTransacciones;
import GestorBD.GestorBD;
import Modelo.TipoInmueble;
import Modelo.TipoOperacion;
import Modelo.Transaccion;
import Modelo.Vendedor;
import java.util.ArrayList;

public class VentanaPrincipal extends javax.swing.JFrame {

    GestorBD g;

    public VentanaPrincipal() {
        initComponents();
        this.g = new GestorBD();
        cargarCombos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboTipoOperacion = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cboTipoInmueble = new javax.swing.JComboBox();
        cboVendedores = new javax.swing.JComboBox();
        btnGuardarTransaccion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTransacciones = new javax.swing.JList();
        btnResultados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Inmobiliaria");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Insertar una nueva transaccion:");

        jLabel3.setText("Fecha:");

        jLabel4.setText("Vendedor:");

        jLabel5.setText("Tipo de operacion:");

        jLabel6.setText("Tipo de inmueble:");

        btnGuardarTransaccion.setText("Guardar");
        btnGuardarTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTransaccionActionPerformed(evt);
            }
        });

        jLabel7.setText("Monto:");

        jScrollPane1.setViewportView(lstTransacciones);

        btnResultados.setText("Resultados");
        btnResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResultadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGap(56, 56, 56)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboVendedores, 0, 145, Short.MAX_VALUE)
                                        .addComponent(txtFecha)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cboTipoOperacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboTipoInmueble, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 50, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardarTransaccion)
                                .addGap(18, 18, 18)
                                .addComponent(btnResultados)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboTipoOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboTipoInmueble, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarTransaccion)
                    .addComponent(btnResultados))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTransaccionActionPerformed
        try {
            String fecha = txtFecha.getText();
            int idVendedor = cboVendedores.getSelectedIndex()+1;
            int idTipoOperacion = cboTipoOperacion.getSelectedIndex()+1;
            int idTipoInmueble = cboTipoInmueble.getSelectedIndex()+1;
            float monto = Float.parseFloat(txtMonto.getText());

            Transaccion transaccion = new Transaccion(fecha, idVendedor, idTipoOperacion, idTipoInmueble, monto);
            g.insertarTransaccion(transaccion);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        
        ArrayList<DtoTransacciones> listaDto = g.obtenerTodasLasTransacciones();
        lstTransacciones.setListData(listaDto.toArray());
    }//GEN-LAST:event_btnGuardarTransaccionActionPerformed

    private void btnResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResultadosActionPerformed
        VistaReportes vistaReportes = new VistaReportes();
        vistaReportes.setVisible(true);
    }//GEN-LAST:event_btnResultadosActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarTransaccion;
    private javax.swing.JButton btnResultados;
    private javax.swing.JComboBox cboTipoInmueble;
    private javax.swing.JComboBox cboTipoOperacion;
    private javax.swing.JComboBox cboVendedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstTransacciones;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

    private void cargarCombos() {
        ArrayList<Vendedor> listaVendedor = g.obtenerTodosLosVendedores();

        for (Vendedor vendedor : listaVendedor) {
            cboVendedores.addItem(vendedor);
        }

        ArrayList<TipoInmueble> listaInmueble = g.obtenerTodosLosTiposInmuebles();

        for (TipoInmueble tipoInmueble : listaInmueble) {
            cboTipoInmueble.addItem(tipoInmueble);
        }

        ArrayList<TipoOperacion> listaOperacion = g.obtenerTodosLosTiposOperacion();

        for (TipoOperacion tipoOperacion : listaOperacion) {
            cboTipoOperacion.addItem(tipoOperacion);
        }
    }
}
