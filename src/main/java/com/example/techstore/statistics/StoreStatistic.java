package com.example.techstore.statistics;

public class StoreStatistic {
    private String source;
    private double amount;
    private Type type;

    public enum Type {
        DEBIT,
        CREDIT
    }

    public StoreStatistic() {
    }

    public StoreStatistic(String source, double amount, Type type) {
        this.source = source;
        this.amount = amount;
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
