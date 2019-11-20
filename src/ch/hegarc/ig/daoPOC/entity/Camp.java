package ch.hegarc.ig.daoPOC.entity;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "camp")
@XmlAccessorType(XmlAccessType.FIELD)
public class Camp {

    private int number;
    private String lieu;
    private BigDecimal prix;
    private int maxPlaces;

    public Camp() {
    }

    public Camp(int number, String lieu, BigDecimal prix, int maxPlaces) {
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
