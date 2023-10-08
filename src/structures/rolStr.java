/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package structures;

/**
 *
 * @author jmanc
 */
public class rolStr {
    public enum Rol {
    ADMINISTRADOR(0),
    USUARIO_REGULAR(1),
    GUEST(2);

    private final byte codigo;

    Rol(int codigo) {
        this.codigo = (byte) codigo;
    }

    public byte getCodigo() {
        return this.codigo;
    }

    public static Rol fromCodigo(byte codigo) {
        for (Rol rol : Rol.values()) {
            if (rol.getCodigo() == codigo) {
                return rol;
            }
        }
        throw new IllegalArgumentException("Código de rol no válido: " + codigo);
    }
}

    
    
}
