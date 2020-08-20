package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Producto {
    
    private int  Cantidad;
    private String Nombre, Fabricante, Descripcion, CodigoTienda, CodigoProducto;
    private double Precio;
    private int Garantia;

    public Producto(String CodigoTienda, String CodigoProducto, int Cantidad, String Nombre, String Fabricante, String Descripcion, double Precio, int Garantia) {
        this.CodigoTienda = CodigoTienda;
        this.CodigoProducto = CodigoProducto;
        this.Cantidad = Cantidad;
        this.Nombre = Nombre;
        this.Fabricante = Fabricante;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
        this.Garantia = Garantia;
    }

    public String getCodgioTienda() {
        return CodigoTienda;
    }

    public void setCodgioTienda(String CodgioTienda) {
        this.CodigoTienda = CodgioTienda;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
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
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int isGarantia() {
        return Garantia;
    }

    public void setGarantia(int Garantia) {
        this.Garantia = Garantia;
    }
    
    
}
