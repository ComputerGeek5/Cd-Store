package com.example.techstore.model;

public class Item {
    private String name;
    private String category;
    private Double buyPrice;
    private Double boughtQuantity;
    private Double sellPrice;
    private Double soldQuantity;

    public Item(String name, String category, Double buyPrice, Double boughtQuantity, Double sellPrice, Double soldQuantity) {
        this.name = name;
        this.category = category;
        this.buyPrice = buyPrice;
        this.boughtQuantity = boughtQuantity;
        this.sellPrice = sellPrice;
        this.soldQuantity = soldQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getBoughtQuantity() {
        return boughtQuantity;
    }

    public void setBoughtQuantity(Double boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Double soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
}
