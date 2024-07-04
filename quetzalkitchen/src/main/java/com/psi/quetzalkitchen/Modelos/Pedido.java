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
    private double precioSinDescuento;
    private double precioConDescuento;
    private Date horaEstimada;
    private String localidad;
    private String direccion;
    private int codPostal;
    private Descuento descuento;

    public Pedido() {
    }

    public Pedido(int referencia, ArrayList<PlatoEnPedido> platos, double precioSinDescuento, double precioConDescuento, Date horaEstimada, String localidad, String direccion, int codPostal, Descuento descuento) {
        this.referencia = referencia;
        this.platos = platos;
        this.precioSinDescuento = precioSinDescuento;
        this.precioConDescuento = precioConDescuento;
        this.horaEstimada = horaEstimada;
        this.localidad = localidad;
        this.direccion = direccion;
        this.codPostal = codPostal;
        this.descuento = descuento;
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

    public double getPrecioSinDescuento() {
        return precioSinDescuento;
    }

    public void setPrecioSinDescuento(double precioSinDescuento) {
        this.precioSinDescuento = precioSinDescuento;
    }

    public double getPrecioConDescuento() {
        return precioConDescuento;
    }

    public void setPrecioConDescuento(double precioConDescuento) {
        this.precioConDescuento = precioConDescuento;
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

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Pedido{" + "referencia=" + referencia + ", platos=" + platos + ", precioSinDescuento=" + precioSinDescuento + ", precioConDescuento=" + precioConDescuento + ", horaEstimada=" + horaEstimada + ", localidad=" + localidad + ", direccion=" + direccion + ", codPostal=" + codPostal + ", descuento=" + descuento + '}';
    }

    
    
    
    
}
