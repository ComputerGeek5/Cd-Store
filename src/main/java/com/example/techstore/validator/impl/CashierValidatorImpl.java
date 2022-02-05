package com.example.techstore.validator.impl;

import com.example.techstore.model.CD;
import com.example.techstore.validator.CashierValidator;

import static com.example.techstore.util.Alerter.showError;

public class CashierValidatorImpl implements CashierValidator {
    @Override
    public boolean validateCdBalance(CD cd, double quantityToSell) {
        double boughtQuantity = cd.getBoughtQuantity();
        double soldQuantity = cd.getSoldQuantity();
        double balance = boughtQuantity - soldQuantity - quantityToSell;

        return balance >= 0;
    }
}
