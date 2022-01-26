package com.example.techstore.view;

import com.example.techstore.controller.ManagerController;
import com.example.techstore.view.abst.View;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ManagerView extends View {
    private AnchorPane anchorPane;
    private Button back;
    private Button cd;
    private Button supplier;
    private Button cashier;

    public ManagerView() {
        anchorPane = new AnchorPane();
        back = new Button();
        cd = new Button();
        supplier = new Button();
        cashier = new Button();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        back.setMnemonicParsing(false);
        back.setOnAction(ManagerController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        cd.setLayoutX(270.0);
        cd.setLayoutY(465.0);
        cd.setMnemonicParsing(false);
        cd.setOnAction(ManagerController::cd);
        cd.setPrefHeight(40.0);
        cd.setPrefWidth(200.0);
        cd.getStyleClass().add("button-primary");
        cd.setText("CD");

        supplier.setLayoutX(270.0);
        supplier.setLayoutY(530.0);
        supplier.setMnemonicParsing(false);
        supplier.setOnAction(ManagerController::supplier);
        supplier.setPrefHeight(40.0);
        supplier.setPrefWidth(200.0);
        supplier.getStyleClass().add("button-primary");
        supplier.setText("Supplier");

        cashier.setLayoutX(270.0);
        cashier.setLayoutY(400.0);
        cashier.setMnemonicParsing(false);
        cashier.setOnAction(ManagerController::bill);
        cashier.setPrefHeight(40.0);
        cashier.setPrefWidth(200.0);
        cashier.getStyleClass().add("button-primary");
        cashier.setText("Cashier");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(cd);
        anchorPane.getChildren().add(supplier);
        anchorPane.getChildren().add(cashier);
        getChildren().add(anchorPane);
    }
}
