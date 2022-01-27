package com.example.techstore.util;

import com.example.techstore.model.CD;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.impl.CDRepositoryImpl;
import javafx.scene.control.ComboBox;

import java.util.List;

public class CashierViewUtil {
    private static final CDRepository cdRepository = new CDRepositoryImpl();

    public static void fillComboBoxCdsOptions(ComboBox cdsBox) {
        List<CD> cds = cdRepository.getAll();

        for (CD cd: cds) {
            cdsBox.getItems().add(cd.getTitle());
        }
    }
}
