package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Cliente extends Persona{
    private int CreditoCompra;

    public Cliente(int CreditoCompra, String Nombre, String Telefono, String DPI, String NIT, String Direccion, String Correo) {
        super(Nombre, Telefono, DPI, NIT, Direccion, Correo);
        this.CreditoCompra = CreditoCompra;
    }

    public int getCreditoCompra() {
        return CreditoCompra;
    }

    public void setCreditoCompra(int CreditoCompra) {
        this.CreditoCompra = CreditoCompra;
    }
    
}
