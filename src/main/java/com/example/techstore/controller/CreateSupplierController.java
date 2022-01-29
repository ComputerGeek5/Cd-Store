package com.example.techstore.controller;

import com.example.techstore.model.CD;
import com.example.techstore.model.Supplier;
import com.example.techstore.service.CreateSupplierService;
import com.example.techstore.view.CreateSupplierView;
import com.example.techstore.view.SupplierView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CreateSupplierController {
    private static final CreateSupplierService createSupplierService = new CreateSupplierService();

    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        SupplierView view = new SupplierView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void create(ActionEvent actionEvent) {
        Scene scene = ((Node) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();
        
        CreateSupplierView view = (CreateSupplierView) scene.getRoot();
        Supplier createdSupplier = createSupplierService.create(view);
        
        if (createdSupplier != null) {
            CD updatedCd = createSupplierService.updateCd(createdSupplier);
            if (updatedCd != null) {
                scene = new Scene(new CreateSupplierView(), 1000, 600);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
}
