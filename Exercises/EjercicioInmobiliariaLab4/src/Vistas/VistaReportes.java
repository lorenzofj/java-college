
package Vistas;

import Dto.DtoTransacciones;
import GestorBD.GestorBD;
import java.util.ArrayList;

public class VistaReportes extends javax.swing.JFrame {
    
    GestorBD g;

    public VistaReportes() {
        initComponents();
        this.g = new GestorBD();
        lblTransaccionMontoMasAlto.setText(g.obtenerTransaccionVentaMayorValor().toString());
        lblPorcentajeTipoAlquiler.setText("Porcentaje de transacciones de tipo Alquiler: " + g.porcentajeTransaccionesTipoAlquiler());
        ArrayList<DtoTransacciones> lista = g.obtenerTransaccionesTipoOficina();
        lstTransaccionesTipoOficina.setListData(lista.toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPorcentajeTipoAlquiler = new javax.swing.JLabel();
        lblTransaccionMontoMasAlto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTransaccionesTipoOficina = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Reportes");

        jLabel2.setText("Transaccion de tipo Venta con el monto más alto:");

        lblPorcentajeTipoAlquiler.setText("Porcentaje de transacciones de tipo Alquiler:");

        jLabel3.setText("Transacciones cuyo tipo de inmmueble sea Oficina: ");

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstTransaccionesTipoOficina);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblPorcentajeTipoAlquiler)
                            .addComponent(lblTransaccionMontoMasAlto)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnCerrar))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lblTransaccionMontoMasAlto)
                .addGap(18, 18, 18)
                .addComponent(lblPorcentajeTipoAlquiler)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPorcentajeTipoAlquiler;
    private javax.swing.JLabel lblTransaccionMontoMasAlto;
    private javax.swing.JList lstTransaccionesTipoOficina;
    // End of variables declaration//GEN-END:variables
}
