/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class DescriptorManager {
    private static final String DESCRIPTOR_FILE_PATH = "C:\\MEIA\\desc_bitacora_backup.txt";

    public static void updateDescriptor(String usuarioModificacion, String descriptorFilePath) {
        int registrosBitacora = BitacoraManager.countEntries();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(descriptorFilePath, false))) {
            writer.write("nombre_simbolico:desc_bitacora_backup");
            writer.newLine();
            writer.write("fecha_creacion:" + FileUtils.getCreationDate());
            writer.newLine();
            writer.write("usuario_creacion:" + FileUtils.usuarioCreacion());
            writer.newLine();
            writer.write("fecha_modificacion:" + FileUtils.getCurrentDate());
            writer.newLine();
            writer.write("usuario_modificacion:" + usuarioModificacion);
            writer.newLine();
            writer.write("#_registros:" + registrosBitacora);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



    
    
    


