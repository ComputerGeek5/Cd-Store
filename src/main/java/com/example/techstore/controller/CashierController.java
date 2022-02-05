package com.example.techstore.controller;

import com.example.techstore.model.Bill;
import com.example.techstore.service.CashierService;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.AdminView;
import com.example.techstore.view.CashierView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CashierController {
    private static CashierService cashierService;

    public static void addToBill(ActionEvent actionEvent) {
        boolean cdAdded = cashierService.addCdToBill();
        if (cdAdded) {
            cashierService.addCdToBillInformation();
        }
    }

    public static void checkOut(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Bill created = cashierService.saveBill();
        if (created != null) {
            boolean savedBillFile = cashierService.saveBillFile(created);
            if (savedBillFile) {
//                cashierService.openBillFile(created);
            }

            CashierView view = new CashierView();
            cashierService = new CashierService(new Bill(), view);

            Scene scene = new Scene(view, 1000, 600);
            stage.setScene(scene);
            stage.show();
        }
    }

    public static void removeLast(ActionEvent actionEvent) {
        boolean cdRemoved = cashierService.removeCdFromBill();
        if (cdRemoved) {
            cashierService.removeCdFromBillInformation();
        }
    }

    public static void back(ActionEvent actionEvent) {
        if (HomeController.getUser().getRole() == Role.ADMIN) {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            AdminView view = new AdminView();
            Scene scene = new Scene(view, 1000, 600);
            stage.setScene(scene);
            stage.show();
        } else {
            HomeController.home(actionEvent);
        }
    }

    public static CashierService getCashierService() {
        return cashierService;
    }

    public static void setCashierService(CashierService cashierService) {
        CashierController.cashierService = cashierService;
    }
}
