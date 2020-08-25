package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Pedido {
    private String CodigoPedido, FechaSalida, CodigoVendedor, NIT;
    private int CodigoTet;
    private double Anticipo;
    private boolean Retrasado, Entregado, Recibido;

    public Pedido(String CodigoPedido, String FechaSalida, String CodigoVendedor, String NIT, int CodigoTet, double Anticipo, boolean Retrasado, boolean Entregado, boolean Recibido) {
        this.CodigoPedido = CodigoPedido;
        this.FechaSalida = FechaSalida;
        this.CodigoVendedor = CodigoVendedor;
        this.NIT = NIT;
        this.CodigoTet = CodigoTet;
        this.Anticipo = Anticipo;
        this.Retrasado = Retrasado;
        this.Entregado = Entregado;
        this.Recibido = Recibido;
    }

    public String getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(String CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    public String getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(String FechaSalida) {
        this.FechaSalida = FechaSalida;
    }

    public String getCodigoVendedor() {
        return CodigoVendedor;
    }

    public void setCodigoVendedor(String CodigoVendedor) {
        this.CodigoVendedor = CodigoVendedor;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public int getCodigoTet() {
        return CodigoTet;
    }

    public void setCodigoTet(int CodigoTet) {
        this.CodigoTet = CodigoTet;
    }

    public double getAnticipo() {
        return Anticipo;
    }

    public void setAnticipo(double Anticipo) {
        this.Anticipo = Anticipo;
    }

    public boolean isRetrasado() {
        return Retrasado;
    }

    public void setRetrasado(boolean Retrasado) {
        this.Retrasado = Retrasado;
    }

    public boolean isEntregado() {
        return Entregado;
    }

    public void setEntregado(boolean Entregado) {
        this.Entregado = Entregado;
    }

    public boolean isRecibido() {
        return Recibido;
    }

    public void setRecibido(boolean Recibido) {
        this.Recibido = Recibido;
    }
    
    
}
