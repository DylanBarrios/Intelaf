package com.intelaf.clases;

/**
 *
 * @author dylan
 */
public class Vendedor extends Persona{
    private int CodEmpleado;
    
    public Vendedor(int CodEmpleado, int DPI, int Telefono, String Nombre,  String Direccion, String Correo) {
        super(DPI, Telefono, Nombre, Direccion, Correo);
        this.CodEmpleado = CodEmpleado;
    }

    public int getCodEmpleado() {
        return CodEmpleado;
    }

    public void setCodEmpleado(int CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }
    
}
