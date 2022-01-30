package com.example.techstore.service;

import com.example.techstore.model.CD;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.impl.CDRepositoryImpl;

import java.util.List;

public class CdService {
    private static final CDRepository cdRepository;

    static {
        cdRepository = new CDRepositoryImpl();
    }

    public List<CD> getAll() {
        return cdRepository.getAll();
    }
}
