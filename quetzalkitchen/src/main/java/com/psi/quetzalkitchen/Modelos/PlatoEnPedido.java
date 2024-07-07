/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Modelos;

/**
 *
 * @author Mañanas
 */
public class PlatoEnPedido {
    
    private int id;
    private Plato plato;
    private int cantidad;
    private double precioPlatos;

    public PlatoEnPedido() {
    }

    public PlatoEnPedido(Plato plato, int cantidad, double precioArticulos) {
        this.plato = plato;
        this.cantidad = cantidad;
        this.precioPlatos = precioArticulos;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioPlatos() {
        return precioPlatos;
    }

    public void setPrecioPlatos(double precioPlatos) {
        this.precioPlatos = precioPlatos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ArticuloEnPedido{" + "plato=" + plato + ", cantidad=" + cantidad + ", precioPlatos=" + precioPlatos + '}';
    }
        
}
