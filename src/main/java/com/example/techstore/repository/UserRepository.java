package com.example.techstore.repository;

import com.example.techstore.model.abst.User;
import com.example.techstore.repository.abst.CRUDRepository;

public interface UserRepository extends CRUDRepository<User> {
    User findByUsername(String username);
}
