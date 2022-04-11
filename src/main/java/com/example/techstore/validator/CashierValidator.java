package com.example.techstore.validator;

import com.example.techstore.model.Bill;
import com.example.techstore.model.Cd;

public interface CashierValidator {
    String cdBalanceErrorMessage = "Out of stock";

    boolean validateCdBalance(Cd cd, double quantityToSell);

    boolean validateBill(Bill bill);
}
