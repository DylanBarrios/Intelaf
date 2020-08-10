package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Tienda {
    
    private int CodigoTienda, Telefono1, Telefono2;
    private String Nombre, Direccion, Correo, Horario;

    public Tienda(int CodigoTienda, int Telefono1, int Telefono2, String Nombre, String Direccion, String Correo, String Horario) {
        this.CodigoTienda = CodigoTienda;
        this.Telefono1 = Telefono1;
        this.Telefono2 = Telefono2;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Horario = Horario;
    }

    public int getCodigoTienda() {
        return CodigoTienda;
    }

    public void setCodigoTienda(int CodigoTienda) {
        this.CodigoTienda = CodigoTienda;
    }

    public int getTelefono1() {
        return Telefono1;
    }

    public void setTelefono1(int Telefono1) {
        this.Telefono1 = Telefono1;
    }

    public int getTelefono2() {
        return Telefono2;
    }

    public void setTelefono2(int Telefono2) {
        this.Telefono2 = Telefono2;
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

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }
    
    
}
