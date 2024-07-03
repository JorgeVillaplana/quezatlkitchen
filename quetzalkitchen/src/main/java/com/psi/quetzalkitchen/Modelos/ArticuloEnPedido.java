/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Modelos;

/**
 *
 * @author Mañanas
 */
public class ArticuloEnPedido {
    
    private Articulo articulo;
    private int cantidad;
    private double precioArticulos;

    public ArticuloEnPedido() {
    }

    public ArticuloEnPedido(Articulo articulo, int cantidad, double precioArticulos) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precioArticulos = precioArticulos;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioArticulos() {
        return precioArticulos;
    }

    public void setPrecioArticulos(double precioArticulos) {
        this.precioArticulos = precioArticulos;
    }

    @Override
    public String toString() {
        return "ArticuloEnPedido{" + "articulo=" + articulo + ", cantidad=" + cantidad + ", precioArticulos=" + precioArticulos + '}';
    }
        
}
