package com.example.techstore.service;

import com.example.techstore.model.abst.User;

import static com.example.techstore.controller.AuthController.isAuthenticated;

public class AuthService {
    public void authenticateUser(User attemptUser, User actualUser) {
        String attemptPassword = attemptUser.getPassword();
        String actualPassword = actualUser.getPassword();

        if (attemptPassword.equals(actualPassword)) {
            isAuthenticated = true;
        }
    }
}
