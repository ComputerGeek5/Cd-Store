package com.example.techstore.service;

import com.example.techstore.model.Employee;
import com.example.techstore.repository.UserRepository;
import com.example.techstore.repository.impl.UsersRepositoryImpl;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.validator.StaffValidator;
import com.example.techstore.validator.impl.StaffValidatorImpl;
import com.example.techstore.view.EditStaffView;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.techstore.util.Alerter.showError;
import static com.example.techstore.validator.StaffValidator.usernameTakenErrorMessage;

public class StaffService {
    private static final UserRepository userRepository;
    private static final StaffValidator staffValidator;

    static {
        userRepository = new UsersRepositoryImpl();
        staffValidator = new StaffValidatorImpl();
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

    public boolean update(EditStaffView view, String id) {
        String name = view.getName().getText();
        String username = view.getUsername().getText();
        String password = view.getPassword().getText();
        Role role = (Role) view.getRoles().getValue();
        LocalDate birthday = view.getBirthday().getValue();
        String phone = view.getPhone().getText();
        String email = view.getEmail().getText();
        double salary = Double.parseDouble(view.getSalary().getText());

        Employee newEmployee = new Employee(name, username, password, role, birthday, phone, email, salary);
        newEmployee.setId(id);

        Employee updated = (Employee) userRepository.update(newEmployee);
        boolean validUpdatedCd = staffValidator.validateUpdatedEmployee(updated);

        if (validUpdatedCd) {
            showError(usernameTakenErrorMessage);
            return false;
        }

        return true;
    }

    public boolean delete(String id) {
        Employee employee = new Employee();
        employee.setId(id);
        Employee deleted = (Employee) userRepository.delete(employee);

        return deleted != null;
    }
}
