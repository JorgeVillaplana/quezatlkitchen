/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import com.psi.quetzalkitchen.Modelos.Direccion;
import com.psi.quetzalkitchen.Modelos.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.util.Date;


/**
 * FXML Controller class
 *
 * @author Mañanas
 */
public class RegisterController implements Initializable {

    @FXML
    TextField dni;
    @FXML
    TextField nombre;
    @FXML
    TextField apellido;
    @FXML
    TextField apellido2;
    @FXML
    TextField localidad;
    @FXML
    TextField birthdate;
    @FXML
    TextField cp;
    @FXML
    TextField direccion;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void confirm(ActionEvent event){
        Usuario usuario = new Usuario();
        usuario.setDNI(dni.getText());
        usuario.setNombre(nombre.getText());
        usuario.setApellido1(apellido.getText());
        usuario.setApellido2(apellido2.getText());
        Date fechaNacimiento = new Date(birthdate.getText());
        usuario.setFechaNac(fechaNacimiento);
        Direccion direccion = new Direccion(localidad.getText(), Integer.parseInt(cp.getText()), this.direccion.getText()); 
        usuario.setDireccion(direccion);
    }
    
    @FXML
    public void deleteAll(ActionEvent event){
        dni.setText("");
        nombre.setText("");
        apellido.setText("");
        apellido2.setText("");
        birthdate.setText("");
        localidad.setText("");
        cp.setText("");
        direccion.setText("");
    }
    
    @FXML
    private void switchToWelcome() throws IOException {
        App.setRoot("welcome");
    }
}
