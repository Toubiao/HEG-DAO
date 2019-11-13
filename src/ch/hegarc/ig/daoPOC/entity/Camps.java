package ch.hegarc.ig.daoPOC.entity;

import java.math.BigDecimal;

public class Camps {
    private int number;
    private String lieu;
    private BigDecimal prix;
    private int maxPlaces;

    public Camps() {
    }

    public Camps(int number, String lieu, BigDecimal prix, int maxPlaces) {
        this.number = number;
        this.lieu = lieu;
        this.prix = prix;
        this.maxPlaces = maxPlaces;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public int getMaxPlaces() {
        return maxPlaces;
    }

    public void setMaxPlaces(int maxPlaces) {
        this.maxPlaces = maxPlaces;
    }
}
