/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import proyecto1.controllers.AuthController;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import structures.rolStr;
import structures.loginModel; 
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;


/**
 *
 * @author jmanc
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    
    public LoginFrame() {
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

        JLogin = new javax.swing.JButton();
        JTextUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JnombreText = new javax.swing.JTextField();
        JApellidoText = new javax.swing.JTextField();
        JCorreoText = new javax.swing.JTextField();
        JTelefonoText = new javax.swing.JTextField();
        JPathFotoText = new javax.swing.JTextField();
        JFechaText = new javax.swing.JTextField();
        JPasswordText = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JBtnFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLogin.setText("Registrarse");
        JLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JLoginActionPerformed(evt);
            }
        });

        JTextUser.setText("jpperez");
        JTextUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTextUserMouseClicked(evt);
            }
        });
        JTextUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextUserActionPerformed(evt);
            }
        });

        JnombreText.setText("Juan");
        JnombreText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JnombreTextMouseClicked(evt);
            }
        });

        JApellidoText.setText("Perez");
        JApellidoText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JApellidoTextMouseClicked(evt);
            }
        });

        JCorreoText.setText("ejemplo@correo.com");
        JCorreoText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JCorreoTextMouseClicked(evt);
            }
        });

        JTelefonoText.setText("12345678");
        JTelefonoText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTelefonoTextMouseClicked(evt);
            }
        });

        JPathFotoText.setEditable(false);
        JPathFotoText.setText("C:\\imagenes");
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

        JFechaText.setText("YYYY-MM-DD");
        JFechaText.setAutoscrolls(false);
        JFechaText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JFechaTextMouseClicked(evt);
            }
        });

        JPasswordText.setText("jPasswordField1");
        JPasswordText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                JPasswordTextFocusLost(evt);
            }
        });
        JPasswordText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPasswordTextMouseClicked(evt);
            }
        });
        JPasswordText.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JPasswordTextInputMethodTextChanged(evt);
            }
        });
        JPasswordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPasswordTextActionPerformed(evt);
            }
        });

        jLabel2.setText("Seguridad");

        jLabel3.setText("Usuario");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Nombre");

        jLabel6.setText("Apellido");

        jLabel7.setText("Telefono");

        jLabel8.setText("Correo");

        jLabel9.setText("Fecha de Nacimiento");

        jLabel10.setText("Fotografia");

        JBtnFoto.setText("Buscar Fotografia");
        JBtnFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JnombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(JApellidoText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(JCorreoText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                            .addComponent(JFechaText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                                            .addComponent(JTelefonoText, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JPathFotoText, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JBtnFoto)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(JLogin)))
                        .addGap(139, 139, 139))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JnombreText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JApellidoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCorreoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTelefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JFechaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JPathFotoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(JBtnFoto))
                .addGap(53, 53, 53)
                .addComponent(JLogin)
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private String fotoPath = "";
    
    
    private void JLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JLoginActionPerformed

        structures.usuario nuevoUsuario = new  structures.usuario();
    if (JTextUser.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo Usuario está vacío.");
        return;
    }

    if (JnombreText.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo Nombre está vacío.");
        return;
    }

    if (JApellidoText.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo Apellido está vacío.");
        return;
    }

    if (String.valueOf(JPasswordText.getPassword()).trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo Contraseña está vacío.");
        return;
    }

    if (JFechaText.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo Fecha de nacimiento está vacío.");
        return;
    }

    if (JCorreoText.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo Correo está vacío.");
        return;
    }

    if (JTelefonoText.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo Teléfono está vacío.");
        return;
    }

    // Aquí continúan tus validaciones originales:
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

    nuevoUsuario.setUsuario(JTextUser.getText());
        nuevoUsuario.setNombre(JnombreText.getText());
        nuevoUsuario.setApellido(JApellidoText.getText());
        nuevoUsuario.setPassword(String.valueOf(JPasswordText.getPassword()));
        nuevoUsuario.setFechaNacimiento(JFechaText.getText());
        nuevoUsuario.setCorreoAlterno(JCorreoText.getText());
        nuevoUsuario.setTelefono(Integer.parseInt(JTelefonoText.getText()));
        nuevoUsuario.setPathFotografia(fotoPath);
        nuevoUsuario.setRol(rolStr.Rol.USUARIO_REGULAR);
        nuevoUsuario.setEstatus(1);
        
        boolean estaRegistrado = AuthController.register(nuevoUsuario);
        if(estaRegistrado){
            JOptionPane.showMessageDialog(null, "Usuario Registrado exitosamente!");
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Error al registrar. Es posible que el usuario ya exista.");
        }

    }//GEN-LAST:event_JLoginActionPerformed

    private void JTextUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextUserActionPerformed

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
    private void JPasswordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPasswordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPasswordTextActionPerformed

    private void JPathFotoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPathFotoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JPathFotoTextActionPerformed

    private void JTextUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTextUserMouseClicked
        // TODO add your handling code here:
        JTextUser.setText("");
    }//GEN-LAST:event_JTextUserMouseClicked

    private void JPasswordTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPasswordTextMouseClicked
        // TODO add your handling code here:
        JPasswordText.setText("");
    }//GEN-LAST:event_JPasswordTextMouseClicked

    private void JnombreTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JnombreTextMouseClicked
        // TODO add your handling code here:
        JnombreText.setText("");
    }//GEN-LAST:event_JnombreTextMouseClicked

    private void JApellidoTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JApellidoTextMouseClicked
        // TODO add your handling code here:
        JApellidoText.setText("");
    }//GEN-LAST:event_JApellidoTextMouseClicked

    private void JCorreoTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JCorreoTextMouseClicked
        // TODO add your handling code here:
        JCorreoText.setText("");
    }//GEN-LAST:event_JCorreoTextMouseClicked

    private void JTelefonoTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTelefonoTextMouseClicked
        // TODO add your handling code here:
        JTelefonoText.setText("");
    }//GEN-LAST:event_JTelefonoTextMouseClicked

    private void JFechaTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JFechaTextMouseClicked
        // TODO add your handling code here:
        JFechaText.setText("");
    }//GEN-LAST:event_JFechaTextMouseClicked

    private void JPathFotoTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPathFotoTextMouseClicked
        // TODO add your handling code here:
        JPathFotoText.setText("");
    }//GEN-LAST:event_JPathFotoTextMouseClicked

    private void JBtnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnFotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this); // Puedes usar 'this' si estás dentro de un JFrame

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
                String rutaSeleccionada = archivoSeleccionado.getAbsolutePath();
            JPathFotoText.setText(rutaSeleccionada);

         // Obtén el nombre de usuario ingresado en tu interfaz
            String nombreUsuario = JTextUser.getText(); // Reemplaza 'JNombreUsuario' con el nombre de tu campo de texto para el nombre de usuario

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

    private void JPasswordTextInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JPasswordTextInputMethodTextChanged
       
    }//GEN-LAST:event_JPasswordTextInputMethodTextChanged
private loginModel model = new loginModel();

    private void JPasswordTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JPasswordTextFocusLost
    String password = new String(JPasswordText.getPassword());
    String strengthMessage = model.verifyPassword(password);
    jLabel2.setText(strengthMessage);
        
    }//GEN-LAST:event_JPasswordTextFocusLost
    
    // Método para obtener la extensión del archivo
    private String getFileExtension(File file) {
    String extension = "";
    String fileName = file.getName();
    int lastIndex = fileName.lastIndexOf(".");
    if (lastIndex > 0) {
        extension = fileName.substring(lastIndex + 1).toLowerCase();
    }
    return extension;
    }
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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JApellidoText;
    private javax.swing.JButton JBtnFoto;
    private javax.swing.JTextField JCorreoText;
    private javax.swing.JTextField JFechaText;
    private javax.swing.JButton JLogin;
    private javax.swing.JPasswordField JPasswordText;
    private javax.swing.JTextField JPathFotoText;
    private javax.swing.JTextField JTelefonoText;
    private javax.swing.JTextField JTextUser;
    private javax.swing.JTextField JnombreText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
