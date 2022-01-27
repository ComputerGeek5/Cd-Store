package com.example.techstore.model;

import com.example.techstore.controller.CashierController;
import com.example.techstore.model.abst.User;
import com.example.techstore.service.CashierService;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.CashierView;

import java.util.Date;

public class Cashier extends Employee {
    private int billsSold = 0;

    public Cashier() {
        super();
    }

    public Cashier(String name, String username, String password, Role role, Date birthday, String phone, String email, double salary) {
        super(name, username, password, role, birthday, phone, email, salary);
    }

    public Cashier(User user) {
        this(user.getName(), user.getUsername(), user.getPassword(), user.getRole(), null, null, null, 0);
    }

    public int getBillsSold() {
        return billsSold;
    }

    public void setBillsSold(int billsSold) {
        this.billsSold = billsSold;
    }
}
