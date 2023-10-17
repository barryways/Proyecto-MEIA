/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
    
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 *
 * @author claud
 */
public class FileUtils {
    public static void copyFolder(File source, File destination) throws IOException {
    if (source.isDirectory()) {
        if (!destination.exists()) {
            destination.mkdir();
        }

        String[] files = source.list();
        for (String file : files) {
            File srcFile = new File(source, file);
            File destFile = new File(destination, file);
            copyFolder(srcFile, destFile);
        }
    } else {
        Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
    
    public static String getCreationDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }
    
    public static String usuarioCreacion() {
        try {
            // Abre el archivo de usuarios para leer el primer usuario
            File usuariosFile = new File("C:\\MEIA\\usuario.txt");
            if (usuariosFile.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(usuariosFile));
                String line = br.readLine();
                br.close();

                // Suponiendo que el primer usuario está en la primera línea del archivo
                if (line != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length > 0) {
                        return parts[0];
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return "UsuarioDesconocido";
    }
}


