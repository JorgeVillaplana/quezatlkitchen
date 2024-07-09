/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Plato;
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
public class PlatoServicio {

    public PlatoServicio() {
    }

    public Plato getPlatoById(int id) {
        Plato plato = new Plato();
        AlergenoServicio aleServ = new AlergenoServicio();
        RestauranteServicio resServ = new RestauranteServicio();
        PreparedStatement stm;
        try {
            String sql = "SELECT * FROM PLATO WHERE ID = ?";
            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();

            while (result.next()) {

                plato.setId(result.getInt("ID"));
                plato.setNombre(result.getString("NOMBRE"));
                plato.setPrecioUnitario(result.getDouble("PRECIO_UNITARIO"));
                plato.setAlergenos(aleServ.getAlergenosByPlato(plato));
                plato.setRestaurante(resServ.getRestauranteById(result.getInt("ID_RESTAURANTE")));
                
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return plato;
    }

    public ArrayList<Plato> getAllPlatos() {
        ArrayList<Plato> platos = new ArrayList<Plato>();
        RestauranteServicio resServ = new RestauranteServicio();
        AlergenoServicio aleServ = new AlergenoServicio();
        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM PLATO");

            while (result.next()) {
                Plato plato = new Plato();
                
                plato.setId(result.getInt("ID"));
                plato.setNombre(result.getString("NOMBRE"));
                plato.setPrecioUnitario(result.getDouble("PRECIO_UNITARIO"));
                plato.setAlergenos(aleServ.getAlergenosByPlato(plato));
                plato.setRestaurante(resServ.getRestauranteById(result.getInt("ID_RESTAURANTE")));
                
                
                platos.add(plato);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return platos;
    }
}
