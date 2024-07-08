/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Descuento;
import com.psi.quetzalkitchen.Modelos.Pedido;
import com.psi.quetzalkitchen.Modelos.PlatoEnPedido;
import com.psi.quetzalkitchen.Modelos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
public class PedidoServicio {

    private ArrayList<PlatoEnPedido> platosEnPedido;
    private Pedido pedido;
    private Descuento descuento;
    private Usuario usuario;

    public PedidoServicio() {
    }
    
    public void crearNuevoPedido(Usuario usuario){
        pedido = new Pedido();
        if(!platosEnPedido.isEmpty()){
            pedido.setPlatos(platosEnPedido);
        }
        
        PreparedStatement stm;
        try {
            String[] campos = {"ID_USUARIO","PRECIO_SIN_DESCUENTO"};
            stm = ConnectDB.con.prepareStatement("INSERT INTO PEDIDO", campos);
//            stm.setString(0, );
//
//            while (result.next()) {
//
//                plato.setId(result.getInt("ID"));
//                plato.setNombre(result.getString("NOMBRE"));
//                plato.setPrecioUnitario(result.getDouble("PRECIO_UNITARIO"));
//                plato.setAlergenos(aleServ.getAlergenosByPlato(plato));
//                
//            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
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
