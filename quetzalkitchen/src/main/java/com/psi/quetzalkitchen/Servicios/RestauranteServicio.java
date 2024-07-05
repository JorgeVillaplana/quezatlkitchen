/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Modelos.Plato;
import com.psi.quetzalkitchen.Modelos.Restaurante;
import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class RestauranteServicio {
    
    private ArrayList<Restaurante> restaurantes;

    public RestauranteServicio() {
    }
    
    public ArrayList<Restaurante> obtenerRestaurantes(){
        
        /**
         * TODO: Hacer el método para coger los restaurantes de BD.
         */        
        
        return this.restaurantes;
    }
    
    public Restaurante obtenRestauranteDePlato(Plato plato){
        
        Restaurante restaurante = new Restaurante();
        /**
         * TODO: 
         */
        return restaurante;
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
    
}
