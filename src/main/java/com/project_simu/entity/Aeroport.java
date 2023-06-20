package com.project_simu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import org.locationtech.jts.geom.Point;




@Entity
public class Aeroport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long ID_aeroport;
    @NonNull
    private String nom_aeroport;
    private Integer nbr_piste;
    private Integer nbr_place_Sol;
    private Integer temps_acces;
    private Integer duree_boucle;
    @Lob
    private Point Localisation;
//    @OneToMany
//    private List<Avion> Avions;
    public Aeroport() {
    }

    public Aeroport(@NonNull String nom_aeroport, Integer nbr_piste, Integer nbr_place_Sol, Integer temps_acces, Integer duree_boucle, Point Localisation) {
        this.nom_aeroport = nom_aeroport;
        this.nbr_piste = nbr_piste;
        this.nbr_place_Sol = nbr_place_Sol;
        this.temps_acces = temps_acces;
        this.duree_boucle = duree_boucle;
        this.Localisation= Localisation;
    }

    public Long getID_aeroport() {
        return ID_aeroport;
    }

    public void setID_aeroport(Long ID_aeroport) {
        this.ID_aeroport = ID_aeroport;
    }

    @NonNull
    public String getNom_aeroport() {
        return nom_aeroport;
    }

    public void setNom_aeroport(@NonNull String nom_aeroport) {
        this.nom_aeroport = nom_aeroport;
    }

    public Integer getNbr_piste() {
        return nbr_piste;
    }

    public void setNbr_piste(Integer nbr_piste) {
        this.nbr_piste = nbr_piste;
    }

    public Integer getNbr_place_Sol() {
        return nbr_place_Sol;
    }

    public void setNbr_place_Sol(Integer nbr_place_Sol) {
        this.nbr_place_Sol = nbr_place_Sol;
    }

    public Integer getTemps_acces() {
        return temps_acces;
    }

    public void setTemps_acces(Integer temps_acces) {
        this.temps_acces = temps_acces;
    }

    public Integer getDuree_boucle() {
        return duree_boucle;
    }

    public void setDuree_boucle(Integer duree_boucle) {
        this.duree_boucle = duree_boucle;
    }

    public Point getLocalisation() {
        return Localisation;
    }

    public void setLocalisation(Point localisation) {
        Localisation = localisation;
    }

    @Override
    public String toString() {
        return "Aeroport{" +
                "nom_aeroport='" + nom_aeroport + '\'' +
                ", nbr_piste=" + nbr_piste +
                ", nbr_place_Sol=" + nbr_place_Sol +
                ", temps_acces=" + temps_acces +
                ", duree_boucle=" + duree_boucle +
                ", localisation=" + Localisation +
                '}';
    }
}
