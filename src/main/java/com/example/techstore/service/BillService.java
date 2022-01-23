package com.example.techstore.service;

import com.example.techstore.model.Bill;
import com.example.techstore.model.CD;
import com.example.techstore.repository.BillRepository;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.impl.BillRepositoryImpl;
import com.example.techstore.repository.impl.CDRepositoryImpl;
import com.example.techstore.view.CashierView;
import javafx.scene.control.TextArea;

public class BillService {
    private static final CDRepository cdRepository;
    private static final BillRepository billRepository;

    static {
        cdRepository = new CDRepositoryImpl();
        billRepository = new BillRepositoryImpl();
    }

    public Bill saveBill(Bill bill) {
        return billRepository.create(bill);
    }


    public boolean addCdToBill(Bill bill, CashierView view) {
        String title = view.getTitle().getText();
        int quantity = Integer.parseInt(view.getQuantity().getText());

        CD cd = cdRepository.findByTitle(title);
        int soldQuantity = cd.getSoldQuantity();
        cd.setSoldQuantity(soldQuantity + quantity);

        double price = cd.getSellPrice() * quantity;
        double total = bill.getTotal() + price;
        bill.setTotal(total);

        return bill.getCds().add(cd);
    }

    public void addCdToBillInformation(Bill bill, CashierView view) {
        TextArea billInformationNode = view.getBillInformation();
        String billInformation = billInformationNode.getText();
        String title = view.getTitle().getText();
        int quantity = Integer.parseInt(view.getQuantity().getText());

        CD cd = bill.getCds().getLast();
        double price = cd.getSellPrice() * quantity;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(billInformation).append("\n");
        stringBuilder.append("CD Title:    ").append(title)
        .append("    Quantity:    ").append(quantity)
        .append("    Price:    ").append(price);

        billInformation = stringBuilder.toString();

        billInformationNode.setText(billInformation);
    }


    public boolean removeCdFromBill(Bill bill, CashierView view) {
        int quantity = Integer.parseInt(view.getQuantity().getText());

        CD cd = bill.getCds().getLast();
        int soldQuantity = cd.getSoldQuantity();
        cd.setSoldQuantity(soldQuantity - quantity);

        double price = cd.getSellPrice() * quantity;
        double total = bill.getTotal() - price;
        bill.setTotal(total);

        return bill.getCds().remove(cd);
    }

    public void removeCdFromBillInformation(Bill bill, CashierView view) {
        TextArea billInformationNode = view.getBillInformation();
        String billInformation = billInformationNode.getText();
        billInformation = billInformation.substring(0, billInformation.lastIndexOf("\n"));

        billInformationNode.setText(billInformation);
    }
}
