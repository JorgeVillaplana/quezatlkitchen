/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Direccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class DireccionServicio {

    private Direccion direccion;

    public DireccionServicio() {
    }

    public DireccionServicio(Direccion direccion) {
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    Direccion getDireccionById(int id) {
       direccion = new Direccion();
        
        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM DIRECCION WHERE ID = "+ id);

            while (result.next()) {

                direccion.setId(result.getInt("ID"));
                direccion.setLocalidad(result.getString("LOCALIDAD"));
                direccion.setCodigoPostal(result.getInt("CP"));
                direccion.setCallePortalPiso(result.getString("CALLE_NUM_PISO"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return direccion;
    }

}
