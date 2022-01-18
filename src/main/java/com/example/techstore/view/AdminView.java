package com.example.techstore.view;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class AdminView extends VBox {

    private final AnchorPane anchorPane;
    private final Button home;
    private final Button Billing;
    private final Button store;
    private final Button Staff;

    public AdminView() {
        anchorPane = new AnchorPane();
        home = new Button();
        Billing = new Button();
        store = new Button();
        Staff = new Button();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        home.setLayoutX(14.0);
        home.setLayoutY(14.0);
        home.setMnemonicParsing(false);
        home.setOnAction(this::home);
        home.setPrefHeight(40.0);
        home.setPrefWidth(200.0);
        home.getStyleClass().add("button-primary");
        home.setText("Home");

        Billing.setLayoutX(275.0);
        Billing.setLayoutY(383.0);
        Billing.setMnemonicParsing(false);
        Billing.setOnAction(this::billing);
        Billing.setPrefHeight(40.0);
        Billing.setPrefWidth(200.0);
        Billing.getStyleClass().add("button-primary");
        Billing.setText("Billing");

        store.setLayoutX(275.0);
        store.setLayoutY(458.0);
        store.setMnemonicParsing(false);
        store.setOnAction(this::store);
        store.setPrefHeight(40.0);
        store.setPrefWidth(200.0);
        store.getStyleClass().add("button-primary");
        store.setText("Store");

        Staff.setLayoutX(275.0);
        Staff.setLayoutY(533.0);
        Staff.setMnemonicParsing(false);
        Staff.setOnAction(this::staff);
        Staff.setPrefHeight(40.0);
        Staff.setPrefWidth(200.0);
        Staff.getStyleClass().add("button-primary");
        Staff.setText("Staff");

        anchorPane.getChildren().add(home);
        anchorPane.getChildren().add(Billing);
        anchorPane.getChildren().add(store);
        anchorPane.getChildren().add(Staff);
        getChildren().add(anchorPane);

    }

    private void home(javafx.event.ActionEvent actionEvent) {

    }

    private void billing(javafx.event.ActionEvent actionEvent) {

    }

    private void store(javafx.event.ActionEvent actionEvent) {

    }

    private void staff(javafx.event.ActionEvent actionEvent) {

    }
}
