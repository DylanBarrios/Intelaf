package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Persona {
    private String NIT, Nombre, Telefono;
    private String DPI, Direccion, Correo;
    private double Credito;

    public Persona(String NIT, String Nombre, String Telefono, String DPI, String Direccion, String Correo, double Credito) {
        this.NIT = NIT;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.DPI = DPI;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Credito = Credito;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
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

    public double getCredito() {
        return Credito;
    }

    public void setCredito(double Credito) {
        this.Credito = Credito;
    }
    
    
    
}
