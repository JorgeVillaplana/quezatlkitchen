/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Descuento;
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

        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM DESCUENTO WHERE ID = " + id);

            while (result.next()) {

                descuento.setId(result.getInt("ID"));
                descuento.setCodigo(result.getString("CODIGO"));
                descuento.setPorcentaje(result.getInt("PORCENTAJE"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(DescuentoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return descuento;
    }

    public Descuento getDescuentoByCodigo(String codigo) {
        Descuento descuento = new Descuento();

        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM DESCUENTO WHERE CODIGO = " + codigo);

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
