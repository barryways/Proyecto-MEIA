/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

/**
 *
 * @author jmanc
 */
public class SongNode {
    private int no_registro;
    private String path; // Nombre (path completo)
    private String title; // Título
    private String artist; // Artista
    private String band; 
    private String legalInformation; 
    private String album;
    private String year;
    private String genre;
    private String imagePath; // Imagen
    private String duration; // Duración (Opcional)
    private String lyricsPath; // Letra (Opcional)

    SongNode left; // Izq
    SongNode right; // Der

    public SongNode(String path, String title, String artist, String band, String legalInformation, String album, String year, String genre, String imagePath, String duration, String lyricsPath) {
        this.path = path;
        this.title = title;
        this.artist = artist;
        this.band = band; 
        this.legalInformation = legalInformation;
        this.album = album;
        this.year = year;
        this.genre = genre;
        this.imagePath = imagePath;
        this.duration = duration;
        this.lyricsPath = lyricsPath;
        this.left = null;
        this.right = null;
        this.no_registro = 0;
    }

    // Getters y Setters
    public int getNoRegistro(){
        return no_registro;
    }
    public void setNoRegistro(int No_registro){
        this.no_registro = No_registro;
    }
    
    public String getBand(){
        return band; 
    }
    public void setBand(String band){
        this.band = band; 
    }
    public String getLegalInformation(){
        return legalInformation;
    }
    public void setLegalInformation(String legalInformation){
        this.legalInformation = legalInformation; 
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLyricsPath() {
        return lyricsPath;
    }

    public void setLyricsPath(String lyricsPath) {
        this.lyricsPath = lyricsPath;
    }

    public SongNode getLeft() {
        return left;
    }

    public void setLeft(SongNode left) {
        this.left = left;
    }

    public SongNode getRight() {
        return right;
    }

    public void setRight(SongNode right) {
        this.right = right;
    }
}

