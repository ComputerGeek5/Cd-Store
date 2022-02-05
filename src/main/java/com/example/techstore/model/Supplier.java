package com.example.techstore.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Supplier implements Serializable {
    private String id;
    private String name;
    private Cd cd;
    private int cdQuantity;
    private LocalDate registerDate;

    {
        id = UUID.randomUUID().toString();
        this.registerDate = LocalDate.now();
    }

    public Supplier() {
    }

    public Supplier(String name, Cd cd, int cdQuantity) {
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

    public Cd getCd() {
        return cd;
    }

    public void setCd(Cd cd) {
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
}
