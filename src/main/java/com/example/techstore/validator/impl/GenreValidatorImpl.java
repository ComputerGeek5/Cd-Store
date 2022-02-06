package com.example.techstore.validator.impl;

import com.example.techstore.model.Genre;
import com.example.techstore.validator.GenreValidator;

public class GenreValidatorImpl implements GenreValidator {
    public boolean validateCreatedGenre(Genre genre) {
        return genre != null;
    }
}
