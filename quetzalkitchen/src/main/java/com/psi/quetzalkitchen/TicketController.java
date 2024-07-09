/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import com.psi.quetzalkitchen.Servicios.PedidoServicio;
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
public class TicketController implements Initializable {

    @FXML
    private TextArea ticketInfo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ticketInfo.setText(Session.getPedido().toString());
        
    }    
    
    @FXML
    public void aceptar() throws IOException{
        PedidoServicio pedServ = new PedidoServicio();
        pedServ.crearNuevoPedido();
        App.setRoot("welcome");
    }
    
    @FXML
    public void cancelar() throws IOException{
        App.setRoot("catalogue");
    }
}
