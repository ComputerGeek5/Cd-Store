package com.example.techstore.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Cd implements Serializable {
    private String id;
    private String title;
    private String genre;
    private double buyPrice;
    private int boughtQuantity;
    private double sellPrice;
    private int soldQuantity;

    {
        id = UUID.randomUUID().toString();
    }

    public Cd() {
    }

    public Cd(String title, String genre, double buyPrice, double sellPrice) {
        this.title = title;
        this.genre = genre;
        this.buyPrice = buyPrice;
        this.boughtQuantity = 0;
        this.sellPrice = sellPrice;
        this.soldQuantity = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cd cd = (Cd) o;
        return title.equals(cd.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getBoughtQuantity() {
        return boughtQuantity;
    }

    public void setBoughtQuantity(int boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
