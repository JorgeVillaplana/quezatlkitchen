module com.psi.quetzalkitchen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.base;

    opens com.psi.quetzalkitchen to javafx.fxml;
    exports com.psi.quetzalkitchen;
}
