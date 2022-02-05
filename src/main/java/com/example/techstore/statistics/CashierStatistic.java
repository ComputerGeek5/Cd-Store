package com.example.techstore.statistics;

public class CashierStatistic {
    private String issuer;
    private int bills;
    private int cds;
    private double profit;

    public CashierStatistic() {
    }

    public CashierStatistic(String issuer, int bills, int cds, double profit) {
        this.issuer = issuer;
        this.bills = bills;
        this.cds = cds;
        this.profit = profit;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public int getBills() {
        return bills;
    }

    public void setBills(int bills) {
        this.bills = bills;
    }

    public int getCds() {
        return cds;
    }

    public void setCds(int cds) {
        this.cds = cds;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
