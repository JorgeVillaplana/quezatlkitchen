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

    private int id;
    private ArrayList<PlatoEnPedido> platos;
    private double precioSinDescuento;
    private double precioConDescuento;
    private Date horaEstimada;
    private Direccion direccion;
    private Descuento descuento;
    private Usuario usuario;

    public Pedido() {
    }

    public Pedido(int id, ArrayList<PlatoEnPedido> platos, double precioSinDescuento, double precioConDescuento, Date horaEstimada, Direccion direccion, Descuento descuento) {
        this.id = id;
        this.platos = platos;
        this.precioSinDescuento = precioSinDescuento;
        this.precioConDescuento = precioConDescuento;
        this.horaEstimada = horaEstimada;
        this.direccion = direccion;
        this.descuento = descuento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", platos=" + platos + ", precioSinDescuento=" + precioSinDescuento + ", precioConDescuento=" + precioConDescuento + ", horaEstimada=" + horaEstimada + ", direccion=" + direccion + ", descuento=" + descuento + ", usuario=" + usuario + '}';
    }

    

}
