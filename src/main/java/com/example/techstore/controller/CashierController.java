package com.example.techstore.controller;

import com.example.techstore.model.Bill;
import com.example.techstore.service.CashierService;
import com.example.techstore.view.CashierView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.example.techstore.util.Constant.appTitle;

public class CashierController {
    private static CashierService cashierService;

    public static void addToBill(ActionEvent actionEvent) {
        CashierView view = (CashierView) actionEvent.getSource();

        boolean cdAdded = cashierService.addCdToBill();
        if (cdAdded) {
            cashierService.addCdToBillInformation();
        }
    }

    public static void checkOut(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        Bill created = cashierService.saveBill();
        if (created != null) {
            CashierView view = new CashierView();
            cashierService = new CashierService(new Bill(), view);

            Scene scene = new Scene(view, 1000, 600);
            stage.setScene(scene);
            stage.setTitle(appTitle);
            stage.show();
        }
    }

    public static void removeLast(ActionEvent actionEvent) {
        CashierView view = (CashierView) actionEvent.getSource();

        boolean cdRemoved = cashierService.removeCdFromBill();
        if (cdRemoved) {
            cashierService.removeCdFromBillInformation();
        }
    }

    public static void back(ActionEvent actionEvent) {
        HomeController.home(actionEvent);
    }


    public static CashierService getCashierService() {
        return cashierService;
    }

    public static void setCashierService(CashierService cashierService) {
        CashierController.cashierService = cashierService;
    }
}
