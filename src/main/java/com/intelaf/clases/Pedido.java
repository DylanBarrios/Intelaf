package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Pedido {
    private int CodigoPedido, CodigoProducto, CodigoCliente, CodigoTET;
    private int Cantidad; 
    private double Total, Anticipo;
    private String FechaSalida;
    private Boolean Entregado;

    public Pedido(int CodigoPedido, int CodigoProducto, int CodigoCliente, int CodigoTET, Double Anticipo, int Cantidad, double Total, String FechaSalida, Boolean Entregado) {
        this.CodigoPedido = CodigoPedido;
        this.CodigoProducto = CodigoProducto;
        this.CodigoCliente = CodigoCliente;
        this.CodigoTET = CodigoTET;
        this.Anticipo = Anticipo;
        this.Cantidad = Cantidad;
        this.Total = Total;
        this.FechaSalida = FechaSalida;
        this.Entregado = Entregado;
    }

    public int getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(int CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    public int getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(int CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int CodigoCliente) {
        this.CodigoCliente = CodigoCliente;
    }

    public int getCodigoTET() {
        return CodigoTET;
    }

    public void setCodigoTET(int CodigoTET) {
        this.CodigoTET = CodigoTET;
    }

    public Double getAnticipo() {
        return Anticipo;
    }

    public void setAnticipo(Double Anticipo) {
        this.Anticipo = Anticipo;
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

    public String getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(String FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public Boolean getEntregado() {
        return Entregado;
    }

    public void setEntregado(Boolean Entregado) {
        this.Entregado = Entregado;
    }

    
}
