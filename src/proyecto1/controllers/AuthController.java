package proyecto1.controllers;

import structures.usuario;
import structures.rolStr;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class AuthController {

    private static final String FILE_PATH = "C:\\MEIA\\usuario.txt";
    private static final String DESC_FILE_PATH = "C:\\MEIA\\desc_usuario.txt";

    public static usuario authenticate(String username, String password) {
        usuario authenticatedUser = null;
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts[0].equals(username) && parts[1].equals(password) && "1".equals(parts[9])) {
                        authenticatedUser = new usuario();
                        authenticatedUser.setUsuario(parts[0]);
                        authenticatedUser.setPassword(parts[1]);
                        authenticatedUser.setNombre(parts[2]);
                        authenticatedUser.setApellido(parts[3]);
                        authenticatedUser.setFechaNacimiento(parts[4]);
                        authenticatedUser.setCorreoAlterno(parts[5]);
                        authenticatedUser.setTelefono(Integer.parseInt(parts[6]));
                        authenticatedUser.setPathFotografia(parts[7]);
                        authenticatedUser.setRol(rolStr.Rol.fromCodigo(Byte.parseByte(parts[8])));
                        
                        authenticatedUser.setEstatus(1);

                        break;
                    }
                }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authenticatedUser;
    }

    public static boolean register(usuario newUser) {
        try {
            File file = new File(FILE_PATH);
            File descFile = new File(DESC_FILE_PATH);
            boolean isAdminPresent = checkIfAdminExists();
               
            if (!isAdminPresent) {
                newUser.setRol(rolStr.Rol.ADMINISTRADOR);
            } else {
                newUser.setRol(rolStr.Rol.USUARIO_REGULAR);
            }
            if (!file.exists()) {
                file.createNewFile();
                descFile.createNewFile();
                initializeDescriptor(newUser.getUsuario());
            } else {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.split("\\|")[0].equals(newUser.getUsuario())) {
                        br.close();
                        return false;
                    }
                }
                br.close();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(newUser.toString());
            bw.newLine();
            bw.close();
            updateDescriptor(newUser.getUsuario());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkIfAdminExists() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("=====================");  // <-- Aquí está la impresión del valor de 'line'

                    System.out.println(line);  // <-- Aquí está la impresión del valor de 'line'
                    System.out.println("=====================");  // <-- Aquí está la impresión del valor de 'line'

                    if (line.split("\\|").length > 8 && Byte.parseByte(line.split("\\|")[8]) == rolStr.Rol.ADMINISTRADOR.getCodigo()) {

                        br.close();
                        return true;
                    }
                }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void initializeDescriptor(String user) throws IOException {
        String fecha_actual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DESC_FILE_PATH, false))) {
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

    public static boolean checkUserPrivileges(String user) {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length > 8 && parts[0].equals(user)) {
                        if (parts[8].equals("0")) {
                            br.close();
                            return true;
                        }
                    }
                }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
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

}
