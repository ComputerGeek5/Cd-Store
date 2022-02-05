package com.example.techstore.controller;

import com.example.techstore.model.Cd;
import com.example.techstore.service.CdService;
import com.example.techstore.view.CdView;
import com.example.techstore.view.EditCdView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditCdController {
    private static final CdService cdService;

    static {
        cdService = new CdService();
    }

    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        CdView view = new CdView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void update(ActionEvent actionEvent, String id) {
        EditCdView view = (EditCdView) ((Node) actionEvent.getSource()).getScene().getRoot();
        boolean updated = cdService.update(view, id);

        if (updated) {
            back(actionEvent);
        }
    }

    public static void delete(ActionEvent actionEvent, String id) {
        Cd cd = new Cd();
        cd.setId(id);

        boolean deleted = cdService.delete(cd);

        if (deleted) {
            back(actionEvent);
        }
    }
}
