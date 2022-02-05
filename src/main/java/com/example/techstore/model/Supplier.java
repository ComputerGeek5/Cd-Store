package com.example.techstore.model;

import java.io.Serializable;
import java.util.UUID;

public class Supplier implements Serializable {
    private String id;
    private String name;
    private CD cd;
    private int cdQuantity;

    {
        id = UUID.randomUUID().toString();
    }

    public Supplier() {
    }

    public Supplier(String name, CD cd, int cdQuantity) {
        this.name = name;
        this.cd = cd;
        this.cdQuantity = cdQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public int getCdQuantity() {
        return cdQuantity;
    }

    public void setCdQuantity(int cdQuantity) {
        this.cdQuantity = cdQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
