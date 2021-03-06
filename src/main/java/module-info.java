module com.example.techstore {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires fontawesomefx;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires javafx.base;
    requires org.apache.logging.log4j;
    requires org.apache.commons.io;

    opens com.example.techstore to javafx.fxml, javafx.base;
    exports com.example.techstore;
    exports com.example.techstore.controller;
    opens com.example.techstore.controller to javafx.fxml;
    opens com.example.techstore.model.abst to javafx.base;
    opens com.example.techstore.model to javafx.base;
    opens com.example.techstore.statistics to javafx.base;
}