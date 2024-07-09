/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import com.psi.quetzalkitchen.Modelos.Alergeno;
import com.psi.quetzalkitchen.Modelos.Pedido;
import com.psi.quetzalkitchen.Modelos.Plato;
import com.psi.quetzalkitchen.Modelos.PlatoEnPedido;
import com.psi.quetzalkitchen.Servicios.PedidoServicio;
import com.psi.quetzalkitchen.Servicios.PlatoServicio;
import com.psi.quetzalkitchen.Servicios.PlatosEnPedidoServicio;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    @FXML
    private HBox grande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        obtenerPlatosDeBD(); //Obtenemos los platos de la BD
        int counter = 0;

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
        contenedor.setId(id);
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
        campoCantidad.setOnAction(event -> {
            String texto = campoCantidad.getText();
            if (texto.matches("\\d+") && Integer.parseInt(texto) > 0) {
            } else {
                campoCantidad.setText("0");
            }
        });
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
    public void recogePedido() throws IOException {
        List<Node> hijos = grande.getChildren();
        PlatosEnPedidoServicio ps = new PlatosEnPedidoServicio();
        PedidoServicio pedS = new PedidoServicio();
        ArrayList<PlatoEnPedido> platosPedidos = new ArrayList();

        for (Node hijo : hijos) {
            PlatoEnPedido nuevoPlato = new PlatoEnPedido();

            HBox contenedor = (HBox) hijo;
            for (Plato plato : platos) {
                if (contenedor.getId().equals(String.valueOf(plato.getId()))) {
                    nuevoPlato.setPlato(plato);
                }
            }
            List<Node> elementos = contenedor.getChildren();
            for (Node elemento : elementos) {
                if (elemento instanceof TextField) {

                    int cantidad = (Integer.parseInt((((TextField) elemento).getText())));

                    if (cantidad > 0) {
                        nuevoPlato.setCantidad(cantidad);
                        nuevoPlato.setPrecioPlatos(ps.calculaPrecio(nuevoPlato.getPlato(), cantidad));
                        platosPedidos.add(nuevoPlato);
                    }
                }
            }
        }

        Pedido pedido = new Pedido();
        pedido.setPlatos(platosPedidos);
        pedido.setPrecioSinDescuento(pedS.calcularPrecioTotal(pedido));
        Session.setPedido(pedido);

        App.setRoot("deliveryConfirm");
    }

    @FXML
    public void cancelar() throws IOException {
        App.setRoot("catalogue");
    }

    @FXML
    public void showLogin() throws IOException {
        App.setRoot("login");
    }
}
