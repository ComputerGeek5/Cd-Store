package com.example.techstore.model;

import com.example.techstore.model.abst.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;

public class Bill implements Serializable  {
    private String id;
    private Deque<CD> cds;
    private double total;
    private LocalDate purchauseDate;
    private User issuer;
    private String billInformation;

    {
        id = UUID.randomUUID().toString();
        this.purchauseDate = LocalDate.now();
    }

    public Bill() {
        cds = new ArrayDeque<>();
    }

    public Bill(Deque<CD> cds, double total, LocalDate purchauseDate, User issuer) {
        this.cds = cds;
        this.total = total;
        this.issuer = issuer;
    }

    public Deque<CD> getCds() {
        return cds;
    }

    public void setCds(Deque<CD> cds) {
        this.cds = cds;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getPurchauseDate() {
        return purchauseDate;
    }

    public void setPurchauseDate(LocalDate purchauseDate) {
        this.purchauseDate = purchauseDate;
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
