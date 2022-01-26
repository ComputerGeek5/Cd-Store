package com.example.techstore.controller;

import com.example.techstore.view.CdView;
import com.example.techstore.view.CreateCdView;
import com.example.techstore.view.CreateStaffView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.techstore.util.Constant.appTitle;

public class StaffController {
    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        CdView view = new CdView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }

    public static void add(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        CreateStaffView view = new CreateStaffView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(appTitle);
        stage.show();
    }
}
