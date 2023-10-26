/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

/**
 *
 * @author carlo
 */
public class Contactos {
    private String usuario;
    private String contacto;
    private String fecha_transaccion;
    private String usuario_transaccion;
    private int status;
    
    public String getUsuario(){
        return usuario;
    }
    public String getContacto(){
        return contacto;
    }
    public String getFechaTransaccion(){
        return fecha_transaccion;
    }
    public String getUsuarioTransaccion(){
        return usuario_transaccion;
    }
    public int getStatus(){
        return status;
    }
    
    public void setUsuario(String user){
        this.usuario = user;
    }
    public void setContacto(String contact){
        this.contacto =  contact;
    }
    public void setFechaTransaccion(String fecha_transaccion){
        this.fecha_transaccion =  fecha_transaccion;
    }
    public void setUsuarioTransaccion(String usuario_transaccion){
        this.usuario_transaccion =  usuario_transaccion;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public String toString(){
        return usuario +"|"+
        contacto +"|"+ 
        fecha_transaccion + "|"+
        usuario_transaccion +"|"+
        status;
    }
}
