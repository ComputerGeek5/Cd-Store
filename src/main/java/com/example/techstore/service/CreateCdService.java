package com.example.techstore.service;

import com.example.techstore.model.CD;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.impl.CDRepositoryImpl;
import com.example.techstore.view.CreateCdView;

import java.util.List;

public class CreateCdService {
    private static final CDRepository cdRepository;

    static {
        cdRepository = new CDRepositoryImpl();
    }

    public boolean createCd(CreateCdView view) {
        String title = view.getTitle().getText();
        String genre = view.getGenre().getText();
        double buyPrice = Double.parseDouble(view.getBuyPrice().getText());
        double sellPrice = Double.parseDouble(view.getSellPrice().getText());
        CD cd = new CD(title, genre, buyPrice, sellPrice);

        CD created = cdRepository.create(cd);

        return created != null;
    }
}
