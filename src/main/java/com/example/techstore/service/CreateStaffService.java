package com.example.techstore.service;

import com.example.techstore.model.Admin;
import com.example.techstore.model.Employee;
import com.example.techstore.model.abst.User;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.repository.impl.UsersRepositoryImpl;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.CreateStaffView;

public class CreateStaffService {
    private static final UserRepository userRepository;

    static {
        userRepository = new UsersRepositoryImpl();
    }

    public boolean createUser(CreateStaffView createStaffView) {
        String name = createStaffView.getName().getText();
        String username = createStaffView.getUsername().getText();
        String password = createStaffView.getPassword().getText();
        Role role = (Role) createStaffView.getRoles().getValue();

        User user = new User(name, username, password, role);
//        createUserByRole(user, role);

        User created = userRepository.create(user);
        return created != null;
    }

    private static User createUserByRole(Role role) {
        if (role == Role.ADMIN) {
           return new Admin();
        } else  {
            return new Employee();
        }
    }
}
