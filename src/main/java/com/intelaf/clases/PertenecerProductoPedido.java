package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class PertenecerProductoPedido {

    private int CodigoPertenecer;
    private String CodigoProducto;
    private String CodigoPedido;
    private Double SubTotal;
    private int cantidadProductos;

    public PertenecerProductoPedido(int CodigoPertenecer, String CodigoProducto, String CodigoPedido, Double SubTotal, int cantidadProductos) {
        this.CodigoPertenecer = CodigoPertenecer;
        this.CodigoProducto = CodigoProducto;
        this.CodigoPedido = CodigoPedido;
        this.SubTotal = SubTotal;
        this.cantidadProductos = cantidadProductos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getCodigoPertenecer() {
        return CodigoPertenecer;
    }

    public void setCodigoPertenecer(int CodigoPertenecer) {
        this.CodigoPertenecer = CodigoPertenecer;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }

    public String getCodigoPedido() {
        return CodigoPedido;
    }

    public void setCodigoPedido(String CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    public Double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(Double SubTotal) {
        this.SubTotal = SubTotal;
    }
    
    
}
