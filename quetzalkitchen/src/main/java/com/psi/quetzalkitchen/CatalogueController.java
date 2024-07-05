/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import com.psi.quetzalkitchen.Modelos.Alergeno;
import com.psi.quetzalkitchen.Modelos.Plato;
import com.psi.quetzalkitchen.Servicios.PlatoServicio;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
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
        int counter = 0;
        HBox grande = new HBox();
        for (Plato plato : platos) {
            HBox hbox = creaCampo(plato, String.valueOf(plato.getId()));
            hbox.setId(String.valueOf(plato.getId()));
            if (counter % 2 == 0) {
                hbox.getStyleClass().add("left");
            } else {
                hbox.getStyleClass().add("right");
            }
            grande.getChildren().add(hbox);
            counter++;
        }
        catalogo.setContent(grande);
    }

    public HBox creaCampo(Plato plato, String id) {
        HBox contenedor = new HBox();

        TitledPane paraPlato = creaPlato(plato, "plato-" + id);
        TextField paraCantidad = creaCampoCantidad("cantidad" + id);

        contenedor.getChildren().addAll(paraPlato, paraCantidad);
        return contenedor;
    }

    public TitledPane creaPlato(Plato plato, String id) {
        VBox contienePlato = new VBox();

        TitledPane cajaPlato = new TitledPane(plato.getNombre(), contienePlato);
        cajaPlato.setId("cajaplato" + id);

        Label restaurantePlato = new Label(plato.getRestaurante().getNombre());
        Label precioPlato = new Label(Double.toString(plato.getPrecioUnitario()));
        Tooltip alergenos = new Tooltip();
        String paraTooltip = "";
        //Alergenos
        for (Alergeno a : plato.getAlergenos()) {
            paraTooltip += a.getNombre();
            paraTooltip += ", ";
        }
        alergenos.setText(paraTooltip);

        contienePlato.getChildren().addAll(restaurantePlato, precioPlato);
        cajaPlato.setTooltip(alergenos);

        return cajaPlato;
    }

    public TextField creaCampoCantidad(String id) {
        TextField campoCantidad = new TextField();
        campoCantidad.setId(id);
        campoCantidad.setText("0");
        return campoCantidad;
    }

    public void obtenerPlatosDeBD() {

        platos = platoServicio.getAllPlatos();

    }

    public int validaNumerosEnCantidad(TextField cantidad) {
        try {
            int i = Integer.parseInt(cantidad.getText());
            return i;
        } catch (NumberFormatException excep) {
            cantidad.setText("0");
            return 0;
        }
    }
    
    @FXML
    public void recogePedido(){
        
    }
}
