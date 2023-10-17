/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.controllers;import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author carlo
 */
public class UserController {

    private static final String FILE_PATH = "C:\\MEIA\\usuario.txt";
    private static final String DESC_FILE_PATH = "C:\\MEIA\\desc_usuario.txt";

    public static void EditUser(String user, String[] newData) {
    List<String> lines = new ArrayList<>();
    boolean userUpdated = false;

    try {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts[0].equals(user)) {
                    // Modifica los datos sólo si el nuevo dato no está vacío.
                    for (int i = 0; i < newData.length && i < parts.length; i++) {
                        if (newData[i] == null || newData[i].isEmpty()) {
                            newData[i] = parts[i];
                        }
                    }

                    line = String.join("|", newData);
                    userUpdated = true;
                }

                lines.add(line);
            }

            br.close();

            // Si el usuario no fue encontrado, añadimos su registro al archivo.
            if (!userUpdated) {
                lines.add(String.join("|", newData));
            }

            // Escribir nuevamente en el archivo
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String updatedLine : lines) {
                bw.write(updatedLine);
                bw.newLine();
            }
            bw.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
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
    public static String getAllUser(String user){
        String[] datos = getUserData(user);
                return (datos[0] + " | " + datos[2] + " | " + datos[3] + " | " + datos[4] + " | " + datos[5] + " | " + datos[6] +  " | " + datos[7] + "|" + datos[8] + "|" + datos[9]);
    }

      public static void eliminarUsuario(String user) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                System.out.println("Si existe el archivo");
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts[0].equals(user) && !"0".equals(parts[8])) {
                        parts[9] = "0";
                        line = String.join("|", parts);
                    }
                    lines.add(line);
                }

                br.close();

                // Escribir nuevamente en el archivo
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (String updatedLine : lines) {
                    bw.write(updatedLine);
                    bw.newLine();
                }
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
