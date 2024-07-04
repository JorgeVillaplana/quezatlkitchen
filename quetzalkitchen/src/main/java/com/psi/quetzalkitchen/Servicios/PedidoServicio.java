/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Modelos.Descuento;
import com.psi.quetzalkitchen.Modelos.Pedido;

/**
 *
 * @author Mañanas
 */
public class PedidoServicio {
    
    private Pedido pedido;
    private Descuento descuento;
    
    
    public void ponPrecioConDescuento(String codigoDescuento){
        
        /**
         * TODO: crear el código que coja el precio sin descuento del pedido,
         * y con el código que recibe que lo compare con el que trae el objeto descuento
         * Si funciona, se calcula el precio con descuento del pedido usando el porcentaje
         * que tiene el objeto descuento, si no se iguala al precio sin descuento.
         */
  if (codigoDescuento==descuento.getCodigo()){
      pedido.setPrecioConDescuento(pedido.getPrecioSinDescuento()-pedido.getPrecioSinDescuento() * descuento.getPorcentaje());
      pedido.setDescuento(descuento);
  }else{
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
