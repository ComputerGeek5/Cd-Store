package com.example.techstore.controller;

import com.example.techstore.view.HomeView;
import com.example.techstore.view.SignInView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static com.example.techstore.util.Constant.appTitle;

public class HomeController {
    private static final Logger logger = LogManager.getLogger();

    public static void home(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        HomeView home = new HomeView();
        Scene scene = new Scene(home, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    public static void signIn(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        SignInView signIn = new SignInView();
        Scene scene = new Scene(signIn, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    public static void exit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
        closeResources();
    }

    private static void closeResources() {
        
    }
}
