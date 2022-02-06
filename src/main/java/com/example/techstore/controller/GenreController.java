package com.example.techstore.controller;

import com.example.techstore.model.Genre;
import com.example.techstore.service.GenreService;
import com.example.techstore.view.CdView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class GenreController {
    private static final GenreService genreService;

    static {
        genreService = new GenreService();
    }

    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        CdView view = new CdView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void add(ActionEvent actionEvent) {
        TextInputDialog inputDialog = new TextInputDialog();
        inputDialog.setHeaderText("Genre");
        inputDialog.setContentText("Genre Name");
        inputDialog.showAndWait();

        boolean created = genreService.create(inputDialog);

        if (created) {
            CdController.genres(actionEvent);
        }
    }
}
