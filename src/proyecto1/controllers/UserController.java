/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class UserController {

    private static final String FILE_PATH = "C:\\MEIA\\usuario.txt";
    private static final String DESC_FILE_PATH = "C:\\MEIA\\desc_usuario.txt";

    public void EditUser() {

    }

    public static String[] getUserData(String user) {
        String[] data = new String[10];
        try {

            File file = new File(FILE_PATH);
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length > 8 && parts[0].equals(user)) {
                        for (int i = 0; i < parts.length; i++) {
                            data[i] = parts[i];
                        }
                        return data;
                    }

                }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getDataPlane(String user) {
        String[] datos = getUserData(user);
        return (datos[0] + " | " + datos[2] + " | " + datos[3] + " | " + datos[4] + " | " + datos[5] + " | " + datos[6]);
    }

    public static void eliminarUsuario(String user) {
        try {
            File file = new File(FILE_PATH);
            File tempFile = new File("temp.txt");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length > 8 && parts[0].equals(user)) {
                        // Omite esta línea (no la escribe en el archivo temporal)
                    } else {
                        // Escribe la línea actual en el archivo temporal
                        bw.write(line);
                        bw.newLine();
                    }
                }

                br.close();
                bw.close();

                // Borra el archivo original
                if (file.delete()) {
                    // Reemplaza el archivo original con el archivo temporal
                    if (tempFile.renameTo(file)) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo realizar la operación.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la operación. 2");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
