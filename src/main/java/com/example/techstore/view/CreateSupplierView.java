package com.example.techstore.view;

import com.example.techstore.controller.CreateSupplierController;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class CreateSupplierView extends VBox {
    private final AnchorPane anchorPane;
    private final Button back;
    private final TextField name;
    private final Button create;
    private final ComboBox cd;

    public CreateSupplierView() {
        anchorPane = new AnchorPane();
        back = new Button();
        name = new TextField();
        create = new Button();
        cd = new ComboBox();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        back.setMnemonicParsing(false);
        back.setOnAction(CreateSupplierController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        name.setAlignment(javafx.geometry.Pos.CENTER);
        name.setLayoutX(351.0);
        name.setLayoutY(115.0);
        name.setPrefWidth(300.0);
        name.setPromptText("Name");

        create.setLayoutX(400.0);
        create.setLayoutY(300.0);
        create.setMnemonicParsing(false);
        create.setOnAction(CreateSupplierController::create);
        create.setPrefHeight(40.0);
        create.setPrefWidth(200.0);
        create.getStyleClass().add("button-secondary");
        create.setText("Create");

        cd.setLayoutX(350.0);
        cd.setLayoutY(200.0);
        cd.setPrefWidth(300.0);
        cd.setPromptText("CD");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(name);
        anchorPane.getChildren().add(create);
        anchorPane.getChildren().add(cd);
        getChildren().add(anchorPane);
    }
}
