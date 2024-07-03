module com.psi.quetzalkitchen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.psi.quetzalkitchen to javafx.fxml;
    exports com.psi.quetzalkitchen;
}
