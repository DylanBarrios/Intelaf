package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class TiempoEntreTiendas {
    int CodigoTET;
    String CodTiendaOrigen, CodTiendaDestino;
    int TiempoET;

    public TiempoEntreTiendas(int CodigoTET, String CodTiendaOrigen, String CodTiendaDestino, int TiempoET) {
        this.CodigoTET = CodigoTET;
        this.CodTiendaOrigen = CodTiendaOrigen;
        this.CodTiendaDestino = CodTiendaDestino;
        this.TiempoET = TiempoET;
    }

    public int getCodigoTET() {
        return CodigoTET;
    }

    public void setCodigoTET(int CodigoTET) {
        this.CodigoTET = CodigoTET;
    }

    public String getCodTiendaOrigen() {
        return CodTiendaOrigen;
    }

    public void setCodTiendaOrigen(String CodTiendaOrigen) {
        this.CodTiendaOrigen = CodTiendaOrigen;
    }

    public String getCodTiendaDestino() {
        return CodTiendaDestino;
    }

    public void setCodTiendaDestino(String CodTiendaDestino) {
        this.CodTiendaDestino = CodTiendaDestino;
    }

    public int getTiempoET() {
        return TiempoET;
    }

    public void setTiempoET(int TiempoET) {
        this.TiempoET = TiempoET;
    }
    
    
}
