package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Pedido {
    private int CodigoPedido, Cantidad;
    private String TiendaOrigen, TiendaDestino;
    private String Cliente, Articulo, Fecha;

    public Pedido(int CodigoPedido, int Cantidad, String TiendaOrigen, String TiendaDestino, String Cliente, String Articulo, String Fecha) {
        this.CodigoPedido = CodigoPedido;
        this.Cantidad = Cantidad;
        this.TiendaOrigen = TiendaOrigen;
        this.TiendaDestino = TiendaDestino;
        this.Cliente = Cliente;
        this.Articulo = Articulo;
        this.Fecha = Fecha;
    }

    public int getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(int CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getTiendaOrigen() {
        return TiendaOrigen;
    }

    public void setTiendaOrigen(String TiendaOrigen) {
        this.TiendaOrigen = TiendaOrigen;
    }

    public String getTiendaDestino() {
        return TiendaDestino;
    }

    public void setTiendaDestino(String TiendaDestino) {
        this.TiendaDestino = TiendaDestino;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String Articulo) {
        this.Articulo = Articulo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
