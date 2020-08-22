package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Producto {
    
    private int Garantia;
    private String CodigoProducto, Nombre, Fabricante, Descripcion;
    private double precio;

    public Producto(String CodigoProducto, int Garantia, String Nombre, String Fabricante, String Descripcion, double precio) {
        this.CodigoProducto = CodigoProducto;
        this.Garantia = Garantia;
        this.Nombre = Nombre;
        this.Fabricante = Fabricante;
        this.Descripcion = Descripcion;
        this.precio = precio;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
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
