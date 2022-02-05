package com.example.techstore.validator.impl;

import com.example.techstore.model.Cd;
import com.example.techstore.validator.CdValidator;

public class CdValidatorImpl implements CdValidator {
    @Override
    public boolean validateCreatedCd(Cd cd) {
        return cd != null;
    }

    @Override
    public boolean validateUpdatedCd(Cd cd) {
        return cd != null;
    }
}
