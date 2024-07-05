/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import com.psi.quetzalkitchen.Modelos.Plato;
import com.psi.quetzalkitchen.Servicios.PlatoServicio;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mañanas
 */
public class CatalogueController implements Initializable {

    private ArrayList<Plato> platos;
    private PlatoServicio platoServicio = new PlatoServicio();
    @FXML
    private ScrollPane catalogo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        obtenerPlatosDeBD(); //Obtenemos los platos de la BD
        
        
    }    
    
    public void creaCampo(Plato plato, String id){
        
    }
    
    public VBox creaPlato(Plato plato, String id){
        
        VBox cajaPlato = new VBox();
        cajaPlato.setId("cajaplato" + id);
        
        Label nombrePlato = new Label(plato.getNombre());
        Label restaurantePlato = new Label(plato.getRestaurante().getNombre());
        Label precioPlato = new Label(Double.toString(plato.getPrecioUnitario()));
        Tooltip alergenos = new Tooltip();
        //Alergenos
        
        return cajaPlato;
    }
    
    public void obtenerPlatosDeBD(){
        
        platos = platoServicio.getAllPlatos();
        
    }
}
