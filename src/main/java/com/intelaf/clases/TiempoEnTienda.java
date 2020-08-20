package com.intelaf.clases;

public class TiempoEnTienda {
    int CodigoTET, TiempoET;
    String TiendaOrigen, TiendaDestino;

    public TiempoEnTienda(int CodigoTET, int TiempoET, String TiendaOrigen, String TiendaDestino) {
        this.CodigoTET = CodigoTET;
        this.TiempoET = TiempoET;
        this.TiendaOrigen = TiendaOrigen;
        this.TiendaDestino = TiendaDestino;
    }

    public int getCodigoTET() {
        return CodigoTET;
    }

    public void setCodigoTET(int CodigoTET) {
        this.CodigoTET = CodigoTET;
    }

    public int getTiempoET() {
        return TiempoET;
    }

    public void setTiempoET(int TiempoET) {
        this.TiempoET = TiempoET;
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
    
    
}
