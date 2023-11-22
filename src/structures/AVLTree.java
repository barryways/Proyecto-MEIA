package structures;
import java.util.function.Consumer;
public class AVLTree {
    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    public AVLNode getRoot() {
        return root;
    }

    // Insertar un nodo
    public void insert(String path, String title, String artist, String band, String legalInformation, String album, String year, String genre, String imagePath, String duration, String lyricsPath) {
        AVLNode newNode = new AVLNode(path, title, artist, band, legalInformation, album, year, genre, imagePath, duration, lyricsPath);
        root = insertRec(root, newNode);
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
        }

        // Si la clave a ser borrada es mayor que la clave de la raíz, entonces está en el subárbol derecho
        else if ((title + artist).compareTo(root.getTitle() + root.getArtist()) > 0) {
            root.setRight(deleteNode(root.getRight(), title, artist));
        }

        else {
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
        if (N == null)
            return 0;
        return N.height;
    }

    private int getBalanceFactor(AVLNode N) {
        if (N == null)
            return 0;
        return getHeight(N.getLeft()) - getHeight(N.getRight());
    }

    public AVLNode search(String title, String album) {
        return searchRec(root, title, album);
    }

 private AVLNode searchRec(AVLNode node, String title, String album) {
    if (node == null) {
        return null;
    }
//Busqueda por titulo y album devuelve conicidencias si encuentra por titulo o por album. 
    boolean titleMatches = title.isEmpty() || title.equals(node.getTitle());
    boolean albumMatches = album.isEmpty() || album.equals(node.getAlbum());
    System.out.println("ESTE ES EL ALBUM A BUSCAR: " +album);
        System.out.println("ESTE ES EL ALBUM DEL NODO : " +node.getAlbum());

    if (titleMatches && albumMatches) {
        return node;
    }

    String nodeKey = (title.isEmpty() ? "" : node.getTitle()) + (album.isEmpty() ? "" : node.getAlbum());
    String searchKey = (title.isEmpty() ? "" : title) + (album.isEmpty() ? "" : album);

    int comparisonResult = searchKey.compareTo(nodeKey);
    if (comparisonResult < 0) {
        return searchRec(node.getLeft(), title, album);
    } else if (comparisonResult > 0) {
        return searchRec(node.getRight(), title, album);
    } else {
        return node;
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
}
