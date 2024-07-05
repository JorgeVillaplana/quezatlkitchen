/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Modelos.Descuento;
import com.psi.quetzalkitchen.Modelos.Pedido;
import com.psi.quetzalkitchen.Modelos.PlatoEnPedido;
import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class PedidoServicio {

    private ArrayList<PlatoEnPedido> platosEnPedido;
    private Pedido pedido;
    private Descuento descuento;

    public PedidoServicio() {
    }
    
    public void crearNuevoPedido(){
        pedido = new Pedido();
        if(!platosEnPedido.isEmpty()){
            pedido.setPlatos(platosEnPedido);
        }
        
        /**
         * TODO: Mandar el pedido a BBDD.
         */
    }
    
    public void calcularPrecioTotal(){
        
    }

    public void ponPrecioConDescuento(String codigoDescuento) {

        if (codigoDescuento.equals(descuento.getCodigo())) {
            pedido.setPrecioConDescuento(pedido.getPrecioSinDescuento() - pedido.getPrecioSinDescuento() * descuento.getPorcentaje());
            pedido.setDescuento(descuento);
        } else {
            pedido.setPrecioSinDescuento(pedido.getPrecioSinDescuento());
        }

    }

    @Override
    public String toString() {
        return "PedidoServicio{" + "pedido=" + pedido + ", descuento=" + descuento + '}';
    }

    public PedidoServicio(Pedido pedido, Descuento descuento) {
        this.pedido = pedido;
        this.descuento = descuento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }
}
