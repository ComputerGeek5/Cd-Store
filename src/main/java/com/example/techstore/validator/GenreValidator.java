package com.example.techstore.validator;

import com.example.techstore.model.Genre;

public interface GenreValidator {
    String genreExistsMessage = "This genre already exists";

    boolean validateCreatedGenre(Genre genre);
}
