/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Modelos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mañanas
 */
public class Pedido {
    
    private int referencia;
    private ArrayList<PlatoEnPedido> platos;
    private double precioTotal;
    private Date horaEstimada;
    private String localidad;
    private String direccion;
    private int codPostal;

    public Pedido() {
    }

    public Pedido(int referencia, ArrayList<PlatoEnPedido> articulos, double total, Date horaEstimada, String localidad, String direccion, int codPostal) {
        
        this.referencia = referencia;
        this.platos = articulos;
        this.precioTotal = total;
        this.horaEstimada = horaEstimada;
        this.localidad = localidad;
        this.direccion = direccion;
        this.codPostal = codPostal;
        
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public ArrayList<PlatoEnPedido> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<PlatoEnPedido> platos) {
        this.platos = platos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getHoraEstimada() {
        return horaEstimada;
    }

    public void setHoraEstimada(Date horaEstimada) {
        this.horaEstimada = horaEstimada;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    @Override
    public String toString() {
        return "Pedido{" + "referencia=" + referencia + ", platos=" + platos + ", total=" + precioTotal + ", horaEstimada=" + horaEstimada + ", localidad=" + localidad + ", direccion=" + direccion + ", codPostal=" + codPostal + '}';
    }
    
    
    
}
