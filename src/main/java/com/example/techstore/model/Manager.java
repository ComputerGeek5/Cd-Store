package com.example.techstore.model;

import com.example.techstore.model.abst.User;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.ManagerView;

import java.util.Date;

public class Manager extends Employee {
    public Manager() {
        super();
    }

    public Manager(String name, String username, String password, Role role, Date birthday, String phone, String email, double salary) {
        super(name, username, password, role, birthday, phone, email, salary);
    }

    public Manager(User user) {
        this(user.getName(), user.getUsername(), user.getPassword(), user.getRole(), null, null, null, 0);
    }
}
