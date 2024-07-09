/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Plato;
import com.psi.quetzalkitchen.Modelos.PlatoEnPedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
public class PlatosEnPedidoServicio {

    private PlatoEnPedido plato;
    private static ArrayList<PlatoEnPedido> platosParaPedido;

    public PlatosEnPedidoServicio() {

    }

    public double calculaPrecio(Plato plato, int cantidad) {
        return plato.getPrecioUnitario() * cantidad;

    }

    public PlatoEnPedido insertarPlatoEnPedido(PlatoEnPedido plato) {
        PreparedStatement stm;
        try {
            String sql = "INSERT INTO PLATO_EN_PEDIDO (ID_PLATO, CANTIDAD, PRECIO_PLATOS, ID_PEDIDO) VALUES(?,?,?,?)";

            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, plato.getPlato().getId());
            stm.setInt(2, plato.getCantidad());
            stm.setDouble(3, calculaPrecio(plato.getPlato(), plato.getCantidad()));
            stm.setInt(4, plato.getPedido() != null ?  (int) plato.getPedido().getId() : null);
  
            int affectedRows = stm.executeUpdate();

            if (affectedRows > 0) {
                ResultSet result = stm.getGeneratedKeys();
                while(result.next()){
                    plato.setId(result.getInt("INSERT_ID"));
                }
                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return plato;
    }

    public static ArrayList<PlatoEnPedido> getPlatosParaPedido() {
        return platosParaPedido;
    }

    public static void setPlatosParaPedido(ArrayList<PlatoEnPedido> platosParaPedido) {
        PlatosEnPedidoServicio.platosParaPedido = platosParaPedido;
    }
    
    
}
