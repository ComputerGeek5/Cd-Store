package com.example.techstore.controller;

import com.example.techstore.model.Bill;
import com.example.techstore.service.BillService;
import com.example.techstore.service.CDService;
import com.example.techstore.view.CashierView;
import javafx.event.ActionEvent;

public class CashierController {
    private static final CDService cdService = new CDService();
    private static final BillService billService = new BillService();
    private static Bill bill = new Bill();

    public static void addToBill(ActionEvent actionEvent) {
        CashierView view = ((CashierView) actionEvent.getSource());
        boolean cdAdded = billService.addCdToBill(bill, view);

        if (cdAdded) {
            billService.addCdToBillInformation(bill, view);
        }
    }

    public static void checkOut(ActionEvent actionEvent) {
        CashierView view = ((CashierView) actionEvent.getSource());

        Bill created = billService.saveBill(bill);
        if (created != null) {
            view = new CashierView();
            bill = new Bill();
        }
    }

    public static void removeLast(ActionEvent actionEvent) {
        CashierView view = ((CashierView) actionEvent.getSource());
        boolean cdRemoved = billService.removeCdFromBill(bill, view);

        if (cdRemoved) {
            billService.removeCdFromBillInformation(bill, view);
        }
    }

    public static void back(ActionEvent actionEvent) {
        HomeController.home(actionEvent);
    }
}
