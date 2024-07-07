/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Direccion;
import com.psi.quetzalkitchen.Modelos.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class UsuarioServicio {

    private Usuario usuario;

    public UsuarioServicio() {
    }

    public UsuarioServicio(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Usuario> getAllUsers() {

        Statement stm;
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM USUARIO");

            while (result.next()) {

                Usuario usuario = new Usuario();
                usuario.setId(result.getInt("ID"));
                usuario.setDNI(result.getString("DNI"));
                usuario.setNombre(result.getString("NOMBRE"));
                usuario.setApellido1(result.getString("APELLIDO1"));
                usuario.setApellido2(result.getString("APELLIDO2"));
                usuario.setFechaNac(result.getDate("FECHA_NAC"));
                usuario.setEdad(result.getInt("EDAD"));
                usuario.setEmail(result.getString("EMAIL"));
                usuario.setPass(result.getString("PASS"));
                Direccion direccion = new Direccion();
                direccion.setId(result.getInt("ID"));
                DireccionServicio direcServicio = new DireccionServicio();
                direccion = direcServicio.getDireccionById(direccion.getId());
                usuario.setDireccion(direccion);

                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarios;

    }
    
    public Usuario getUsuarioById(int id){
        usuario = new Usuario();
        
        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM USUARIO WHERE ID = "+ id);

            while (result.next()) {

                usuario.setId(result.getInt("ID"));
                usuario.setDNI(result.getString("DNI"));
                usuario.setNombre(result.getString("NOMBRE"));
                usuario.setApellido1(result.getString("APELLIDO1"));
                usuario.setApellido2(result.getString("APELLIDO2"));
                usuario.setFechaNac(result.getDate("FECHA_NAC"));
                usuario.setEdad(result.getInt("EDAD"));
                usuario.setEmail(result.getString("EMAIL"));
                usuario.setPass(result.getString("PASS"));
                Direccion direccion = new Direccion();
                direccion.setId(result.getInt("ID_DIRECCION"));
                DireccionServicio direcServicio = new DireccionServicio();
                direccion = direcServicio.getDireccionById(direccion.getId());
                usuario.setDireccion(direccion);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }

}
