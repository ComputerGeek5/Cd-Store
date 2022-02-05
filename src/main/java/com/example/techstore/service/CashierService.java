package com.example.techstore.service;

import com.example.techstore.controller.HomeController;
import com.example.techstore.model.Bill;
import com.example.techstore.model.Cd;
import com.example.techstore.model.abst.User;
import com.example.techstore.repository.BillRepository;
import com.example.techstore.repository.CDRepository;
import com.example.techstore.repository.impl.BillRepositoryImpl;
import com.example.techstore.repository.impl.CDRepositoryImpl;
import com.example.techstore.validator.CashierValidator;
import com.example.techstore.validator.impl.CashierValidatorImpl;
import com.example.techstore.view.CashierView;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.techstore.util.Alerter.showError;
import static com.example.techstore.validator.CashierValidator.cdBalanceErrorMessage;

public class CashierService {
    private static final CDRepository cdRepository;
    private static final BillRepository billRepository;
    private static final CashierValidator cashierValidator;

    private Bill bill;
    private CashierView view;

    static {
        cdRepository = new CDRepositoryImpl();
        billRepository = new BillRepositoryImpl();
        cashierValidator = new CashierValidatorImpl();
    }

    public CashierService(Bill bill, CashierView view) {
        this.bill = bill;
        this.view = view;
    }

    public Bill saveBill() {
        User issuer = HomeController.getUser();
        bill.setIssuer(issuer);
        bill.setBillInformation(view.getBillInformation().getText());

        for (Cd cd: bill.getCds()) {
            cdRepository.update(cd);
        }
        return billRepository.create(bill);
    }

    public boolean saveBillFile(Bill bill) {
        File resources = new File("./src/main/resources/com/example/techstore/static/data/dummy.txt");
        String billDataLocation = resources.getAbsolutePath();
        billDataLocation = billDataLocation.substring(0, billDataLocation.lastIndexOf("\\"));
        String fileLocation = billDataLocation + "\\bill_" + bill.getId() + ".txt";
        File billFile = new File(fileLocation);

        tryToSaveBillFile(billFile);
        boolean saved = tryToWriteBillInformation(billFile, bill.getBillInformation());
        return saved;
    }

    private static void tryToSaveBillFile(File billFile) {
        try {
            billFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean tryToWriteBillInformation(File billFile, String billInformation) {
        try {
            FileWriter myWriter = new FileWriter(billFile.getAbsolutePath());
            myWriter.write(billInformation);
            myWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addCdToBill() {
        String title = (String) view.getCd().getValue();
        int quantity = Integer.parseInt(view.getQuantity().getText());

        Cd cd = cdRepository.findByTitle(title);
        int soldQuantity = cd.getSoldQuantity();

        boolean validCdBalance = cashierValidator.validateCdBalance(cd, quantity);
        if (!validCdBalance) {
            showError(cdBalanceErrorMessage);
            return false;
        }

        cd.setSoldQuantity(soldQuantity + quantity);

        double price = cd.getSellPrice() * quantity;
        double total = bill.getTotal() + price;
        bill.setTotal(total);

        return bill.getCds().add(cd);
    }

    public void addCdToBillInformation() {
        TextArea billInformationNode = view.getBillInformation();
        String billInformation = billInformationNode.getText();
        billInformation = billInformation.substring(billInformation.indexOf("\n"));
        String total = "Total:    " + bill.getTotal();
        String title = (String) view.getCd().getValue();
        int quantity = Integer.parseInt(view.getQuantity().getText());

        Cd cd = bill.getCds().getLast();
        double price = cd.getSellPrice() * quantity;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(total).append(billInformation).append("\n");
        stringBuilder.append("CD Title:    ").append(title).append("\n")
        .append("Quantity:    ").append(quantity).append("\n")
        .append("Price:    ").append(price);

        billInformation = stringBuilder.toString();

        billInformationNode.setText(billInformation);
    }


    public boolean removeCdFromBill() {
        int quantity = Integer.parseInt(view.getQuantity().getText());

        Cd cd = cdRepository.findByTitle(bill.getCds().getLast().getTitle());
        int soldQuantity = cd.getSoldQuantity();
        cd.setSoldQuantity(soldQuantity - quantity);

        double price = cd.getSellPrice() * quantity;
        double total = bill.getTotal() - price;
        bill.setTotal(total);

        return bill.getCds().remove(cd);
    }

    public void removeCdFromBillInformation() {
        TextArea billInformationNode = view.getBillInformation();
        String total = "Total:    " + bill.getTotal();
        String billInformation = billInformationNode.getText();
        billInformation = billInformation.substring(billInformation.indexOf("\n"));

        for (int i = 0; i < 3; i++) {
            billInformation = billInformation.substring(0, billInformation.lastIndexOf("\n"));
        }

        billInformation = total + billInformation;

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
