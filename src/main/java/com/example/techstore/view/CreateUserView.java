package com.example.techstore.view;

import com.example.techstore.controller.CreateUserController;
import com.example.techstore.view.abst.View;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class CreateUserView extends View {
    private final AnchorPane anchorPane;
    private final Button back;
    private final TextField name;
    private final TextField username;
    private final PasswordField password;
    private final Button create;
    private final ComboBox role;

    public CreateUserView() {
        anchorPane = new AnchorPane();
        back = new Button();
        name = new TextField();
        username = new TextField();
        password = new PasswordField();
        create = new Button();
        role = new ComboBox();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        back.setMnemonicParsing(false);
        back.setOnAction(CreateUserController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        name.setAlignment(javafx.geometry.Pos.CENTER);
        name.setLayoutX(351.0);
        name.setLayoutY(115.0);
        name.setPromptText("Name");

        username.setAlignment(javafx.geometry.Pos.CENTER);
        username.setLayoutX(351.0);
        username.setLayoutY(200.0);
        username.setPromptText("Username");

        password.setAlignment(javafx.geometry.Pos.CENTER);
        password.setLayoutX(351.0);
        password.setLayoutY(285.0);
        password.setPromptText("Password");

        create.setLayoutX(400.0);
        create.setLayoutY(470.0);
        create.setMnemonicParsing(false);
        create.setOnAction(CreateUserController::create);
        create.setPrefHeight(40.0);
        create.setPrefWidth(200.0);
        create.getStyleClass().add("button-secondary");
        create.setText("Create");

        role.setLayoutX(350.0);
        role.setLayoutY(370.0);
        role.setPrefWidth(300.0);
        role.setPromptText("Role");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(name);
        anchorPane.getChildren().add(username);
        anchorPane.getChildren().add(password);
        anchorPane.getChildren().add(create);
        anchorPane.getChildren().add(role);
        getChildren().add(anchorPane);
    }
}
