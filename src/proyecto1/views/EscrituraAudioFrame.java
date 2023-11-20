/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.views;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import structures.ArbolBinario;
import structures.SongNode;

/**
 *
 * @author claud
 */
public class EscrituraAudioFrame extends javax.swing.JFrame {

    private SongNode cancion;
    private ArbolBinario arbolBinario;

    /**
     * Creates new form BusquedaAudioFrame
     */
    public EscrituraAudioFrame(String pista, ArbolBinario arbol) {
        initComponents();
        // Dividir el texto usando el guion como delimitador
        String[] partes = pista.split("-");
        //llega como pista =titulo-artista
        arbolBinario = arbol;
        cancion = arbolBinario.search(partes[0], partes[1]);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCancion = new javax.swing.JTable();
        jButtonGuardarAudio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Editar/Escribir Datos");

        jTableCancion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Titulo", "Artista", "Album", "Año", "Genero", "Imagen", "Duracion", "Letra", "Banda", "Legal Inf."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCancion);

        jButtonGuardarAudio.setText("Guardar");
        jButtonGuardarAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarAudioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1436, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(632, 632, 632)
                        .addComponent(jButtonGuardarAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(669, 669, 669)
                        .addComponent(jLabel1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonGuardarAudio)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void llenarDatosGrid(SongNode cancion) {
        // Obtener el modelo de la tabla existente
        DefaultTableModel modeloTabla = (DefaultTableModel) jTableCancion.getModel();

        // Agregar una nueva fila al modelo de la tabla
        modeloTabla.addRow(new Object[]{
            cancion.getPath(),
            cancion.getTitle(),
            cancion.getArtist(),
            cancion.getAlbum(),
            cancion.getYear(),
            cancion.getGenre(),
            cancion.getImagePath(),
            cancion.getDuration(),
            cancion.getLyricsPath(),
            cancion.getBand(),
            cancion.getLegalInformation()
        });

        // Notificar a la tabla que se han realizado cambios en el modelo
        modeloTabla.fireTableDataChanged();

    }

    private void jButtonGuardarAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarAudioActionPerformed
        int numRows = jTableCancion.getRowCount();
        if (numRows > 0) {
            String album = (String) jTableCancion.getValueAt(0, 3);
            String año = (String) jTableCancion.getValueAt(0, 4);
            String genero = (String) jTableCancion.getValueAt(0, 5);
            String imagen = (String) jTableCancion.getValueAt(0, 6);
            String duracion = (String) jTableCancion.getValueAt(0, 7);
            String letra = (String) jTableCancion.getValueAt(0, 8);
            String banda = (String) jTableCancion.getValueAt(0, 9);
            String legalInf = (String) jTableCancion.getValueAt(0, 10);
            arbolBinario.edit(cancion.getTitle(), cancion.getArtist(), cancion.getPath(), cancion.getTitle(), cancion.getArtist(), banda, legalInf, album, año, genero, imagen, duracion, letra);
            JOptionPane.showMessageDialog(this, "Se completo con exito la edicion");
        } else {
            JOptionPane.showMessageDialog(this, "No hay datos para poderlos editar");

        }

    }//GEN-LAST:event_jButtonGuardarAudioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EscrituraAudioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EscrituraAudioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EscrituraAudioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EscrituraAudioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EscrituraAudioFrame("", null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGuardarAudio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCancion;
    // End of variables declaration//GEN-END:variables
}
