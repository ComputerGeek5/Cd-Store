package com.example.techstore.controller;

import com.example.techstore.model.Cd;
import com.example.techstore.model.Genre;
import com.example.techstore.service.GenreService;
import com.example.techstore.view.GenreView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.GenericArrayType;

public class EditGenreController {
    private static final GenreService genreService;

    static {
        genreService = new GenreService();
    }

    public static void delete(ActionEvent actionEvent, String id) {
        Genre genre = new Genre();
        genre.setId(id);

        boolean deleted = genreService.delete(genre);

        if (deleted) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            GenreView view = new GenreView();
            Scene scene = new Scene(view, 1000, 600);
            stage.setScene(scene);
            stage.show();
        }
    }
}
