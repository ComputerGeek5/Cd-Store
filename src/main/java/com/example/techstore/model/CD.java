package com.example.techstore.model;

import com.example.techstore.controller.CdController;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.scene.control.Button;
import org.controlsfx.glyphfont.Glyph;

import java.io.Serializable;
import java.util.UUID;

public class CD implements Serializable {
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

    public CD() {
    }

    public CD(String title, String genre, double buyPrice, double sellPrice) {
        this.title = title;
        this.genre = genre;
        this.buyPrice = buyPrice;
        this.boughtQuantity = 0;
        this.sellPrice = sellPrice;
        this.soldQuantity = 0;
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
