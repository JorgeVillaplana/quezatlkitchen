/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import com.psi.quetzalkitchen.Modelos.Direccion;
import com.psi.quetzalkitchen.Modelos.Pedido;
import com.psi.quetzalkitchen.Servicios.DireccionServicio;
import com.psi.quetzalkitchen.Servicios.PedidoServicio;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mañanas
 */
public class DeliveryConfirmController implements Initializable {

    @FXML
    private TextArea muestraInfo;
    @FXML
    private TextField direccion;
    @FXML
    private TextField cp;
    @FXML
    private TextField localidad;
    @FXML
    private TextField cDesc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        muestraInfo.setText(Session.getPedido().toString());
    }

    @FXML
    public void send() throws IOException {
        Direccion direccion = new Direccion();
        DireccionServicio direServ = new DireccionServicio();
        Pedido pedido = Session.getPedido();
        PedidoServicio pedidoServ = new PedidoServicio();

        direccion.setCallePortalPiso(RegisterController.checkContent(this.direccion));
        direccion.setCodigoPostal(Integer.parseInt(RegisterController.checkContent(cp)));
        direccion.setLocalidad(RegisterController.checkContent(localidad));
        direccion = direServ.setNuevaDireccion(direccion);

        pedido.setDireccion(direccion);
        pedido = pedidoServ.actualizaDireccionPedido(pedido);

        pedido.setPrecioSinDescuento(pedidoServ.calcularPrecioTotal(pedido));
        pedidoServ.ponPrecioConDescuento(RegisterController.checkContent(this.cDesc));
        
        Session.setPedido(pedido);
        App.setRoot("ticket");
    }

    @FXML
    public void cancel() {
        direccion.setText("");
        cp.setText("");
        localidad.setText("");
        cDesc.setText("");
    }

    @FXML
    public void back() throws IOException {
        App.setRoot("catalogue");
    }

}
