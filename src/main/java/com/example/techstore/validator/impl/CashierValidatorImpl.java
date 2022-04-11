package com.example.techstore.validator.impl;

import com.example.techstore.model.Bill;
import com.example.techstore.model.Cd;
import com.example.techstore.validator.CashierValidator;

public class CashierValidatorImpl implements CashierValidator {
    @Override
    public boolean validateCdBalance(Cd cd, double quantityToSell) {
        double boughtQuantity = cd.getBoughtQuantity();
        double soldQuantity = cd.getSoldQuantity();
        double balance = boughtQuantity - soldQuantity - quantityToSell;

        return balance >= 0;
    }

    @Override
    public boolean validateBill(Bill bill) {
        return bill.getCds().size() > 0;
    }
}
