package com.example.techstore.util;

import com.example.techstore.model.Genre;
import com.example.techstore.repository.GenreRepository;
import com.example.techstore.repository.impl.GenreRepositoryImpl;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Set;

public class CreateCdViewUtil {
    private static final GenreRepository genreRepository = new GenreRepositoryImpl();

    public static void fillComboBoxGenresOptions(ComboBox<Genre> genresBox) {
        Set<Genre> genres = (Set<Genre>) genreRepository.findAll();

        for (Genre genre: genres) {
            genresBox.getItems().add(genre);
        }
    }
}
