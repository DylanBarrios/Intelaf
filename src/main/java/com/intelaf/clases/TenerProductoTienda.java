package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class TenerProductoTienda {
    private int idTener;
    private int Cantidad;
    private String CodigoProducto;
    private String CodigoTienda;

    public TenerProductoTienda(int idTener, int Cantidad, String CodigoProducto, String CodigoTienda) {
        this.idTener = idTener;
        this.Cantidad = Cantidad;
        this.CodigoProducto = CodigoProducto;
        this.CodigoTienda = CodigoTienda;
    }

    public String getCodigoTienda() {
        return CodigoTienda;
    }

    public void setCodigoTienda(String CodigoTienda) {
        this.CodigoTienda = CodigoTienda;
    }

    public int getIdTener() {
        return idTener;
    }

    public void setIdTener(int idTener) {
        this.idTener = idTener;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(String CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
    }
    
}
