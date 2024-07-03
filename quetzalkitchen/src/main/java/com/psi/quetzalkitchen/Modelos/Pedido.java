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
    
    private ArrayList<ArticuloEnPedido> articulos;
    private double total;
    private Date horaEstimada;
    private String localidad;
    private String direccion;
    private int codPostal;

    public Pedido() {
    }

    public Pedido(ArrayList<ArticuloEnPedido> articulos, double total, Date horaEstimada, String localidad, String direccion, int codPostal) {
        this.articulos = articulos;
        this.total = total;
        this.horaEstimada = horaEstimada;
        this.localidad = localidad;
        this.direccion = direccion;
        this.codPostal = codPostal;
    }

    public ArrayList<ArticuloEnPedido> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<ArticuloEnPedido> articulos) {
        this.articulos = articulos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        return "Pedido{" + "articulos=" + articulos + ", total=" + total + ", horaEstimada=" + horaEstimada + ", localidad=" + localidad + ", direccion=" + direccion + ", codPostal=" + codPostal + '}';
    }
    
    
    
}
