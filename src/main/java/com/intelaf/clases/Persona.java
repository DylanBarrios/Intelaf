package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Persona {
    
    protected String Nombre, Telefono, DPI;
    protected String NIT, Direccion, Correo;

    public Persona(String Nombre, String Telefono, String DPI, String NIT, String Direccion, String Correo) {
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.DPI = DPI;
        this.NIT = NIT;
        this.Direccion = Direccion;
        this.Correo = Correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    
}
