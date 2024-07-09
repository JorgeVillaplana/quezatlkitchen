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

        PreparedStatement stm;
        try {
            String sql = "SELECT * FROM DIRECCION WHERE ID = ?";
            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt( 1, id);
            ResultSet result = stm.executeQuery();

            while (result.next()) {

                direccion.setId(result.getInt("ID"));
                direccion.setLocalidad(result.getString("LOCALIDAD"));
                direccion.setCodigoPostal(result.getInt("CP"));
                direccion.setCallePortalPiso(result.getString("CALLE_NUM_PISO"));

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


        return direccion;
    }

    public Direccion setNuevaDireccion(Direccion direccion) {
        PreparedStatement stm;
        try {
            String sql = "INSERT INTO DIRECCION (LOCALIDAD, CP, CALLE_NUM_PISO) VALUES (?,?,?)";

            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stm.setString(1, direccion.getLocalidad());
            stm.setInt(2, direccion.getCodigoPostal());
            stm.setString(3, direccion.getCallePortalPiso());

            int affectedRows = stm.executeUpdate();
            if(affectedRows > 0){
            ResultSet result = stm.getGeneratedKeys();

           while (result.next()) {
                direccion.setId(result.getInt("insert_id"));
                
            }}

            return direccion;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

}
