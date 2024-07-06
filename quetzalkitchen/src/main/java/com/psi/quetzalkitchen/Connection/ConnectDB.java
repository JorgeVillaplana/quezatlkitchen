/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Connection;

import Constants.UtilConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jorge
 */
public class ConnectDB {

    
    public static Connection con;

    public static void connect() {
        System.out.println("Conectando a la base de datos...");
        try {
            DriverManager.setLoginTimeout(45);
            con = DriverManager.getConnection(UtilConstants.DB_URL + UtilConstants.DB_NAME, UtilConstants.DB_USER, UtilConstants.DB_PASS);
            System.out.println("Conexión realizada con éxito");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }

}
