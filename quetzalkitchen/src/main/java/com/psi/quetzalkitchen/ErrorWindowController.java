/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Mañanas
 */
public class ErrorWindowController implements Initializable {

    @FXML
    TextArea errorMsg;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.errorMsg.setText(Session.getMensajeError());
    }    
    
    @FXML
    private void switchToWelcome() throws IOException {
        App.setRoot("welcome");
    }
}
