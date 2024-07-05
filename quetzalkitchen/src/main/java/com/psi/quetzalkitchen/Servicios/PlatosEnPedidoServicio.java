/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Modelos.Plato;
import com.psi.quetzalkitchen.Modelos.PlatoEnPedido;

/**
 *
 * @author Mañanas
 */
public class PlatosEnPedidoServicio {
    
    private  PlatoEnPedido plato;
    
    public PlatosEnPedidoServicio(){
        
    }
    
    public PlatoEnPedido calculaPrecio(Plato plato, int cantidad){
        double precioDeTodosLosPlatos = plato.getPrecioUnitario() * cantidad;
        this.plato =  new PlatoEnPedido(plato, cantidad, precioDeTodosLosPlatos);
        return this.plato;
    }
}
