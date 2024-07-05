/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Modelos.Plato;
import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class PlatoServicio {

    public PlatoServicio() {
    }
    
    
    public Plato getPlato(int id){
        Plato plato = new Plato();
        /**
         * TODO: Obtener un plato de la BBDD por su id.
         */
        return plato;
    }
    
    public ArrayList<Plato> getAllPlatos(){
        ArrayList<Plato> platos = new ArrayList<Plato>();
        /**
         * TODO: Coger de BBDD todos los platos de la tabla.
         */
        return platos;
    }
}
