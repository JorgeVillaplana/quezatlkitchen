/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Direccion;
import java.sql.PreparedStatement;
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

    public Direccion getDireccionById(int id) {
        direccion = new Direccion();

        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM DIRECCION WHERE ID = " + id);

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

    public Direccion setNuevaDireccion(Direccion direccion) {
        PreparedStatement stm;
        try {
            String[] camposDireccion = {"LOCALIDAD", "CP", "CALLE_NUM_PISO"};

            stm = ConnectDB.con.prepareStatement("INSERT INTO DIRECCION", camposDireccion);

            stm.setString(0, direccion.getLocalidad());
            stm.setInt(1, direccion.getCodigoPostal());
            stm.setString(2, direccion.getCallePortalPiso());

            ResultSet result = stm.executeQuery();

            Direccion nuevaDirec = new Direccion();

            while (result.next()) {
                nuevaDirec.setId(result.getInt("ID"));
                nuevaDirec.setLocalidad(result.getString("LOCALIDAD"));
                nuevaDirec.setCodigoPostal(result.getInt("CP"));
                nuevaDirec.setCallePortalPiso(result.getString("CALLE_NUM_PISO"));
            }

            return nuevaDirec;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

}
