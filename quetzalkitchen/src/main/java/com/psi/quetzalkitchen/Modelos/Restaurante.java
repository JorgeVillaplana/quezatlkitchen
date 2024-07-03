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

    private String nombre;
    private boolean empresaEnvioPropia;

    public Restaurante() {
    }

    public Restaurante(String nombre, boolean empresaEnvioPropia) {
        this.nombre = nombre;
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

    public void setEmpresaEnvioPropia(boolean empresaEnvioPropia) {
        this.empresaEnvioPropia = empresaEnvioPropia;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "nombre=" + nombre + ", empresaEnvioPropia=" + empresaEnvioPropia + '}';
    }


}
