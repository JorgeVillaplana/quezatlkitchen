/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Modelos.Plato;
import com.psi.quetzalkitchen.Modelos.PlatoEnPedido;
import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class CatalogoServicio {

    private ArrayList<Plato> platos;
    private ArrayList<PlatoEnPedido> platosEnPedido;

    public CatalogoServicio() {
    }

    public ArrayList<Plato> getAllPlatos() {
        /**
         * TODO: Obtener platos de la BBDD.
         */
        return this.platos;
    }

    public void setPlatosEnPedido(ArrayList<Plato> platos, ArrayList<Integer> cantidades) {
        PlatosEnPedidoServicio platPedSer = new PlatosEnPedidoServicio();

        if (platos.size() == cantidades.size()) {
            for (int i = 0; i < platos.size(); i++) {
                platosEnPedido.add(platPedSer.calculaPrecio(platos.get(i), cantidades.get(i)));
            }
        }
        
        /**
         * TODO: Mandar a base de datos platosEnPedido, creando primero el pedido.
         */
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public ArrayList<PlatoEnPedido> getPlatosEnPedido() {
        return platosEnPedido;
    }

    public void setPlatosEnPedido(ArrayList<PlatoEnPedido> platosEnPedido) {
        this.platosEnPedido = platosEnPedido;
    }

}