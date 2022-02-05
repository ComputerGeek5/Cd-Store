package com.example.techstore.controller;

import com.example.techstore.model.CD;
import com.example.techstore.model.Employee;
import com.example.techstore.service.CdService;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.CdView;
import com.example.techstore.view.EditCdView;
import com.example.techstore.view.EditStaffView;
import com.example.techstore.view.ManagerView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EditCdController {
    private static final CdService cdService;

    static {
        cdService = new CdService();
    }

    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        CdView view = new CdView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void update(ActionEvent actionEvent, String id) {
        EditCdView view = (EditCdView) ((Node) actionEvent.getSource()).getScene().getRoot();
        String title = view.getTitle().getText();
        String genre = view.getGenre().getText();
        double buyPrice = Double.parseDouble(view.getBuyPrice().getText());
        double sellPrice = Double.parseDouble(view.getSellPrice().getText());

        CD newCd = new CD(title, genre, buyPrice, sellPrice);
        newCd.setId(id);

        CD updated = cdService.update(newCd);

        if (updated != null) {
            back(actionEvent);
        }
    }

    public static void delete(ActionEvent actionEvent, String id) {
        CD cd = new CD();
        cd.setId(id);

        CD deleted = cdService.delete(cd);

        if (deleted != null) {
            back(actionEvent);
        }
    }
}
