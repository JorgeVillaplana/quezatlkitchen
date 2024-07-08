/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen;

import com.psi.quetzalkitchen.Modelos.Usuario;

/**
 *
 * @author Mañanas
 */
public class Session {
    
    private static Usuario usuario;
    private static String mensajeError;
    
    public static void setUsuario(Usuario usuario){
        Session.usuario = usuario;
    }
    
    public static Usuario getUsuario(){
        return Session.usuario;
    }

    public static String getMensajeError() {
        return mensajeError;
    }

    public static void setMensajeError(String mensajeError) {
        Session.mensajeError = mensajeError;
    }
    
}
