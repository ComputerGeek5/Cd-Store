package com.example.techstore.model;

import com.example.techstore.model.abst.User;
import com.example.techstore.util.enumerator.Role;

import java.util.Date;

public class Employee extends User {
    Date birthday;
    String phone;
    String email;
    Double salary;

    public Employee(String name, String username, String password, Role role, Date birthday, String phone, String email, Double salary) {
        super(name, username, password, role);
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
