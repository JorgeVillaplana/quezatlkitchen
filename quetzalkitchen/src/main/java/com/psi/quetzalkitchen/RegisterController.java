/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import java.net.URL;
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
    TextField birthyear;
    @FXML
    TextField birthmonth;
    @FXML
    TextField birthday;
    @FXML
    TextField localidad;
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
        
    }
    
    @FXML
    public void deleteAll(ActionEvent event){
        dni.setText("");
        nombre.setText("");
        apellido.setText("");
        apellido2.setText("");
        birthday.setText("");
        birthmonth.setText("");
        birthyear.setText("");
        localidad.setText("");
        cp.setText("");
        direccion.setText("");
    }
}
