package com.example.techstore.view;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public abstract class HomeView extends VBox {

    protected final AnchorPane anchorPane;
    protected final Button signIn;
    protected final Button exitButton;
    protected final Button aboutButton;

    public HomeView() {

        anchorPane = new AnchorPane();
        signIn = new Button();
        exitButton = new Button();
        aboutButton = new Button();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        signIn.setLayoutX(300.0);
        signIn.setLayoutY(430.0);
        signIn.setMnemonicParsing(false);
        signIn.setOnAction(this::signIn);
        signIn.setPrefHeight(40.0);
        signIn.setPrefWidth(200.0);
        signIn.getStyleClass().add("button-secondary");
        signIn.setText("Sign In");

        exitButton.setLayoutX(300.0);
        exitButton.setLayoutY(530.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(40.0);
        exitButton.setPrefWidth(200.0);
        exitButton.getStyleClass().add("button-danger");
        exitButton.setText("Exit");

        aboutButton.setLayoutX(300.0);
        aboutButton.setLayoutY(480.0);
        aboutButton.setMnemonicParsing(false);
        aboutButton.setPrefHeight(40.0);
        aboutButton.setPrefWidth(200.0);
        aboutButton.getStyleClass().add("button-primary");
        aboutButton.setText("About");

        anchorPane.getChildren().add(signIn);
        anchorPane.getChildren().add(exitButton);
        anchorPane.getChildren().add(aboutButton);
        getChildren().add(anchorPane);

    }

    protected abstract void signIn(javafx.event.ActionEvent actionEvent);

}
