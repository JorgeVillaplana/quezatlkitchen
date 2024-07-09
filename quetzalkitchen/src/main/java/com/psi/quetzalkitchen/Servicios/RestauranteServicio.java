/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Restaurante;
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
public class RestauranteServicio {

    private ArrayList<Restaurante> restaurantes;

    public RestauranteServicio() {
    }

    public ArrayList<Restaurante> obtenerRestaurantes() {

        Statement stm;
        this.restaurantes = new ArrayList();

        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM RESTAURANTE");
            
            while (result.next()) {
                Restaurante restaurante = new Restaurante();
                
                restaurante.setId(result.getInt("ID"));
                restaurante.setNombre(result.getString("NOMBRE"));
                restaurante.setEmpresaEnvioPropia((result.getInt("ENVIOS") == 1));

                DireccionServicio direccionServ = new DireccionServicio();

                restaurante.setDireccion(direccionServ.getDireccionById(result.getInt("ID_DIRECCION")));

                this.restaurantes.add(restaurante);
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return this.restaurantes;
    }

    public Restaurante getRestauranteById(int id) {

        Restaurante restaurante = new Restaurante();

        PreparedStatement stm;
        try {
            String sql = "SELECT * FROM RESTAURANTE WHERE ID = ?";
            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();

            while (result.next()) {

                restaurante.setId(result.getInt("ID"));
                restaurante.setNombre(result.getString("NOMBRE"));
                restaurante.setEmpresaEnvioPropia((result.getInt("ENVIOS") == 1));

                DireccionServicio direccionServ = new DireccionServicio();

                restaurante.setDireccion(direccionServ.getDireccionById(result.getInt("ID_DIRECCION")));

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return restaurante;
    }

}
