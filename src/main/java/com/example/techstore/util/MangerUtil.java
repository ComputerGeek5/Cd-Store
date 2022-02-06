package com.example.techstore.util;

import com.example.techstore.model.Cd;
import com.example.techstore.model.Genre;
import com.example.techstore.repository.CdRepository;
import com.example.techstore.repository.GenreRepository;
import com.example.techstore.repository.impl.CdRepositoryImpl;
import com.example.techstore.repository.impl.GenreRepositoryImpl;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.techstore.util.Alerter.showWarning;

public class MangerUtil {
    private static final GenreRepository genreRepository;
    private static final CdRepository cdRepository;

    static {
        genreRepository = new GenreRepositoryImpl();
        cdRepository = new CdRepositoryImpl();
    }

    public static void showLowGenres() {
        Set<Genre> genres = (Set<Genre>) genreRepository.findAll();

        for (Genre genre: genres) {
            String lowGenreWarningMessage = "Low stock in genre: " + genre.getName();

            int genreBalance = 0;

            Set<Cd> cds = cdRepository.findAll()
                    .stream()
                    .filter(cd -> cd.getGenre().getId().equals(genre.getId()))
                    .collect(Collectors.toSet());

            for (Cd cd: cds) {
                int cdBalance = cd.getBoughtQuantity() - cd.getSoldQuantity();
                genreBalance += cdBalance;
            }

            if (genreBalance < 5) {
                showWarning(lowGenreWarningMessage);
            }
        }
    }
}
