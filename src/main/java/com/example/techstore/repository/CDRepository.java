package com.example.techstore.repository;

import com.example.techstore.model.CD;
import com.example.techstore.repository.abst.CRUDRepository;

public interface CDRepository extends CRUDRepository<CD> {
    CD findByTitle(String title);
}
