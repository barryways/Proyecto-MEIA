/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.views;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import proyecto1.controllers.AuthController;
import proyecto1.controllers.UserController;

/**
 *
 * @author carlo
 */
public class EditUser extends javax.swing.JFrame {

    /**
     * Creates new form EditUser
     */
    public EditUser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JBtnEdit = new javax.swing.JButton();
        JBtnFoto = new javax.swing.JButton();
        JPathFotoText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JFechaText = new javax.swing.JTextField();
        JTelefonoText = new javax.swing.JTextField();
        JCorreoText = new javax.swing.JTextField();
        JPasswordText = new javax.swing.JPasswordField();
        jLabelUsuario = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JBtnEdit.setText("Editar");
        JBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnEditActionPerformed(evt);
            }
        });

        JBtnFoto.setText("Buscar Fotografia");
        JBtnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnFotoActionPerformed(evt);
            }
        });

        JPathFotoText.setEditable(false);
        JPathFotoText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPathFotoTextMouseClicked(evt);
            }
        });
        JPathFotoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPathFotoTextActionPerformed(evt);
            }
        });

        jLabel10.setText("Fotografia");

        jLabel9.setText("Fecha de Nacimiento");

        JFechaText.setAutoscrolls(false);
        JFechaText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFechaTextMouseClicked(evt);
            }
        });

        JTelefonoText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTelefonoTextMouseClicked(evt);
            }
        });

        JCorreoText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCorreoTextMouseClicked(evt);
            }
        });

        JPasswordText.setText("jPasswordField1");
        JPasswordText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPasswordTextMouseClicked(evt);
            }
        });
        JPasswordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPasswordTextActionPerformed(evt);
            }
        });

        jLabelUsuario.setText("Editar Usuario");

        jLabel4.setText("Contraseña");

        jLabel8.setText("Correo");

        jLabel7.setText("Telefono");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(JBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JCorreoText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTelefonoText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                            .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JFechaText, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JPathFotoText, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBtnFoto)))))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelUsuario)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(JCorreoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(JTelefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(JFechaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JPathFotoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBtnFoto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(JBtnEdit)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String username = "";
    private String clave = "";
    private String nombre = "";
    private String apellido = "";
    private String fechaNacimiento = "";
    private String correo = "";
    private String telefono = "";
    private String fotoPath = "";
    private String rol = "";

    public void cargarDatos(String user) {
        String[] datosUsuario = AuthController.getUserData(user);
        username = datosUsuario[0];
        clave = datosUsuario[1];
        nombre = datosUsuario[2];
        apellido = datosUsuario[3];
        fechaNacimiento = datosUsuario[4];
        correo = datosUsuario[5];
        telefono = datosUsuario[6];
        fotoPath = datosUsuario[7];
        rol = datosUsuario[8];
        jLabelUsuario.setText("Editar Usuario: "+username);
    }

    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhone(String phone) {
        String regex = "^\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    private boolean isValidDate(String date) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    private String getFileExtension(File file) {
        String extension = "";
        String fileName = file.getName();
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex > 0) {
            extension = fileName.substring(lastIndex + 1).toLowerCase();
        }
        return extension;
    }


    private void JBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnEditActionPerformed
        structures.usuario nuevoUsuario = new structures.usuario();
        if (!isValidEmail(JCorreoText.getText())) {
            JOptionPane.showMessageDialog(null, "Campo incorrecto: Correo. Debería tener el formato: ejemplo@dominio.com");
            return;
        }

        if (!isValidPhone(JTelefonoText.getText())) {
            JOptionPane.showMessageDialog(null, "Campo incorrecto: Teléfono. Debería tener 8 dígitos.");
            return;
        }

        if (!isValidDate(JFechaText.getText())) {
            JOptionPane.showMessageDialog(null, "Campo incorrecto: Fecha de nacimiento. Debería tener el formato: YYYY-MM-DD.");
            return;
        }
            String[] newData = new String[10];
            newData[0] = username;
            newData[1] = JCorreoText.getText();
            newData[2] = String.valueOf(JPasswordText.getPassword()); 
            newData[3] = nombre;
            newData[4] = apellido;
            newData[5] = JFechaText.getText();
            newData[6] = JCorreoText.getText();
            newData[7] = JTelefonoText.getText();
            newData[8] = JPathFotoText.getText();
            newData[9] = rol;
            UserController.EditUser(username,newData);


    }//GEN-LAST:event_JBtnEditActionPerformed

    private void JBtnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnFotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this); // Puedes usar 'this' si estás dentro de un JFrame

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String rutaSeleccionada = archivoSeleccionado.getAbsolutePath();
            JPathFotoText.setText(rutaSeleccionada);

            // Obtén el nombre de usuario ingresado en tu interfaz
            String nombreUsuario = username; 

            // Directorio de destino
            String extension = getFileExtension(archivoSeleccionado);
            String nombreArchivoDestino = nombreUsuario + "." + extension;
            String directorioDestino = "C:\\MEIA\\foto\\" + nombreArchivoDestino;

            fotoPath = directorioDestino;

            try {
                Files.copy(archivoSeleccionado.toPath(), new File(directorioDestino).toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Imagen copiada exitosamente a " + directorioDestino);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_JBtnFotoActionPerformed

    private void JPathFotoTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPathFotoTextMouseClicked
        // TODO add your handling code here:
        JPathFotoText.setText("");
    }//GEN-LAST:event_JPathFotoTextMouseClicked

    private void JPathFotoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPathFotoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPathFotoTextActionPerformed

    private void JFechaTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JFechaTextMouseClicked
        // TODO add your handling code here:
        JFechaText.setText("");
    }//GEN-LAST:event_JFechaTextMouseClicked

    private void JTelefonoTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTelefonoTextMouseClicked
        // TODO add your handling code here:
        JTelefonoText.setText("");
    }//GEN-LAST:event_JTelefonoTextMouseClicked

    private void JCorreoTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCorreoTextMouseClicked
        // TODO add your handling code here:
        JCorreoText.setText("");
    }//GEN-LAST:event_JCorreoTextMouseClicked

    private void JPasswordTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPasswordTextMouseClicked
        // TODO add your handling code here:
        JPasswordText.setText("");
    }//GEN-LAST:event_JPasswordTextMouseClicked

    private void JPasswordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPasswordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPasswordTextActionPerformed

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
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnEdit;
    private javax.swing.JButton JBtnFoto;
    private javax.swing.JTextField JCorreoText;
    private javax.swing.JTextField JFechaText;
    private javax.swing.JPasswordField JPasswordText;
    private javax.swing.JTextField JPathFotoText;
    private javax.swing.JTextField JTelefonoText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelUsuario;
    // End of variables declaration//GEN-END:variables
}
