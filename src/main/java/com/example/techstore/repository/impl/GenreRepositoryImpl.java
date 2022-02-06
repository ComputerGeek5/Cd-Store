package com.example.techstore.repository.impl;

import com.example.techstore.model.Genre;
import com.example.techstore.repository.GenreRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

public class GenreRepositoryImpl implements GenreRepository {
    private static final String dataLocation = "./src/main/java/com/example/techstore/data/genres.dat";
    private static ObjectOutputStream genresOutput;

    private static Set<Genre> genres;
    private static Logger logger = LogManager.getLogger();

    static {
        initializeData();
    }

    private static void initializeData() {
        genres = tryToInitializeData();
    }

    private static Set<Genre> tryToInitializeData() {
        Set<Genre> genres = new HashSet<>();

        try {
            ObjectInputStream genresInput = new ObjectInputStream(new FileInputStream(dataLocation));
            genres = (Set<Genre>) genresInput.readObject();
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find genres data.");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            if (! (e instanceof EOFException)) {
                logger.fatal("Failed to read genres data.");
                e.printStackTrace();
            }
        }

        return genres;
    }

    private static void initializeOutput() {
        try {
            genresOutput = new ObjectOutputStream(new FileOutputStream(dataLocation));
        } catch (FileNotFoundException e) {
            logger.fatal("Failed to find genres data.");
            e.printStackTrace();
        } catch (IOException e) {
            logger.fatal("Failed to read genres data.");
            e.printStackTrace();
        }
    }


    @Override
    public Genre findByName(String name) {
        for (Genre genre: genres) {
            if (genre.getName().equals(name)) {
                return genre;
            }
        }

        return null;
    }


    @Override
    public Genre findById(String id) {
        Genre found = null;

        for(Genre genre: genres) {
            if (genre.getId().equals(id)) {
                found = genre;
            }
        }

        return found;
    }


    @Override
    public Genre create(Genre genre) {
        Genre created = tryToCreateGenre(genre);
        return created;
    }

    private Genre tryToCreateGenre(Genre genre) {
        initializeOutput();

        try {
            boolean unique = genres.add(genre);
            if (unique) {
                genresOutput.writeObject(genres);
                genresOutput.flush();
                return genre;
            }
        } catch (IOException e) {
            logger.fatal("Failed to create genre.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Set<Genre> findAll() {
        return genres;
    }


    @Override
    public Genre update(Genre genre) {
        initializeOutput();
        Genre before = findById(genre.getId());

        Genre updated = tryToUpdateGenre(before, genre, genres);
        return updated;
    }

    private Genre tryToUpdateGenre(Genre before, Genre after, Set<Genre> genres) {
        try {
            genres.remove(before);
            boolean unique = genres.add(after);
            if (unique) {
                genresOutput.writeObject(genres);
                genresOutput.flush();
                return after;
            }
        } catch (IOException e) {
            logger.fatal("Failed to update genre.");
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Genre delete(Genre genre) {
        initializeOutput();
        genre = findById(genre.getId());

        Genre deleted = tryToDeleteGenre(genre, genres);
        return deleted;
    }

    private static Genre tryToDeleteGenre(Genre genre, Set<Genre> genres) {
        try {
            genres.remove(genre);
            genresOutput.writeObject(genres);
            genresOutput.flush();
            return genre;
        } catch (IOException e) {
            logger.fatal("Failed to delete genre.");
            e.printStackTrace();
        }

        return null;
    }
}
