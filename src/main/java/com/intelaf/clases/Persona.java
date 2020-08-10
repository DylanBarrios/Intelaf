package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Persona {
    
    protected int DPI, Telefono;
    protected String Nombre, Direccion, Correo;

    public Persona(int DPI, int Telefono, String Nombre, String Direccion, String Correo) {
        this.DPI = DPI;
        this.Telefono = Telefono;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Correo = Correo;
    }

    public int getDPI() {
        return DPI;
    }

    public void setDPI(int DPI) {
        this.DPI = DPI;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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
