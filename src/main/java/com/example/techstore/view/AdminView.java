package com.example.techstore.view;

import com.example.techstore.controller.AdminController;
import com.example.techstore.view.abst.View;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class AdminView extends View {
    private AnchorPane anchorPane;
    private Button back;
    private Button store;
    private Button staff;
    private Button billing;
    private Button statistics;

    public AdminView() {
        anchorPane = new AnchorPane();
        back = new Button();
        store = new Button();
        staff = new Button();
        billing = new Button();
        statistics = new Button();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        
        back.setOnAction(AdminController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        statistics.setLayoutY(383.0);
        statistics.setLayoutX(275.0);
        statistics.setLayoutY(383.0);
        statistics.setOnAction(AdminController::statistics);
        statistics.setPrefHeight(40.0);
        statistics.setPrefWidth(200.0);
        statistics.getStyleClass().add("button-primary");
        statistics.setText("Statistics");

        billing.setLayoutX(275.0);
        billing.setLayoutY(383.0);
        billing.setOnAction(AdminController::cashier);
        billing.setPrefHeight(40.0);
        billing.setPrefWidth(200.0);
        billing.getStyleClass().add("button-primary");
        billing.setText("Billing");

        store.setLayoutX(275.0);
        store.setLayoutY(458.0);
        store.setOnAction(AdminController::manager);
        store.setPrefHeight(40.0);
        store.setPrefWidth(200.0);
        store.getStyleClass().add("button-primary");
        store.setText("Store");

        staff.setLayoutX(275.0);
        staff.setLayoutY(533.0);
        staff.setOnAction(AdminController::staff);
        staff.setPrefHeight(40.0);
        staff.setPrefWidth(200.0);
        staff.getStyleClass().add("button-primary");
        staff.setText("Staff");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(store);
        anchorPane.getChildren().add(staff);
        anchorPane.getChildren().add(billing);
        getChildren().add(anchorPane);
    }
}
