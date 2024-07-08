/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.psi.quetzalkitchen.Servicios;

import com.psi.quetzalkitchen.Connection.ConnectDB;
import com.psi.quetzalkitchen.Modelos.Direccion;
import com.psi.quetzalkitchen.Modelos.Usuario;
import java.sql.PreparedStatement;
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

    private static Usuario usuario;

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

    public Usuario getUsuarioById(int id) {
        usuario = new Usuario();

        Statement stm;
        try {
            stm = ConnectDB.con.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM USUARIO WHERE ID = " + id);

            while (result.next()) {

                usuario.setId(result.getInt("ID"));
                usuario.setDNI(result.getString("DNI"));
                usuario.setNombre(result.getString("NOMBRE"));
                usuario.setApellido1(result.getString("APELLIDO1"));
                usuario.setApellido2(result.getString("APELLIDO2"));
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

    public Usuario setNuevoUsuario(Usuario usuario) {
        PreparedStatement stm;
        try {
            String sql = "INSERT INTO USUARIO (DNI, NOMBRE, APELLIDO1, APELLIDO2, EDAD, EMAIL, PASS, ID_DIRECCION) VALUES (?,?,?,?,?,?,?,?)";

            stm = ConnectDB.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stm.setString(1, usuario.getDNI());
            stm.setString(2, usuario.getNombre());
            stm.setString(3, usuario.getApellido1());
            stm.setString(4, usuario.getApellido2());
            stm.setInt(5, usuario.getEdad());
            stm.setString(6, usuario.getEmail());
            stm.setString(7, usuario.getPass());
            DireccionServicio direcServ = new DireccionServicio();
            stm.setInt(8, direcServ.setNuevaDireccion(usuario.getDireccion()).getId());

            int affectedRows = stm.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error al insertar el registro.");
            }

            ResultSet generatedKeys = stm.getGeneratedKeys();
            if (generatedKeys.next()) {
                usuario.setId(generatedKeys.getInt(1));
                return usuario;
            } else {
                throw new SQLException("No se pudo obtener el ID del registro insertado.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    

}
