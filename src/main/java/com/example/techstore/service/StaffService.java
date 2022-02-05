package com.example.techstore.service;

import com.example.techstore.model.Employee;
import com.example.techstore.model.abst.User;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.repository.impl.UsersRepositoryImpl;
import com.example.techstore.util.enumerator.Role;

import java.util.List;
import java.util.stream.Collectors;

public class StaffService {
    private static final UserRepository userRepository;

    static {
        userRepository = new UsersRepositoryImpl();
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = userRepository.findAll()
                .stream()
                .filter(user -> user.getRole() == Role.MANAGER || user.getRole() == Role.CASHIER)
                .map(user -> (Employee) user)
                .collect(Collectors.toList());

        return employees;
    }

    public Employee findById(String id) {
        return (Employee) userRepository.findById(id);
    }

    public Employee update(Employee employee) {
        return (Employee) userRepository.update(employee);
    }

    public Employee delete(Employee employee) {
        return (Employee) userRepository.delete(employee);
    }
}
