package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Cliente extends Persona{
    private double CreditoCompra;

    public Cliente(double CreditoCompra, String Nombre, String Telefono, String DPI, String NIT, String Direccion, String Correo) {
        super(Nombre, Telefono, DPI, NIT, Direccion, Correo);
        this.CreditoCompra = CreditoCompra;
    }

    public double getCreditoCompra() {
        return CreditoCompra;
    }

    public void setCreditoCompra(double CreditoCompra) {
        this.CreditoCompra = CreditoCompra;
    }
    
}
