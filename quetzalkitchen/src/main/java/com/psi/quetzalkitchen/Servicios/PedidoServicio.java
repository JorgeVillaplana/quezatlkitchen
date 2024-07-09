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
import com.psi.quetzalkitchen.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        this.pedido = Session.getPedido();
        this.usuario = Session.getUsuario();
    }
    
    public void crearNuevoPedido() {
        pedido = Session.getPedido();
        
        PreparedStatement stm;
        try {
            String sql = "INSERT INTO PEDIDO (ID_USUARIO, PRECIO_SIN_DESCUENTO) VALUES (?,?)";
            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, this.usuario.getId());
            stm.setDouble(2, this.calcularPrecioTotal(pedido));
            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                ResultSet result = stm.getGeneratedKeys();
                
                while (result.next()) {
                    
                    this.pedido.setId(result.getInt("ID"));
                    if (!this.pedido.getPlatos().isEmpty()) {
                        for (PlatoEnPedido plato : this.pedido.getPlatos()) {
                            if (plato.getPedido() == null) {
                                plato.setPedido(this.pedido);
                            }
                            PlatosEnPedidoServicio platoPedServ = new PlatosEnPedidoServicio();
                            platoPedServ.insertarPlatoEnPedido(plato);
                        }
                    }
                }
            }
            Session.setPedido(this.pedido);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
    public double calcularPrecioTotal(Pedido pedido) {
        double sumatorio = 0.0;
        
        for (PlatoEnPedido plato : pedido.getPlatos()) {
            sumatorio += plato.getPrecioPlatos();
        }
        
        pedido.setPrecioSinDescuento(sumatorio);
        return sumatorio;
    }
    
    public Pedido ponPrecioConDescuento(String codigoDescuento) {
        DescuentoServicio descuentoServicio = new DescuentoServicio();
        this.descuento = descuentoServicio.getDescuentoByCodigo(codigoDescuento);
        
        pedido.setPrecioConDescuento(pedido.getPrecioSinDescuento() - pedido.getPrecioSinDescuento() * (((double) descuento.getPorcentaje()) / 100));
        pedido.setDescuento(descuento);
        return pedido;
    }
    
    public ArrayList<PlatoEnPedido> getPlatosEnPedido() {
        return platosEnPedido;
    }
    
    public void setPlatosEnPedido(ArrayList<PlatoEnPedido> platosEnPedido) {
        this.platosEnPedido = platosEnPedido;
    }
    
    public void insertPlatosEnPedido() {
        PlatosEnPedidoServicio platoPedServ = new PlatosEnPedidoServicio();
        
        for (PlatoEnPedido plato : this.platosEnPedido) {
            plato.setPedido(this.pedido);
            
            platoPedServ.insertarPlatoEnPedido(plato);
        }
    }
    
    public Pedido actualizaDireccionPedido(Pedido pedido) {
        if (pedido.getDireccion() != null) {
            PreparedStatement stm;
            try {
                String sql = "UPDATE PEDIDO SET ID_DIRECCION = ? WHERE ID = " + pedido.getId();
                stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setInt(1, pedido.getDireccion().getId());
                
                int affectedRows = stm.executeUpdate();
                if (affectedRows >= 1) {
                    return pedido;
                }
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
        return pedido;
    }
}
