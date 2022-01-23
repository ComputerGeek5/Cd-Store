package com.example.techstore.model;

import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.ManagerView;

import java.util.Date;

public class Manager extends Employee {
    public Manager(String name, String username, String password, Role role, Date birthday, String phone, String email, double salary) {
        super(name, username, password, role, birthday, phone, email, salary);
        this.view = new ManagerView();
    }
}
