/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Alergeno;
import com.psi.quetzalkitchen.Modelos.Plato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class AlergenoServicio {

    private Alergeno alergeno;

    public AlergenoServicio() {
    }

    public AlergenoServicio(Alergeno alergeno) {
        this.alergeno = alergeno;
    }

    public Alergeno getAlergeno() {
        return alergeno;
    }

    public void setAlergeno(Alergeno alergeno) {
        this.alergeno = alergeno;
    }

    public Alergeno getAlergenoById(int id) {
        alergeno = new Alergeno();

        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM ALERGENO WHERE ID = " + id);

            while (result.next()) {

                alergeno.setId(result.getInt("ID"));
                alergeno.setNombre(result.getString("NOMBRE"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alergeno;
    }
    
    public ArrayList<Alergeno> getAlergenosByPlato (Plato plato){
        ArrayList<Alergeno> alergenos =  new ArrayList<>();
        
        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT ID_ALERGENO FROM ALERGENO_EN_PLATO WHERE ID_PLATO = " + plato.getId());

            while (result.next()) {

                Alergeno alergeno = getAlergenoById(result.getInt("ID_ALERGENO"));
                
                alergenos.add(alergeno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return alergenos;
    }
}
