package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Venta {
    private int CodigoVenta, CodigoProducto, Cantidad;
    private double Total, CantidaEfectivo, CantidadCredito;

    public Venta(int CodigoVenta, int CodigoProducto, int Cantidad, double Total, double CantidaEfectivo, double CantidadCredito) {
        this.CodigoVenta = CodigoVenta;
        this.CodigoProducto = CodigoProducto;
        this.Cantidad = Cantidad;
        this.Total = Total;
        this.CantidaEfectivo = CantidaEfectivo;
        this.CantidadCredito = CantidadCredito;
    }

    public int getCodigoVenta() {
        return CodigoVenta;
    }

    public void setCodigoVenta(int CodigoVenta) {
        this.CodigoVenta = CodigoVenta;
    }

    public int getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(int CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
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

    public double getCantidaEfectivo() {
        return CantidaEfectivo;
    }

    public void setCantidaEfectivo(double CantidaEfectivo) {
        this.CantidaEfectivo = CantidaEfectivo;
    }

    public double getCantidadCredito() {
        return CantidadCredito;
    }

    public void setCantidadCredito(double CantidadCredito) {
        this.CantidadCredito = CantidadCredito;
    }
    
    
}
