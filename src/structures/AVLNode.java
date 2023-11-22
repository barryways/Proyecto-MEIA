package structures;

public class AVLNode extends SongNode {
    int height; // Altura del nodo, necesaria para el balanceo del árbol AVL
    private int no_registro = 0;
    
    // Constructor
    public AVLNode(String path, String title, String artist, String band, String legalInformation, String album, String year, String genre, String imagePath, String duration, String lyricsPath) {
        super(path, title, artist, band, legalInformation, album, year, genre, imagePath, duration, lyricsPath);
        this.no_registro = 0;
        this.height = 1; // Inicializar la altura como 1 para un nuevo nodo (hoja)
    }
        // Getters y Setters
    public int getNoRegistro(){
        return no_registro;
    }
    public void setNoRegistro(int No_registro){
        this.no_registro = No_registro;
    }

    // Getters y Setters
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public AVLNode getLeft() {
        return (AVLNode) super.getLeft();
    }

    @Override
    public void setLeft(SongNode left) {
        super.setLeft(left);
    }

    @Override
    public AVLNode getRight() {
        return (AVLNode) super.getRight();
    }

    @Override
    public void setRight(SongNode right) {
        super.setRight(right);
    }
}
