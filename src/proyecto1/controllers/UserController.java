/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.controllers;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import static proyecto1.controllers.AuthController.checkIfAdminExists;
import structures.rolStr;
import structures.usuario;
import structures.Contactos;

/**
 *
 * @author carlo
 */
public class UserController {

    private static final String FILE_PATH = "C:\\MEIA\\usuario.txt";
    private static final String DESC_FILE_PATH = "C:\\MEIA\\desc_usuario.txt";
    private static final String FILE_PATH_CONTACT = "C:\\MEIA\\contactos.txt";
    private static final String DESC_FILE_PATH_CONTACT = "C:\\MEIA\\desc_contactos.txt";

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

    public static List<String[]> getAllInformationByParams(String data, int positionInFile) {
        List<String[]> userDataList = new ArrayList<>();

        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length > 8 && parts[positionInFile].equals(data)) {
                        userDataList.add(parts);
                    }
                }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userDataList;
    }

    public static String getDataPlane(String user) {
        String[] datos = getUserData(user);
        return (datos[0] + " | " + datos[2] + " | " + datos[3] + " | " + datos[4] + " | " + datos[5] + " | " + datos[6]);
    }

    public static String getAllUser(String user) {
        String[] datos = getUserData(user);
        return (datos[0] + " | " + datos[2] + " | " + datos[3] + " | " + datos[4] + " | " + datos[5] + " | " + datos[6] + " | " + datos[7] + "|" + datos[8] + "|" + datos[9]);
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

    public static String getContactoByUser(String user) {
        String[] datos = getUserData(user);
        return (datos[0] + " | " + datos[2] + " | " + datos[3]);
    }

    public static List<String[]> getContactoByName(String name) {
        List<String[]> datos = getAllInformationByParams(name, 2);
        return datos;
    }

    public static List<String[]> getContactoByLastName(String lastName) {
        List<String[]> datos = getAllInformationByParams(lastName, 3);
        return datos;
    }

    public static boolean registerNewContact(Contactos newContact) {
        try {
            File file = new File(FILE_PATH_CONTACT);
            File descFile = new File(DESC_FILE_PATH_CONTACT);

            if (!file.exists()) {
                file.createNewFile();
                descFile.createNewFile();
                initializeDescriptor(newContact.getUsuario());
            } else {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.split("\\|")[0].equals(newContact.getUsuario())) {
                        br.close();
                        return false;
                    }
                }
                br.close();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(newContact.toString());
            bw.newLine();
            bw.close();
            updateDescriptor(newContact.getUsuario());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    private static void initializeDescriptor(String user) throws IOException {
        String fecha_actual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DESC_FILE_PATH_CONTACT, false))) {
            writer.write("nombre_simbolico:desc_usuario");
            writer.newLine();
            writer.write("fecha_creacion:" + fecha_actual);
            writer.newLine();
            writer.write("usuario_creacion:" + user);
            writer.newLine();
            writer.write("fecha_modificacion:" + fecha_actual);
            writer.newLine();
            writer.write("usuario_modificacion:" + user);
            writer.newLine();
            writer.write("#_registros:0");
            writer.newLine();
            writer.write("registros_activos:0");
            writer.newLine();
            writer.write("registros_inactivos:0");
            writer.newLine();
        }
    }

    private static void updateDescriptor(String user) throws IOException {
        File descFile = new File(DESC_FILE_PATH);

        String nombre_simbolico = "desc_usuario";
        String fecha_creacion = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String usuario_creacion = user;
        String fecha_modificacion = fecha_creacion;
        String usuario_modificacion = user;
        int num_registros = 0;
        int registros_activos = 0;
        int registros_inactivos = 0;

        if (descFile.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(descFile));

            nombre_simbolico = getNextLineValue(reader);
            fecha_creacion = getNextLineValue(reader);
            usuario_creacion = getNextLineValue(reader);
            fecha_modificacion = getNextLineValue(reader);
            usuario_modificacion = getNextLineValue(reader);

            num_registros = getIntFromNextLine(reader);
            registros_activos = getIntFromNextLine(reader);
            registros_inactivos = getIntFromNextLine(reader);

            reader.close();
        }

        fecha_modificacion = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        usuario_modificacion = user;
        num_registros++;
        registros_activos++;

        BufferedWriter writer = new BufferedWriter(new FileWriter(descFile, false));
        writer.write("nombre_simbolico:" + nombre_simbolico);
        writer.newLine();
        writer.write("fecha_creacion:" + fecha_creacion);
        writer.newLine();
        writer.write("usuario_creacion:" + usuario_creacion);
        writer.newLine();
        writer.write("fecha_modificacion:" + fecha_modificacion);
        writer.newLine();
        writer.write("usuario_modificacion:" + usuario_modificacion);
        writer.newLine();
        writer.write("#_registros:" + num_registros);
        writer.newLine();
        writer.write("registros_activos:" + registros_activos);
        writer.newLine();
        writer.write("registros_inactivos:" + registros_inactivos);
        writer.newLine();
        writer.close();
    }

    private static String getNextLineValue(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        if (line != null) {
            return line.split(":")[1];
        }
        return "";
    }

    private static int getIntFromNextLine(BufferedReader reader) throws IOException {
        String value = getNextLineValue(reader);
        if (!value.isEmpty()) {
            return Integer.parseInt(value);
        }
        return 0;
    }

    public static void deleteContact(String user, String contact) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(FILE_PATH_CONTACT);
            if (file.exists()) {
                System.out.println("Si existe el archivo");
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts[0].equals(user) && parts[1].equals(contact.trim()) && parts[4].equals("1") ) {
                        parts[4] = "0";
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
