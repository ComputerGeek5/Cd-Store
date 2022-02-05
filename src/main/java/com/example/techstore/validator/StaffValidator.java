package com.example.techstore.validator;

import com.example.techstore.model.Employee;
import com.example.techstore.model.abst.User;

public interface StaffValidator {
    String usernameTakenErrorMessage = "Username is taken";

    boolean validateCreatedUser(User user);

    boolean validateUpdatedEmployee(Employee user);
}
