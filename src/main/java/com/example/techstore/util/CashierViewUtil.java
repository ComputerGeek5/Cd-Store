package com.example.techstore.util;

import com.example.techstore.model.Cd;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.impl.CDRepositoryImpl;
import javafx.scene.control.ComboBox;

import java.util.Set;

public class CashierViewUtil {
    private static final CDRepository cdRepository = new CDRepositoryImpl();

    public static void fillComboBoxCdsOptions(ComboBox cdsBox) {
        Set<Cd> cds = (Set<Cd>) cdRepository.findAll();

        for (Cd cd: cds) {
            cdsBox.getItems().add(cd.getTitle());
        }
    }
}
