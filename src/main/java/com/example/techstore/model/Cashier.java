package com.example.techstore.model;

import com.example.techstore.util.enumerator.Role;

import java.util.Date;

public class Cashier extends Employee {
    public Cashier(String name, String username, String password, Role role, Date birthday, String phone, String email, Double salary) {
        super(name, username, password, role, birthday, phone, email, salary);
    }
}
