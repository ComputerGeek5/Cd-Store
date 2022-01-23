package com.example.techstore.service;

import com.example.techstore.model.CD;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.impl.CDRepositoryImpl;

public class CDService {
    private static final CDRepository cdRepository;

    static {
        cdRepository = new CDRepositoryImpl();
    }

    public CD findByTitle(String title) {
        return cdRepository.findByTitle(title);
    }
}
