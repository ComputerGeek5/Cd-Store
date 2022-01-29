package com.example.techstore.controller;

import com.example.techstore.model.Cashier;
import com.example.techstore.view.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.techstore.util.Constant.appTitle;

public class ManagerController {
    public static void cd(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        CdView view = new CdView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void supplier(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        SupplierView view = new SupplierView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void bill(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        BillView view = new BillView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void back(ActionEvent actionEvent) {
        HomeController.home(actionEvent);
    }
}
