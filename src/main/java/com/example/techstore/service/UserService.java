package com.example.techstore.service;

import com.example.techstore.model.abst.User;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.repository.impl.UsersRepositoryImpl;

public class UserService {
    private static final UserRepository userRepository;

    static {
        userRepository = new UsersRepositoryImpl();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
