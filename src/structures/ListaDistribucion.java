package structures;

import java.util.Date;

/**
 *
 * @author jmanc
 */
public class ListaDistribucion {
    private String nombreLista; 
    private String usuario;
    private String descripcion; 
    private int numeroUsuarios; 
    private Date fechaCreacion; 
    private int estatus; 

    // Getters
    public String getNombreLista() {
        return nombreLista;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNumeroUsuarios() {
        return numeroUsuarios;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public int getEstatus() {
        return estatus;
    }

    // Setters
    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNumeroUsuarios(int numeroUsuarios) {
        this.numeroUsuarios = numeroUsuarios;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
}
