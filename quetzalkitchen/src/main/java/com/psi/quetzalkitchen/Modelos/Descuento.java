/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Modelos;

/**
 *
 * @author Mañanas
 */
public class Descuento {
    
    private String codigo;
    private int porcentaje;

    public Descuento() {
    }

    public Descuento(String codigo, int porcentaje) {
        this.codigo = codigo;
        this.porcentaje = porcentaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Descuento{" + "codigo=" + codigo + ", porcentaje=" + porcentaje + '}';
    }
    
}
