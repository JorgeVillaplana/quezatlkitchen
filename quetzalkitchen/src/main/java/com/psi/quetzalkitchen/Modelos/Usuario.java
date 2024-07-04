/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Modelos;

import java.util.Date;

/**
 *
 * @author Mañanas
 */
public class Usuario {
    
    private String DNI;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String localidad;
    private String dirección;
    private int codPostal;
    private Date fechaNac;
    private int edad;
    private String email;

    public Usuario() {
    }

    public Usuario(String DNI, String nombre, String apellido1, String apellido2, String localidad, String dirección, int codPostal, Date fechaNac, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.localidad = localidad;
        this.dirección = dirección;
        this.codPostal = codPostal;
        this.fechaNac = fechaNac;
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", localidad=" + localidad + ", direcci\u00f3n=" + dirección + ", codPostal=" + codPostal + ", fechaNac=" + fechaNac + ", edad=" + edad + ", email=" + email + '}';
    }
    
}
