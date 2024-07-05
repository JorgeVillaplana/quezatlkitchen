/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author jorge
 */
public class ConnectDB {
    
    private static final String URLDATABASE = "jdbc:mariadb://localhost:3306/";
    private static final String NAMEDB = "quetzalkitchendb";
    private static final String USERDB = "root";
    private static final String PASSDB = "1234";
    
    public void connect(){
        try{
            Connection con = DriverManager.getConnection(URLDATABASE+NAMEDB , USERDB, PASSDB);
            
        }catch(Exception e){
            
        }
    }
    
}
