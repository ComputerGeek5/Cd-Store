package com.example.techstore.view;

import com.example.techstore.controller.CreateStaffController;
import com.example.techstore.view.abst.View;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

import static com.example.techstore.util.enumerator.CreateStaffViewUtil.fillComboBoxOptions;

public class CreateStaffView extends View {
    private AnchorPane anchorPane;
    private Button back;
    private TextField name;
    private TextField username;
    private PasswordField password;
    private Button create;
    private ComboBox roles;

    public CreateStaffView() {
        anchorPane = new AnchorPane();
        back = new Button();
        name = new TextField();
        username = new TextField();
        password = new PasswordField();
        create = new Button();
        roles = new ComboBox();

        fillComboBoxOptions(roles);

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        back.setLayoutX(14.0);
        back.setLayoutY(14.0);
        back.setMnemonicParsing(false);
        back.setOnAction(CreateStaffController::back);
        back.setPrefHeight(40.0);
        back.setPrefWidth(200.0);
        back.getStyleClass().add("button-primary");
        back.setText("Back");

        name.setAlignment(javafx.geometry.Pos.CENTER);
        name.setLayoutX(351.0);
        name.setLayoutY(115.0);
        name.setPrefWidth(300.0);
        name.setPromptText("Name");

        username.setAlignment(javafx.geometry.Pos.CENTER);
        username.setLayoutX(351.0);
        username.setLayoutY(200.0);
        username.setPrefWidth(300.0);
        username.setPromptText("Username");

        password.setAlignment(javafx.geometry.Pos.CENTER);
        password.setLayoutX(351.0);
        password.setLayoutY(285.0);
        password.setPrefWidth(300.0);
        password.setPromptText("Password");

        create.setLayoutX(400.0);
        create.setLayoutY(470.0);
        create.setMnemonicParsing(false);
        create.setOnAction(CreateStaffController::create);
        create.setPrefHeight(40.0);
        create.setPrefWidth(200.0);
        create.getStyleClass().add("button-secondary");
        create.setText("Create");

        roles.setLayoutX(350.0);
        roles.setLayoutY(370.0);
        roles.setPrefWidth(300.0);
        roles.setPromptText("Role");

        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(name);
        anchorPane.getChildren().add(username);
        anchorPane.getChildren().add(password);
        anchorPane.getChildren().add(create);
        anchorPane.getChildren().add(roles);
        getChildren().add(anchorPane);
    }

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public ComboBox getRoles() {
        return roles;
    }

    public void setRoles(ComboBox roles) {
        this.roles = roles;
    }
}
