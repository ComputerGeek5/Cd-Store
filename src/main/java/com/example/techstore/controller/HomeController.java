package com.example.techstore.controller;

import com.example.techstore.view.HomeView;
import com.example.techstore.view.SignInView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeController {
    public static void home(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        HomeView home = new HomeView();
        Scene scene = new Scene(home, 1000, 600);
        stage.setScene(scene);
        stage.setTitle("Banking System");
        stage.show();
    }

    public static void signIn(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        SignInView signIn = new SignInView();
        Scene scene = new Scene(signIn, 1000, 600);
        stage.setScene(scene);
        stage.setTitle("Banking System");
        stage.show();
    }
}
