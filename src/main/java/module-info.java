module com.example.techstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;

    opens com.example.techstore to javafx.fxml;
    exports com.example.techstore;
    exports com.example.techstore.controller;
    opens com.example.techstore.controller to javafx.fxml;
}