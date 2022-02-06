package com.example.techstore.util;

import com.example.techstore.model.Cd;
import com.example.techstore.repository.CdRepository;
import com.example.techstore.repository.impl.CdRepositoryImpl;
import javafx.scene.control.ComboBox;

import java.util.Set;

public class CashierUtil {
    private static final CdRepository cdRepository = new CdRepositoryImpl();

    public static void fillComboBoxCdsOptions(ComboBox cdsBox) {
        Set<Cd> cds = (Set<Cd>) cdRepository.findAll();

        for (Cd cd: cds) {
            cdsBox.getItems().add(cd.getTitle());
        }
    }
}
