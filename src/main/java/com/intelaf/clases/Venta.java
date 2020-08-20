package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Venta {
    private int NIT, CodigoVenta, CodigoProducto, Cantidad;
    private double Total, PagoEfectivo, PagoCredito;

    public Venta(int NIT, int CodigoVenta, int CodigoProducto, int Cantidad, double Total, double PagoEfectivo, double PagoCredito) {
        this.NIT = NIT;
        this.CodigoVenta = CodigoVenta;
        this.CodigoProducto = CodigoProducto;
        this.Cantidad = Cantidad;
        this.Total = Total;
        this.PagoEfectivo = PagoEfectivo;
        this.PagoCredito = PagoCredito;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
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

    public double getPagoEfectivo() {
        return PagoEfectivo;
    }

    public void setPagoEfectivo(double PagoEfectivo) {
        this.PagoEfectivo = PagoEfectivo;
    }

    public double getPagoCredito() {
        return PagoCredito;
    }

    public void setPagoCredito(double PagoCredito) {
        this.PagoCredito = PagoCredito;
    }

    
}
