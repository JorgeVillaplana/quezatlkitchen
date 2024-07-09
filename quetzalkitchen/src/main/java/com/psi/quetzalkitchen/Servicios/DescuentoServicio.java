/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Descuento;
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
public class DescuentoServicio {

    public Descuento getDescuentoById(int id) {
        Descuento descuento = new Descuento();

        PreparedStatement stm;
        try {
            String sql = "SELECT * FROM DESCUENTO WHERE ID = ?";
            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();

            while (result.next()) {

                descuento.setId(result.getInt("ID"));
                descuento.setCodigo(result.getString("CODIGO"));
                descuento.setPorcentaje(result.getInt("PORCENTAJE"));

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return descuento;
    }

    public Descuento getDescuentoByCodigo(String codigo) {
        Descuento descuento = new Descuento();

        PreparedStatement stm;
        try {
            String sql = "SELECT * FROM DESCUENTO WHERE CODIGO = ?";
            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, codigo);
            ResultSet result = stm.executeQuery();

            while (result.next()) {

                descuento.setId(result.getInt("ID"));
                descuento.setCodigo(result.getString("CODIGO"));
                descuento.setPorcentaje(result.getInt("PORCENTAJE"));

            }

        } catch (SQLException ex) {
            descuento.setCodigo(codigo);
            descuento.setPorcentaje(0);
        }
        
        return descuento;
    }

}
