package com.example.techstore.util;

import com.example.techstore.model.Admin;
import com.example.techstore.model.Cashier;
import com.example.techstore.model.Manager;
import com.example.techstore.model.abst.User;
import com.example.techstore.util.enumerator.Role;

public class UserUtil {
    public static void convertUser(User user) {
        if (user.getRole() == Role.ADMIN) {
            user = new Admin(user);
        } else if (user.getRole() == Role.MANAGER) {
            user = new Manager(user);
        } else {
            user = new Cashier(user);
        }
    }
}
