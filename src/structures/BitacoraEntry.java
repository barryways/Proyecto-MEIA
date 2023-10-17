/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author claud
 */
public class BitacoraEntry {
    private String ruta_absoluta;
    private String Usuario;
    private Date fecha_transaccion;

    public BitacoraEntry(String ruta_absoluta, String Usuario) {
        this.ruta_absoluta = ruta_absoluta;
        this.Usuario = Usuario;
        this.fecha_transaccion = new Date();
    }

    public String toFileString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ruta_absoluta + "|" + Usuario + "|" + dateFormat.format(fecha_transaccion);
    }
    public static void addToBitacora(BitacoraEntry entry, String bitacoraFilePath) {
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(bitacoraFilePath, true));
        writer.write(entry.toFileString());
        writer.newLine();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}

