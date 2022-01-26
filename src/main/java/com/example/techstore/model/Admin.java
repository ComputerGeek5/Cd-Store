package com.example.techstore.model;

import com.example.techstore.model.abst.User;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.AdminView;

public class Admin extends User {
    public Admin() {
        super();
    }

    public Admin(String name, String username, String password, Role role) {
        super(name, username, password, role);
        this.view = new AdminView();
    }
}
