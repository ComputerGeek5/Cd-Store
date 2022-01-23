package com.example.techstore.model;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

public class Bill {
    private Deque<CD> cds;
    private double total;
    private Date purchauseDate;

    public Bill() {
        cds = new ArrayDeque<>();
    }

    public Bill(Deque<CD> cds, double total, Date purchauseDate) {
        this.cds = cds;
        this.total = total;
        this.purchauseDate = purchauseDate;
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

    public Date getPurchauseDate() {
        return purchauseDate;
    }

    public void setPurchauseDate(Date purchauseDate) {
        this.purchauseDate = purchauseDate;
    }
}
