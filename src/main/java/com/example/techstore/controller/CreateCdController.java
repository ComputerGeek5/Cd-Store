package com.example.techstore.controller;

import com.example.techstore.service.CreateCdService;
import com.example.techstore.view.CdView;
import com.example.techstore.view.CreateCdView;
import com.example.techstore.view.SupplierView;
import com.example.techstore.view.abst.View;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.techstore.util.Constant.appTitle;

public class CreateCdController {
    private static final CreateCdService createCdService;

    static {
        createCdService = new CreateCdService();
    }

    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        CdView view = new CdView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void create(ActionEvent actionEvent) {
        CreateCdView view = (CreateCdView) ((Node) actionEvent.getSource()).getScene().getRoot();
        boolean isCreated =  createCdService.createCd(view);

        if (isCreated) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            view = new CreateCdView();
            Scene scene = new Scene(view, 1000, 600);
            stage.setScene(scene);
            stage.show();
        }
    }
}
