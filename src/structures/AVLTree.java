package structures;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

public class AVLTree {

    private AVLNode root;
//Actua como un indice en el árbol, donde las claves son los titulos de las pistas
    //Y los valores son los nodos del AVL
    private Map<String, AVLNode> indexPorTitulo;

    public AVLTree() {
        root = null;
        indexPorTitulo = new HashMap<>();
    }

    public AVLNode getRoot() {
        return root;

    }

    // Insertar un nodo
    public void insert(String path, String title, String artist, String band, String legalInformation, String album, String year, String genre, String imagePath, String duration, String lyricsPath) {
        AVLNode newNode = new AVLNode(path, title, artist, band, legalInformation, album, year, genre, imagePath, duration, lyricsPath);
        root = insertRec(root, newNode);
        indexPorTitulo.put(title, newNode);
    }

    private AVLNode insertRec(AVLNode node, AVLNode newNode) {
        /* 1. Realizar la inserción normal de BST */
        if (node == null) {
            return newNode;
        }

        if ((newNode.getTitle() + newNode.getArtist()).compareTo(node.getTitle() + node.getArtist()) < 0) {
            node.setLeft(insertRec(node.getLeft(), newNode));
        } else if ((newNode.getTitle() + newNode.getArtist()).compareTo(node.getTitle() + node.getArtist()) > 0) {
            node.setRight(insertRec(node.getRight(), newNode));
        } else {
            return node;
        }

        /* 2. Actualizar la altura de este nodo ancestro */
        node.setHeight(1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight())));

        /* 3. Obtener el factor de balance de este nodo ancestro para verificar si este nodo se desequilibró */
        int balance = getBalanceFactor(node);

        // Si el nodo se desequilibra, hay 4 casos
        // Caso izquierda izquierda
        if (balance > 1 && (newNode.getTitle() + newNode.getArtist()).compareTo(node.getLeft().getTitle() + node.getLeft().getArtist()) < 0) {
            return rightRotate(node);
        }

        // Caso derecha derecha
        if (balance < -1 && (newNode.getTitle() + newNode.getArtist()).compareTo(node.getRight().getTitle() + node.getRight().getArtist()) > 0) {
            return leftRotate(node);
        }

        // Caso izquierda derecha
        if (balance > 1 && (newNode.getTitle() + newNode.getArtist()).compareTo(node.getLeft().getTitle() + node.getLeft().getArtist()) > 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Caso derecha izquierda
        if (balance < -1 && (newNode.getTitle() + newNode.getArtist()).compareTo(node.getRight().getTitle() + node.getRight().getArtist()) < 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    // Método para eliminar un nodo
    public void delete(String title, String artist) {
        root = deleteNode(root, title, artist);
    }

    private AVLNode deleteNode(AVLNode root, String title, String artist) {
        // Paso 1: Realizar la eliminación estándar de BST
        if (root == null) {
            return root;
        }

        // Si la clave a ser borrada es menor que la clave de la raíz, entonces está en el subárbol izquierdo
        if ((title + artist).compareTo(root.getTitle() + root.getArtist()) < 0) {
            root.setLeft(deleteNode(root.getLeft(), title, artist));
        } // Si la clave a ser borrada es mayor que la clave de la raíz, entonces está en el subárbol derecho
        else if ((title + artist).compareTo(root.getTitle() + root.getArtist()) > 0) {
            root.setRight(deleteNode(root.getRight(), title, artist));
        } else {
            // Nodo con solo un hijo o sin hijo
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                AVLNode temp = null;
                if (temp == root.getLeft()) {
                    temp = root.getRight();
                } else {
                    temp = root.getLeft();
                }

                // Sin hijos
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // Un hijo
                    root = temp; // Copiar los contenidos del hijo no nulo
                }
            } else {
                AVLNode temp = minValueNode(root.getRight());

                // Copiar los datos del sucesor en orden a este nodo
                root.setTitle(temp.getTitle());
                root.setArtist(temp.getArtist());

                // Eliminar el sucesor en orden
                root.setRight(deleteNode(root.getRight(), temp.getTitle(), temp.getArtist()));
            }
        }

        // Si el árbol tenía solo un nodo, entonces devolver
        if (root == null) {
            return root;
        }

        root.setHeight(Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1);

        int balance = getBalanceFactor(root);

        // Si el nodo se desequilibra, hay 4 casos
        // Caso izquierda izquierda
        if (balance > 1 && getBalanceFactor(root.getLeft()) >= 0) {
            return rightRotate(root);
        }

        // Caso izquierda derecha
        if (balance > 1 && getBalanceFactor(root.getLeft()) < 0) {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        // Caso derecha derecha
        if (balance < -1 && getBalanceFactor(root.getRight()) <= 0) {
            return leftRotate(root);
        }

        // Caso derecha izquierda
        if (balance < -1 && getBalanceFactor(root.getRight()) > 0) {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }

    AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;

        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
    }

    // Métodos auxiliares para rotaciones
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();

        // Realizar rotación
        x.setRight(y);
        y.setLeft(T2);

        // Actualizar alturas
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);

        // Devolver nueva raíz
        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode T2 = y.getLeft();

        // Realizar rotación
        y.setLeft(x);
        x.setRight(T2);

        // Actualizar alturas
        x.setHeight(Math.max(getHeight(x.getLeft()), getHeight(x.getRight())) + 1);
        y.setHeight(Math.max(getHeight(y.getLeft()), getHeight(y.getRight())) + 1);

        return y;
    }

    private int getHeight(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    private int getBalanceFactor(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return getHeight(N.getLeft()) - getHeight(N.getRight());
    }

    public AVLNode searchByTitle(String title) {
        return indexPorTitulo.get(title);
    }

    public AVLNode search(String title, String album) {
        List<AVLNode> matches = new ArrayList<>();
        searchSequential(root, title, album, matches);
        return matches.isEmpty() ? null : matches.get(0); // Devuelve el primer resultado o null
    }

    private AVLNode searchRec(AVLNode node, String title, String artista) {
        if (node == null) {
            return null;
        }
//Busqueda por titulo y album devuelve conicidencias si encuentra por titulo o por album. 
        boolean titleMatches = title.isEmpty() || title.equals(node.getTitle());
        boolean albumMatches = artista.isEmpty() || artista.equals(node.getArtist());
        System.out.println("ESTE ES EL ALBUM A BUSCAR: " + artista);
        System.out.println("ESTE ES EL ARTISTA DEL NODO : " + node.getAlbum());

        if (titleMatches && albumMatches) {
            return node;
        }

        String nodeKey = (title.isEmpty() ? "" : node.getTitle()) + (artista.isEmpty() ? "" : node.getArtist());
        String searchKey = (title.isEmpty() ? "" : title) + (artista.isEmpty() ? "" : artista);

        int comparisonResult = searchKey.compareTo(nodeKey);
        if (comparisonResult < 0) {
            return searchRec(node.getLeft(), title, artista);
        } else if (comparisonResult > 0) {
            return searchRec(node.getRight(), title, artista);
        } else {
            return node;
        }
    }

    private void searchSequential(AVLNode node, String title, String album, List<AVLNode> matches) {
        if (node != null) {
            boolean titleMatches = title.isEmpty() || node.getTitle().equalsIgnoreCase(title);
            boolean albumMatches = album.isEmpty() || node.getAlbum().equalsIgnoreCase(album);

            if (titleMatches && albumMatches) {
                matches.add(node);
            }

            searchSequential(node.getLeft(), title, album, matches);
            searchSequential(node.getRight(), title, album, matches);
        }
    }

    // Recorrido In-Order
    public void inOrderTraversal(Consumer<AVLNode> action) {
        inOrderTraversalRec(root, action);
    }

    private void inOrderTraversalRec(AVLNode node, Consumer<AVLNode> action) {
        if (node != null) {
            inOrderTraversalRec(node.getLeft(), action);
            action.accept(node);
            inOrderTraversalRec(node.getRight(), action);
        }
    }

    // Recorrido Pre-Order
    public void preOrderTraversal(Consumer<AVLNode> action) {
        preOrderTraversalRec(root, action);
    }

    private void preOrderTraversalRec(AVLNode node, Consumer<AVLNode> action) {
        if (node != null) {
            action.accept(node);
            preOrderTraversalRec(node.getLeft(), action);
            preOrderTraversalRec(node.getRight(), action);
        }
    }

    public void edit(String originalTitle, String originalArtist, String newPath, String newTitle, String newArtist, String newBand, String newLegalInformation, String newAlbum, String newYear, String newGenre, String newImagePath, String newDuration, String newLyricsPath) {
        // Primero, buscar el nodo que vamos a editar
        AVLNode nodeToEdit = search(originalTitle, originalArtist);

        if (nodeToEdit != null) {
            // Si el título y artista no han cambiado, actualizamos la información directamente
            if (nodeToEdit.getTitle().equals(newTitle) && nodeToEdit.getArtist().equals(newArtist)) {
                updateNodeInfo(nodeToEdit, newPath, newTitle, newArtist, newBand, newLegalInformation, newAlbum, newYear, newGenre, newImagePath, newDuration, newLyricsPath);
            writeToFile();
            } else {
                // Si el título o artista han cambiado, necesitamos eliminar y reinsertar el nodo
                delete(originalTitle, originalArtist);
                insert(newPath, newTitle, newArtist, newBand, newLegalInformation, newAlbum, newYear, newGenre, newImagePath, newDuration, newLyricsPath);
           writeToFile();
            }
        } else {
            System.out.println("Nodo no encontrado para editar");
        }
    }

    private void updateNodeInfo(AVLNode node, String path, String title, String artist, String band, String legalInformation, String album, String year, String genre, String imagePath, String duration, String lyricsPath) {
        node.setPath(path);
        node.setTitle(title);
        node.setArtist(artist);
        node.setBand(band);
        node.setLegalInformation(legalInformation);
        node.setAlbum(album);
        node.setYear(year);
        node.setGenre(genre);
        node.setImagePath(imagePath);
        node.setDuration(duration);
        node.setLyricsPath(lyricsPath);
    }

    // Recorrido Post-Order
    public void postOrderTraversal(Consumer<AVLNode> action) {
        postOrderTraversalRec(root, action);
    }

    private void postOrderTraversalRec(AVLNode node, Consumer<AVLNode> action) {
        if (node != null) {
            postOrderTraversalRec(node.getLeft(), action);
            postOrderTraversalRec(node.getRight(), action);
            action.accept(node);
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
