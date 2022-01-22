package com.example.techstore.controller;

import com.example.techstore.model.Admin;
import com.example.techstore.model.Cashier;
import com.example.techstore.model.Employee;
import com.example.techstore.model.Manager;
import com.example.techstore.model.abst.User;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.repository.UsersRepositoryImpl;
import com.example.techstore.view.*;
import com.example.techstore.view.abst.View;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static com.example.techstore.util.Constant.appTitle;


public class AuthController {
    public static Boolean isAuthenticated;
    private static final UserRepository userRepository;

    static {
        isAuthenticated = false;
        userRepository = new UsersRepositoryImpl();
    }

    public static void signIn(ActionEvent actionEvent) {
        View view = new SignInView();

        SignInView signIn = (SignInView) actionEvent.getSource();
        String username = signIn.getUsernameField().getText();
        String password = signIn.getPasswordField().getText();

        User user = userRepository.findByUsername(username);
        if (user != null) {
            User attemptUser = (User) user.clone();
            attemptUser.setPassword(password);

            authenticateUser(attemptUser, user);
            view = renderViewByRole(user);
        }

        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    private static void authenticateUser(User attemptUser, User actualUser) {
        String attemptPassword = attemptUser.getPassword();
        String actualPassword = actualUser.getPassword();

        if (attemptPassword.equals(actualPassword)) {
            isAuthenticated = true;
        }
    }

    public static View renderViewByRole(User user) {
        View view;
        if (user instanceof Admin) {
            view = new AdminView();
        } else if (user instanceof Manager) {
            view = new ManagerView();
        } else {
            view = new CashierView();
        }
        return view;
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
