/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Connection;

import com.psi.quetzalkitchen.Constants.UtilConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jorge
 */
public class ConnectDB {

    public static Connection con = null;

    public static void connect() {
        TunnelSSH.connectTunnel();
        System.out.println("Conectando a la base de datos...");
        try {
            DriverManager.setLoginTimeout(45);
            String hostURL = "jdbc:mysql://" + UtilConstants.DB_URL + "/" + UtilConstants.DB_NAME + "?autoReconnect=true&useSSL=false";
            con = DriverManager.getConnection(hostURL, UtilConstants.DB_USER, UtilConstants.DB_PASS);
            System.out.println("Conexión realizada con éxito");
        } catch (SQLException ex) {
            // handle any errors
            TunnelSSH.closeTunnel();
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }

    public static void closeCon() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

}
