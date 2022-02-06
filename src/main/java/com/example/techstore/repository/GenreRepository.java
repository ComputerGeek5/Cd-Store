package com.example.techstore.repository;

import com.example.techstore.model.Genre;
import com.example.techstore.repository.abst.CRUDRepository;

public interface GenreRepository extends CRUDRepository<Genre> {
    Genre findByName(String name);
}
