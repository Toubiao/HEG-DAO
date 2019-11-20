package ch.hegarc.ig.daoPOC.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "eleve")
@XmlAccessorType(XmlAccessType.FIELD)
public class Eleve {
    private int number;
    private String matricule;
    private String nom;
    private String prenom;
    private Date dateNaiss;

    public Eleve() {
    }

    public Eleve(int number, String matricule, String nom, String prenom, Date dateNaiss) {
        this.number = number;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
}
