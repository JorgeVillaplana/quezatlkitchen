/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Modelos;

/**
 *
 * @author Mañanas
 */
public class Direccion {
    
    private int id;
    private String localidad;
    private int codigoPostal;
    private String callePortalPiso;

    public Direccion() {
    }

    public Direccion(String localidad, int codigoPostal, String callePortalPiso) {
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.callePortalPiso = callePortalPiso;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCallePortalPiso() {
        return callePortalPiso;
    }

    public void setCallePortalPiso(String callePortalPiso) {
        this.callePortalPiso = callePortalPiso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Direccion{" + "localidad=" + localidad + ", codigoPostal=" + codigoPostal + ", callePortalPiso=" + callePortalPiso + '}';
    }
    
}
