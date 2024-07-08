/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import com.psi.quetzalkitchen.Modelos.Usuario;
import com.psi.quetzalkitchen.Servicios.UsuarioServicio;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mañanas
 */
public class LoginController implements Initializable {

    @FXML
    TextField userMail;
    @FXML
    TextField userPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void confirm(ActionEvent event) {
        String userMail = this.userMail.getText();
        String userPass = this.userPass.getText();
        UsuarioServicio userServ = new UsuarioServicio();
        if (Session.getUsuario() != null) {
            if (userMail.equals(Session.getUsuario().getEmail()) && userPass.equals(Session.getUsuario().getPass())) {

            }
        } else {
            ArrayList<Usuario> usuarios = userServ.getAllUsers();
        }

    }

    @FXML
    public void switchToRegistry(ActionEvent event) throws IOException {
        App.setRoot("register");
    }

    @FXML
    public void deleteAll(ActionEvent event) {
        this.userMail.setText("");
        this.userPass.setText("");
    }
}
