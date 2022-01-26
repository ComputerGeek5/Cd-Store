package com.example.techstore.view;

import com.example.techstore.controller.AuthController;
import com.example.techstore.controller.HomeController;
import com.example.techstore.view.abst.View;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import static com.example.techstore.controller.AuthController.isAuthenticated;

public class HomeView extends View {
    private AnchorPane anchorPane;
    private Button signIn;
    private Button signOut;
    private Button exitButton;
    private Button aboutButton;

    public HomeView() {
        anchorPane = new AnchorPane();
        signIn = new Button();
        signOut = new Button();
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
        signIn.setOnAction(HomeController::signIn);
        signIn.setPrefHeight(40.0);
        signIn.setPrefWidth(200.0);
        signIn.getStyleClass().add("button-secondary");
        signIn.setText("Sign In");

        signOut.setLayoutX(300.0);
        signOut.setLayoutY(430.0);
        signOut.setMnemonicParsing(false);
        signOut.setOnAction(AuthController::signOut);
        signOut.setPrefHeight(40.0);
        signOut.setPrefWidth(200.0);
        signOut.getStyleClass().add("button-danger");
        signOut.setText("Sign Out");

        exitButton.setLayoutX(300.0);
        exitButton.setLayoutY(530.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setOnAction(HomeController::exit);
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

        if (isAuthenticated) {
            anchorPane.getChildren().remove(signIn);
            anchorPane.getChildren().add(signOut);
        } else {
            anchorPane.getChildren().add(signIn);
        }

        anchorPane.getChildren().add(exitButton);
        anchorPane.getChildren().add(aboutButton);
        getChildren().add(anchorPane);
    }
}
