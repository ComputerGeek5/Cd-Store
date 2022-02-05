package com.example.techstore.controller;

import com.example.techstore.model.Employee;
import com.example.techstore.model.abst.User;
import com.example.techstore.service.StaffService;
import com.example.techstore.util.enumerator.Role;
import com.example.techstore.view.EditStaffView;
import com.example.techstore.view.StaffView;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EditStaffController {
    private static final StaffService staffService;

    static {
        staffService = new StaffService();
    }

    public static void back(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        StaffView view = new StaffView();
        Scene scene = new Scene(view, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void update(ActionEvent actionEvent, String id) {
        EditStaffView view = (EditStaffView) ((Node) actionEvent.getSource()).getScene().getRoot();
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

        Employee updated = staffService.update(newEmployee);

        if (updated != null) {
            back(actionEvent);
        }
    }

    public static void delete(ActionEvent actionEvent, String id) {
        Employee employee = new Employee();
        employee.setId(id);

        Employee deleted = staffService.delete(employee);

        if (deleted != null) {
            back(actionEvent);
        }
    }
}
