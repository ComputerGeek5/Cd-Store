package com.example.techstore.model;

import java.util.Date;
import java.util.List;

public class Bill {
    private List<Item> items;
    private Double total;
    private Date date;

    public Bill(List<Item> items, Double total, Date date) {
        this.items = items;
        this.total = total;
        this.date = date;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
