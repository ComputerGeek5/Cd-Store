package com.example.techstore.validator;

import com.example.techstore.model.CD;

public interface CashierValidator {
    String cdBalanceErrorMessage = "Out of stock";

    boolean validateCdBalance(CD cd, double quantityToSell);
}
