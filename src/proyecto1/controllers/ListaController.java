/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import structures.ListaDistribucion;
import structures.ListaUsuario;
import java.io.*;

/**
 *
 * @author jmanc
 */
public class ListaController {
     private final String path = "C:/MEIA/Lista_usuario.txt";

     public boolean registrarLista(ListaDistribucion lista, String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(lista.getNombreLista() + "|" + lista.getUsuario() + "|" + lista.getDescripcion() 
                        + "|0|" + lista.getFechaCreacion().toString() + "|1\n");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
     public boolean asociarUsuario(ListaUsuario listaUsuario, String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write("0|0.0|" + listaUsuario.getUsuario() + "|" + listaUsuario.getNombre_lista() 
                        + "|" + listaUsuario.getUsuario_asociado() + "|-1|" + listaUsuario.getFecha_creacion().toString() + "|1\n");
            writer.close();
            incrementarNumeroUsuarios(listaUsuario.getNombre_lista(), listaUsuario.getUsuario());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
     private void incrementarNumeroUsuarios(String nombreLista, String usuario) {
        String ruta = "C:/MEIA/lista.txt";
        try {
            List<String> lineas = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes[0].equals(nombreLista) && partes[1].equals(usuario)) {
                    int numeroUsuarios = Integer.parseInt(partes[3]);
                    numeroUsuarios++;
                    linea = partes[0] + "|" + partes[1] + "|" + partes[2] + "|" + numeroUsuarios + "|" + partes[4] + "|" + partes[5];
                }
                lineas.add(linea);
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
            for (String l : lineas) {
                writer.write(l + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
     
     // Método para lista de usuarios
    public boolean agregarListaUsuario(ListaUsuario listaUsuario) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            int registro = obtenerUltimoRegistro() + 1;
            listaUsuario.setRegistro(registro);
            listaUsuario.setPosicion(calcularPosicion(listaUsuario.getUsuario(), listaUsuario.getNombre_lista(), listaUsuario.getUsuario_asociado()));
            listaUsuario.setSiguiente(-1);

            String data = String.join("|",
                    Integer.toString(registro),
                    Double.toString(listaUsuario.getPosicion()),
                    listaUsuario.getUsuario(),
                    listaUsuario.getNombre_lista(),
                    listaUsuario.getUsuario_asociado(),
                    Integer.toString(listaUsuario.getSiguiente()),
                    listaUsuario.getFecha_creacion().toString(),
                    Integer.toString(listaUsuario.getStatus())
            );

            writer.write(data);
            writer.newLine();
            writer.close();

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // MétodoS para buscar un usuario en la lista basado en su nombre
    public ListaUsuario buscarListaUsuario(String usuario, String nombreLista, String usuarioAsociado) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes[2].equals(usuario) && partes[3].equals(nombreLista) && partes[4].equals(usuarioAsociado)) {
                    ListaUsuario listaUsuario = new ListaUsuario();
                    listaUsuario.setRegistro(Integer.parseInt(partes[0]));
                    listaUsuario.setPosicion(Double.parseDouble(partes[1]));
                    listaUsuario.setUsuario(partes[2]);
                    listaUsuario.setNombre_lista(partes[3]);
                    listaUsuario.setUsuario_asociado(partes[4]);
                    listaUsuario.setSiguiente(Integer.parseInt(partes[5]));
                    // Aquí puedes agregar la conversión de la fecha y el status
                    return listaUsuario;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private final String listaUsuarioFilePath = "C:/MEIA/Lista_usuario.txt";

    public List<String> buscarUsuariosAsociados(String usuario) {
    List<String> usuariosAsociados = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(listaUsuarioFilePath))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split("\\|");
            if (partes.length >= 5 && partes[4].equals(usuario)) {
                usuariosAsociados.add(linea);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return usuariosAsociados;
    }


    // Método para modificar un usuario en la lista
    public boolean modificarListaUsuario(ListaUsuario listaUsuario) {
        List<String> lineas = new ArrayList<>();
        boolean modificado = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes[2].equals(listaUsuario.getUsuario()) && partes[3].equals(listaUsuario.getNombre_lista()) && partes[4].equals(listaUsuario.getUsuario_asociado())) {
                    linea = String.join("|",
                            Integer.toString(listaUsuario.getRegistro()),
                            Double.toString(listaUsuario.getPosicion()),
                            listaUsuario.getUsuario(),
                            listaUsuario.getNombre_lista(),
                            listaUsuario.getUsuario_asociado(),
                            Integer.toString(listaUsuario.getSiguiente()),
                            listaUsuario.getFecha_creacion().toString(),
                            Integer.toString(listaUsuario.getStatus())
                    );
                    modificado = true;
                }
                lineas.add(linea);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (String l : lineas) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return modificado;
    }

    // Método para eliminar un usuario en la lista (soft delete, se cambia el status a 0)
    public boolean eliminarListaUsuario(String usuario, String nombreLista, String usuarioAsociado) {
        List<String> lineas = new ArrayList<>();
        boolean eliminado = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes[2].equals(usuario) && partes[3].equals(nombreLista) && partes[4].equals(usuarioAsociado)) {
                    partes[7] = "0";  // Cambia el status a 0 (eliminado)
                    linea = String.join("|", partes);
                    eliminado = true;
                }
                lineas.add(linea);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (String l : lineas) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return eliminado;
    }

    private int obtenerUltimoRegistro() {
        int ultimoRegistro = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\\|");
                int registroActual = Integer.parseInt(partes[0]);
                if (registroActual > ultimoRegistro) {
                    ultimoRegistro = registroActual;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ultimoRegistro;
    }

    private double calcularPosicion(String usuario, String nombreLista, String usuarioAsociado) {
        return usuario.hashCode() + nombreLista.hashCode() + usuarioAsociado.hashCode();
    }
    
    

}


