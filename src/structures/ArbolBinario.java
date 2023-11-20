/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import structures.SongNode;

/**
 *
 * @author jmanc
 */
public class ArbolBinario {

    private SongNode root;
    private int registroActual = 1;

    public ArbolBinario() {
        root = null;
    }

    public SongNode getRoot() {
        return root;
    }

    public void setRoot(SongNode root) {
        this.root = root;
    }

    public void insert(String path, String title, String artist, String band, String legalInformation, String album, String year, String genre, String imagePath, String duration, String lyricsPath) {

        SongNode newNode = new SongNode(path, title, artist, band, legalInformation, album, year, genre, imagePath, duration, lyricsPath);
        newNode.setNoRegistro(registroActual++);
        if (root == null) {
            root = newNode;
        } else {
            insertRec(root, newNode);
        }
    }

    private void insertRec(SongNode current, SongNode newNode) {
        if ((newNode.getTitle() + newNode.getArtist()).compareTo(current.getTitle() + current.getArtist()) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                insertRec(current.getLeft(), newNode);
            }
        } else if ((newNode.getTitle() + newNode.getArtist()).compareTo(current.getTitle() + current.getArtist()) > 0) {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
                insertRec(current.getRight(), newNode);
            }
        }
    }

    public SongNode search(String title, String artist) {
        return searchRec(root, title, artist);
    }

    private SongNode searchRec(SongNode current, String title, String artist) {
        if (current == null) {
            return null;
        }
        if (title.equals(current.getTitle()) && artist.equals(current.getArtist())) {
            return current;
        }
        return (title + artist).compareTo(current.getTitle() + current.getArtist()) < 0
                ? searchRec(current.getLeft(), title, artist)
                : searchRec(current.getRight(), title, artist);
    }

    public void delete(String title, String artist) {
        root = deleteRec(root, title, artist);
    }

    public void edit(String originalTitle, String originalArtist, String newPath, String newTitle, String newArtist, String newBand, String newLegalInformation, String newAlbum, String newYear, String newGenre, String newImagePath, String newDuration, String newLyricsPath) {
        SongNode nodeToEdit = search(originalTitle, originalArtist);
        if (nodeToEdit != null) {
            // Actualizar los atributos del nodo
            nodeToEdit.setPath(newPath);
            nodeToEdit.setTitle(newTitle);
            nodeToEdit.setArtist(newArtist);
            nodeToEdit.setBand(newBand);
            nodeToEdit.setLegalInformation(newLegalInformation);
            nodeToEdit.setAlbum(newAlbum);
            nodeToEdit.setYear(newYear);
            nodeToEdit.setGenre(newGenre);
            nodeToEdit.setImagePath(newImagePath);
            nodeToEdit.setDuration(newDuration);
            nodeToEdit.setLyricsPath(newLyricsPath);
            System.out.println("Se logro realizar la edicion.");
            this.writeToFile();
        } else {
            System.out.println("Canción no encontrada en el árbol.");
        }

    }

    private SongNode deleteRec(SongNode current, String title, String artist) {
        if (current == null) {
            return null;
        }

        if (title.equals(current.getTitle()) && artist.equals(current.getArtist())) {
            // Nodo con solo un hijo o sin hijos
            if (current.getLeft() == null) {
                return current.getRight();
            } else if (current.getRight() == null) {
                return current.getLeft();
            }

            // Nodo con dos hijos: Obtener el sucesor (el menor en el subárbol derecho)
            current.setTitle(findSmallestValue(current.getRight()).getTitle());
            current.setArtist(findSmallestValue(current.getRight()).getArtist());
            // Eliminar el sucesor
            current.setRight(deleteRec(current.getRight(), current.getTitle(), current.getArtist()));
            return current;
        }
        if ((title + artist).compareTo(current.getTitle() + current.getArtist()) < 0) {
            current.setLeft(deleteRec(current.getLeft(), title, artist));
            return current;
        }
        current.setRight(deleteRec(current.getRight(), title, artist));
        return current;
    }

    private SongNode findSmallestValue(SongNode root) {
        return root.getLeft() == null ? root : findSmallestValue(root.getLeft());
    }

    public void inOrderTraversal(Consumer<SongNode> action) {
        inOrderTraversalRec(root, action);
    }

    private void inOrderTraversalRec(SongNode node, Consumer<SongNode> action) {
        if (node != null) {
            inOrderTraversalRec(node.getLeft(), action);
            action.accept(node);
            inOrderTraversalRec(node.getRight(), action);
        }
    }

    public void writeToFile() {
        String filePath = "C:\\MEIA\\binario.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            inOrderTraversal(node -> {
                try {
                    // Escribe los datos del nodo en el archivo
                    writer.write(node.getNoRegistro() + "|"
                            + (node.getRight() != null ? node.getRight().getNoRegistro() : "-1") + "|"
                            + (node.getLeft() != null ? node.getLeft().getNoRegistro() : "-1") + "|"
                            + node.getPath() + "|"
                            + node.getTitle() + "|"
                            + node.getArtist() + "|"
                            + node.getBand() + "|"
                            + node.getLegalInformation() + "|"
                            + node.getAlbum() + "|"
                            + node.getYear() + "|"
                            + node.getGenre() + "|"
                            + node.getImagePath() + "|"
                            + node.getDuration() + "|"
                            + node.getLyricsPath());
                    writer.newLine();
                    String nombreGenerico = node.getArtist() + "-" + node.getTitle();
                    if (node.getImagePath() != "") {
                        this.copiarImagen(node.getImagePath(), nombreGenerico);
                    } else {
                        this.copiarImagen("C:\\MEIA\\imagenes\\NoImagen.jpg", nombreGenerico);
                    }
                    if (node.getLyricsPath() != "") {
                        this.copiarLetras(node.getImagePath(), nombreGenerico);
                    } else {
                        this.copiarLetras("C:\\MEIA\\lyrics\\NoLetra.txt", nombreGenerico);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copiarImagen(String rutaOriginal, String nombreCopia) {
        try {
            String carpetaDestino = "C:\\MEIA\\imagenes\\";
            // Lee la imagen original
            BufferedImage imagenOriginal = ImageIO.read(new File(rutaOriginal));

            // Asegúrate de que la carpeta de destino exista, si no, créala
            File carpetaDestinoFile = new File(carpetaDestino);
            if (!carpetaDestinoFile.exists()) {
                carpetaDestinoFile.mkdirs();
            }

            // Obtiene la extensión del archivo de la imagen original
            String extension = obtenerExtension(rutaOriginal);

            // Crea la ruta completa para la copia
            String rutaCopia = carpetaDestino + nombreCopia + "-copia" + "." + extension;

            // Escribe la copia en la carpeta de destino
            ImageIO.write(imagenOriginal, extension, new File(rutaCopia));

            System.out.println("Imagen copiada con éxito en: " + rutaCopia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copiarLetras(String rutaOriginal, String nombreCopia) {
        try {
            String carpetaDestino = "C:\\MEIA\\lyrics\\";
            // Asegúrate de que la carpeta de destino exista, si no, créala
            File carpetaDestinoFile = new File(carpetaDestino);
            if (!carpetaDestinoFile.exists()) {
                carpetaDestinoFile.mkdirs();
            }

            // Crea la ruta completa para la copia
            String rutaCopia = carpetaDestino + nombreCopia + "-copia";

            // Usa la clase Files para copiar el archivo
            Path rutaOriginalPath = new File(rutaOriginal).toPath();
            Path rutaCopiaPath = new File(rutaCopia).toPath();

            Files.copy(rutaOriginalPath, rutaCopiaPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Archivo copiado con éxito en: " + rutaCopia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener la extensión del archivo a partir de la ruta
    private static String obtenerExtension(String rutaArchivo) {
        int index = rutaArchivo.lastIndexOf('.');
        if (index > 0 && index < rutaArchivo.length() - 1) {
            return rutaArchivo.substring(index + 1).toLowerCase();
        }
        return "";
    }

}
