package com.example.techstore.repository;

import com.example.techstore.model.abst.User;

public interface UserRepository extends CRUDRepository<User> {
    User findByUsername(String username);
}
