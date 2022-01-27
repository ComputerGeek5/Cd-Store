package com.example.techstore.controller;

import com.example.techstore.model.Bill;
import com.example.techstore.model.abst.User;
import com.example.techstore.service.CashierService;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.*;
import com.example.techstore.view.abst.View;
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
    private static User user;

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
    }

    public static void self(ActionEvent actionEvent) {
        View view;

        if (user.getRole() == Role.ADMIN) {
            view = new AdminView();
        } else if (user.getRole()  == Role.MANAGER) {
            view = new ManagerView();
        } else {
            view = new CashierView();

            Bill bill = new Bill();
            CashierView cashierView = (CashierView) view;
            CashierController.setCashierService(new CashierService(bill, cashierView));
        }

        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        HomeController.user = user;
    }
}
