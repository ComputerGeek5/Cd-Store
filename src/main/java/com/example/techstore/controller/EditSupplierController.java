package com.example.techstore.controller;

import com.example.techstore.model.Employee;
import com.example.techstore.model.Supplier;
import com.example.techstore.service.SupplierService;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.EditStaffView;
import com.example.techstore.view.StaffView;
import com.example.techstore.view.SupplierView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EditSupplierController {
    private static final SupplierService supplierService;

    static {
        supplierService = new SupplierService();
    }

    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        SupplierView view = new SupplierView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void delete(ActionEvent actionEvent, String id) {
        Supplier supplier = new Supplier();
        supplier.setId(id);

        Supplier deleted = supplierService.delete(supplier);

        if (deleted != null) {
            back(actionEvent);
        }
    }
}
