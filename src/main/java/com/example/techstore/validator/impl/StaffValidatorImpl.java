package com.example.techstore.validator.impl;

import com.example.techstore.model.Employee;
import com.example.techstore.model.abst.User;
import com.example.techstore.validator.StaffValidator;

public class StaffValidatorImpl implements StaffValidator {
    @Override
    public boolean validateCreatedUser(User user) {
        return user != null;
    }

    @Override
    public boolean validateUpdatedEmployee(Employee user) {
        return user != null;
    }
}
