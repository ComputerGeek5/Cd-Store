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
    private Button home;
    private Button signIn;
    private Button signOut;
    private Button exitButton;

    public HomeView() {
        anchorPane = new AnchorPane();
        home = new Button();
        signIn = new Button();
        signOut = new Button();
        exitButton = new Button();

        setPrefHeight(600.0);
        setPrefWidth(1000.0);
        getStyleClass().add("main");
        getStylesheets().add("/com/example/techstore/static/style.css");

        VBox.setVgrow(anchorPane, javafx.scene.layout.Priority.ALWAYS);
        anchorPane.setPrefWidth(1000.0);

        signIn.setLayoutX(400.0);
        signIn.setLayoutY(450.0);
        signIn.setOnAction(HomeController::signIn);
        signIn.setPrefHeight(40.0);
        signIn.setPrefWidth(200.0);
        signIn.getStyleClass().add("button-secondary");
        signIn.setText("Sign In");

        signOut.setLayoutX(400.0);
        signOut.setLayoutY(375.0);
        signOut.setOnAction(AuthController::signOut);
        signOut.setPrefHeight(40.0);
        signOut.setPrefWidth(200.0);
        signOut.getStyleClass().add("button-danger");
        signOut.setText("Sign Out");

        exitButton.setLayoutX(400.0);
        exitButton.setLayoutY(525.0);
        exitButton.setOnAction(HomeController::exit);
        exitButton.setPrefHeight(40.0);
        exitButton.setPrefWidth(200.0);
        exitButton.getStyleClass().add("button-danger");
        exitButton.setText("Exit");

        home.setLayoutX(400.0);
        home.setLayoutY(450.0);
        home.setOnAction(HomeController::self);
        home.setPrefHeight(40.0);
        home.setPrefWidth(200.0);
        home.getStyleClass().add("button-primary");
        home.setText("Home");

        if (isAuthenticated) {
            anchorPane.getChildren().remove(signIn);
            anchorPane.getChildren().add(signOut);
        } else {
            anchorPane.getChildren().remove(signOut);
            anchorPane.getChildren().add(signIn);
        }

        anchorPane.getChildren().add(exitButton);

        if (isAuthenticated) {
            anchorPane.getChildren().add(home);
        }

        getChildren().add(anchorPane);
    }
}
