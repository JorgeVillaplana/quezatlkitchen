/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Modelos;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class Plato {
    
    private String nombre;
    private String referencia;
    private double precioUnitario;
    private Restaurante restaurante;
    private ArrayList<Alergeno> alergenos;

    public Plato() {
    }

    public Plato(String nombre, String referencia, double precioUnitario, Restaurante restaurante, ArrayList<Alergeno> alergenos) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.precioUnitario = precioUnitario;
        this.restaurante = restaurante;
        this.alergenos = alergenos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public ArrayList<Alergeno> getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(ArrayList<Alergeno> alergenos) {
        this.alergenos = alergenos;
    }

    @Override
    public String toString() {
        return "Articulo{" + "nombre=" + nombre + ", referencia=" + referencia + ", precioUnitario=" + precioUnitario + ", restaurante=" + restaurante + ", alergenos=" + alergenos + '}';
    }
    
}
