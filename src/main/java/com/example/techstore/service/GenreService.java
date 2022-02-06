package com.example.techstore.service;

import com.example.techstore.model.Genre;
import com.example.techstore.repository.GenreRepository;
import com.example.techstore.repository.impl.GenreRepositoryImpl;
import com.example.techstore.validator.GenreValidator;
import com.example.techstore.validator.impl.GenreValidatorImpl;
import javafx.scene.control.TextInputDialog;

import java.util.List;
import java.util.Set;

import static com.example.techstore.util.Alerter.showError;
import static com.example.techstore.validator.GenreValidator.genreExistsMessage;

public class GenreService {
    private static final GenreRepository genreRepository;
    private static final GenreValidator genreValidator;

    static {
        genreRepository = new GenreRepositoryImpl();
        genreValidator = new GenreValidatorImpl();
    }

    public Set<Genre> findAll() {
        return (Set<Genre>) genreRepository.findAll();
    }

    public boolean delete(Genre genre) {
        Genre deleted =  genreRepository.delete(genre);
        return deleted != null;
    }

    public boolean create(TextInputDialog inputDialog) {
        String name = inputDialog.getEditor().getText();
        Genre genre = new Genre(name);

        Genre created =  genreRepository.create(genre);

        boolean validCreatedGenre = genreValidator.validateCreatedGenre(created);
        if (!validCreatedGenre) {
            showError(genreExistsMessage);
            return false;
        }

        return true;
    }

    public Genre findGenreByName(String name) {
        return genreRepository.findByName(name);
    }
}
