/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Plato;
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
        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM PLATO WHERE ID = " + id);

            while (result.next()) {

                plato.setId(result.getInt("ID"));
                plato.setNombre(result.getString("NOMBRE"));
                plato.setPrecioUnitario(result.getDouble("PRECIO_UNITARIO"));
                plato.setAlergenos(aleServ.getAlergenosByPlato(plato));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plato;
    }

    public ArrayList<Plato> getAllPlatos() {
        ArrayList<Plato> platos = new ArrayList<Plato>();
        
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
                
                platos.add(plato);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return platos;
    }
}
