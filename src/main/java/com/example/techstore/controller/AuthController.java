package com.example.techstore.controller;

import com.example.techstore.model.abst.User;
import com.example.techstore.service.AuthService;
import com.example.techstore.view.*;
import com.example.techstore.view.abst.View;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.techstore.util.Constant.appTitle;

public class AuthController {
    public static Boolean isAuthenticated;
    private static final AuthService authService;

    static {
        isAuthenticated = false;
        authService = new AuthService();
    }

    public static void signIn(ActionEvent actionEvent) {
        View view = new SignInView();

        SignInView signIn = (SignInView) actionEvent.getSource();
        String username = signIn.getUsernameField().getText();
        String password = signIn.getPasswordField().getText();

        User user = authService.findByUsername(username);
        if (user != null) {
            User attemptUser = (User) user.clone();
            attemptUser.setPassword(password);

            authService.authenticateUser(attemptUser, user);
            view = user.getView();
        }

        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    public static void signOut(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        HomeView homeView = new HomeView();
        Scene scene = new Scene(homeView, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
        isAuthenticated = false;
    }
}
