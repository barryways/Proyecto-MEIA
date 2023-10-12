/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;
//import proyecto1.views.LoginFrame; 
import javax.swing.JOptionPane;
import proyecto1.controllers.AuthController;
import proyecto1.views.LoginFrame;
import proyecto1.views.StartFrame;
/**
 *
 * @author jmanc
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() ->{
            if(AuthController.checkIfAdminExists()){
                new StartFrame().setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay ningun usuario registrado, se el primero.");
                new StartFrame().setVisible(true);
                new LoginFrame().setVisible(true);

            }
            
        });
    }
    
}
