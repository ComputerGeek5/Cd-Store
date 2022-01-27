package com.example.techstore.service;

import com.example.techstore.controller.CashierController;
import com.example.techstore.controller.HomeController;
import com.example.techstore.model.Bill;
import com.example.techstore.model.CD;
import com.example.techstore.model.Cashier;
import com.example.techstore.repository.BillRepository;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.impl.BillRepositoryImpl;
import com.example.techstore.repository.impl.CDRepositoryImpl;
import com.example.techstore.view.CashierView;
import javafx.scene.control.TextArea;

public class CashierService {
    private static final CDRepository cdRepository;
    private static final BillRepository billRepository;
    private Bill bill;
    private CashierView view;

    static {
        cdRepository = new CDRepositoryImpl();
        billRepository = new BillRepositoryImpl();
    }

    public CashierService(Bill bill, CashierView view) {
        this.bill = bill;
        this.view = view;
    }

    public Bill saveBill() {
        Cashier cashier = (Cashier) HomeController.getUser();
        int billsSold = cashier.getBillsSold();
        cashier.setBillsSold(++billsSold);
        return billRepository.create(bill);
    }


    public boolean addCdToBill() {
        String title = (String) view.getCd().getValue();
        int quantity = Integer.parseInt(view.getQuantity().getText());

        CD cd = cdRepository.findByTitle(title);
        int soldQuantity = cd.getSoldQuantity();
        cd.setSoldQuantity(soldQuantity + quantity);

        double price = cd.getSellPrice() * quantity;
        double total = bill.getTotal() + price;
        bill.setTotal(total);

        return bill.getCds().add(cd);
    }

    public void addCdToBillInformation() {
        TextArea billInformationNode = view.getBillInformation();
        String billInformation = billInformationNode.getText();
        String title = (String) view.getCd().getValue();
        int quantity = Integer.parseInt(view.getQuantity().getText());

        CD cd = bill.getCds().getLast();
        double price = cd.getSellPrice() * quantity;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(billInformation).append("\n");
        stringBuilder.append("CD Title:    ").append(title).append("\n")
        .append("Quantity:    ").append(quantity).append("\n")
        .append("Price:    ").append(price);

        billInformation = stringBuilder.toString();

        billInformationNode.setText(billInformation);
    }


    public boolean removeCdFromBill() {
        int quantity = Integer.parseInt(view.getQuantity().getText());

        CD cd = bill.getCds().getLast();
        int soldQuantity = cd.getSoldQuantity();
        cd.setSoldQuantity(soldQuantity - quantity);

        double price = cd.getSellPrice() * quantity;
        double total = bill.getTotal() - price;
        bill.setTotal(total);

        return bill.getCds().remove(cd);
    }

    public void removeCdFromBillInformation() {
        TextArea billInformationNode = view.getBillInformation();
        String billInformation = billInformationNode.getText();

        for (int i = 0; i < 3; i++) {
            billInformation = billInformation.substring(0, billInformation.lastIndexOf("\n"));
        }

        billInformationNode.setText(billInformation);
    }


    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public CashierView getView() {
        return view;
    }

    public void setView(CashierView view) {
        this.view = view;
    }
}
