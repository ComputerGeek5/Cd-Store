package com.example.techstore.repository;

import com.example.techstore.model.Cd;
import com.example.techstore.repository.abst.CRUDRepository;

public interface CdRepository extends CRUDRepository<Cd> {
    Cd findByTitle(String title);
}
