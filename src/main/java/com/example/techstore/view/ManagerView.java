package com.example.techstore.view;

import com.example.techstore.view.abst.View;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ManagerView extends View {
    private AnchorPane anchorPane;
    private Button home;
    private Button Item;
    private Button supplier;
    private Button cashier;

    public ManagerView() {
        anchorPane = new AnchorPane();
        home = new Button();
        Item = new Button();
        supplier = new Button();
        cashier = new Button();

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

        Item.setLayoutX(270.0);
        Item.setLayoutY(465.0);
        Item.setMnemonicParsing(false);
        Item.setOnAction(this::item);
        Item.setPrefHeight(40.0);
        Item.setPrefWidth(200.0);
        Item.getStyleClass().add("button-primary");
        Item.setText("Item");

        supplier.setLayoutX(270.0);
        supplier.setLayoutY(530.0);
        supplier.setMnemonicParsing(false);
        supplier.setOnAction(this::supplier);
        supplier.setPrefHeight(40.0);
        supplier.setPrefWidth(200.0);
        supplier.getStyleClass().add("button-primary");
        supplier.setText("Supplier");

        cashier.setLayoutX(270.0);
        cashier.setLayoutY(400.0);
        cashier.setMnemonicParsing(false);
        cashier.setOnAction(this::cashier);
        cashier.setPrefHeight(40.0);
        cashier.setPrefWidth(200.0);
        cashier.getStyleClass().add("button-primary");
        cashier.setText("Cashier");

        anchorPane.getChildren().add(home);
        anchorPane.getChildren().add(Item);
        anchorPane.getChildren().add(supplier);
        anchorPane.getChildren().add(cashier);
        getChildren().add(anchorPane);

    }

    private void home(javafx.event.ActionEvent actionEvent) {

    }

    private void item(javafx.event.ActionEvent actionEvent) {

    }

    private void supplier(javafx.event.ActionEvent actionEvent) {

    }

    private void cashier(javafx.event.ActionEvent actionEvent) {

    }
}
