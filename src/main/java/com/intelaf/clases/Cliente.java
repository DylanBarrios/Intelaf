package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Cliente extends Persona{
    int NIT;
    Double CreditoCompra;
    
    public Cliente(int DPI, int Telefono, String Nombre, String Direccion, String Correo, int NIT, Double CreditoCompra){
        super(DPI, Telefono, Nombre, Direccion, Correo);
        this.NIT = NIT;
        this.CreditoCompra = CreditoCompra;
    }

    public int getNIT() {
        return NIT;
    }

    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public Double getCreditoCompra() {
        return CreditoCompra;
    }

    public void setCreditoCompra(Double CreditoCompra) {
        this.CreditoCompra = CreditoCompra;
    }

}
