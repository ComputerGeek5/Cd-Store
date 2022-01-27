package com.example.techstore.controller;

import com.example.techstore.model.Bill;
import com.example.techstore.model.Cashier;
import com.example.techstore.model.abst.User;
import com.example.techstore.service.AuthService;
import com.example.techstore.service.CashierService;
import com.example.techstore.util.enumerator.Role;
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

        SignInView signInView = (SignInView) ((Node) actionEvent.getSource()).getScene().getRoot();
        String username = signInView.getUsernameField().getText();
        String password = signInView.getPasswordField().getText();

        User user = authService.findByUsername(username);
        if (user != null) {
            User attemptUser = (User) user.clone();
            attemptUser.setPassword(password);

            authService.authenticateUser(attemptUser, user);

            if (isAuthenticated) {
                HomeController.setUser(user);
                HomeController.self(actionEvent);
            } else {
                Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(view, 1000, 600);
                stage.setScene(scene);
                stage.setTitle(appTitle);
                stage.show();
            }
        }
    }

    public static void signOut(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        isAuthenticated = false;
        HomeView homeView = new HomeView();
        Scene scene = new Scene(homeView, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }
}
