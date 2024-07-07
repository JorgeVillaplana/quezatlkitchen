/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Modelos;

/**
 *
 * @author Mañanas
 */
public class Restaurante {

    private int id;
    private String nombre;
    private boolean empresaEnvioPropia;
    private Direccion direccion;

    public Restaurante() {
    }

    public Restaurante(String nombre, boolean empresaEnvioPropia, Direccion direccion) {
        this.nombre = nombre;
        this.empresaEnvioPropia = empresaEnvioPropia;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEmpresaEnvioPropia() {
        return empresaEnvioPropia;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setEmpresaEnvioPropia(boolean empresaEnvioPropia) {
        this.empresaEnvioPropia = empresaEnvioPropia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "nombre=" + nombre + ", empresaEnvioPropia=" + empresaEnvioPropia + ", direccion=" + direccion + '}';
    }

  
}
