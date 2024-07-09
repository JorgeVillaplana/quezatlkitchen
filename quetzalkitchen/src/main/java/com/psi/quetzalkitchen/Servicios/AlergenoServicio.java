/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Alergeno;
import com.psi.quetzalkitchen.Modelos.Plato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        
        PreparedStatement stm;
        try {
            String sql = "SELECT * FROM ALERGENO WHERE ID = ?";
            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, id);
            ResultSet result = stm.executeQuery();
            
            while (result.next()) {
                
                alergeno.setId(result.getInt("ID"));
                alergeno.setNombre(result.getString("NOMBRE"));
                
            }
            
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return alergeno;
    }
    
    public ArrayList<Alergeno> getAlergenosByPlato(Plato plato) {
        ArrayList<Alergeno> alergenos = new ArrayList<>();
        
        PreparedStatement stm;
        try {
            String sql = "SELECT ID_ALERGENO FROM ALERGENO_EN_PLATO WHERE ID_PLATO = ?";
            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, plato.getId());
            ResultSet result = stm.executeQuery();
            
            while (result.next()) {
                
                Alergeno alergeno = getAlergenoById(result.getInt("ID_ALERGENO"));
                
                alergenos.add(alergeno);
            }
            
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return alergenos;
    }
}
