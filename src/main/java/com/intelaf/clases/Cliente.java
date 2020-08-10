package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Cliente extends Persona{
    String NIT;
    int CreditoCompra;
    
    public Cliente(int DPI, int Telefono, String Nombre, String Direccion, String Correo, String NIT, int CreditoCompra){
        super(DPI, Telefono, Nombre, Direccion, Correo);
        this.NIT = NIT;
        this.CreditoCompra = CreditoCompra;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public int getCreditoCompra() {
        return CreditoCompra;
    }

    public void setCreditoCompra(int CreditoCompra) {
        this.CreditoCompra = CreditoCompra;
    }
    
    
    
}
