
package Vistas;

import Dto.DtoPerrosDueños;
import Dto.DtoPromedioEdades;
import GestorBD.GestorBD;
import java.util.ArrayList;

public class VentanaReportes extends javax.swing.JFrame {
    
    GestorBD g;

    public VentanaReportes() {
        initComponents();
        g = new GestorBD();
        ArrayList<DtoPerrosDueños> dtoPerrosDueños = g.obtenerPerrosDueños();
        lstListadoPerros.setListData(dtoPerrosDueños.toArray());
        
       /* int cantidadMascotas = 0;
        float promedioEdades = 0;
        
        ArrayList<DtoPromedioEdades> listaEdades = g.promedioEdadesMascotas();
        for (DtoPromedioEdades listaEdade : listaEdades) {
            cantidadMascotas += listaEdade.cantidadMascotas;
            promedioEdades += listaEdade.promedioEdad;
        }
        
        lblPromedioEdad.setText("" + promedioEdades / cantidadMascotas);*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstListadoPerros = new javax.swing.JList();
        lblPromedioEdad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Listado de perros:");

        jScrollPane1.setViewportView(lstListadoPerros);

        lblPromedioEdad.setText("Promedio de edad de las mascotas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblPromedioEdad))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPromedioEdad)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPromedioEdad;
    private javax.swing.JList lstListadoPerros;
    // End of variables declaration//GEN-END:variables
}
