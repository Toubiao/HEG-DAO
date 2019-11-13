package ch.hegarc.ig.daoPOC.entity;

import java.math.BigDecimal;

public class Camp {
    private int number;
    private String lieu;
    private BigDecimal prix;
    private int max_place;

    public Camp(){}

    public Camp(int number, String lieu, BigDecimal prix, int max_place){
        this.number = number;
        this.lieu = lieu;
        this.prix = prix;
        this.max_place = max_place;
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

    public int getMax_place() {
        return max_place;
    }

    public void setMax_place(int max_place) {
        this.max_place = max_place;
    }
}
