package com.example.techstore.model;

import com.example.techstore.model.abst.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;

public class Bill implements Serializable  {
    private String id;
    private Deque<Cd> cds;
    private double total;
    private LocalDate issueDate;
    private User issuer;
    private String billInformation;

    {
        id = UUID.randomUUID().toString();
        this.issueDate = LocalDate.now();
    }

    public Bill() {
        cds = new ArrayDeque<>();
    }

    public Bill(Deque<Cd> cds, double total, LocalDate issueDate, User issuer) {
        this.cds = cds;
        this.total = total;
        this.issuer = issuer;
    }

    public Deque<Cd> getCds() {
        return cds;
    }

    public void setCds(Deque<Cd> cds) {
        this.cds = cds;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public User getIssuer() {
        return issuer;
    }

    public void setIssuer(User issuer) {
        this.issuer = issuer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillInformation() {
        return billInformation;
    }

    public void setBillInformation(String billInformation) {
        this.billInformation = billInformation;
    }
}
