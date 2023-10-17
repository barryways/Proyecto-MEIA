/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author claud
 */
public class BitacoraManager {
    private static final String BITACORA_FILE_PATH = "C:\\MEIA\\bitacora_backup.txt";

    public static int countEntries() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(BITACORA_FILE_PATH));
            int count = 0;

            while (reader.readLine() != null) {
                count++;
            }

            reader.close();
            return count;
        } catch (IOException e) {
            e.printStackTrace();
            return -1; // Retorna un valor negativo en caso de error
        }
    }
}
