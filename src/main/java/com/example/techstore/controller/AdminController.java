package com.example.techstore.controller;

import com.example.techstore.model.Manager;
import com.example.techstore.view.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.techstore.util.Constant.appTitle;

public class AdminController {
    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        HomeView view = new HomeView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    public static void billing(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        BillView view = new BillView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    public static void manager(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ManagerView view = new ManagerView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    public static void staff(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        StaffView view = new StaffView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }
}
