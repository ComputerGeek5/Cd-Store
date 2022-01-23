package com.example.techstore.service;

import com.example.techstore.model.abst.User;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.repository.impl.UsersRepositoryImpl;

import static com.example.techstore.controller.AuthController.isAuthenticated;

public class AuthService {
    private static final UserRepository userRepository;

    static {
        userRepository = new UsersRepositoryImpl();
    }


    public void authenticateUser(User attemptUser, User actualUser) {
        String attemptPassword = attemptUser.getPassword();
        String actualPassword = actualUser.getPassword();

        if (attemptPassword.equals(actualPassword)) {
            isAuthenticated = true;
        }
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
