package Vistas;
import Dto.DtoLibrosOrigenNacional;
import Dto.DtoListadoLibros;
import Gestor.GestorBD;
import java.util.ArrayList;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    GestorBD g;

    public VentanaPrincipal() {
        initComponents();
        
        this.g = new GestorBD();
        lblCantLibrosRegistrados.setText("Cantidad de libros registrados: " + g.cantidadLibrosRegistrados());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblCantLibrosRegistrados = new javax.swing.JLabel();
        btnNuevoLibro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnMostrarLibros = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstListaAutoresNacionales = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstListadoLibros = new javax.swing.JList();
        btnListadoLibros = new javax.swing.JButton();
        btnBuscarAutor = new javax.swing.JButton();
        btnModificarLibro = new javax.swing.JButton();
        lblPorcentajeLibros = new javax.swing.JLabel();
        btnPorcentajeSoloLectura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Biblioteca");

        lblCantLibrosRegistrados.setText("Cantidad de libros registrados:");

        btnNuevoLibro.setText("Nuevo libro");
        btnNuevoLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoLibroActionPerformed(evt);
            }
        });

        jLabel2.setText("Libros de autores de origen nacional:");

        btnMostrarLibros.setText("Mostrar");
        btnMostrarLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarLibrosActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstListaAutoresNacionales);

        jLabel3.setText("Listado de libros:");

        jScrollPane2.setViewportView(lstListadoLibros);

        btnListadoLibros.setText("Mostrar");
        btnListadoLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoLibrosActionPerformed(evt);
            }
        });

        btnBuscarAutor.setText("Buscar autor");
        btnBuscarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutorActionPerformed(evt);
            }
        });

        btnModificarLibro.setText("Modificar libro");
        btnModificarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarLibroActionPerformed(evt);
            }
        });

        lblPorcentajeLibros.setText("Porcentaje de libros que son de solo lectura:");

        btnPorcentajeSoloLectura.setText("Mostrar");
        btnPorcentajeSoloLectura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorcentajeSoloLecturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCantLibrosRegistrados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificarLibro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevoLibro))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnMostrarLibros))
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(btnListadoLibros)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPorcentajeLibros)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(btnPorcentajeSoloLectura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantLibrosRegistrados)
                    .addComponent(btnNuevoLibro)
                    .addComponent(btnBuscarAutor)
                    .addComponent(btnModificarLibro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(btnListadoLibros))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarLibros))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(lblPorcentajeLibros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPorcentajeSoloLectura)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarLibrosActionPerformed
        ArrayList<DtoLibrosOrigenNacional> reporte3 = g.librosDeAutoresNacionales();
        lstListaAutoresNacionales.setListData(reporte3.toArray());
    }//GEN-LAST:event_btnMostrarLibrosActionPerformed

    private void btnListadoLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoLibrosActionPerformed
        ArrayList<DtoListadoLibros> reporte2 = g.obtenerListadoLibros();
        lstListadoLibros.setListData(reporte2.toArray());
    }//GEN-LAST:event_btnListadoLibrosActionPerformed

    private void btnBuscarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutorActionPerformed
        BuscarAutor buscarAutor = new BuscarAutor();
        buscarAutor.setVisible(true);
    }//GEN-LAST:event_btnBuscarAutorActionPerformed

    private void btnNuevoLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLibroActionPerformed
        AltaLibro altaLibro = new AltaLibro();
        altaLibro.setVisible(true);
    }//GEN-LAST:event_btnNuevoLibroActionPerformed

    private void btnModificarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarLibroActionPerformed
        ModificarLibro modificarLibro = new ModificarLibro();
        modificarLibro.setVisible(true);
    }//GEN-LAST:event_btnModificarLibroActionPerformed

    private void btnPorcentajeSoloLecturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorcentajeSoloLecturaActionPerformed
        lblPorcentajeLibros.setText("Porcentaje de libros que son de solo lectura: " + g.porcentajeLibrosSoloLectura());
    }//GEN-LAST:event_btnPorcentajeSoloLecturaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAutor;
    private javax.swing.JButton btnListadoLibros;
    private javax.swing.JButton btnModificarLibro;
    private javax.swing.JButton btnMostrarLibros;
    private javax.swing.JButton btnNuevoLibro;
    private javax.swing.JButton btnPorcentajeSoloLectura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantLibrosRegistrados;
    private javax.swing.JLabel lblPorcentajeLibros;
    private javax.swing.JList lstListaAutoresNacionales;
    private javax.swing.JList lstListadoLibros;
    // End of variables declaration//GEN-END:variables
}
