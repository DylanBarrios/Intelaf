package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Venta {
    private String CodigoProducto, CodigoVendedor;
    private String FechaRealizada, NIT;
    private int CodigoVenta, Cantidad;
    private double Total;

    public Venta(String CodigoProducto, String CodigoVendedor, String FechaRealizada, String NIT, int CodigoVenta, int Cantidad, double Total) {
        this.CodigoProducto = CodigoProducto;
        this.CodigoVendedor = CodigoVendedor;
        this.FechaRealizada = FechaRealizada;
        this.NIT = NIT;
        this.CodigoVenta = CodigoVenta;
        this.Cantidad = Cantidad;
        this.Total = Total;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getCodigoVendedor() {
        return CodigoVendedor;
    }

    public void setCodigoVendedor(String CodigoVendedor) {
        this.CodigoVendedor = CodigoVendedor;
    }

    public String getFechaRealizada() {
        return FechaRealizada;
    }

    public void setFechaRealizada(String FechaRealizada) {
        this.FechaRealizada = FechaRealizada;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public int getCodigoVenta() {
        return CodigoVenta;
    }

    public void setCodigoVenta(int CodigoVenta) {
        this.CodigoVenta = CodigoVenta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    
}
