package com.example.techstore.controller;

import com.example.techstore.view.CreateSupplierView;
import com.example.techstore.view.ManagerView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.techstore.util.Constant.appTitle;

public class SupplierController {
    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ManagerView view = new ManagerView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    public static void add(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        CreateSupplierView view = new CreateSupplierView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }
}
