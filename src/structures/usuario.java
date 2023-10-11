/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;
import structures.rolStr;
/**
 *
 * @author jmanc
 */
public class usuario {
      private String usuario;
    private String nombre;
    private String apellido;
    private String password;
private rolStr.Rol rol;
    private String fechaNacimiento;
    private String correoAlterno;
    private int telefono;
    private String pathFotografia;
    private byte estatus;
    
     // Getters
    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

   
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCorreoAlterno() {
        return correoAlterno;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getPathFotografia() {
        return pathFotografia;
    }

    public byte getEstatus() {
        return estatus;
    }
  public rolStr.Rol getRol() {
    return rol;
}
public void setRol(rolStr.Rol rol) {
    this.rol = rol;
}


    // Setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCorreoAlterno(String correoAlterno) {
        this.correoAlterno = correoAlterno;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setPathFotografia(String pathFotografia) {
        this.pathFotografia = pathFotografia;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }
    public String toString() {
    return usuario + "|" + 
           password + "|" + 
           nombre + "|" + 
           apellido + "|" +
           fechaNacimiento + "|" + 
           correoAlterno + "|" + 
           telefono + "|" + 
           pathFotografia + "|" +
           this.getRol().getCodigo() + "|"+
           estatus;
}

}
