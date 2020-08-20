package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Producto {
    
    private int CodigoProducto, Garantia;
    private String Nombre, Fabricante, Descripcion;
    private double precio;

    public Producto(int CodigoProducto, int Garantia, String Nombre, String Fabricante, String Descripcion, double precio) {
        this.CodigoProducto = CodigoProducto;
        this.Garantia = Garantia;
        this.Nombre = Nombre;
        this.Fabricante = Fabricante;
        this.Descripcion = Descripcion;
        this.precio = precio;
    }

    public int getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(int CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public int getGarantia() {
        return Garantia;
    }

    public void setGarantia(int Garantia) {
        this.Garantia = Garantia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
