/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Connection;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.psi.quetzalkitchen.Constants.UtilConstants;
import java.util.Properties;

/**
 *
 * @author jorge
 */
public class TunnelSSH {

    public static Session tunelSSH = null;

    public static void connectTunnel() {

        try {
            Properties config = new Properties();
            JSch jsch = new JSch();
            System.out.println("Creando túnel SSH...");

            TunnelSSH.tunelSSH = jsch.getSession(UtilConstants.SSH_REMOTE_USER, UtilConstants.SSH_REMOTE_HOST, UtilConstants.SSH_REMOTE_PORT);
            config.put("StrictHostKeyChecking", "no");
            config.put("ConnectionAttempts", "3");
            config.put("PreferredAuthentications", "password");
            TunnelSSH.tunelSSH.setConfig(config);
            TunnelSSH.tunelSSH.connect();
            TunnelSSH.tunelSSH.setPortForwardingL(UtilConstants.SSH_LOCAL_PORT, UtilConstants.SSH_REMOTE_HOST, UtilConstants.DB_PORT);
            System.out.println("Túnel creado.");
            
        } catch (JSchException e) {
            System.out.println(e);
        }
    }

    public static void closeTunnel() {
        if (TunnelSSH.tunelSSH != null && TunnelSSH.tunelSSH.isConnected()) {
            TunnelSSH.tunelSSH.disconnect();
            System.out.println("Túnel SSH cerrado.");
        }
    }

}
