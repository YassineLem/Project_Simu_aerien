package com.project_simu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class Contrôleur_aérien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int ID_controleur;
    private String nom;
    private String prenom;
    private String Email;
    private String password;

    public Contrôleur_aérien() {
    }

    public Contrôleur_aérien(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        Email = email;
        this.password = password;
    }

    public int getID_controleur() {
        return ID_controleur;
    }

    public void setID_controleur(int ID_controleur) {
        this.ID_controleur = ID_controleur;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
