package com.example.techstore.service;

import com.example.techstore.model.Cd;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.impl.CDRepositoryImpl;
import com.example.techstore.validator.CdValidator;
import com.example.techstore.validator.impl.CdValidatorImpl;
import com.example.techstore.view.CreateCdView;

import static com.example.techstore.util.Alerter.showError;
import static com.example.techstore.validator.CdValidator.cdExistsErrorMessage;

public class CreateCdService {
    private static final CDRepository cdRepository;
    private static final CdValidator createCdValidator;

    static {
        cdRepository = new CDRepositoryImpl();
        createCdValidator = new CdValidatorImpl();
    }

    public boolean createCd(CreateCdView view) {
        String title = view.getTitle().getText();
        String genre = view.getGenre().getText();
        double buyPrice = Double.parseDouble(view.getBuyPrice().getText());
        double sellPrice = Double.parseDouble(view.getSellPrice().getText());
        Cd cd = new Cd(title, genre, buyPrice, sellPrice);

        Cd created = cdRepository.create(cd);
        boolean validCreatedCd = createCdValidator.validateCreatedCd(created);

        if (!validCreatedCd) {
            showError(cdExistsErrorMessage);
            return false;
        }

        return true;
    }
}
