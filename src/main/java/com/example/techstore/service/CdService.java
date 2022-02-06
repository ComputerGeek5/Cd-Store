package com.example.techstore.service;

import com.example.techstore.model.Cd;
import com.example.techstore.model.Genre;
import com.example.techstore.repository.CdRepository;
import com.example.techstore.repository.impl.CdRepositoryImpl;
import com.example.techstore.validator.CdValidator;
import com.example.techstore.validator.impl.CdValidatorImpl;
import com.example.techstore.view.EditCdView;

import java.util.Set;

import static com.example.techstore.util.Alerter.showError;
import static com.example.techstore.validator.CdValidator.cdExistsErrorMessage;

public class CdService {
    private static final CdRepository cdRepository;
    private static final CdValidator cdValidator;

    static {
        cdRepository = new CdRepositoryImpl();
        cdValidator = new CdValidatorImpl();
    }

    public Set<Cd> findAll() {
        return (Set<Cd>) cdRepository.findAll();
    }

    public Cd findById(String id) {
        return cdRepository.findById(id);
    }

    public boolean update(EditCdView view, String id) {
        String title = view.getTitle().getText();
        Genre genre = view.getGenres().getValue();
        double buyPrice = Double.parseDouble(view.getBuyPrice().getText());
        double sellPrice = Double.parseDouble(view.getSellPrice().getText());

        Cd newCd = new Cd(title, genre, buyPrice, sellPrice);
        newCd.setId(id);

        Cd updated = cdRepository.update(newCd);
        boolean validUpdatedCd = cdValidator.validateUpdatedCd(updated);

        if (validUpdatedCd) {
            showError(cdExistsErrorMessage);
            return false;
        }

        return true;
    }

    public boolean delete(Cd cd) {
        Cd deleted = cdRepository.delete(cd);
        return deleted != null;
    }
}
