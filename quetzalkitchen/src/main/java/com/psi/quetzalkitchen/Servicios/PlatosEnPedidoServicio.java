/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Plato;
import com.psi.quetzalkitchen.Modelos.PlatoEnPedido;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
public class PlatosEnPedidoServicio {

    private PlatoEnPedido plato;

    public PlatosEnPedidoServicio() {

    }

    public double calculaPrecio(Plato plato, int cantidad) {
        return plato.getPrecioUnitario() * cantidad;

    }

    public boolean insertarPlatoEnPedido(PlatoEnPedido plato) {
        PreparedStatement stm;
        try {
            String[] campos = {"ID_PLATO", "CANTIDAD", "PRECIO_PLATOS", "ID_PEDIDO"};

            stm = ConnectDB.con.prepareStatement("INSERT INTO PLATO_EN_PEDIDO", campos);
            stm.setInt(0, plato.getPlato().getId());
            stm.setInt(1, plato.getCantidad());
            stm.setDouble(2, calculaPrecio(plato.getPlato(), plato.getCantidad()));
            stm.setInt(3, plato.getPedido() != null ?  (int) plato.getPedido().getId() : null);
  
            int affectedRows = stm.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
