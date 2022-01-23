package com.example.techstore.model;

import java.util.List;

public class Supplier {
    String name;
    List<CD> CDS;

    public Supplier(String name, List<CD> CDS) {
        this.name = name;
        this.CDS = CDS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CD> getItems() {
        return CDS;
    }

    public void setItems(List<CD> CDS) {
        this.CDS = CDS;
    }
}
