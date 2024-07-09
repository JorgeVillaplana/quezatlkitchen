/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.psi.quetzalkitchen;

import com.psi.quetzalkitchen.Modelos.Direccion;
import com.psi.quetzalkitchen.Modelos.Usuario;
import com.psi.quetzalkitchen.Servicios.DireccionServicio;
import com.psi.quetzalkitchen.Servicios.UsuarioServicio;
import java.io.IOException;
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
    TextField localidad;
    @FXML
    TextField cp;
    @FXML
    TextField direccion;
    @FXML
    TextField edad;
    @FXML
    TextField email;
    @FXML
    TextField pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void confirm(ActionEvent event) throws IOException {
        Usuario usuario = new Usuario();
        usuario.setDNI(checkContent(dni));
        usuario.setNombre(checkContent(nombre));
        usuario.setApellido1(checkContent(apellido));
        usuario.setApellido2(checkContent(apellido2));
        usuario.setEdad(Integer.parseInt(checkContent(edad)));
        usuario.setEmail(checkContent(email));
        usuario.setPass(checkContent(pass));

        Direccion direccion = new Direccion(checkContent(localidad), Integer.parseInt(checkContent(cp)), checkContent(this.direccion));
        DireccionServicio direServ = new DireccionServicio();
        usuario.setDireccion(direServ.setNuevaDireccion(direccion));

        UsuarioServicio usuServ = new UsuarioServicio();
        Session.setUsuario(usuServ.setNuevoUsuario(usuario));

        App.setRoot("login");
    }

    @FXML
    public void deleteAll(ActionEvent event) {
        dni.setText("");
        nombre.setText("");
        apellido.setText("");
        apellido2.setText("");
        edad.setText("");
        localidad.setText("");
        cp.setText("");
        direccion.setText("");
    }

    @FXML
    private void switchToWelcome() throws IOException {
        App.setRoot("welcome");
    }

    @FXML
    private void checkInteger(ActionEvent event) {
        String texto = ((TextField) event.getSource()).getText();
        if (texto.matches("\\d+") && Integer.parseInt(texto) > 0) {
            // Valor entero positivo, aceptarlo
        } else {
            ((TextField) event.getSource()).setText("");
        }
    }

    public static String checkContent(TextField textField) {
        if (textField.getText().isBlank()) {
            textField.setText("Requerido!");
            return "";
        }
        return textField.getText(); // Prevent form submission
    }

}
