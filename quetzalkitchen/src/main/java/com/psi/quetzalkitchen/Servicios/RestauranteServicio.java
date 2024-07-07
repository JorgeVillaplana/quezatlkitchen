/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Restaurante;
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
    
    public ArrayList<Restaurante> obtenerRestaurantes(){
        
        /**
         * TODO: Hacer el método para coger los restaurantes de BD.
         */        
        
        return this.restaurantes;
    }
    
    public Restaurante getRestauranteById(int id){
        
        Restaurante restaurante = new Restaurante();
        
        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM RESTAURANTE WHERE ID = " + id);

            while (result.next()) {

                restaurante.setId(result.getInt("ID"));
                restaurante.setNombre(result.getString("NOMBRE"));
                restaurante.setEmpresaEnvioPropia( (result.getByte("EMPRESA_ENVIO_PROPIA") == 1) );
                
                DireccionServicio direccionServ = new DireccionServicio();
                
                restaurante.setDireccion(direccionServ.getDireccionById(result.getInt("ID_DIRECCION")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurante;
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
    
}
