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
    private Button cashiers;
    private Button statistics;

    public ManagerView() {
        anchorPane = new AnchorPane();
        back = new Button();
        cd = new Button();
        supplier = new Button();
        cashiers = new Button();
        statistics = new Button();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        back.setOnAction(ManagerController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        statistics.setLayoutX(400.0);
        statistics.setLayoutY(300.0);
        statistics.setOnAction(ManagerController::statistics);
        statistics.setPrefHeight(40.0);
        statistics.setPrefWidth(200.0);
        statistics.getStyleClass().add("button-primary");
        statistics.setText("Statistics");

        cd.setLayoutX(400.0);
        cd.setLayoutY(450.0);
        cd.setOnAction(ManagerController::cd);
        cd.setPrefHeight(40.0);
        cd.setPrefWidth(200.0);
        cd.getStyleClass().add("button-primary");
        cd.setText("CD");

        supplier.setLayoutX(400.0);
        supplier.setLayoutY(525.0);
        supplier.setOnAction(ManagerController::supplier);
        supplier.setPrefHeight(40.0);
        supplier.setPrefWidth(200.0);
        supplier.getStyleClass().add("button-primary");
        supplier.setText("Supplier");

        cashiers.setLayoutX(400.0);
        cashiers.setLayoutY(375.0);
        cashiers.setOnAction(ManagerController::bill);
        cashiers.setPrefHeight(40.0);
        cashiers.setPrefWidth(200.0);
        cashiers.getStyleClass().add("button-primary");
        cashiers.setText("Cashiers");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(cd);
        anchorPane.getChildren().add(supplier);
        anchorPane.getChildren().add(cashiers);
        anchorPane.getChildren().add(statistics);
        getChildren().add(anchorPane);
    }
}
