package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Tienda {
    
    private String CodigoTienda, Nombre, Direccion;
    private String Telefono1, Telefono2, Correo, Horario;

    public Tienda(String CodigoTienda, String Nombre, String Direccion, String Telefono1, String Telefono2, String Correo, String Horario) {
        this.CodigoTienda = CodigoTienda;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono1 = Telefono1;
        this.Telefono2 = Telefono2;
        this.Correo = Correo;
        this.Horario = Horario;
    }

    public String getCodigoTienda() {
        return CodigoTienda;
    }

    public void setCodigoTienda(String CodigoTienda) {
        this.CodigoTienda = CodigoTienda;
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

    public String getTelefono1() {
        return Telefono1;
    }

    public void setTelefono1(String Telefono1) {
        this.Telefono1 = Telefono1;
    }

    public String getTelefono2() {
        return Telefono2;
    }

    public void setTelefono2(String Telefono2) {
        this.Telefono2 = Telefono2;
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
