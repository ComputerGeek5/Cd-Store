package com.example.techstore.controller;

import com.example.techstore.model.Bill;
import com.example.techstore.service.CashierService;
import com.example.techstore.view.CashierView;
import javafx.event.ActionEvent;

public class CashierController {
    private static CashierService cashierService;

    public static void addToBill(ActionEvent actionEvent) {
        CashierView view = ((CashierView) actionEvent.getSource());

        boolean cdAdded = cashierService.addCdToBill();
        if (cdAdded) {
            cashierService.addCdToBillInformation();
        }
    }

    public static void checkOut(ActionEvent actionEvent) {
        CashierView view = ((CashierView) actionEvent.getSource());

        Bill created = cashierService.saveBill();
        if (created != null) {
            view = new CashierView();
            cashierService = new CashierService(new Bill(), view);
        }
    }

    public static void removeLast(ActionEvent actionEvent) {
        CashierView view = ((CashierView) actionEvent.getSource());

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
}
